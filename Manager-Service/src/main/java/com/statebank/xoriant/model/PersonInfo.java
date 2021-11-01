package com.statebank.xoriant.model;

public class PersonInfo {

	private int personId;
	
	private String personName;
	
	private String gender;
	
	private String dob;
	
	private String mobNumber;
	
	private Address address;
	
	private String role;
	
	private String personType;
	

	public PersonInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PersonInfo(int personId, String personName, String gender, String dob, String mobNumber, Address address,
			String role, String personType) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.gender = gender;
		this.dob = dob;
		this.mobNumber = mobNumber;
		this.address = address;
		this.role = role;
		this.personType = personType;
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getMobNumber() {
		return mobNumber;
	}


	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPersonType() {
		return personType;
	}


	public void setPersonType(String personType) {
		this.personType = personType;
	}


	@Override
	public String toString() {
		return "PersonInfo [personId=" + personId + ", personName=" + personName + ", gender=" + gender + ", dob=" + dob
				+ ", mobNumber=" + mobNumber + ", address=" + address + ", role=" + role + ", personType=" + personType
				+ "]";
	}



	
}
