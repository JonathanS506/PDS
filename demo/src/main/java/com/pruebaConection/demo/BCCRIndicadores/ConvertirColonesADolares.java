/**
 * Paquete al que pertenece la clase
 */
package com.pruebaConection.demo.BCCRIndicadores;

import com.pruebaConection.demo.BCCRIndicadores.TipoCambio;
import org.springframework.stereotype.Service;

/**
 * Codificación de la clase ConverirColonesADolares
 */
@Service
public class ConvertirColonesADolares {

  private TipoCambio tipoCambio;

  public ConvertirColonesADolares(TipoCambio tipoCambio) {
    this.tipoCambio = tipoCambio;
  }

  public double convertirColonesADolares(double montoColones) {
    double tipoVenta = tipoCambio.getVenta();
    return montoColones / tipoVenta;
  }
}
