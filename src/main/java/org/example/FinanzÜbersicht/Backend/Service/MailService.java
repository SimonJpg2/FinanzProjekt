package org.example.FinanzÜbersicht.Backend.Service;

import org.example.FinanzÜbersicht.Backend.Exceptions.VerificationException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Properties;

import static javax.mail.Message.RecipientType.TO;
import static javax.mail.Transport.*;

/**
 * Class MailService.
 * <p>
 *     Class to send E-Mails
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */

public class MailService {
    private Session session;
    private String code = "";
    private final String username = "Notenuebersicht.Verify@gmail.com";
    private final String password = "rwjzebvpditpyrxu";

    public MailService() {
        init();
    }

    /**
     * Method init.
     * <p>
     *     Initializes components for smtp client.
     * </p>
     */
    private void init() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true"); // enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // enable tls
        properties.put("mail.smtp.host", "smtp.gmail.com"); // set smtp host
        properties.put("mail.smtp.port", "25"); // set smtp port
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // set ssl for host

        // create session
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        prepareRandomCode();
    }

    /**
     * Method prepareRandomCode.
     * <p>
     *     Prepares verification token.
     * </p>
     */
    private void prepareRandomCode() {
        // use secure random for more security.
        var random = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            code += random.nextInt(9);
        }
        System.out.println("(+) INFO: Token generated successfully.");
    }

    /**
     * Method sendMail.
     * <p>
     *     Prepares E-Mail which will be send.
     * </p>
     * @param clientEmail {@link java.lang.String} the email address of client.
     * @throws VerificationException if an error occurs.
     */
    public void sendMail(String clientEmail) throws VerificationException {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username)); // set sender
            message.setRecipient(TO, new InternetAddress(clientEmail)); // set receiver
            message.setSubject("Finanzübersicht Verifizierung"); // set subject
            message.setText("Dein Verifizierungstoken lautet:" + code + ".\n" +
                    "Falls du dein Passwort nicht zurücksetzen willst, kannst du diese E-Mail ignorieren.\n" +
                    "Diese Mail wurde automatisch versendet und antwortet auf keine einkommenden E-Mails."); // set message
            send(message); // send email
        } catch (MessagingException e) {
            throw new VerificationException(e.getMessage());
        }
    }

    /**
     * Method getCode.
     * @return the verification token
     */
    public String getCode() {
        return code;
    }
}
