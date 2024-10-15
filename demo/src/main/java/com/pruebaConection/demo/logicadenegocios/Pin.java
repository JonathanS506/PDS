/**
 * Clase para manejar la lógica de un PIN cifrado.
 *
 * @author Jonathan Carmona
 */
package com.pruebaConection.demo.logicadenegocios;

import com.pruebaConection.demo.logicavalidaciondatos.ValidarInformacion;

/**
 * Implementación de la clase Pin
 */
public class Pin {

  private String pinCifrado;

  /**
   * Constructor que inicializa el PIN.
   *
   * @param caracteres El PIN en texto plano que se desea cifrar.
   */
  public Pin(String caracteres) {
    setPin(caracteres);
  }

  public String getPinCifrado() {
    return pinCifrado;
  }

  public String getPin() {
    return cifrarPin(pinCifrado);
  }

  /**
   * Establece el PIN cifrándolo (invirtiéndolo).
   *
   * @param caracteres El PIN en texto plano que se desea cifrar.
   */
  public void setPin(String caracteres) {
    if (!ValidarInformacion.validarPin(caracteres)) {
      throw new IllegalArgumentException("El PIN debe tener 6 caracteres, al menos una letra mayúscula y un número.");
    }
    this.pinCifrado = cifrarPin(caracteres);
  }

  /**
   * Cifra el PIN invirtiendo el texto.
   *
   * @param pin El PIN en texto plano que se desea cifrar.
   * @return El PIN cifrado como un String.
   */
  private String cifrarPin(String pin) {
    return new StringBuilder(pin).reverse().toString();
  }

  /**
   * Valida si el PIN ingresado es correcto comparándolo con el PIN cifrado.
   *
   * @param pinIngresado El PIN que se desea validar.
   * @return true si el PIN ingresado es correcto, false en caso contrario.
   */
  public boolean validarPinCorrecto(String pinIngresado) {
    return pinCifrado.equals(cifrarPin(pinIngresado));
  }

  public void cambiarPin(String nuevoPin) {
    ValidarInformacion.validarPin(nuevoPin);

    if (cifrarPin(nuevoPin) == null ? this.pinCifrado != null : !cifrarPin(nuevoPin).equals(this.pinCifrado)) {
      setPin(nuevoPin);
    }
  }
}
