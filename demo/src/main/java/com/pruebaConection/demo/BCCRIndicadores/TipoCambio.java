/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.BCCRIndicadores;

/**
 * Importaciones necesarias para el funcionamiento de la clase
 */
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.springframework.stereotype.Service;

/**
 * <code>TipoCambio</code> se comunica con el WebService del BCCR para obtener
 * el tipo de cambio en tiempo real mediante una solicitud SOAP. Sólo funciona
 * con la moneda <strong>USD</strong>.
 *
 * <p>
 * Este código fue originalmente escrito por Hans Araya y ha sido modificado por
 * Jonathan Carmona - Keleer Jiménez.</p>
 * Accso al enlace: "https://github.com/hansjag04/indicadores-economicos-bccr"
 *
 * @editedby Jonathan Carmona - Keleer Jiménez
 * @version 1.1
 */
@Service
public class TipoCambio {

  private int indicador = 0; // 317: Compra, 318: Venta
  private String tcFechaInicio;
  private String tcFechaFinal;
  private final String tcNombre = "Proyecto Diseno";
  private final String tnSubNiveles = "N";
  private final String HOST = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx";
  private final String correoElectronico = "proyectodisenoti@gmail.com";
  private final String token = "NNYMS4RIEL";
  private final String SOAP_ACTION = "http://ws.sdde.bccr.fi.cr/ObtenerIndicadoresEconomicosXML";

  /**
   * Constructor que establece la fecha inicial y final del tipo de cambio.
   */
  public TipoCambio() {
    setFecha();
  }

  /**
   * Devuelve el valor de <strong>COMPRA</strong> USD del BCCR.
   *
   * @return <code>Double</code> con el valor del precio de compra.
   */
  public double getCompra() {
    setCompra();
    double valor = Double.parseDouble(getValue());
    return valor;
  }

  /**
   * Devuelve el valor de <strong>VENTA</strong> USD del BCCR.
   *
   * @return <code>Double</code> con el valor del precio de venta.
   */
  public double getVenta() {
    setVenta();
    double valor = Double.parseDouble(getValue());
    return valor;
  }

  /**
   * Envía la solicitud SOAP al servicio del BCCR y obtiene el valor de la
   * respuesta.
   *
   * @return <code>String</code> con el valor obtenido del BCCR.
   */
  private String getValue() {
    try {
      String soapRequest = buildSoapRequest();
      URL url = new URL(HOST);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
      connection.setRequestProperty("SOAPAction", SOAP_ACTION);
      connection.setDoOutput(true);

      OutputStream outputStream = connection.getOutputStream();
      outputStream.write(soapRequest.getBytes("UTF-8"));
      outputStream.flush();
      outputStream.close();

      Scanner scanner = new Scanner(connection.getInputStream());
      StringBuilder response = new StringBuilder();
      while (scanner.hasNext()) {
        response.append(scanner.nextLine());
      }
      scanner.close();

      // Extraer el valor NUM_VALOR de la respuesta
      XmlParser xml = new XmlParser(response.toString());
      return xml.getValue("NUM_VALOR");
    } catch (Exception e) {
      System.out.println("Error al obtener el valor del BCCR.");
      e.printStackTrace();
      return "0";
    }
  }

  /**
   * Construye la solicitud SOAP basada en los parámetros configurados.
   *
   * @return <code>String</code> con la solicitud SOAP.
   */
  private String buildSoapRequest() {
    return "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
            + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
            + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
            + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
            + "<soap:Body>"
            + "<ObtenerIndicadoresEconomicosXML xmlns=\"http://ws.sdde.bccr.fi.cr\">"
            + "<Indicador>" + indicador + "</Indicador>"
            + "<FechaInicio>" + tcFechaInicio + "</FechaInicio>"
            + "<FechaFinal>" + tcFechaFinal + "</FechaFinal>"
            + "<Nombre>" + tcNombre + "</Nombre>"
            + "<SubNiveles>" + tnSubNiveles + "</SubNiveles>"
            + "<CorreoElectronico>" + correoElectronico + "</CorreoElectronico>"
            + "<Token>" + token + "</Token>"
            + "</ObtenerIndicadoresEconomicosXML>"
            + "</soap:Body>"
            + "</soap:Envelope>";
  }

  /**
   * Establece la fecha de inicio y final al día actual.
   */
  private void setFecha() {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    this.tcFechaInicio = sdf.format(date);
    this.tcFechaFinal = tcFechaInicio;
  }

  /**
   * Configura el indicador para el valor de compra.
   */
  private void setCompra() {
    this.indicador = 317;
  }

  /**
   * Configura el indicador para el valor de venta.
   */
  private void setVenta() {
    this.indicador = 318;
  }
}
