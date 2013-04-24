package com.scb.springintegration.gateway;

public class TradeProcessor {
	
	public Trade receiveTrade(Trade t) {
		System.out.println("Received the Trade via Gateway:" + t);
		return t;
	}
}
