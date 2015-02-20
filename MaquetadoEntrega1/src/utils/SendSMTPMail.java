package utils;

import java.io.*;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;


public class SendSMTPMail {

	public SendSMTPMail() {
		// TODO Auto-generated constructor stub
	}
	
	public void sendEmail(String from, String to, String subject, String content,String pass) throws IOException {

		
	    final String username = from;
	    final String password = pass;

	    //we set the email properties
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", 465);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.port", 465);
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.debug", "true");
	    props.put("mail.smtp.socketFactory.fallback", "false");
	    
	    Session session = Session.getInstance(props,new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });
	    
	    
	    try {
	    	MimeMessage msg = new MimeMessage(session);
		    msg.saveChanges();
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
	        message.setSubject(subject);
	        message.setText(content);
            message.setContent(content, message.getContentType());
            
            message.saveChanges();
	        
			Transport transport = session.getTransport("smtps");
			
			transport.connect("smtp.gmail.com",465, username, password);
            
            transport.sendMessage(message, InternetAddress.parse(to));
           
            transport.close();
	        
	    } catch (MessagingException e) {
	    	
	        e.printStackTrace();
	    }
	}
	


}
