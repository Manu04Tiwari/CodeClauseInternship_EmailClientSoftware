import javax.swing.*;

import jakarta.mail.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailClientGUI extends JFrame {

    public EmailClientGUI() {
        setTitle("Email Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField toField = new JTextField(30);
        JTextField subjectField = new JTextField(30);
        JTextArea bodyArea = new JTextArea(5, 30);
        JButton sendButton = new JButton("Send Email");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String to = toField.getText();
                String subject = subjectField.getText();
                String body = bodyArea.getText();

                Session session = EmailSession.getSession("smtp.yourmail.com", "587", 
                        "your-email@example.com", "password");
                EmailSender.sendEmail(session, to, subject, body);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("To:"));
        panel.add(toField);
        panel.add(new JLabel("Subject:"));
        panel.add(subjectField);
        panel.add(new JScrollPane(bodyArea));
        panel.add(sendButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmailClientGUI();
    }
}
