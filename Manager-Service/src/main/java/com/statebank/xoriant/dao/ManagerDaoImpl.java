package com.statebank.xoriant.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.statebank.xoriant.dao.util.CommonMethods;
import com.statebank.xoriant.dao.util.DBQueries;
import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.Branch;
import com.statebank.xoriant.model.PersonInfo;

 

@Repository
public class ManagerDaoImpl implements ManagerDao  {

	public static final String SAVING = "SAVING";
	private static final String MANAGER = "MANAGER";
	private static final String CUSTOMER = "CUSTOMER";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Branch addNewBranch(Branch branch) {
		
		int res = jdbcTemplate.update(DBQueries.ADD_NEW_BRANCH,CommonMethods.getBranchId(), branch.getBranchName(),
				branch.getIfscCode(),branch.getMicrCode(),branch.getManagerId());

		if (res != 0) {
			return branch;
		}

		return null;	
	}
	
 @Override
public PersonInfo addNewPerson(PersonInfo personInfo) {
	personInfo.getAddress().setAddressId(CommonMethods.getAddressId());
	personInfo.setPersonId(CommonMethods.getPersonId());
	System.out.println("PERSON ID=="+personInfo.getPersonId());
	System.out.println("ADDRESS ID=="+personInfo.getAddress().getAddressId());
	
	/*
	 * System.out.println("Data="+personInfo.getAddress().getAddressId()+",next="+
	 * personInfo.getAddress().getDoorNo()+",next="+
	 * personInfo.getAddress().getCity()+",next="+personInfo.getAddress().getArea()+
	 * ",next="+
	 * personInfo.getAddress().getState()+",next="+personInfo.getAddress().
	 * getPincode()+",next="+
	 * personInfo.getAddress().getAddressType()+",next="+personInfo.getAddress().
	 * getBranchId()+",next="+ personInfo.getPersonId());
	 */
	int res = jdbcTemplate.update(DBQueries.ADD_NEW_ADDRESS,personInfo.getAddress().getAddressId(),personInfo.getAddress().getDoorNo(),
			personInfo.getAddress().getCity(),personInfo.getAddress().getArea(),
			personInfo.getAddress().getState(),personInfo.getAddress().getPincode(),
			personInfo.getAddress().getAddressType(),personInfo.getAddress().getBranchId(),
			personInfo.getPersonId());
	
	System.out.println("================Address Inserted====================");
	
		if (personInfo.getAddress().getAddressId() != 0) {

			int res1 = jdbcTemplate.update(DBQueries.ADD_NEW_PERSON,personInfo.getPersonId(),personInfo.getPersonName(),
					personInfo.getDob(), personInfo.getMobNumber(),personInfo.getAddress().getAddressId(),
					personInfo.getPersonType(),personInfo.getRole(),personInfo.getGender());
			
			System.out.println("==================Person Inserted=======================");
			
			if(personInfo.getPersonType().equals(CUSTOMER)) {
				
				int res2 = jdbcTemplate.update(DBQueries.ADD_NEW_CUSTOMER,CommonMethods.getCustomerId(),personInfo.getPersonId());
				System.out.println("=================Customer Inserted=======================");
			}
			return personInfo;
		}

		return null;	
	}

 
@Override
public int updateCustomer(int accountNumber,PersonInfo personInfo) {
	

		int res = jdbcTemplate.update(DBQueries.UPDATE_CUSTOMER,personInfo.getPersonName(),personInfo.getDob(),
				personInfo.getMobNumber(),accountNumber);
		
		System.out.println("================Customer Updated Inserted====================");
		if(res==1)
		return res;
		
		return 0;	
}

 @Override
public void deleteCustomer(int customer_id) {
	System.out.println("Inside delete method");
	//System.out.println("METHOD value return="+checkCustomer_id(customer_id));
	
	if( checkCustomer_id(customer_id) ==true)
	{
		System.out.println("==========CUSTOMER ID present into DB===="+customer_id);
		String personId=getPersonId(customer_id);
		int r0 = jdbcTemplate.update(DBQueries.DELETE_CUSTOMER_Q0,customer_id );
		int r1 = jdbcTemplate.update(DBQueries.DELETE_CUSTOMER_Q1,customer_id );
		int r2 = jdbcTemplate.update(DBQueries.DELETE_CUSTOMER_Q2,customer_id );
		int r3 = jdbcTemplate.update(DBQueries.DELETE_CUSTOMER_Q3,customer_id );
		System.out.println("==========Person ID ID===="+personId);
		int r4= jdbcTemplate.update(DBQueries.DELETE_CUSTOMER_Q4,customer_id );
//		
		int r5= jdbcTemplate.update(DBQueries.DELETE_CUSTOMER_Q5,personId );
		
		System.out.println("========= CUSTOMER DELETED===="+customer_id);
		 
	}
	else
		System.out.println("==========Not present CUSTOMER ID===="+customer_id);
  
		 
	}

 @Override
public void addAccount(String roleType,int accountId,int balance,int customerId,int managerId,int accountTypeId,int branchId)
{
	if(roleType.equals(MANAGER))
	{
		int res1 = jdbcTemplate.update(DBQueries.ADD_NEW_ACCOUNT,accountId,balance,customerId,accountTypeId,branchId);
		int res2 = jdbcTemplate.update(DBQueries.ADD_NEW_PERSON_ACCOUNT, customerId,managerId,accountId);
		if(accountTypeId==1)
		{
			int res3 = jdbcTemplate.update(DBQueries.ADD_NEW_SAVING_ACCOUNT,accountId,DBQueries.s_interest_rate,DBQueries.s_minimum_balance,DBQueries.s_transaction_limit,DBQueries.s_transaction_amount_limit);
			
		}
		else
		{
			int res4 = jdbcTemplate.update(DBQueries.ADD_NEW_CURRENT_ACCOUNT,accountId,DBQueries.c_transaction_limit, DBQueries.c_minimum_balance,DBQueries.c_transaction_amount_limit );
			
		}
		System.out.println("================New Account Inserted====================");
		
	}
	else
		System.out.println(" permission restricted...!");
 
	
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
	public int updateAccount(int customerId, int accountNumber, String accountType, int balance) {

		System.out.println("OLD ACCOUNT TYPE="+getOldAccountType(accountNumber));
		if (getOldAccountType(accountNumber).equals(SAVING)) {
			
		
			int res2 = jdbcTemplate.update(DBQueries.DELETE_ACCOUNT_FROM_SAVING_ACCOUNT_TABLE,accountNumber);


			System.out.println("DELETED from saving");
		} else {
			System.out.println("OLD ACCOUNT TYPE="+getOldAccountType(accountNumber));
			int res2 = jdbcTemplate.update(DBQueries.DELETE_ACCOUNT_FROM_CURRENT_ACCOUNT_TABLE,accountNumber);


			System.out.println("DELETED from CURRENT");

		}
		

		int res2 = jdbcTemplate.update(DBQueries.UPDATE_ACCOUNT, balance, accountType, accountNumber, customerId);
		
		if (accountType.equals(SAVING)) {
			int res3 = jdbcTemplate.update(DBQueries.ADD_NEW_SAVING_ACCOUNT , DBQueries.s_interest_rate,
					DBQueries.s_minimum_balance, DBQueries.s_transaction_limit, DBQueries.s_transaction_amount_limit,accountNumber);

		} else {
			int res4 = jdbcTemplate.update(DBQueries.ADD_NEW_CURRENT_ACCOUNT, DBQueries.c_transaction_limit,
					DBQueries.c_minimum_balance, DBQueries.c_transaction_amount_limit,accountNumber);

		}
	if (res2 == 1)
			System.out.println("Account Updated successfully............");
		return 1;
	}
 @Override
	public int deleteAccount(int customerId, int accountNumber, String accountType) {

	  
		if (getOldAccountType(accountNumber).equals(SAVING)) {
			
		
			int res2 = jdbcTemplate.update(DBQueries.DELETE_ACCOUNT_FROM_SAVING_ACCOUNT_TABLE,accountNumber);


			System.out.println("DELETED from saving");
		} else {
			 
			int res2 = jdbcTemplate.update(DBQueries.DELETE_ACCOUNT_FROM_CURRENT_ACCOUNT_TABLE,accountNumber);


			System.out.println("DELETED from CURRENT");

		}
		
		//delete from delete from person_account  ;
		int res2 = jdbcTemplate.update(DBQueries.DELETE_ACCOUNT_FROM_PERSON_ACCOUNT,accountNumber);
		int res12 = jdbcTemplate.update(DBQueries.DELETE_ACCOUNT_FROM_ACCOUNT_DETAILS,accountNumber);

	  
		if(res12==1)
			System.out.println("Account DELETED successfully............");
		return 1;
	}
	
	
	public String getPersonId(int customer_id) {

		return (String) jdbcTemplate.queryForObject(DBQueries.SELCET_PERSON_ID, String.class, customer_id);
	}

	
	public Boolean checkCustomer_id(int customer_id) {
		return jdbcTemplate.queryForObject(DBQueries.CHECK_CUSTOMER_ID, Boolean.class, customer_id);

	}
	
	
	public String getOldAccountType(int accountId) {

		return (String) jdbcTemplate.queryForObject(DBQueries.GET_OLD_ACCOUNT_TYPE, String.class, accountId);
	}

}
