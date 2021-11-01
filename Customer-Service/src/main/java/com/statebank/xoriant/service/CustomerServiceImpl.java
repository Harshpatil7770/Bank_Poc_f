package com.statebank.xoriant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statebank.xoriant.dao.CustomerDao;
import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.Address;
import com.statebank.xoriant.model.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.util.UserDTO;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	private TransactionServiceProxy transactionServiceProxy;
	
	@Autowired
	private UserServiceProxy userServiceProxy;
	
public List<AccountDetails> findAccountDetails() {
		
		return customerDao.findAccountDetails();
	}
	@Override
	public List<AccountDetails> viewAllAccounts(int customer_id) {
		return customerDao.viewAllAccounts(customer_id);
	}
	@Override
	public Address editAddress(Address address,int customer_id) {
		
		return customerDao.editAddress(address,customer_id);
	}
	
	@Override
	public List<TransactionDetails> MiniStatement(int accountNumber) {
		// TODO Auto-generated method stub
		return transactionServiceProxy.MiniStatement(accountNumber);
	}
	  @Override
	  public String checkBalance(int accountNumber) { 
	
	  return transactionServiceProxy.checkBalance(accountNumber); 
	  }
	 
	@Override
	public int changePassword(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userServiceProxy.changePassword(userDTO);
	}
	@Override
	public String withdrawMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType) {
		// TODO Auto-generated method stub
		return transactionServiceProxy.withdrawMoney(accountNumber, amount, description, userType, transactionType, accountType);
	}
	@Override
	public String DepositMoney(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType) {
		// TODO Auto-generated method stub
		return transactionServiceProxy.DepositMoney(accountNumber, amount, description, userType, transactionType, accountType);
	}
	@Override
	public List<TransactionDetails> CustomizedMiniStatement(int accountNumber, double amount, String fromDate,
			String toDate) {
		// TODO Auto-generated method stub
		return transactionServiceProxy.CustomizedMiniStatement(accountNumber, amount, fromDate, toDate);
	}
	@Override
	public String fundTransfer(int accountNumber, double amount, String description, String userType,
			String transactionType, String accountType) {
		// TODO Auto-generated method stub
		return transactionServiceProxy.fundTransfer(accountNumber, amount, description, userType, transactionType, accountType);
	}
	
	
	
}
