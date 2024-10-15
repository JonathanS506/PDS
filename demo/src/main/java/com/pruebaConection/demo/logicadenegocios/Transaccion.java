package com.pruebaConection.demo.logicadenegocios;

import com.pruebaConection.demo.logicadenegocios.TipoTransaccion;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    private double monto;
    private LocalDateTime fechaTransaccion;
    private double cargoPorComision;

    @Enumerated(EnumType.STRING)
    private TipoTransaccion tipo;
    
    @ManyToOne 
    @JoinColumn(name = "numeroCuenta", nullable = false)
    private Cuenta cuenta; 

    // Constructor
    public Transaccion() {
        // Constructor vacío requerido por JPA
    }

    public Transaccion(double monto, double cargoPorComision, TipoTransaccion tipo) {
        validarParametros(monto, cargoPorComision, tipo);
        this.monto = monto;
        this.cargoPorComision = cargoPorComision;
        this.tipo = tipo;
        this.fechaTransaccion = LocalDateTime.now();
    }

    // Getters y setters

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public double getCargoPorComision() {
        return cargoPorComision;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setMonto(double monto) {
        validarMonto(monto);
        this.monto = monto;
    }

    public void setCargoPorComision(double cargoPorComision) {
        validarCargoPorComision(cargoPorComision);
        this.cargoPorComision = cargoPorComision;
    }

    public void setTipo(TipoTransaccion tipo) {
        validarTipo(tipo);
        this.tipo = tipo;
    }

    private void validarParametros(double monto, double cargoPorComision, TipoTransaccion tipo) {
        validarMonto(monto);
        validarCargoPorComision(cargoPorComision);
        validarTipo(tipo);
    }

    private void validarMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de la transacción debe ser un número entero positivo.");
        }
    }

    private void validarCargoPorComision(double cargoPorComision) {
        if (cargoPorComision < 0) {
            throw new IllegalArgumentException("El cargo por comisión no puede ser negativo.");
        }
    }

    private void validarTipo(TipoTransaccion tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de transacción no puede ser nulo.");
        }
    }
}
