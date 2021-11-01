package com.statebank.xoriant.dao.util;

import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDTO {

	public String userName;
	public String password;
	public String oldPassword;
	public String newPassword;
	public int customerId;
    public  String security_question;
	
	public  String security_answer;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String userName, String password, String oldPassword, String newPassword, int customerId,
			String security_question, String security_answer) {
		super();
		this.userName = userName;
		this.password = password;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.customerId = customerId;
		this.security_question = security_question;
		this.security_answer = security_answer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + ", customerId=" + customerId + ", security_question="
				+ security_question + ", security_answer=" + security_answer + "]";
	}
	
	
public static UserDTO getUserDetails(int customer_id,JdbcTemplate jdbcTemplate) {
		
		return jdbcTemplate.query(DBQueries.CHANGE_PASSWORD, (ResultSet rs) -> {
			if (rs.next()) {
				
				UserDTO obj= new UserDTO();
				
				obj.setUserName(rs.getString(1));
				obj.setPassword(rs.getString(2));
				obj.setSecurity_question(rs.getString(3));
				obj.setSecurity_answer(rs.getString(4));
				
				return obj;
				
			}
			
			return null;
			
		},customer_id);
		

	}
	
}
