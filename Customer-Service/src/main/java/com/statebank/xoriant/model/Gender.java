package com.statebank.xoriant.model;

public enum Gender {
    Male("MALE"),
 
    Female("FEMALE");

	 private final String name;

	    private Gender(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return this.name;
	    }
    
}
