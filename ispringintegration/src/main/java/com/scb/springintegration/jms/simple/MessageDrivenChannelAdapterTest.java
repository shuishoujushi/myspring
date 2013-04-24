package com.scb.springintegration.jms.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.MessageChannel;

public class MessageDrivenChannelAdapterTest {
	
	private ApplicationContext context = null;
	private MessageChannel channel = null;
	private final static String[] configFiles = {
		"/META-INF/spring/jms/message-driven-channel-adapter.xml"
	};
	
	public MessageDrivenChannelAdapterTest(){
		context = new ClassPathXmlApplicationContext(configFiles);
		channel = (MessageChannel) context.getBean("jmsChannel");
	}
	
	
	public void doJob(){
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MessageDrivenChannelAdapterTest t = new MessageDrivenChannelAdapterTest();
//		t.doJob();
	}

}
