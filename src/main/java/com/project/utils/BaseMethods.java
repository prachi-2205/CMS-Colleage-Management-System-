package com.project.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class BaseMethods {

	private String from = "noreply.cmsproject@gmail.com";
	private String password = "3yearProject";

	public static String getUsername() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}
	
	

	public String generatePassword() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public String generateMailBody(String firstName, String type, String username, String password) {
		return "Hello, " + firstName + "<br> Welcome to CMS system. You are registered as " + type
				+ " by administration of the college. below are the credentials for login. <br><br>"
				+ "<b>Username : </b>" + username + "<br>" + "<b>Password : </b>" + password;
	}

	public void sendMail(String subject, String messagetext, String recipient) {

		// Getting properties object
		Properties properties = new Properties();

		// setting smtp config
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// step:1 Get The Session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		// step:2 compose the message
		try {
			MimeMessage message = new MimeMessage(session);

			// from email
			message.setFrom(new InternetAddress(from));

			// to email
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// set subject
			message.setSubject(subject);

			// set content
			message.setContent(messagetext, "text/html");

			// step:3 send the message
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public String generateMailBody(String username, int otp) {
		// TODO Auto-generated method stub
		return "Hello,"
		+ "<br><br><center><table border='1'>" + "<tr>"
		+ "<th colspan='2' style='color:hotpink;'>FROM BRIGHT FUTURE COLLEGE</th>" + "</tr>" + "<tr>"
		+ "<td>Username  </td>" + "<td>" + username + "</td>" + "</tr>" + "<tr>"
		+ "<td>OTP </td>" + "<td>" + otp + "</td>" + "</tr>" + "</table></center>";
	}
	
	
	public String generateMailBody1(String username, String password) {
		// TODO Auto-generated method stub
		return "YOUR PASSWORD IS CHANGED....."
		+ "<br><br><center><table border='1'>" + "<tr>"
		+ "<th colspan='2' style='color:hotpink;'>FROM BRIGHT FUTURE COLLEGE</th>" + "</tr>" + "<tr>"
		+ "<td>USERNAME  </td>" + "<td>" + username + "</td>" + "</tr>" + "<tr>"
		+ "<td>NEW PASSWORD </td>" + "<td>" + password + "</td>" + "</tr>" + "</table></center>";
	}
	
	

	
}
