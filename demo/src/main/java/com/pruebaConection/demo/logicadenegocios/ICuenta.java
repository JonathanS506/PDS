/**
 * @authors Jonathan Carmona - Keleer Jiménez
 * Definición de la interface ICuenta.
 */

/**
 * Paquete al que pertenece la interface
 */
package com.pruebaConection.demo.logicadenegocios;


/**
 * Importaciones necesarias para l funcionamiento de la interface
 */
import java.util.ArrayList;

/**
 * Interface de operaciones y funcionalidades de una cuenta en el sistema.
 */
public interface ICuenta {

  /**
   * Activa la cuenta.
   */
  void activarCuenta();

  /**
   * Inactiva la cuenta.
   */
  void inactivarCuenta();

  /**
   * Realiza un depósito en la cuenta.
   *
   * @param monto El monto a depositar.
   */
  void depositar(double monto);

  /**
   * Realiza un retiro de la cuenta.
   *
   * @param monto El monto a retirar.
   */
  void retirar(double monto);

  /**
   * Consulta el saldo de la cuenta.
   *
   * @return El saldo actual de la cuenta.
   */
  double consultarSaldo();

  /**
   * Agrega una transacción a la lista de transacciones de la cuenta.
   *
   * @param transaccion La transacción que se agregará.
   */
  void agregarTransaccion(Transaccion transaccion);

  /**
   * Asigna la lista de transacciones a la cuenta.
   *
   * @param transacciones La lista de transacciones.
   */
  void setTransacciones(ArrayList<Transaccion> transacciones);

  /**
   * Obtiene el número de cuenta.
   *
   * @return El número de cuenta.
   */
  Object getNumeroCuenta();
}

