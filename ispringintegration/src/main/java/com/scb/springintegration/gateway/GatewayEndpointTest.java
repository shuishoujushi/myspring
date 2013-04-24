package com.scb.springintegration.gateway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GatewayEndpointTest {

	private ITradeGateway tradeGateway;
	private ApplicationContext ctx;
	
	public GatewayEndpointTest() {
		ctx = new ClassPathXmlApplicationContext("META-INF/spring/gateway/mygateway.xml");
		// obtain our service interface
		tradeGateway = ctx.getBean("gateway", ITradeGateway.class);
	}

	public void publishTrade(Trade t) {
		// call the method to publish the trade!
		Trade it = tradeGateway.processTrade(t);
		System.out.println("Trade Message published (Reply)." + it.getStatus());
	}

	public static void main(String[] args) {
		GatewayEndpointTest test = new GatewayEndpointTest();
		test.publishTrade(TradeUtil.createTrade());
	}
}
