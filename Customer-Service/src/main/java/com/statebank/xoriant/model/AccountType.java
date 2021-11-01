package com.statebank.xoriant.model;

public enum AccountType {

    // public enum accountType{"SAVING","CURRENT"}
	 Current("CURRENT"),
	 
	    Saving("SAVING");

		 private  String accountType;

		    private AccountType (String accountType) {
		        this.accountType = accountType;
		    }

		    public String getAccountType() {
		        return this.accountType;
		    }

			public void setAccountType(String accountType) {
				this.accountType = accountType;
			}
			
}
