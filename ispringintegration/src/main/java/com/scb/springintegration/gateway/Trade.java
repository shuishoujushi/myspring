package com.scb.springintegration.gateway;

import java.util.Date;

public class Trade {
	private Long id;
	private String status;
	private String account;
	private Date transDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	public String toString(){
		return "id = " + this.id + ", account = " + this.account + ", transDate = " + this.transDate + ", status = " + this.status;
	}
}
