package com.statebank.xoriant.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.Address;
import com.statebank.xoriant.model.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.util.UserDTO;


public interface CustomerService {

	public Address editAddress(Address address,int customer_id);
	
	
	public List<AccountDetails> viewAllAccounts(int customer_id);
	public List<AccountDetails> findAccountDetails();


	public List<TransactionDetails> MiniStatement(int accountNumber);

	public int changePassword(UserDTO userDTO);
	
	public String checkBalance(int accountNumber);

	public String withdrawMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType);

	public String DepositMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType);

	public List<TransactionDetails> CustomizedMiniStatement(int accountNumber, double amount, String fromdate,
			String toDate);

	public String fundTransfer(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType);
}
