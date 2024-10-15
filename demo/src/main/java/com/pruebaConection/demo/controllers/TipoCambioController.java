package com.pruebaConection.demo.controllers;

import com.pruebaConection.demo.BCCRIndicadores.TipoCambio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {

  private final TipoCambio tipoCambio;

  public TipoCambioController(TipoCambio tipoCambio) {
    this.tipoCambio = tipoCambio;
  }

  @GetMapping("/compra")
  public ResponseEntity<Double> obtenerTipoCambioCompra() {
    try {
      double tipoCompra = tipoCambio.getCompra();
      return ResponseEntity.ok(tipoCompra);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/venta")
  public ResponseEntity<Double> obtenerTipoCambioVenta() {
    try {
      double tipoVenta = tipoCambio.getVenta();
      return ResponseEntity.ok(tipoVenta);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}
