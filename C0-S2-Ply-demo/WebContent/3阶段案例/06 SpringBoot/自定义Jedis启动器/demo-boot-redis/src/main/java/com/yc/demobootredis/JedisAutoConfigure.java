package com.yc.demobootredis;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;

@Configuration
@ConditionalOnProperty(prefix="jedis",value="enable" , havingValue="true")
@EnableConfigurationProperties(JedisProperties.class)
public class JedisAutoConfigure {
	
	@Resource
	private JedisProperties jedisProperties;
	
	@Bean
	public Jedis getJedis() {
		return new Jedis(jedisProperties.getIp(),
				jedisProperties.getPort());
	}

}
