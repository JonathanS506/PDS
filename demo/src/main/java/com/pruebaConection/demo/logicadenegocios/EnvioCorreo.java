/**
 * Clase para el envío de correos electrónicos usando Gmail SMTP.
 *
 * @authors Jonathan Carmona - Keleer Jiménez
 */
package com.pruebaConection.demo.logicadenegocios;

import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.MessagingException;
import java.io.File;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 * Clase que maneja el envío de correos electrónicos a través de SMTP de Gmail.
 */
public class EnvioCorreo {
  private String usuario; 
  private String clave = "q d m l s o x n d i o n lb s z"; 
  private String servidor = "smtp.gmail.com"; 
  private String puerto = "587"; 
  private Properties propiedades; 

  /**
   * Constructor de la clase EnvioCorreo.
   *
   * @param pCorreo La dirección de correo del usuario.
   */
  public EnvioCorreo(String pCorreo) {
    propiedades = new Properties();
    propiedades.put("mail.smtp.host", servidor);
    propiedades.put("mail.smtp.ssl.trust", servidor);
    propiedades.put("mail.smtp.port", puerto);
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");
    propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2"); 
    usuario = pCorreo;
  }

  /**
   * Abre una sesión SMTP para enviar correos.
   *
   * @return La sesión SMTP.
   */
  private Session abrirSesion() {
    return Session.getInstance(propiedades, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(usuario, clave);
      }
    });
  }

  /**
   * Envía un correo electrónico simple.
   *
   * @param pDestinatario La dirección de correo del destinatario.
   * @param pTituloCorreo El título del correo.
   * @param pCuerpo El cuerpo del correo.
   */
  public void enviarCorreo(String pDestinatario, String pTituloCorreo, String pCuerpo) {
    Session sesion = abrirSesion();

    try {
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(usuario));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(pDestinatario));
      message.setSubject(pTituloCorreo);
      message.setText(pCuerpo);

      Transport.send(message);
      System.out.println("Correo enviado exitosamente.");
    } catch (MessagingException e) {
      System.out.println("Error al enviar el correo: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Envía un correo electrónico con archivos adjuntos.
   *
   * @param pDestinatario La dirección de correo del destinatario.
   * @param tituloCorreo El título del correo.
   * @param cuerpo El cuerpo del correo.
   * @param archivosAdjuntos La lista de archivos a adjuntar.
   */
  public void enviarCorreoArchivo(String pDestinatario, String tituloCorreo, String cuerpo, String[] archivosAdjuntos) {
    Session sesion = abrirSesion();

    try {
      Message message = new MimeMessage(sesion);
      message.setFrom(new InternetAddress(usuario));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(pDestinatario));
      message.setSubject(tituloCorreo);

      // Cuerpo del correo
      BodyPart textoPart = new MimeBodyPart();
      textoPart.setText(cuerpo);

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(textoPart);

      for (String archivo : archivosAdjuntos) {
        BodyPart adjuntoPart = new MimeBodyPart();
        DataSource source = new FileDataSource(new File(archivo));
        adjuntoPart.setDataHandler(new DataHandler(source));
        adjuntoPart.setFileName(new File(archivo).getName());
        multipart.addBodyPart(adjuntoPart);
      }

      message.setContent(multipart);

      Transport.send(message);
      System.out.println("Correo con adjuntos enviado exitosamente.");
    } catch (MessagingException e) {
      System.err.println("Error al enviar el correo con adjuntos: " + e.getMessage());
      e.printStackTrace();
    }
  }
}

