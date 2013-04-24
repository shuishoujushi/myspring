package com.scb.springintegration.jms.simple;

import java.io.InputStream;
import java.util.Scanner;

public class InOutChannelAdapterTest extends Thread{

	private OutboundChannelAdaterTest out = null;
	private MessageDrivenChannelAdapterTest in = null;
	
	public InOutChannelAdapterTest(){
		out = new OutboundChannelAdaterTest();
//		in = new MessageDrivenChannelAdapterTest();
	}
	
	
	@Override
	public void run() {
		String msg;
		for(int i = 0; i < 10; i++){
			msg = "This is the " + i + " message";
			out.doJob(msg);
//			System.out.print("Please input your message : ");
//			InputStream in = System.in;
//			Scanner scan = new Scanner(in);
//			scan.next();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InOutChannelAdapterTest test = new InOutChannelAdapterTest();
		test.start();
	}

}
