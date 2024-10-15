/**
 * @authors Jonathan Carmona - Keleer Jiménez
 * Implementación de la clase Cuenta
 */
/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.logicadenegocios;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.pruebaConection.demo.logicavalidaciondatos.ValidarInformacion;

@Entity
@Table(name = "Cuenta")
public class Cuenta implements ICuenta {

  @Id
  @Column(name = "numeroCuenta", length = 10)
  private String numeroCuenta;

  @Column(name = "fechaCreacion")
  private LocalDateTime fechaCreacion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCliente", nullable = false)
  private Cliente cliente;

  @Embedded
  private Pin pin;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado")
  private Estatus estatus;

  @Column(name = "saldo")
  private double saldo;

  @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
  private List<Transaccion> transacciones = new ArrayList<>();

  protected Cuenta() {
  }

  /**
   * Constructor de la clase Cuenta.
   *
   * @param monto El monto inicial de la cuenta.
   * @param pin
   */
  public Cuenta(double monto, String pin) {
    activarCuenta();
    setFechaCreacion();
    setSaldo(monto);
    this.pin = new Pin(pin);
  }

  /**
   * Constructor de la clase Cuenta con todos los parámetros.
   *
   * @param numeroCuenta Número de la cuenta.
   * @param fechaCreacion Fecha de creación de la cuenta.
   * @param pin PIN de la cuenta.
   * @param estado Estado de la cuenta.
   * @param saldo Saldo de la cuenta.
   * @param transacciones Lista de transacciones de la cuenta.
   */
  public Cuenta(String numeroCuenta, LocalDateTime fechaCreacion, String pin, Estatus estado, double saldo,
          ArrayList<Transaccion> transacciones) {
    validarPin(pin);
    this.numeroCuenta = numeroCuenta;
    this.fechaCreacion = fechaCreacion;
    this.pin = new Pin(pin);
    this.estatus = estado;
    setSaldo(saldo);
    this.transacciones = transacciones;
  }

  /**
   * Constructor de la clase Cuenta con todos los parámetros.
   *
   * @param numeroCuenta Número de la cuenta.
   * @param fechaCreacion Fecha de creación de la cuenta.
   * @param pin PIN de la cuenta.
   * @param estado Estado de la cuenta.
   * @param saldo Saldo de la cuenta.
   */
  public Cuenta(String numeroCuenta, LocalDateTime fechaCreacion, String pin, Estatus estado, double saldo) {
    validarPin(pin);
    this.numeroCuenta = numeroCuenta;
    this.fechaCreacion = fechaCreacion;
    this.pin = new Pin(pin);
    this.estatus = estado;
    setSaldo(saldo);
  }

  private void validarPin(String pin) {
    if (!ValidarInformacion.validarNoNuloOVacio(pin) || !ValidarInformacion.validarPin(pin)) {
      throw new IllegalArgumentException("El PIN es inválido.");
    }
  }

  @Override
  public void activarCuenta() {
    this.estatus = Estatus.ACTIVA;
  }

  @Override
  public void inactivarCuenta() {
    this.estatus = Estatus.INACTIVA;
  }

  private void setSaldo(double saldo) {
    if (!ValidarInformacion.validarNumeroEnteroPositivo(saldo)) {
      throw new IllegalArgumentException("El saldo debe ser un número entero positivo.");
    }
    this.saldo = saldo;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public Pin getPin() {
    return pin;
  }

  public Estatus getEstatus() {
    return estatus;
  }

  public double getSaldo() {
    return saldo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
   public void setPin(Pin pin) {
    this.pin = pin;
  }

  public List<Transaccion> getTransacciones() {
    return transacciones;
  }

  public void setFechaCreacion() {
    fechaCreacion = LocalDateTime.now();
  }

  /**
   * Deposita un monto en la cuenta.
   *
   * @param monto El monto a depositar.
   */
  @Override
  public void depositar(double monto) {
    validarMonto(monto);

    int cantidadTransacciones = transacciones.size();
    double cargoPorComision = verificarCantidadTransacciones(cantidadTransacciones, monto);

    saldo += monto - cargoPorComision;

    //Transaccion transaccion = new Transaccion(monto, cargoPorComision, TipoTransaccion.DEPOSITO);
    //agregarTransaccion(transaccion);

    System.out.println("Depósito realizado de " + monto + " colones. Nuevo saldo: " + saldo);
  }

  /**
   * Retira un monto de la cuenta.
   *
   * @param monto El monto a retirar.
   */
  @Override
  public void retirar(double monto) {
    validarMonto(monto);

    int cantidadTransacciones = transacciones.size();
    double cargoPorComision = verificarCantidadTransacciones(cantidadTransacciones, monto);

    if (saldo >= (monto + cargoPorComision)) {
      saldo -= (monto + cargoPorComision);

      //Transaccion transaccion = new Transaccion(monto, cargoPorComision, TipoTransaccion.RETIRO);
      //agregarTransaccion(transaccion);

      System.out.println("Retiro realizado de " + monto + " colones. Nuevo saldo: " + saldo);
    } else {
      System.out.println("Saldo insuficiente para realizar el retiro.");
    }
  }

  /**
   * Valida el monto ingresado.
   *
   * @param monto El monto a validar.
   */
  private void validarMonto(double monto) {
    if (!ValidarInformacion.validarNumeroDecimalPositivo(monto)) {
      throw new IllegalArgumentException("El monto debe ser un número entero positivo.");
    }
    if (!esEntero(monto)) {
      throw new IllegalArgumentException("El monto no debe contener decimales.");
    }
  }

  /**
   * Verifica si el monto es un número entero.
   *
   * @param monto El monto a verificar.
   * @return true si es entero, false en caso contrario.
   */
  private boolean esEntero(double monto) {
    return monto % 1 == 0;
  }

  /**
   * Consulta el saldo actual de la cuenta.
   *
   * @return El saldo actual de la cuenta.
   */
  @Override
  public double consultarSaldo() {
    return this.saldo;
  }

  /**
   * Obtiene el número de cuenta.
   *
   * @return El número de cuenta.
   */
  @Override
  public String getNumeroCuenta() {
    return this.numeroCuenta;
  }

  @Override
  public void agregarTransaccion(Transaccion transaccion) {
    transacciones.add(transaccion);
  }

  @Override
  public void setTransacciones(ArrayList<Transaccion> transacciones) {
    this.transacciones = transacciones;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  /**
   * Verifica la cantidad de transacciones y calcula el cargo por comisión si
   * aplica.
   *
   * @param cantidadTransacciones La cantidad de transacciones realizadas.
   * @param monto El monto de la transacción actual.
   * @return El cargo por comisión si aplica, 0.0 en caso contrario.
   */
  private double verificarCantidadTransacciones(int cantidadTransacciones, double monto) {
    double cargoPorComision = 0;
    if (cantidadTransacciones >= 3) {
      cargoPorComision = Comision.calcularComision(monto);
      System.out.println("Se aplicará una comisión de " + cargoPorComision + " colones.");
    }
    return cargoPorComision;
  }

  public void setEstatus(Estatus estatus) {
    this.estatus = estatus;
  }
}