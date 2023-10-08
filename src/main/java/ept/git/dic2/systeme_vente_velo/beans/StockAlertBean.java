package ept.git.dic2.systeme_vente_velo.beans;//package ept.git.dic2.systeme_vente_velo.beans;
//
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.mail.MessagingException;

@Singleton
//@Startup
public class StockAlertBean {

    @Inject
    private EmailBean emailBean;

    @Schedule(hour = "*", minute = "*/30", persistent = false) // Execute every 30 minutes
    public void sendStockAlert() {
        try {
            // Retrieve stock status information
            String stockStatus = getStockStatus();

            // Send the email
            emailBean.sendEmail("recipient@example.com", "Stock Alert", "Current stock status: " + stockStatus);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String getStockStatus() {
        // Logic to retrieve stock status
        return "In stock";
    }
}
