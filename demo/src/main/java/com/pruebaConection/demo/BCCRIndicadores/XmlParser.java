/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.BCCRIndicadores;

/**
 * Importaciones necesarias para el funcionamiento de la clase
 */
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;

/**
 * <code>XmlParser</code> realiza el parseado de un documento <code>XML</code>.
 * 
 * <p>Este código fue originalmente escrito por Hans Araya y ha sido modificado por Jonathan Carmona - Keleer Jiménez.</p>
 *
 * @editedby Jonathan Carmona - Keleer Jiménez
 * @version 1.1
 */
public class XmlParser {

  private String xml;
  private Element rootElement;

  /**
   * Constructor que inicializa las herramientas para parseo de XML.
   * 
   * @param data Documento XML.
   * @throws SAXException Si ocurre un error en el parseo XML.
   * @throws IOException Si ocurre un error de entrada/salida.
   * @throws ParserConfigurationException Si ocurre un error en la configuración del parser.
   */
  public XmlParser(String data) throws SAXException, IOException, ParserConfigurationException {
    data = replaceChars(data); // Reemplazar caracteres especiales
    this.xml = data;

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new InputSource(new StringReader(this.xml)));
    this.rootElement = document.getDocumentElement();
  }

  /**
   * Obtiene el valor de una etiqueta en el documento XML.
   * 
   * @param tag La etiqueta de la cual extraer el valor.
   * @return <code>String</code> con el valor de la etiqueta enviada.
   */
  public String getValue(String tag) {
    try {
      NodeList list = this.rootElement.getElementsByTagName(tag);
      if (list != null && list.getLength() > 0) {
        NodeList subList = list.item(0).getChildNodes();
        return subList.item(0).getNodeValue();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * Reemplaza caracteres especiales presentes en el XML.
   * 
   * @param data Documento XML en formato <code>String</code>.
   * @return <code>String</code> con los caracteres corregidos.
   */
  private String replaceChars(String data) {
    data = data.replace("&lt;", "<");
    data = data.replace("&gt;", ">");
    data = data.replace("&amp;", "&");
    data = data.replace("&quot;", "\"");
    data = data.replace("&apos;", "'");
    return data;
  }

}
