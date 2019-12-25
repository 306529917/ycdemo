package com.yc.jee.util;

import ognl.Ognl;
import ognl.OgnlException;

public class BeanUtils {
	
	/**
	 * 使用OGNL表达式获取对象的字段值
	 * @param obj
	 * @param ognl
	 * @return
	 */
	public static Object getValue(Object obj, String ognl) {
		try {
			return Ognl.getValue(ognl, obj);
		} catch (OgnlException e) {
			throw new RuntimeException(e);
		}
	}

}
