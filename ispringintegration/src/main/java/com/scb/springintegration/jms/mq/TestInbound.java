package com.scb.springintegration.jms.mq;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

import com.scb.springintegration.jms.Trade;

public class TestInbound {

	public static Trade getTrade(String transanctionId, String accountNumber, BigDecimal amount, String status){
		Trade t = new Trade();
		t.setTransactionId(transanctionId);
		t.setAccountNumber(accountNumber);
		t.setAmount(amount);
		t.setStatus(status);
		t.setTransDate(new Date());
		return t;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] configFiles = {
				"/META-INF/spring/jms-mq/mq-context.xml",
				"/META-INF/spring/jms-activemq/message-driven-channel-adapter.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configFiles);
//		MessageChannel channel = (MessageChannel) ctx.getBean("stdinToJmsoutChannel");
		
//		Trade t = getTrade("1", "123", BigDecimal.ONE, "Submit");
//		Message<Trade> message = new GenericMessage<Trade>(t);
////		Message<String> message = new GenericMessage<String>("test");
//		channel.send(message);
	}

}
