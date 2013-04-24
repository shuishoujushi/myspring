package com.scb.springintegration.jms.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.scb.springintegration.jms.Trade;

public class JmsSender {
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(final String msg){
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				System.out.println("send msg ========= " + msg);
				return session.createTextMessage(msg);
			}
		});
	}
	
	public void send(Trade trade){
		jmsTemplate.convertAndSend(trade);
	}
}
