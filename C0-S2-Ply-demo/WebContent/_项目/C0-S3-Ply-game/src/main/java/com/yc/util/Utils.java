package com.yc.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Utils {

	public static LinkedHashMap<String, String> asMap(String... nameAndValues) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i + 1 < nameAndValues.length; i += 2) {
			map.put(nameAndValues[i], nameAndValues[i + 1]);
		}
		return map;
	}

	public static Map<Object, Object> asMap(Object... keyAnaValues) {
		Map<Object, Object> ret = new LinkedHashMap<>();
		for (int i = 0; i < keyAnaValues.length - 1; i += 2) {
			ret.put(keyAnaValues[i], keyAnaValues[i + 1]);
		}
		return ret;
	}

	@SafeVarargs
	public static <T> T ifNull(T... values) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null) {
				continue;
			} else {
				return values[i];
			}
		}
		return null;
	}

	public static String concatPath(String... paths) {
		return String.join("/", paths);
	}

	public static String[] group(String string, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		int i[] = { 0 };
		if (m.find()) {
			return Stream.generate(() -> {
				return m.group(++i[0]);
			}).limit(m.groupCount()).toArray(String[]::new);
		} else {
			return null;
		}
	}

	public static void show(Object... objects) {
		System.out.print("Show: ");
		for (int i = 0; i < objects.length; i++) {
			System.out.print(i + 1 + ": " + objects[i]);
			if (i < objects.length - 1) {
				System.out.print(" ==>");
			}
		}
		System.out.println();
	}

	/**
	 * 	执行方法, 抛出运行期异常
	 */
	@SafeVarargs
	@SuppressWarnings("unchecked")
	public static <T extends AutoCloseable> void tex(AutoCloseableCreator<T> creator, Handler<T> trys, Handler<Exception>... catchs) {
		AutoCloseable os = null;
		try {
			try {
				trys.handle((T) (os = creator.create()));
			} catch (Exception e) {
				for (Handler<Exception> eh : catchs) {
					eh.handle(e);
				}
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 	执行方法, 打印异常
	 */
	@SuppressWarnings("unchecked")
	public static <T extends AutoCloseable> void pex(AutoCloseableCreator<T> creator, Handler<T> handler) {
		AutoCloseable os = null;
		try {
			handler.handle((T) (os = creator.create()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static interface AutoCloseableCreator<T extends AutoCloseable> {
		T create() throws Exception;
	}

	public static interface Handler<T> {
		void handle(T t) throws Exception;
	}

	/**
	 * 	执行方法, 抛出运行期异常
	 */
	public static void tex(NoExceptionHandler handler) {
		try {
			handler.handle();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 	执行方法, 打印异常
	 */
	public static void pex(NoExceptionHandler handler) {
		try {
			handler.handle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static interface NoExceptionHandler {
		void handle() throws Exception;
	}

}
