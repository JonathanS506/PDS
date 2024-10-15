/**
 * @authors Jonathan Carmona - Keleer Jiménez
 * Implementación de la clase Cliente
 */
/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.logicadenegocios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 * Clase Cliente que representa a un cliente general del sistema.
 */
@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED) // Configura la estrategia de herencia
public abstract class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "idCliente", nullable = false, length = 10)
  private String idCliente;

  @Column(name = "nombrePila", nullable = false, length = 55)
  private String nombrePila;

  @Column(name = "primerApellido", nullable = false, length = 55)
  private String primerApellido;

  @Column(name = "segundoApellido", length = 55)
  private String segundoApellido;

  @Column(name = "identificacion", nullable = false, length = 50)
  private String identificacion;

  @Column(name = "telefono", nullable = false, length = 20)
  private String telefono;

  @Column(name = "email", nullable = false, length = 255)
  private String correoElectronico;

  @Column(name = "cantidadCuentas", nullable = false)
  private int cantidadCuentas;

  public Cliente() {
  }

  public Cliente(String nombrePila, String primerApellido, String segundoApellido, String identificacion,
          String telefono, String correoElectronico, int cantidadCuentas) {
    this.nombrePila = nombrePila;
    this.primerApellido = primerApellido;
    this.segundoApellido = segundoApellido;
    this.identificacion = identificacion;
    this.telefono = telefono;
    this.correoElectronico = correoElectronico;
    this.cantidadCuentas = cantidadCuentas;
  }

  public Cliente(String idCliente, String nombrePila, String primerApellido, String segundoApellido,
          String identificacion, String telefono, String correoElectronico, int cantidadCuentas) {
    this(nombrePila, primerApellido, segundoApellido, identificacion, telefono, correoElectronico, cantidadCuentas);
    this.idCliente = idCliente;
  }

  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  public String getNombrePila() {
    return nombrePila;
  }

  public void setNombrePila(String nombrePila) {
    this.nombrePila = nombrePila;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public void setSegundoApellido(String segundoApellido) {
    this.segundoApellido = segundoApellido;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public int getCantidadCuentas() {
    return cantidadCuentas;
  }

  public void setCantidadCuentas(int cantidadCuentas) {
    this.cantidadCuentas = cantidadCuentas;
  }
}

