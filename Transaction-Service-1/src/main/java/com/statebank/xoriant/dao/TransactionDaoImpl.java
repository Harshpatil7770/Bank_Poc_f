package com.statebank.xoriant.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.statebank.xoriant.dao.util.CommonMethods;
import com.statebank.xoriant.dao.util.CustomerDTO;
import com.statebank.xoriant.dao.util.DBQueries;
import com.statebank.xoriant.dao.util.DTO;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.model.TransactionType;
import com.statebank.xoriant.resource.MailSender;


@Repository
public class TransactionDaoImpl implements TransactionDao  {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MailSender sender;

	String DETAILS_ARE_INVALID = "Details are invalid !!";
	
	@Override
	public String withdrawMoney(CustomerDTO customerDTO) {

		DTO obj = DTO.getData(customerDTO.getAccountNumber(), jdbcTemplate);
		int balance = (int) obj.getAmount();
		int remainingAmt =0;
		
		if (balance > customerDTO.getAmount()) {

			int res = jdbcTemplate.update(DBQueries.WITHDRAW_MONEY, CommonMethods.getTransactionId(), customerDTO.getAmount(),
					CommonMethods.getCurrentDate(), customerDTO.getAccountNumber(), customerDTO.getDescription(),customerDTO.getPayeesAccountNumber() ,customerDTO.getTransactionType(),customerDTO.getAccountType());
			remainingAmt = (int) (balance - customerDTO.getAmount());

			int n = jdbcTemplate.update(DBQueries.UPDATE_ACCOUNT_BALNCE, remainingAmt, customerDTO.getAccountNumber());
			if (n != 0) {
				
				sender.sendWithdrawDetails(customerDTO.getAmount(),remainingAmt);
				String msg= customerDTO.getAmount()+"Debited form your account, remaining balance is :"+remainingAmt;
				return msg;
			}

		}
		return DETAILS_ARE_INVALID;
	}

	@Override
	public String DepositMoney(CustomerDTO customerDTO) {

		
		DTO obj = DTO.getData(customerDTO.getAccountNumber(), jdbcTemplate);
		int balance = (int) obj.getAmount();

		int res = jdbcTemplate.update(DBQueries.DEPOSIT_MONEY, CommonMethods.getTransactionId(), customerDTO.getAmount(),
				CommonMethods.getCurrentDate(),  customerDTO.getAccountNumber(), customerDTO.getDescription(),customerDTO.getPayeesAccountNumber(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		int newBalance = (int) (balance + customerDTO.getAmount());

		int n = jdbcTemplate.update(DBQueries.UPDATE_ACCOUNT_BALNCE, newBalance, customerDTO.getAccountNumber());

		if (n != 0) {
			
			sender.sendDepositeDetails(customerDTO.getAmount(),newBalance);
			String msg= customerDTO.getAmount()+"Creadited in your account,new balance is :"+newBalance;
			return msg;
		}
		return DETAILS_ARE_INVALID;
	}

	
	@Override
	public List<TransactionDetails> MiniStatement(int accountNumber) {
System.out.println(" geting mini statement and account Number is ::"+accountNumber);
		return jdbcTemplate.query(DBQueries.MINI_STATEMENT, (ResultSet rs) -> {
			List<TransactionDetails> transList = new ArrayList<TransactionDetails>();

			while (rs.next()) {
				TransactionDetails details = new TransactionDetails();
				System.out.println("fetching the transaction ");
				details.setTransactionId(rs.getInt(1));
				details.setAmount(rs.getInt(2));
				details.setTransactionDate(rs.getString(3));
				details.setAccountNumber(rs.getInt(4));
				details.setDescription(rs.getString(5));
				details.setPayeesAccountNumber(rs.getInt(6));
				details.setTransactionType(rs.getString(7));
		     	
				details.setAccountType(rs.getString(8));

				transList.add(details);
			}
			System.out.println("transaction details="+transList);
			return transList;

		}, accountNumber);

	}


	@Override
	public List<TransactionDetails> CustomizedMiniStatement(CustomerDTO customerDTO) {

		return jdbcTemplate.query(DBQueries.CUSTOMIZED_MINI_STATEMENT, (ResultSet rs) -> {
			List<TransactionDetails> transList = new ArrayList<TransactionDetails>();

			while (rs.next()) {
				TransactionDetails details = new TransactionDetails();
				System.out.println("fetching the transaction ");
				details.setTransactionId(rs.getInt(1));
				details.setAmount(rs.getInt(2));
				details.setTransactionDate(rs.getString(3));
				details.setAccountNumber(rs.getInt(4));
				details.setDescription(rs.getString(5));
				details.setPayeesAccountNumber(rs.getInt(6));
				details.setTransactionType(rs.getString(7));
		     	
				details.setAccountType(rs.getString(8));
				transList.add(details);
			}
			return transList;

		},customerDTO);

	}

	@Override
	public String fundTransfer(CustomerDTO customerDTO) {


		DTO obj = DTO.getData(customerDTO.getAccountNumber(), jdbcTemplate);
		int balance = (int) obj.getAmount();

		if (balance > customerDTO.getAmount()) {

			int res = jdbcTemplate.update(DBQueries.WITHDRAW_MONEY,  CommonMethods.getTransactionId(), customerDTO.getAmount(),
					CommonMethods.getCurrentDate(),  customerDTO.getAccountNumber(), customerDTO.getDescription(),customerDTO.getPayeesAccountNumber(),customerDTO.getTransactionType(),customerDTO.getAccountType());
			int remainingAmt = (int) (balance -  customerDTO.getAmount());

			int n = jdbcTemplate.update(DBQueries.UPDATE_ACCOUNT_BALNCE, remainingAmt, customerDTO.getAccountNumber());
			if (n != 0) {
				
				sender.sendFundTransaferDetails( customerDTO.getAmount(),remainingAmt);
				String msg= customerDTO.getAmount()+"Fund is Transfered from your account,new balance is :"+remainingAmt;
				return msg;
			}

		}
		return DETAILS_ARE_INVALID;
	}


	@Override
	public String checkBalance(int accountNumber) {
		System.out.println("<<<<<<<<<<<<<<<<<INSIDE CHECK BALANCE>>>>>>>>>>>>>>>>>");
		DTO dto = null;
		try {
			dto = DTO.getData(accountNumber, jdbcTemplate);
			double balance = dto.getAmount();
			
			sender.balanceInquiry(balance);
			String msg= "new balance is :"+balance;
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  DETAILS_ARE_INVALID;
		
	}

}
