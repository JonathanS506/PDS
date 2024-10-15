package com.pruebaConection.demo.controllers;

import com.pruebaConection.demo.logicadenegocios.Cuenta;
import com.pruebaConection.demo.servicio.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;

  @PostMapping("/registrar")
  public ResponseEntity<Cuenta> registrarCuenta(@RequestParam Cuenta cuenta) {
    try {
      Cuenta nuevaCuenta = cuentaService.registrarCuenta(cuenta);
      return ResponseEntity.ok(nuevaCuenta);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(null);
    }
  }

  // Endpoint para obtener todas las cuentas
  @GetMapping("/todas")
  public ResponseEntity<List<Cuenta>> obtenerTodasLasCuentas() {
    List<Cuenta> cuentas = cuentaService.obtenerTodasLasCuentas();
    return ResponseEntity.ok(cuentas);
  }

  // Endpoint para buscar una cuenta por su número
  @GetMapping("/{numeroCuenta}")
  public ResponseEntity<Cuenta> obtenerCuentaPorNumero(@PathVariable String numeroCuenta) {
    Optional<Cuenta> cuentaOpt = cuentaService.obtenerCuentaPorNumero(numeroCuenta);
    return cuentaOpt.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build()); // Devuelve un 404 si no se encuentra
  }

  // Endpoint para consultar el saldo de una cuenta
  @GetMapping("/{numeroCuenta}/saldo")
  public ResponseEntity<Double> consultarSaldo(@PathVariable String numeroCuenta) {
    Optional<Cuenta> cuentaOpt = cuentaService.obtenerCuentaPorNumero(numeroCuenta);
    if (cuentaOpt.isPresent()) {
      double saldo = cuentaOpt.get().consultarSaldo();
      return ResponseEntity.ok(saldo);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Endpoint para depositar en una cuenta
  @PostMapping("/{numeroCuenta}/depositar")
  public ResponseEntity<String> depositar(@PathVariable String numeroCuenta, @RequestParam("monto") double monto) {
    try {
      cuentaService.depositar(numeroCuenta, monto);
      return ResponseEntity.ok("Depósito realizado con éxito.");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage()); // Maneja errores de validación
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al procesar el depósito."); // Maneja errores generales
    }
  }

  // Endpoint para retirar de una cuenta
  @PostMapping("/{numeroCuenta}/retirar")
  public ResponseEntity<String> retirar(@PathVariable String numeroCuenta, @RequestParam("monto") double monto) {
    try {
      cuentaService.retirar(numeroCuenta, monto);
      return ResponseEntity.ok("Retiro realizado con éxito.");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al procesar el retiro.");
    }
  }
}
