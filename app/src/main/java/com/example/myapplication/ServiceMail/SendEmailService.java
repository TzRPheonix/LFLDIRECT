package com.example.myapplication.ServiceMail;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.Modele.Utilisateurs;

import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailService  { // Caudron

    private static SendEmailService instance = null;
    private static Context ctx;

    final String username = "lfldirectcontact@gmail.com";
    final String password = "Antoine59164!?";

    Properties prop;
    Session session;

    private SendEmailService(Context context) {
        ctx = context;
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        session = javax.mail.Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }


    public static synchronized SendEmailService getInstance(Context context) {
        if(instance == null) {
            instance = new SendEmailService(context);
        }
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void SendEmail(String adresse, Utilisateurs utilisateurs) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(adresse)
            );
            message.setSubject("Récupération de votre Mot de Passe:");
            message.setText("Bonjour Mr\\Mme " + utilisateurs.getNom() + " vous avez effectué une demande de récuperation pour votre mot de passe le " + LocalDateTime.now().toString() +".\nLe voici : " + utilisateurs.getMdp() + "\n Bonne Journée");

            Transport.send(message);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
