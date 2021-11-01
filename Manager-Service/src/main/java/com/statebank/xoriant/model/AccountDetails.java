package com.statebank.xoriant.model;

public class AccountDetails {

	private int accountId;
	
	private double balance;
	
	private int customerId;
	
	private String accountType;
	
	private int branchId;
	
	private Branch branch;
	
 

	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AccountDetails(int accountId, double balance, int customerId, String accountType, int branchId,
			Branch branch) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customerId = customerId;
		this.accountType = accountType;
		this.branchId = branchId;
		this.branch = branch;
	}



	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public int getBranchId() {
		return branchId;
	}



	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}



	public Branch getBranch() {
		return branch;
	}



	public void setBranch(Branch branch) {
		this.branch = branch;
	}



	@Override
	public String toString() {
		return "AccountDetails [accountId=" + accountId + ", balance=" + balance + ", customerId=" + customerId
				+ ", accountType=" + accountType + ", branchId=" + branchId + ", branch=" + branch + "]";
	}

	 
	
}
