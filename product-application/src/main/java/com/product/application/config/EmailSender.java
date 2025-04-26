package com.product.application.config;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.product.application.dto.UsersDTO;

@Component
public class EmailSender {

	@Value("${mail_host}")
	private String hostName;

	@Value("${mail_port}")
	private String portNumber;
	
	@Value("${mail_username}")
	private String mailUserName;
	
	@Value("${mail_password}")
	private String mailPassword;

	public boolean mailSender(UsersDTO userDetails) {
		// SMTP Server (Gmail example)
		//String host = "smtp.gmail.com";
		//String port = "587";
		
		String host = hostName;
		String port = portNumber;
		final String username = mailUserName; // Replace with your email
		final String password = mailPassword; // Replace with your app password

		// SMTP Properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);

		// Create a Session with authentication
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a MimeMessage
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userDetails.getEmail()));
			message.setSubject("Account created Sucessfully");
			message.setText("Hello "+userDetails.getUserName() +", "+ "We confirming you that your Account as been created successfully");
			
			// Send Email
			Transport.send(message);
			System.out.println("Email sent successfully!");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}

	}
}