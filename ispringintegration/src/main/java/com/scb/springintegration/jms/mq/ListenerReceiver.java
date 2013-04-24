package com.scb.springintegration.jms.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ListenerReceiver implements MessageListener {
	
	public void receive(TextMessage msgText){
		Connection connection = null;
		try {
			InitialContext ctx = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup("jndi/jmsConn");
			connection = factory.createConnection();
			Destination dest = (Destination) ctx.lookup("jndi/dest");
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer receiver = session.createConsumer(dest);
			receiver.setMessageListener(this);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	public void onMessage(Message msg) {
		TextMessage text = (TextMessage) msg;
		System.out.println("Received msg = " + text);
	}

}
