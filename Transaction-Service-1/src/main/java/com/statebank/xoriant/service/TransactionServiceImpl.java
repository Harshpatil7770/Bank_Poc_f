package com.statebank.xoriant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statebank.xoriant.dao.TransactionDao;
import com.statebank.xoriant.dao.util.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;

	@Override
	public String withdrawMoney(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return transactionDao.withdrawMoney(customerDTO);
	}

	@Override
	public String DepositMoney(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return transactionDao.DepositMoney(customerDTO);
	}

	@Override
	public List<TransactionDetails> MiniStatement(int accountNumber) {
		// TODO Auto-generated method stub
		return transactionDao.MiniStatement(accountNumber);
	}

	@Override
	public List<TransactionDetails> CustomizedMiniStatement(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return transactionDao.CustomizedMiniStatement(customerDTO);
	}

	@Override
	public String fundTransfer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return transactionDao.fundTransfer(customerDTO);
	}

	@Override
	public String checkBalance(int accountNumber) {
		// TODO Auto-generated method stub
		return transactionDao.checkBalance(accountNumber);
	}

	
}
