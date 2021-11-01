package com.statebank.xoriant.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statebank.xoriant.dao.util.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin
@RefreshScope
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;

	
	@GetMapping("/withdraw/{accountNumber}/{amount}/{description}/{userType}/{transactionType}/{accountType}")
	public String withdrawMoney(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String description,@PathVariable String userType,
			@PathVariable String transactionType,@PathVariable String accountType) {
		
		CustomerDTO dto=new CustomerDTO();
		dto.setAccountNumber(accountNumber);
		dto.setAmount(amount);
		dto.setDescription(description);
		dto.setTransactionType(transactionType);
		dto.setUserType(userType);
		dto.setAccountType(accountType);
		return transactionService.withdrawMoney(dto);
	}
	
	@GetMapping("/deposite/{accountNumber}/{amount}/{description}/{userType}/{transactionType}/{accountType}")
	public String DepositMoney(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String description,@PathVariable String userType,
			@PathVariable String transactionType,@PathVariable String accountType) {
		CustomerDTO dto=new CustomerDTO();
		dto.setAccountNumber(accountNumber);
		dto.setAmount(amount);
		dto.setDescription(description);
		dto.setTransactionType(transactionType);
		dto.setUserType(userType);
		dto.setAccountType(accountType);
		System.out.println("<<<<<<<<<<<<<<<<<<< EXECUTED BY SERVICE 1  >>>>>>>>>>>>>>>>>");
		return  transactionService.DepositMoney(dto);
	}

	@GetMapping("/miniStatement/{accountNumber}")
	public List<TransactionDetails> MiniStatement(@PathVariable int accountNumber) {
		System.out.println("<<<<<<<<<<<<<<<<<<< EXECUTED BY SERVICE 1  >>>>>>>>>>>>>>>>>");
		return transactionService.MiniStatement(accountNumber);

	}
	@GetMapping("/customizedStatement/{accountNumber}/{amount}/{fromDate}/{toDate}")
	public List<TransactionDetails> CustomizedMiniStatement(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String fromDate,@PathVariable String toDate) {
	 {
		 CustomerDTO dto=new CustomerDTO();
			dto.setAccountNumber(accountNumber);
			dto.setAmount(amount);
			dto.setFormDate(fromDate);
			dto.setToDate(toDate);
			
	 
		System.out.println("<<<<<<<<<<<<<<<<<<< EXECUTED BY SERVICE 1  >>>>>>>>>>>>>>>>>");
		return transactionService.CustomizedMiniStatement(dto);

	}
}

	@GetMapping("/fundTransfer/{accountNumber}/{amount}/{description}/{userType}/{transactionType}/{accountType}")
	public String fundTransfer(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String description,@PathVariable String userType,
			@PathVariable String transactionType,@PathVariable String accountType) {
		 CustomerDTO dto=new CustomerDTO();
			dto.setAccountNumber(accountNumber);
			dto.setAmount(amount);
			dto.setDescription(description);
			dto.setTransactionType(transactionType);
			dto.setUserType(userType);
			dto.setAccountType(accountType);
		System.out.println("<<<<<<<<<<<<<<<<<<< EXECUTED BY SERVICE 1  >>>>>>>>>>>>>>>>>");
		return transactionService.fundTransfer(dto);

	}

	
	  @GetMapping("/checkBalance/{accountNumber}")
	  public String checkBalance(@PathVariable int accountNumber) { 
		  System.out.println("<<<<<<<<<<<<<<<<<<< EXECUTED BY SERVICE 1  >>>>>>>>>>>>>>>>>");
		  return transactionService.checkBalance(accountNumber);
	  
	  }
	 
	

}
