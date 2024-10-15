/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.BCCRIndicadores;

/**
 * Importaciones necesarias para el funcionamiento de la clase
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>GetMethod</code> realiza comunicaciones HTTP mediante el protocolo <code>GET</code>.
 * 
 * <pEste código fue originalmente escrito por Hans Araya y ha sido modificado por Jonathan Carmona - Keleer Jiménez.</p>
 *
 * @author Hans Araya
 * @editedby Jonathan Carmona - Keleer Jiménez
 * @version 1.1
 */

@RestController
public class GetMethod {
  
  /**
   * Devuelve un documento HTML a partir de una solicitud <code>HTTP GET</code>.
   * 
   * @param urlToRead URL a donde enviar la solicitud (incluye parámetros).
   * @return <code>String</code> con el HTML dado por la solicitud HTTP GET.
   * @throws Exception si ocurre un error durante la solicitud HTTP.
   */
  protected static String getHTML(String urlToRead) throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
       result.append(line);
    }
    rd.close();
    return result.toString();
  }
  
}
