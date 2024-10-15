package com.pruebaConection.demo.logicadenegocios;

/**
 * @authors Jonathan Carmona - Keleer Jiménez
 * Implementación de la clase ClienteFisico
 */


import com.pruebaConection.demo.logicadenegocios.Cliente;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase ClienteFisico que representa un cliente físico del sistema.
 */
@Entity
@Table(name = "ClienteFisico")
public class ClienteFisico extends Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "fechaNacimiento", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;

  public ClienteFisico() {
    // Constructor vacío requerido por JPA
  }

  /**
   * Constructor de ClienteFisico.
   *
   * @param nombrePila el nombre de pila del cliente
   * @param primerApellido primer apellido del cliente
   * @param segundoApellido segundo apellido del cliente
   * @param identificacion cédula del cliente
   * @param telefono número de teléfono del cliente
   * @param correoElectronico correo electrónico del cliente
   * @param cantidadCuentas cantidad de cuentas del cliente
   * @param fechaNacimiento fecha de nacimiento del cliente
   */
  public ClienteFisico(String nombrePila, String primerApellido, String segundoApellido, String identificacion,
          String telefono, String correoElectronico, int cantidadCuentas, Date fechaNacimiento) {
    super(nombrePila, primerApellido, segundoApellido, identificacion, telefono, correoElectronico, cantidadCuentas);
    this.fechaNacimiento = fechaNacimiento;
  }

  public ClienteFisico(String idCliente, String nombrePila, String primerApellido, String segundoApellido,
          String identificacion, String telefono, String correoElectronico, int cantidadCuentas, Date fechaNacimiento) {
    super(idCliente, nombrePila, primerApellido, segundoApellido, identificacion, telefono, correoElectronico, cantidadCuentas);
    this.fechaNacimiento = fechaNacimiento;
  }

  /**
   * Obtiene la fecha de nacimiento del cliente físico.
   *
   * @return fecha de nacimiento
   */
  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  /**
   * Establece la fecha de nacimiento del cliente físico.
   *
   * @param fechaNacimiento fecha de nacimiento
   */
  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
}
