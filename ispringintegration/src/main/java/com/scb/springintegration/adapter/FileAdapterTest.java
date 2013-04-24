package com.scb.springintegration.adapter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileAdapterTest {
	private ApplicationContext ctx;
	
	public FileAdapterTest() {
		ctx = new ClassPathXmlApplicationContext("META-INF/spring/adapter/file.xml");
		// obtain our service interface
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileAdapterTest fat = new FileAdapterTest();
	}

}
