package com.scb.activemq.simple;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListenerReceiver implements MessageListener {
	private ApplicationContext ctx;
	private ConnectionFactory factory;
	private Destination dest;
	private Connection conn;
	private Session session;
	
	public ListenerReceiver(){
		init();
	}
	
	public void init(){
		ctx = new ClassPathXmlApplicationContext("/META-INF/spring/activemq/common.xml");
		factory = (ConnectionFactory) ctx.getBean("connectionFactory");
		dest = (Destination) ctx.getBean("destination");
		try {
			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void consumeMessage(){
		try {
			MessageConsumer receiver = session.createConsumer(dest);
			conn.start();
			receiver.setMessageListener(this);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			try {
				session.close();
				conn.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	public void onMessage(Message msg) {
		TextMessage text = (TextMessage) msg;
		System.out.println("Received msg = " + text);
	}
	
	public static void main(String[] args) {
		ListenerReceiver lr = new ListenerReceiver();
		lr.consumeMessage();
	}
}
