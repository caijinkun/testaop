package com.testweb.testaop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.testweb.testaop.aop.TestAOP;

@Configuration
@EnableAspectJAutoProxy
public class TestAOPConfig {
	@Bean
	public TestAOP testAOP(){
		return new TestAOP();
	}
}
