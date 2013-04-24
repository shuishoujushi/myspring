package com.scb.springintegration.jms.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

import com.scb.springintegration.jms.Trade;

public class JmsReceiver implements MessageListener{
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void receive(){
		Message message = jmsTemplate.receive();
		System.out.println("received msg = " + message);
	}
	
	public void receiveObject() throws JMSException{
		ObjectMessage message = (ObjectMessage) jmsTemplate.receiveAndConvert();
		System.out.println("received msg = " + message.getObject());
	}
	
	@Override
	public void onMessage(Message msg) {
		System.out.println("msg arrived " + msg);
		TextMessage text = (TextMessage) msg;
		try {
			System.out.println("Received msg = " + text.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
