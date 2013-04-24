package com.scb.springintegration.jms;

import org.springframework.integration.Message;

public class TradeFilter {

	public boolean isSuccessTrade(Message<?> msg){
		//The msg from server is a String, need format to a Object then invoke its methods and properties.
		Trade t = (Trade) msg.getPayload();
		boolean flag = t.getStatus().equalsIgnoreCase("success");
//		System.out.println("================" + t.getStatus());
		return flag;
	}
}
