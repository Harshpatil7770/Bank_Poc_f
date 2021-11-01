package com.statebank.xoriant.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.AccountType;
import com.statebank.xoriant.model.Address;
import com.statebank.xoriant.model.Branch;
import com.statebank.xoriant.model.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.util.DBQueries;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Address editAddress(Address address,int customer_id) {     
     int res= jdbcTemplate.update(DBQueries.EDIT_ADDRESS,address.getDoorNo(),address.getCity(),
    		 address.getArea(),address.getState(),address.getPincode(),address.getAddressType(),customer_id);
		System.out.println("================Address Changed==============");
		
		if (res != 0) {
			return address;
		}
	return null;
}

	@Override
	public List<AccountDetails> findAccountDetails() {
		
		return jdbcTemplate.query(DBQueries.VIEW_ACCOUNT_INFO,(ResultSet rs)->{
			List<AccountDetails> accountDetails=new ArrayList<AccountDetails>();
			while(rs.next()) {
				AccountDetails accontD=new AccountDetails();

				Branch branch=new Branch();
				
				accontD.setAccountId(rs.getInt("account_number"));
				accontD.setBalance(rs.getDouble("balance"));
			    accontD.setBranchId(rs.getInt("branch_id"));
			    accontD.setCustomerId(rs.getInt("customer_id"));
			  
			    accontD.setAccountType(rs.getString("account_type"));
			  
			    
			    branch.setBranchId(rs.getInt("branch_id"));
			    branch.setBranchName(rs.getString("branch_name"));
			    branch.setIfscCode(rs.getString("ifsc_code"));
			    branch.setMicrCode(rs.getString("micr_code"));	
			    
			    accontD.setBranch(branch);
			    accountDetails.add(accontD);
			    
			    
			}
			return accountDetails;
		});
	
	}

	@Override
	public List<AccountDetails> viewAllAccounts(int customer_Id) {
		return jdbcTemplate.query(DBQueries.VIEW_ACCOUNT_LIST,(ResultSet rs)->{
			List<AccountDetails> accountDetails=new ArrayList<AccountDetails>();
			while(rs.next()) {
				AccountDetails accontD=new AccountDetails();
				accontD.setAccountId(rs.getInt(1));
				accontD.setBalance(rs.getDouble(2));
				accontD.setCustomerId(rs.getInt(3));
				 accontD.setAccountType(rs.getString(4));
				accontD.setBranchName(rs.getString(5));
				
				accountDetails.add(accontD);			
				
			}
			return accountDetails;
		},customer_Id);
	}


}
