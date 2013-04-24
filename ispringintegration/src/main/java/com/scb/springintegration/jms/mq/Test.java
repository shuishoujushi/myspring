package com.scb.springintegration.jms.mq;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.mq.MQException;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.scb.springintegration.jms.Trade;

public class Test {
	
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
	 * @throws MQException 
	 * @throws JMSException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws MQException, JMSException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/jms-mq/mq-context.xml");
		MQQueueConnectionFactory f = (MQQueueConnectionFactory) context.getBean("connectionFactory");
		JmsSender sender = (JmsSender) context.getBean("jmsSender");
		JmsReceiver receiver = (JmsReceiver) context.getBean("jmsReceiver");
//		receiver.receive();
//		receiver.receiveObject();
//		sender.send("spring integration");
		Trade t = getTrade("1", "123", BigDecimal.TEN, "submit");
		sender.send(t);
	}

}
