package com.statebank.xoriant.model;



public enum AccountType {
	
	CURRENT("CURRENT"),
	  
	SAVING("SAVING");
	 
	 private String accountType;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	  
	AccountType(String accountType){
		this.accountType=accountType;
	}
	  	
	/*
	 * SAVING,CURRENT
	 * 
	 * } class AccountType_ {
	 * 
	 * accountType type; public void setAccountType(accountType type) {
	 * this.type=type; }
	 * 
	 * public AccountType_(accountType type) { this.type=type; }
	 * 
	 * public accountType getAccountType() { return type; }
	 * }
	 */
}

