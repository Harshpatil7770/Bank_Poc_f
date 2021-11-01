package com.statebank.xoriant.dao.util;

import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;


public class DTO {
	
	public double amount;
	
	public String description;
	
	public int personId;
	
	public String personType;
	
	public int branchId;
	
    public int AccountNumber; 
	
	public int customerId;
	
	public String userType;
	
	public String transactionType;
	
	public String acccountType;
	
	public String formDate;
	
	public String toDate;
	
	public String payersAccountNumber;
	
	public String payeesAccountNumber;
	
	public String oldPassword;
	
	public String newPassword;

	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO(double amount, String description, int personId, String personType, int branchId, int accountNumber,
			int customerId, String userType, String transactionType, String acccountType, String formDate,
			String toDate, String payersAccountNumber, String payeesAccountNumber, String oldPassword,
			String newPassword) {
		super();
		this.amount = amount;
		this.description = description;
		this.personId = personId;
		this.personType = personType;
		this.branchId = branchId;
		AccountNumber = accountNumber;
		this.customerId = customerId;
		this.userType = userType;
		this.transactionType = transactionType;
		this.acccountType = acccountType;
		this.formDate = formDate;
		this.toDate = toDate;
		this.payersAccountNumber = payersAccountNumber;
		this.payeesAccountNumber = payeesAccountNumber;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAcccountType() {
		return acccountType;
	}

	public void setAcccountType(String acccountType) {
		this.acccountType = acccountType;
	}

	public String getFormDate() {
		return formDate;
	}

	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getPayersAccountNumber() {
		return payersAccountNumber;
	}

	public void setPayersAccountNumber(String payersAccountNumber) {
		this.payersAccountNumber = payersAccountNumber;
	}

	public String getPayeesAccountNumber() {
		return payeesAccountNumber;
	}

	public void setPayeesAccountNumber(String payeesAccountNumber) {
		this.payeesAccountNumber = payeesAccountNumber;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "DTO [amount=" + amount + ", description=" + description + ", personId=" + personId + ", personType="
				+ personType + ", branchId=" + branchId + ", AccountNumber=" + AccountNumber + ", customerId="
				+ customerId + ", userType=" + userType + ", transactionType=" + transactionType + ", acccountType="
				+ acccountType + ", formDate=" + formDate + ", toDate=" + toDate + ", payersAccountNumber="
				+ payersAccountNumber + ", payeesAccountNumber=" + payeesAccountNumber + ", oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + "]";
	}
	
	public static DTO getData(int accountNumber, JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.query(DBQueries.ACCOUNT_DETAILS, (ResultSet rs) -> {
			if (rs.next()) {
				
				DTO obj= new DTO();
				try {
					obj.setAmount(rs.getDouble(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				return obj;
				
			}
			return null;
			
		},accountNumber);
	}
	
}
