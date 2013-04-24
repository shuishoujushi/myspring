package com.scb.springintegration.jms.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InboundGatewayTest {

	private ApplicationContext context = null;
	
	public InboundGatewayTest(){
		context = new ClassPathXmlApplicationContext("/META-INF/spring/jms/inbound-channel-adapter.xml");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InboundGatewayTest test = new InboundGatewayTest();
	}

}
