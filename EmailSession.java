import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.net.Authenticator;
import java.util.Properties;

public class EmailSession {

    public static Session getSession(String host, String port, String user, char[] password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(props);
    }

    public static Session getSession(String host, String port, String user, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSession'");
    }
}
