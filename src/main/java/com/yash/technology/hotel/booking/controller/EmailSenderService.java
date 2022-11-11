package com.yash.technology.hotel.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Service
public class EmailSenderService {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

	
	@Autowired
	private JavaMailSender mailSender;
	public void sendSimpleEmail(String toEmail,
			String body,String subject)
	{
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("dommy1008@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		logger.info("Otp is send to given email id");
		
	}
	
}
