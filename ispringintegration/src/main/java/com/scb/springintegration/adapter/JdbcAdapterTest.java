package com.scb.springintegration.adapter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcAdapterTest {
	private ApplicationContext ctx;
	
	public JdbcAdapterTest() {
		ctx = new ClassPathXmlApplicationContext("META-INF/spring/adapter/jdbc.xml");
		// obtain our service interface
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcAdapterTest fat = new JdbcAdapterTest();
	}

}
