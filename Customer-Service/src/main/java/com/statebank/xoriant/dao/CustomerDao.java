package com.statebank.xoriant.dao;

import java.util.List;

import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.Address;
import com.statebank.xoriant.model.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;


public interface CustomerDao {


	public Address editAddress(Address address,int customer_id);
	
	public List<AccountDetails> findAccountDetails();
	
	public List<AccountDetails> viewAllAccounts(int customer_id);

	
}
