package com.statebank.xoriant.resource;



import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
@Controller
public class MailSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Bean
	public Queue f1() {
		return new Queue("passwordChangeQ", false);
	}
	
	
	public void changePasswordDetails(String password) {
		String msg="Your New Password is :: "+password;
		rabbitTemplate.convertAndSend("passwordChangeQ",msg);
	}

}
