package com.yc.demobootredis;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="jedis")
public class JedisProperties {

	private String ip="127.0.0.1";
	private Integer port=6379;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}

	
}
