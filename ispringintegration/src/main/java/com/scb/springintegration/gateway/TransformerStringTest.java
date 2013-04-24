package com.scb.springintegration.gateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TransformerStringTest {

	private ITradeGateway tradeGateway;
	private ApplicationContext ctx;
	
	public TransformerStringTest() {
		ctx = new ClassPathXmlApplicationContext("META-INF/spring/gateway/mygateway-transformer.xml");
		// obtain our service interface
		tradeGateway = ctx.getBean("tradeGateway", ITradeGateway.class);
	}

	public void publishTrade(Trade t) {
		// call the method to publish the trade!
		System.out.println("before publish trade====================");
		Trade it = tradeGateway.processTrade(t);
		System.out.println("after publish trade==================== " + it.getStatus());
	}

	public static void main(String[] args) {
		TransformerStringTest test = new TransformerStringTest();
		test.publishTrade(TradeUtil.createTrade());
	}

}
