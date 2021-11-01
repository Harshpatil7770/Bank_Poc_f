package com.statebank.xoriant.resource;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statebank.xoriant.dao.util.CustomerDTO;
import com.statebank.xoriant.model.AccountDetails;
import com.statebank.xoriant.model.Branch;
import com.statebank.xoriant.model.PersonInfo;
import com.statebank.xoriant.model.TransactionDetails;
import com.statebank.xoriant.service.ManagerService;

@RestController
@RequestMapping("/api/manager")
@CrossOrigin
@RefreshScope
public class ManagerResource {

	@Autowired(required = false)
	ManagerService managerService;
	
	@PostMapping("/addBranch")
	public Branch addNewBranch(@RequestBody Branch branch) {
		
		return managerService.addNewBranch(branch);
	}
	@PostMapping("/addNewPerson")
	public PersonInfo addNewPerson(@RequestBody PersonInfo personInfo) {
		
		return managerService.addNewPerson(personInfo);
	}

	@PutMapping("/updateCustomer/{accountNumber}")
	public int updateCustomer(@PathVariable int accountNumber,@RequestBody PersonInfo personInfo)
	{
		return managerService.updateCustomer(accountNumber, personInfo);
	}

	 

	@DeleteMapping("/deleteCustomer/{customer_id}")

	public void deleteCustomer( @PathVariable int customer_id) {
		
		managerService.deleteCustomer(customer_id );
	}
	
	  public void addAccount(String roleType, int accountId, int balance, int
	  customerId, int managerId, int accountTypeId, int branchId) {
	  managerService.addAccount(roleType, accountId, balance, customerId,
	  managerId, accountTypeId, branchId);
	  
	  }
	 
	
	//Not  Working
	@GetMapping("/findAccountDetails") // manager method
	public List<AccountDetails> findAccountDetails(){
		return managerService.findAccountDetails();
	}
	
	@GetMapping("/withdraw")
	public String withdrawMoney(@RequestBody CustomerDTO customerDTO) {
		String balance = managerService.withdrawMoney(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getDescription(),
				customerDTO.getUserType(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		
		return balance;
	}
	@GetMapping("/deposite")
	public String DepositMoney(@RequestBody CustomerDTO customerDTO) {
		String balance = managerService.DepositMoney(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getDescription(),
				customerDTO.getUserType(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		return balance;
		
		
	}
	//Not working
	@GetMapping("/miniStatement/{accountNumber}")
	public List<TransactionDetails> MiniStatement(@PathVariable int accountNumber){
		
		List<TransactionDetails> list =managerService.MiniStatement(accountNumber);
		
		return list;
		
	}
	//NOT WORKING
	@GetMapping("/customizedStatement")
	public List<TransactionDetails> CustomizedMiniStatement(@RequestBody CustomerDTO customerDTO){
		
		List<TransactionDetails> list = managerService.CustomizedMiniStatement(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getFormDate(),
				customerDTO.getToDate());
		
		return list;
	}
	@GetMapping("/fundTransfer")
	public String fundTransfer(@RequestBody CustomerDTO customerDTO) {
		
		String balance = managerService.fundTransfer(customerDTO.getAccountNumber(),customerDTO.getAmount(),customerDTO.getDescription(),
				customerDTO.getUserType(),customerDTO.getTransactionType(),customerDTO.getAccountType());
		return balance;
		
	}
	
	
	  @GetMapping("/checkBalance/{accountNumber}")
	  public String checkBalance(@PathVariable int accountNumber) {
	  
	  String balance = managerService.checkBalance(accountNumber);
	  
	  return balance;
	  }
	  
	  @PutMapping("/updateAccount/{customerId}/{accountNumber}/{accountType}/{balance}")
		public int updateAccount(@PathVariable int customerId,@PathVariable  int accountNumber, @PathVariable String accountType,@PathVariable int balance) {
			// TODO Auto-generated method stub
			return managerService.updateAccount(customerId, accountNumber, accountType, balance);
		}

	  @DeleteMapping("/deleteAccount/{customerId}/{accountNumber}/{accountType}")
		public int deleteAccount(@PathVariable int customerId,@PathVariable int accountNumber,@PathVariable  String accountType) {
			// TODO Auto-generated method stub
			return managerService.deleteAccount(customerId, accountNumber, accountType);
		}
	
}
