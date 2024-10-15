/**
 * @authors Jonathan Carmona - Keleer Jiménez
 * Implementación de la clase ClienteJuridico
 */
/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.logicadenegocios;

import com.pruebaConection.demo.logicadenegocios.Cliente;
import jakarta.persistence.*;
import java.io.Serializable;
import com.pruebaConection.demo.logicavalidaciondatos.ValidarInformacion;

/**
 * Clase ClienteJuridico que representa un cliente jurídico del sistema.
 */
@Entity
@Table(name = "ClienteJuridico")
public class ClienteJuridico extends Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "razonSocial", nullable = false)
  private String razonSocial;

  @Column(name = "tipoNegocio", nullable = false)
  private String tipoNegocio;

  public ClienteJuridico() {
  }

  /**
   * Constructor de ClienteJuridico.
   *
   * @param nombrePila Nombre del cliente.
   * @param primerApellido Primer apellido del cliente.
   * @param segundoApellido Segundo apellido del cliente.
   * @param identificacion Identificación del cliente.
   * @param telefono El número de teléfono del cliente.
   * @param correoElectronico El correo electrónico del cliente.
   * @param cantidadCuentas La cantidad de cuentas del cliente.
   * @param razonSocial La razón social del cliente.
   * @param tipoNegocio El tipo de negocio del cliente.
   */
  public ClienteJuridico(String nombrePila, String primerApellido, String segundoApellido, String identificacion,
          String telefono, String correoElectronico, int cantidadCuentas,
          String razonSocial, String tipoNegocio) {
    super(nombrePila, primerApellido, segundoApellido, identificacion, telefono, correoElectronico, cantidadCuentas);
    validarRazonSocial(razonSocial);
    validarTipoNegocio(tipoNegocio);
    this.razonSocial = razonSocial;
    this.tipoNegocio = tipoNegocio;
  }

  public ClienteJuridico(String idCliente, String nombrePila, String primerApellido, String segundoApellido,
          String identificacion, String telefono, String correoElectronico, int cantidadCuentas,
          String razonSocial, String tipoNegocio) {
    super(idCliente, nombrePila, primerApellido, segundoApellido, identificacion, telefono, correoElectronico, cantidadCuentas);
    validarRazonSocial(razonSocial);
    validarTipoNegocio(tipoNegocio);
    this.razonSocial = razonSocial;
    this.tipoNegocio = tipoNegocio;
  }

  /**
   * Obtiene la razón social del cliente.
   *
   * @return La razón social.
   */
  public String getRazonSocial() {
    return razonSocial;
  }

  /**
   * Obtiene el tipo de negocio del cliente.
   *
   * @return El tipo de negocio.
   */
  public String getTipoNegocio() {
    return tipoNegocio;
  }

  /**
   * Asigna la razón social del cliente.
   *
   * @param razonSocial La razón social del cliente.
   */
  public void setRazonSocial(String razonSocial) {
    validarRazonSocial(razonSocial); // Validar antes de asignar
    this.razonSocial = razonSocial;
  }

  /**
   * Asigna el tipo de negocio del cliente.
   *
   * @param tipoNegocio El tipo de negocio.
   */
  public void setTipoNegocio(String tipoNegocio) {
    validarTipoNegocio(tipoNegocio); // Validar antes de asignar
    this.tipoNegocio = tipoNegocio;
  }

  /**
   * Valida que la razón social no sea nula ni vacía.
   *
   * @param razonSocial La razón social a validar.
   */
  private void validarRazonSocial(String razonSocial) {
    if (!ValidarInformacion.validarNoNuloOVacio(razonSocial)) {
      throw new IllegalArgumentException("La razón social no puede ser nula o vacía.");
    }
  }

  /**
   * Valida que el tipo de negocio no sea nulo ni vacío.
   *
   * @param tipoNegocio El tipo de negocio a validar.
   */
  private void validarTipoNegocio(String tipoNegocio) {
    if (!ValidarInformacion.validarNoNuloOVacio(tipoNegocio)) {
      throw new IllegalArgumentException("El tipo de negocio no puede ser nulo o vacío.");
    }
  }
}
