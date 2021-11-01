package com.statebank.xoriant.model;

public enum Role {

	 Manager("MANAGER"),
	 
	    Customer("CUSTOMER");

		 private final String roleName;

		    private Role (String roleName) {
		        this.roleName = roleName;
		    }

		    public String getRolename() {
		        return this.roleName;
		    }
}
