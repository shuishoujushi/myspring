package com.scb.springintegration.jms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Trade implements Serializable {

	private static final long serialVersionUID = 5075055529656082545L;
	
	private String transactionId;
	private String accountNumber;
	private BigDecimal amount;
	private String status;
	private Date transDate;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	@Override
	public String toString() {
		return "transactionId = " + transactionId + "; accountNumber = " + accountNumber + "; amount = " + amount + 
			"; status = " + status + "; transDate = " + transDate;
	}
}
