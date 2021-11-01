package com.statebank.xoriant;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionService1Application {

	

	public static void main(String[] args) {
		SpringApplication.run(TransactionService1Application.class, args);	
		//AccountType type=null;
//		AccountType t=type.CURRENT;
		
	 
//		AccountType_ t_obj= new AccountType_(type.CURRENT);
//	 	System.out.println("First Account Type=="+t_obj.getAccountType());
//
// 	t_obj.setAccountType(type.SAVING);
// 	System.out.println(" New account Type=="+t_obj.getAccountType());
	
		 
//		 System.out.println("Account Type : =="+t.getAccountType());
}
}
