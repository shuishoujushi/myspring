package com.scb.springintegration.gateway;

import java.util.Date;


public class TradeUtil {

	public static Trade createTrade(){
		Trade t = new Trade();
		t.setId(9527l);
		t.setAccount("1234567890");
		t.setTransDate(new Date());
		t.setStatus("DONE");
		return t;
	}
	
}
