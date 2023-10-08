package ept.git.dic2.systeme_vente_velo.beans;//package ept.git.dic2.systeme_vente_velo.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.mail.*;

@Singleton
//@Startup
public class StartupShutdownBean {
    @EJB
    private EmailBean emailBean;

    @PostConstruct
    public void sendStartupEmail() {
        try {
            emailBean.sendEmail("recipient@example.com", "Application Started", "The application has started.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void sendShutdownEmail() {
        try {
            emailBean.sendEmail("recipient@example.com", "Application Shutdown", "The application is shutting down.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
