package com.scb.springintegration.jms.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

public class OutboundGatewayTest {

	private ApplicationContext context = null;
	private MessageChannel channel = null;
	
	public OutboundGatewayTest(){
		context = new ClassPathXmlApplicationContext("/META-INF/spring/jms/outbound-channel-adapter.xml");
		channel = (MessageChannel) context.getBean("jmsChannel");
	}
	
	public void doJob(String param){
		Message<String> msg = new GenericMessage<String>(param);
		channel.send(msg);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutboundGatewayTest test = new OutboundGatewayTest();
		test.doJob("outboundGateway");
	}

}
