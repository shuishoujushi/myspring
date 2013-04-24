package com.scb.springintegration.jms.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

public class OutboundChannelAdaterTest {

	private ApplicationContext context = null;
	private MessageChannel channel = null;
	
	public OutboundChannelAdaterTest(){
		context = new ClassPathXmlApplicationContext("/META-INF/spring/jms/outbound-channel-adapter.xml");
		channel = (MessageChannel) context.getBean("stdinToJmsoutChannel");
	}
	
	public void doJob(String param){
//		String str = "Only a poc for springintegration.";
		Message<String> msg = new GenericMessage<String>(param);
		channel.send(msg);
		System.out.println("The msg send to mq is : " + param);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OutboundChannelAdaterTest test = new OutboundChannelAdaterTest();
		test.doJob("Only a poc for springintegration.");
	}

}
