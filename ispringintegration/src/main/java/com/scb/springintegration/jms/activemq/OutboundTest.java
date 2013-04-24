package com.scb.springintegration.jms.activemq;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

import com.scb.springintegration.jms.Trade;

public class OutboundTest {

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
				"/META-INF/spring/jms-activemq/activemq-context.xml",
				"/META-INF/spring/jms-activemq/outbound-channel-adapter.xml"};
		Random random = new Random();
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configFiles);
		MessageChannel channel = (MessageChannel) ctx.getBean("localChannel");
		GenericMessage<Trade> message = null;
//		Message<String> message = new GenericMessage<String>("test");
		for(int i = 0; i < 10; i++){
			BigDecimal amount = BigDecimal.valueOf(Math.random());
			String status = "success";
			String transactionId = String.valueOf(i);
			String accountNumber = String.valueOf(Math.abs(random.nextInt()));
			if(i % 2 == 0){
				status = "reject";
			}
			Trade t = getTrade(transactionId, accountNumber, amount, status);
			message = new GenericMessage<Trade>(t);
			try {
				channel.send(message);
			} catch (Throwable e) {
				// TODO: handle exception
			}
			System.out.println("Send the trade number is " + i);
		}
	}

}
