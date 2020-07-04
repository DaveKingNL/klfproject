
package com.dave.springsecuritytest.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import org.springframework.stereotype.Service;
/**
 *
 * @author davej
 */
@Service
public class MailSender {
    public static void sendEmail(String senderName, String mailMessage) {

        final String username = "your@gmail.com";
        final String password = "password";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("your@gmail.com")
            );
            message.setSubject("Message from contactform");
            message.setText("You have received the following message from user " + senderName
                    + "\n\n" + mailMessage);

            Transport.send(message);

            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
