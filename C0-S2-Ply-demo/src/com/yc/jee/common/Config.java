package com.yc.jee.common;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Config {
	
	public static final Properties PROPS = new Properties();
	
	static {
		InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			InputStreamReader isr = new  InputStreamReader(in, "utf-8");
			PROPS.load(isr);
		} catch (Exception e) {
			throw new RuntimeException("系统参数读取失败！",e);
		}
	}
	
	

}
