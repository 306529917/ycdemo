package com.yc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.yc.spring.bmi.BmiFilter;
import com.yc.spring.bmi.Container;
import com.yc.spring.bmi.Filter;
import com.yc.spring.bmi.Person;

@Configuration
@ComponentScan("com.yc.spring.bmi")
public class BmiBeanConfig {
	
	@Autowired
	// 指定注入组件的名称
	@Qualifier("ctn")
	private Container ctn;
	
	/**
	 * 由于需要给属性赋值，因此 Filter 的定义需要使用 Bean 注解方法
	 * @return
	 */
	@Bean
	public Filter getFilter() {
		BmiFilter f = new BmiFilter();
		f.setMinHeight(1);
		f.setMaxHeight(2);
		f.setMinWeight(30);
		f.setMaxWeight(200);
		return f;
	}
	
	@Bean
	@Primary
	public Container getContainer() throws Exception {
		/**
		 * 	ctn对象除了，没有检测对象，其他属性都已经完成自动注入
		 * 	在该方法中，只有添加被检测对象就好了
		 */
		// 定义最胖的 宋江
		Person p1 = new Person();
		p1.setName("宋江");
		p1.setHeight(1.5);
		p1.setWeight(80);
		// 定义最轻的 燕青
		Person p2 = new Person();
		p2.setName("燕青");
		p2.setHeight(1.8);
		p2.setWeight(60);
		// 定义群演 武松
		Person p3 = new Person();
		p3.setName("武松");
		p3.setHeight(1.7);
		p3.setWeight(70);
		
		// 给容器添加 大于10个检测对象，由于是list集合可以有重复对象，群演武松被多次添加
		ctn.add(p1);
		ctn.add(p2);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		ctn.add(p3);
		
		// 测量并统计结果
		ctn.measure();
		return ctn;
	}
}
