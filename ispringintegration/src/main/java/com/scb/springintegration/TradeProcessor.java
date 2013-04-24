package com.scb.springintegration;

import org.springframework.integration.Message;

import com.scb.springintegration.jms.Trade;

public class TradeProcessor {
	public void processTrade(Message<Trade> msg){
		
		System.out.println("=========processor====" + msg.getPayload());
		
		boolean flag = msg.getPayload().getStatus().equalsIgnoreCase("success");
		
		if(flag){
			throw new RuntimeException("runtimeexception");
		}
	}
}
