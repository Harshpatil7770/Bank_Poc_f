package com.statebank.xoriant.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class EmailReceiver {

	@Autowired
	private JavaMailSender javaMailSender;

	@RabbitListener(queues = "passwordChangeQ")
	public void balanceInquiry(String bankMsg) {
		 System.out.println("===========> Password changed:: ****====**** <===========");
			System.out.println(bankMsg);
			
	       

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("harshawardhanpatil9343@gmail.com","ctsgit@gmail.com");
	    
	        msg.setSubject("Your Password Has Changed");
	        msg.setText(bankMsg);

	        javaMailSender.send(msg);
	}


}
