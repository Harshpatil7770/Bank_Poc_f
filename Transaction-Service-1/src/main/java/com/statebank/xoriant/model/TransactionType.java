package com.statebank.xoriant.model;

public enum TransactionType {

	WITHDRAW("WITHDRAW"),
	 
	DEPOSITE("DEPOSITE"),
	
	FUNDTRANSFER("FUNDTRANSFER");
	

		 private  String transType;

		     TransactionType (String transType) {
		        this.transType = transType;
		    }

		    public String getTransType() {
		        return this.transType;
		    }

			public void setTransType(String transType) {
				this.transType = transType;
			}
			
		
}
