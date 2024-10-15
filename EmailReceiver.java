import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;

import java.util.Properties;

public class EmailReceiver {
    public static void fetchInbox(Session session) {
        try {
            Store store = session.getStore("imap");
            store.connect("imap.yourmail.com", "your-email@example.com", "password");

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            for (Message msg : inbox.getMessages()) {
                System.out.println("Subject: " + msg.getSubject());
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
