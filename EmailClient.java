package src;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class EmailClient {
    public static void main(String[] args) {
        // SMTP server configuration
        String host = "smtp.gmail.com";
        String port = "587";
        String user = "your-email@gmail.com";  // Replace with your email
        String password = "your-email-password";  // Replace with your password

        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Get the Session object
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, 
                    InternetAddress.parse("recipient@example.com"));  // Replace with recipient email
            message.setSubject("Test Email from Java");
            message.setText("Hello! This is a test email sent from a Java program.");

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
