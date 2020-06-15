package tn.esprit.spring.utility;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Niyaz-laptop
 */
public class MailSender implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void SendMail(String toMail,String subject,String content){
	final String username = "dari.simulation@gmail.com";
	final String password = "dari4119341193";

	Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.port", "465");
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.socketFactory.port", "465");
	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	});

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("dari.simulation@gamil.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
		message.setSubject(subject);
		message.setText(content);

		Transport.send(message);

		System.out.println("Mail Sent");

	} catch (MessagingException e) {
		e.printStackTrace();
	}


}

}
