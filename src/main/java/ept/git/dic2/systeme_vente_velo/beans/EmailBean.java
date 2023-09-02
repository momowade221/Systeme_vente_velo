package ept.git.dic2.systeme_vente_velo.beans;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Stateless
public class EmailBean {

    @Resource(name = "java:jboss/mail/Default")
    private Session mailSession;

    public void sendEmail(String recipient, String subject, String message) throws MessagingException {
        Message email = new MimeMessage(mailSession);
        email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        email.setSubject(subject);
        email.setText(message);
        Transport.send(email);
    }
}
