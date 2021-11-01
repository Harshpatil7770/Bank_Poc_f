package com.statebank.xoriant.model;

public class PersonInfo {

	private int personId;
	
	private String personName;
	
	private String dob;
	
	private String mobNumber;
	
	private Address address;
	
	private String personType;
	
	private Gender gender;
	
	private Role role;
	
	private AccountType accountType;

	public PersonInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonInfo(int personId, String personName, String dob, String mobNumber, Address address, String personType,
			Gender gender, Role role, AccountType accountType) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.dob = dob;
		this.mobNumber = mobNumber;
		this.address = address;
		this.personType = personType;
		this.gender = gender;
		this.role = role;
		this.accountType = accountType;
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

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "PersonInfo [personId=" + personId + ", personName=" + personName + ", dob=" + dob + ", mobNumber="
				+ mobNumber + ", address=" + address + ", personType=" + personType + ", gender=" + gender + ", role="
				+ role + ", accountType=" + accountType + "]";
	}
	
	
    
	
	
}
