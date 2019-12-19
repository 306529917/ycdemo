package com.yc.demo.aop.mybatis;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yc.demo.aop.mybatis.anno.Delete;
import com.yc.demo.aop.mybatis.anno.Insert;
import com.yc.demo.aop.mybatis.anno.Select;
import com.yc.demo.aop.mybatis.anno.Update;
import com.yc.jee.util.DBHelper;

public class SqlSession implements InvocationHandler {

	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> cls) {
		// 使用 JDK 动态代理创建对象
		return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[] { cls }, this);
	}

	@Override
	/**
	 * 作业：
	 * 		请完成该方法，实现通过对 method 上注解的读取，完成对应的SQL操作
	 * 要求：
	 * 		1、根据实体类创建 student 表，包含：sn、name、age、grade 4个字段
	 * 		2、使用 DBHelper 执行SQL
	 * 		3、使用反射获取 SQL语句
	 * 		4、解析语句中的命名参数，根据参数名从 Java 的方法参数中获取 SQL 参数值
	 * 		5、通过反射获取返回结果类型，将结果集按照返回类型返回
	 * 		6、完成 StudentMapperTest.test() 方法的单元测试，并测试通过
	 * 		7、注意：selectAll 返回的是泛型集合，泛型类型请通过下面的 getGenericReturnType() 返回获取
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 获取 sql 语句
		String sql = getSql(method);
		// 获取所有的参数名，并替换占位符 ?
		List<String> paramNameList = new ArrayList<>();
		sql = parseSql(sql, paramNameList);
		// 根据参数名获取参数值
		List<Object> paramValueList = getParamValue(args, paramNameList);

		Object ret;
		if (isSelectMethod(method)) {
			// 执行查询
			ret = select(sql, paramValueList, method);
		} else {
			// 执行更新
			ret = update(sql, paramValueList, method);
		}

		return ret;
	}

	/**
	 * 返回一个方法的返回值的泛型类型
	 * 	例如：将 public List<Student> selectAll(); 方法对象 method 传入，将返回 Student 类对象 
	 */
	public static Class<?> getGenericReturnType(Method method) {
		ParameterizedType type = (ParameterizedType) method.getGenericReturnType();
		try {
			return Class.forName(type.getActualTypeArguments()[0].getTypeName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 从方法注解中获取SQL语句 
	 */
	private String getSql(Method method) {
		Select s = method.getAnnotation(Select.class);
		if (s != null)
			return s.value();
		Delete d = method.getAnnotation(Delete.class);
		if (d != null)
			return d.value();
		Update u = method.getAnnotation(Update.class);
		if (u != null)
			return u.value();
		Insert i = method.getAnnotation(Insert.class);
		if (i != null)
			return i.value();
		return null;
	}

	/**
	 * 解析sql语句，将命名参数（${...}）转换成占位符，并且将参数名取出存入 paramNameList
	 */
	private String parseSql(String sql, List<String> paramNameList) {
		// 定义 MyBatis 命名参数正则表达式表达式（注意：这里使用了分组），匹配 #{参数名} 格式字符串
		String namedSqlParamPatten = "(#\\{(\\w+)\\})";
		// 定义 Java 的正则表达式对象
		Pattern pattern = Pattern.compile(namedSqlParamPatten);
		// 匹配 SQL 语句
		Matcher matcher = pattern.matcher(sql);
		// 捕获每个命名参数，添加到 paramNameList 中
		while (matcher.find()) {
			paramNameList.add(matcher.group(2));
		}
		// 替换所有命名参数为 ? 占位符
		return sql.replaceAll(namedSqlParamPatten, "?");
	}

	/**
	 * 执行查询，根据方法的返回值定义，返回对应结果
	 */
	private Object select(String sql, List<Object> paramValueList, Method method) {
		// 检查返回结果是否是 集合类（假定都带泛型定义） 还是 实体类对象
		if (Collection.class.isAssignableFrom(method.getReturnType())) {
			// 集合 + 泛型
			Class<?> cls = getGenericReturnType(method);
			return DBHelper.selectList(sql, cls, paramValueList.toArray());
		} else {
			// 实体类
			Class<?> cls = method.getReturnType();
			return DBHelper.selectOne(sql, cls, paramValueList.toArray());
		}
	}

	/**
	 * 执行增删改，根据方法的返回值定义，返回对应结果
	 * @return 
	 */
	private Object update(String sql, List<Object> paramValueList, Method method) {
		DBHelper.update(sql, paramValueList.toArray());
		return null;
	}

	/**
	 * 根据方法参数数组，获取所有的 SQL 参数
	 */
	private List<Object> getParamValue(Object[] args, List<String> paramNameList) {
		List<Object> paramValueList = new ArrayList<>();
		if (args != null)
			for (String paramName : paramNameList) {
				// 如果是单参数 并且 参数类型是简单数据类型（字符串、数字、日期、基本数据类型）则直接返回对象值
				if (args.length == 1 && (args[0] == null || isSimpleType(args[0].getClass()))) {
					paramValueList.add(args[0]);
				}
				// 否则到对象数组中找属性值
				/**
				 * 请思考：MyBatis是如何处理当前的情况的？
				 */
				for (Object arg : args) {
					try {
						Field f = arg.getClass().getDeclaredField(paramName);
						/**
						 * 在这里偷个懒，直接用 field 获取属性值了，节省点代码
						 */
						f.setAccessible(true); // 设置允许访问私有属性值
						Object value = f.get(arg);
						paramValueList.add(value); // 取出字段值存入 paramNameList 集合
					} catch (NoSuchFieldException | SecurityException e) {
						// 属性没找到，继续找下一个
						System.out.println(arg.getClass() + "没有该字段：" + paramName);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// 取值异常，无药可救
						throw new RuntimeException(e);
					}
				}
			}
		return paramValueList;
	}

	/**
	 * 判断是否是 查询 方法，否则就是增删改方法 
	 */
	private boolean isSelectMethod(Method method) {
		return method.getAnnotation(Select.class) != null;
	}

	/**
	 * 判断指定类型是否是简单数据类型（8种基本数据类型   或者    String   或者    Number的子类  或者 Date的子类）
	 * @param cls
	 * @return
	 */
	private boolean isSimpleType(Class<?> cls) {
		boolean isBaseType = cls.isPrimitive();
		boolean isString = String.class.isAssignableFrom(cls);
		boolean isNumber = Number.class.isAssignableFrom(cls);
		boolean isDate = Date.class.isAssignableFrom(cls);
		return isBaseType || isString || isNumber || isDate;

	}

}
