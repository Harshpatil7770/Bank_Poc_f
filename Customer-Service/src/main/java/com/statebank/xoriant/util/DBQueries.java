package com.statebank.xoriant.util;

public class DBQueries {

	public static final String EDIT_ADDRESS="update address set door_no=?,city=?, area=?, state=?, pincode=?, address_type=? where person_id=(SELECT person_id FROM customer where customer_id=?);";
	public static final String VIEW_ACCOUNT_INFO="select * from account_details bd inner join branch b on bd.branch_id=b.branch_id";
    public static final String VIEW_ACCOUNT_LIST="select ad.account_number,ad.balance,ad.customer_id,ad.account_type,b.branch_name from account_details ad  join branch b on ad.branch_id=b.branch_id where ad.customer_id=?;";
    public final static String CHANGE_PASSWORD="SELECT u.user_name, u.password, u.security_question, u.security_answer FROM user_login_details u join customer c on u.customer_id=c.customer_id where u.customer_id=?";
}

