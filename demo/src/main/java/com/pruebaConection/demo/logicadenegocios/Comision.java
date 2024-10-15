package com.pruebaConection.demo.logicadenegocios;

import org.springframework.stereotype.Service;

/**
 * Clase que representa la gestión de comisiones.
 */
@Service
public class Comision {

    /**
     * Calcula la comisión sobre un monto dado.
     *
     * @param monto El monto sobre el cual se calculará la comisión.
     * @return La comisión calculada.
     */
    public static double calcularComision(double monto) {
        return monto * 0.5; // Porcentaje de comisión
    }
}

