/**
 * Codificación de la clase ValidarInformación
 * Autores: Jonathan Carmona - Keleer Jiménez
 */


/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.logicavalidaciondatos;

/**
 * Implementación de la clase ValidarInformacion
 */
public class ValidarInformacion {

  /**
   * Valida que una cadena no sea nula ni vacía.
   *
   * @param texto el texto a validar
   * @return true si es válido, false en caso contrario
   */
  public static boolean validarNoNuloOVacio(String texto) {
    return texto != null && !texto.trim().isEmpty();
  }

  /**
   * Valida que un número decimal no sea negativo y sea entero.
   *
   * @param numero el número a validar
   * @return true si es válido, false en caso contrario
   */
  public static boolean validarNumeroDecimalPositivo(double numero) {
    return numero >= 0 && numero % 1 == 0;
  }

  /**
   * Valida que un número entero sea positivo.
   *
   * @param numero el número a validar
   * @return true si es válido, false en caso contrario
   */
  public static boolean validarNumeroEnteroPositivo(double numero) {
    return numero > 0;
  }

  /**
   * Valida el número de teléfono costarricense.
   *
   * @param telefono el número de teléfono a validar
   * @return true si el número es válido, false en caso contrario
   */
  public static boolean validarTelefono(String telefono) {
    return telefono.matches("^(\\d{8})$");
  }

  /**
   * Valida el formato de un correo electrónico.
   *
   * @param correo el correo electrónico a validar
   * @return true si el correo es válido, false en caso contrario
   */
  public static boolean validarCorreo(String correo) {
    return correo.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$");
  }

  /**
   * Valida el formato de un PIN. El PIN debe tener 6 caracteres alfanuméricos,
   * incluyendo al menos una letra mayúscula y un número.
   *
   * @param pin el PIN a validar
   * @return true si el PIN es válido, false en caso contrario
   */
  public static boolean validarPin(String pin) {
    return pin.matches("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6}$");
  }

  /**
   * Valida la fecha de nacimiento. La fecha debe estar en el formato DD/MM/AAAA
   * y ser una fecha válida.
   *
   * @param fechaNacimiento la fecha de nacimiento a validar
   * @return true si la fecha es válida, false en caso contrario
   */
  public static boolean validarFechaNacimiento(String fechaNacimiento) {
    return fechaNacimiento.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$");
  }

  /**
   * Valida que un nombre completo contenga al menos dos palabras y no contenga
   * números.
   *
   * @param nombreCompleto el nombre completo a validar
   * @return true si el nombre completo es válido, false en caso contrario
   */
  public static boolean validarNombreCompleto(String nombreCompleto) {
    return nombreCompleto.matches("^(?=\\S)([A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s+[A-Za-zÁÉÍÓÚáéíóúÑñ]+)+)$");
  }

  /**
   * Valida que la cédula jurídica tenga un formato específico.
   *
   * @param cedula el número de cédula jurídica a validar
   * @return true si es válido, false en caso contrario
   */
  public static boolean validarCedulaJuridica(String cedula) {
    return cedula.matches("^\\d{10}$");
  }

  /**
   * Valida que el PIN no sea igual al anterior.
   *
   * @param nuevoPin el nuevo PIN a validar
   * @param antiguoPin el antiguo PIN
   * @return true si es válido, false en caso contrario
   */
  public static boolean validarPinNoIgual(String nuevoPin, String antiguoPin) {
    return !nuevoPin.equals(antiguoPin);
  }

  /**
   * Valida que un PIN no sea nulo, no esté vacío y cumpla con el formato
   * requerido.
   *
   * @param pin El PIN a validar.
   * @return true si es válido, false en caso contrario.
   */
  public static boolean validarPinCompleto(String pin) {
    return validarNoNuloOVacio(pin) && validarPin(pin);
  }

  /**
   * Valida que un monto sea un entero positivo y no contenga decimales.
   *
   * @param monto El monto a validar.
   * @return true si es válido, false en caso contrario.
   */
  public static boolean validarMonto(int monto) {
    return validarNumeroEnteroPositivo(monto) && (monto % 1 == 0);
  }
}
