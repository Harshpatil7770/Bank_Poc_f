package com.statebank.xoriant.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.statebank.xoriant.model.CustomerDTO;
import com.statebank.xoriant.model.TransactionDetails;

@FeignClient(name ="transaction-service")
public interface TransactionServiceProxy {

	@GetMapping("/api/transaction/withdraw/{accountNumber}/{amount}/{description}/{userType}/{transactionType}/{accountType}")
	public String withdrawMoney(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String description, @PathVariable String userType,
			@PathVariable String transactionType,@PathVariable String accountType);
	
	@GetMapping("/api/transaction/deposite/{accountNumber}/{amount}/{description}/{userType}/{transactionType}/{accountType}")
	public String DepositMoney(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String description, @PathVariable String userType,
			@PathVariable String transactionType,@PathVariable String accountType);
	
	@GetMapping("/api/transaction/fundTransfer/{accountNumber}/{amount}/{description}/{userType}/{transactionType}/{accountType}")
	public String fundTransfer(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String description, @PathVariable String userType,
			@PathVariable String transactionType,@PathVariable String accountType);
	
	@GetMapping("/api/transaction/customizedStatement/{accountNumber}/{amount}/{fromDate}/{toDate}}")
	public List<TransactionDetails> CustomizedMiniStatement(@PathVariable int accountNumber,@PathVariable double amount, @PathVariable String fromDate, @PathVariable String toDate);

	@GetMapping("/api/transaction/miniStatement/{accountNumber}")
	public List<TransactionDetails> MiniStatement(@PathVariable int accountNumber);
	
	 @GetMapping("/api/transaction/checkBalance/{accountNumber}") public String
	 checkBalance(@PathVariable int accountNumber);
	 
	 
}
