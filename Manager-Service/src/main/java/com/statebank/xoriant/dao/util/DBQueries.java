package com.statebank.xoriant.dao.util;

public class DBQueries {
	//for saving account
	public final static String  s_interest_rate="15", s_minimum_balance="1000",
			s_transaction_limit="10", s_transaction_amount_limit="20000";
	
	//for current account
		public final static String  c_interest_rate="10", c_minimum_balance="5000",
				c_transaction_limit="20", c_transaction_amount_limit="50000";
	    public final static String CHANGE_PASSWORD="SELECT u.user_name, u.password, u.security_question, u.security_answer FROM user_login_details u join customer c on u.customer_id=c.customer_id where u.customer_id=?";

	public final static String ALL_CUSTOMER_LIST="select * from customer";
	public final static String VIEW_ACCOUNT_INFO="select * from account_details";
	public static final String ADD_NEW_PERSON="insert into personinfo values(?,?,?,?,?,?,?,?)";
	public static final String ADD_NEW_CUSTOMER="insert into customer values(?,?)";
	public static final String ADD_NEW_MANAGER="insert into manager values(?,?)";
	public static final String ADD_NEW_ADDRESS="insert into address values(?,?,?,?,?,?,?,?,?)";
	public static final String ADD_NEW_BRANCH="insert into branch values(?,?,?,?,?)";
	public static final String UPDATE_CUSTOMER="update  personinfo set person_name=?, dob=?, phone_number=? where person_id =(SELECT person_id FROM state_bank.customer where customer_id=?);";
	
	public static final String SELCET_PERSON_ID="SELECT person_id FROM customer where customer_id=?; ";

	
	public static final String DELETE_CUSTOMER_Q0=" delete  from transaction_details where account_number=(select  account_number from account_details where customer_id=?);";
	public static final String DELETE_CUSTOMER_Q1="delete  FROM  person_account where customer_id=?;";
	public static final String DELETE_CUSTOMER_Q2="delete FROM  account_details where customer_id=?;";
	
	public static final String DELETE_CUSTOMER_Q3="delete  FROM user_login_details where customer_id=? ;";
	public static final String DELETE_CUSTOMER_Q4="delete  FROM  customer where customer_id=?; ";

	public static final String DELETE_CUSTOMER_Q5="DELETE  from personinfo where person_id=? ;";
	public static final String ADD_NEW_CURRENT_ACCOUNT="insert into currentaccount( transaction_limit, minimum_balance, transaction_amount_limit, account_number) values(?,?,?,?)";
	
	public static final String ADD_NEW_SAVING_ACCOUNT="insert into savingaccount (interest_rate, minimum_balance, transaction_limit, transaction_amount_limit, account_number)values(?,?,?,?,?)";
	
	
	public static final String DELETE_ACCOUNT_FROM_PERSON_ACCOUNT="delete from person_account where account_number=?";
	public static final String DELETE_ACCOUNT_FROM_ACCOUNT_DETAILS="delete from account_details where account_number=?;";

	public static final String GET_OLD_ACCOUNT_TYPE="SELECT account_type FROM state_bank.account_details where account_number=?;";
	public static final String DELETE_ACCOUNT_FROM_CURRENT_ACCOUNT_TABLE="delete from currentaccount where account_number=?";
	public static final String DELETE_ACCOUNT_FROM_SAVING_ACCOUNT_TABLE="delete from savingaccount where account_number=?";
	

	public static final String UPDATE_ACCOUNT="  update  account_details set balance=?, account_type=? where account_number=? AND customer_id=?;";

	public static final String DELETE_CUSTOMER_Q6="DELETE  from address where person_id=? ;";
	
	public static final String CHECK_CUSTOMER_ID="SELECT EXISTS(SELECT customer_id FROM customer where customer_id=?);";

	public static final String ADD_NEW_ACCOUNT="insert into account_details values(?,?,?,?,?)";
	public static final String ADD_NEW_PERSON_ACCOUNT="insert into person_account(customer_id, manager_id, account_number) values(?,?,?)";
	
	
} 
