package com.scb.springintegration.jms.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SimpleSenderAndReciver {
	
	public void send(TextMessage msgText){
		Connection connection = null;
		try {
			InitialContext ctx = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup("jndi/jmsConn");
			connection = factory.createConnection();
			Destination dest = (Destination) ctx.lookup("jndi/dest");
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer sender = session.createProducer(dest);
			sender.send(msgText);
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
	
	public void receive(TextMessage msgText){
		Connection connection = null;
		try {
			InitialContext ctx = new InitialContext();
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup("jndi/jmsConn");
			connection = factory.createConnection();
			Destination dest = (Destination) ctx.lookup("jndi/dest");
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageConsumer receiver = session.createConsumer(dest);
			receiver.receive();
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
}
