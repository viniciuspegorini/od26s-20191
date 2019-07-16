package br.edu.utfpr.chemistsincontrol.util.mail;


import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MailSender {

    private static final Logger LOG = Logger.getLogger(MailSender.class.getName());

    private static final String SMTP_HOST = "";
    private static final int SMTP_PORT = 587;
    private static final String SMTP_USERNAME = "";
    private static final String SMTP_PASSWORD = "";
    private static final String SMTP_AUTH = "SSL_TLS";

    private Properties getProperties() {
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", SMTP_HOST);
        props.setProperty("mail.smtp.port", String.valueOf(SMTP_PORT));
        props.setProperty("mail.user", SMTP_USERNAME);
        props.setProperty("mail.password", SMTP_PASSWORD);
        switch (SMTP_AUTH) {
            case "SSL_TLS": {
                props.setProperty("mail.smtp.ssl.enable", "true");
                props.setProperty("mail.smtp.ssl.trust", SMTP_HOST);
                break;
            }
            case "STARTTLS": {
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.ssl.trust", SMTP_HOST);
                break;
            }
            default: {
                props.setProperty("mail.smtp.ssl.enable", "false");
                props.setProperty("mail.smtp.starttls.enable", "false");
                break;
            }
        }
        return props;
    }

    public void montaCorpoEmail(String corpoEmail, List<String> attachments, MimeMessage message) throws MessagingException, IOException {
        Multipart multipart = new MimeMultipart();
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(corpoEmail, "UTF-8", "html");
        multipart.addBodyPart(bodyPart);
        for (String file : attachments) {
            file = file.replace("\r", "");
            file = file.replace("\n", "");
            if (new File(file).exists()) {
                bodyPart = new MimeBodyPart();
                DataSource ds = new FileDataSource(file);
                bodyPart.setDataHandler(new DataHandler(ds));
                bodyPart.setFileName(new File(file).getName());
                bodyPart.setDisposition("attachment");
                multipart.addBodyPart(bodyPart);

            }
        }
        message.setContent(multipart);
    }

    public boolean sendEmail(String mailTo, String assunto, String corpo, List<String> attachments) throws MessagingException, IOException {
        int i = 0;

        Properties props = getProperties();
        LOG.info("SEND MAIL ENTER");

        boolean b = false;
        while (i <= 1) {
            i++;
            try {
                Session session = Session.getDefaultInstance(props);
                session.setDebug(true);
                session.setDebugOut(System.out);
                MimeMessage message = new MimeMessage(session);
                message.setFrom(SMTP_USERNAME);
                message.addRecipient(Message.RecipientType.BCC, new InternetAddress(mailTo));
                message.setSubject(assunto);
                montaCorpoEmail(corpo, attachments, message);

                Transport tp = session.getTransport();
                tp.connect(SMTP_HOST, SMTP_USERNAME, SMTP_PASSWORD);
                LOG.info("STARTING SEND MESSAGE");
                tp.sendMessage(message, message.getAllRecipients());

                LOG.info("CLOSING");
                tp.close();
                LOG.info("SEND MAIL END");
                return true;

            } catch (MessagingException | IOException ex) {
                LOG.log(Level.SEVERE, "Error Sending mail", ex);
                if (!b) {
                    b = true;
                    props.setProperty("mail.smtp.auth", "true");
                } else {
                    throw ex;
                }
            }
        }
        return false;
    }

}