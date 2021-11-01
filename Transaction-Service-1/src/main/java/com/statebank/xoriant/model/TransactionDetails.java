package com.statebank.xoriant.model;

public class TransactionDetails {

private int transactionId;
	
	private double amount;
	
	private String transactionDate;
	
	private String description;
	
	private int payeesAccountNumber;
	
	private int accountNumber;
	
	private String transactionType;

	private String accountType;
	

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TransactionDetails(int transactionId, double amount, String transactionDate, String description,
			int payeesAccountNumber, int accountNumber, String transactionType, String accountType) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.payeesAccountNumber = payeesAccountNumber;
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.accountType = accountType;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPayeesAccountNumber() {
		return payeesAccountNumber;
	}


	public void setPayeesAccountNumber(int payeesAccountNumber) {
		this.payeesAccountNumber = payeesAccountNumber;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", amount=" + amount + ", transactionDate="
				+ transactionDate + ", description=" + description + ", payeesAccountNumber=" + payeesAccountNumber
				+ ", accountNumber=" + accountNumber + ", transactionType=" + transactionType + ", accountType="
				+ accountType + "]";
	}


	
}
