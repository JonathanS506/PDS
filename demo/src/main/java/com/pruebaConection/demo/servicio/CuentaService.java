package com.pruebaConection.demo.servicio;

import com.pruebaConection.demo.logicadenegocios.Cuenta;
import com.pruebaConection.demo.logicadenegocios.Cliente;
import com.pruebaConection.demo.logicadenegocios.Estatus;
import com.pruebaConection.demo.repositorio.CuentaRepository;
import com.pruebaConection.demo.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

  @Autowired
  private CuentaRepository cuentaRepository;

  @Autowired
  private ClienteRepository clienteRepository;

public Cuenta registrarCuenta(Cuenta cuenta) {
    // Extraer la identidad del cliente del objeto cuenta
    String identidadCliente = cuenta.getCliente().getIdCliente(); // Asumiendo que la cuenta tiene un objeto Cliente asociado

    // Buscar el cliente en el repositorio
    Optional<Cliente> clienteOpt = clienteRepository.findById(identidadCliente);

    if (clienteOpt.isPresent()) {
        cuenta.setCliente(clienteOpt.get());

        String numeroCuenta = "CTA" + (cuentaRepository.count() + 1);
        cuenta.setNumeroCuenta(numeroCuenta);
        cuenta.setEstatus(Estatus.ACTIVA);

        cuenta.setFechaCreacion();

        return cuentaRepository.save(cuenta);
    } else {
        throw new IllegalArgumentException("Cliente con identidad " + identidadCliente + " no encontrado.");
    }
}


  // Método para obtener todas las cuentas
  public List<Cuenta> obtenerTodasLasCuentas() {
    return cuentaRepository.findAll();
  }

  // Método para buscar una cuenta por su número de cuenta
  public Optional<Cuenta> obtenerCuentaPorNumero(String numeroCuenta) {
    return cuentaRepository.findById(numeroCuenta);
  }

  // Método para actualizar una cuenta (puede ser útil para cambiar el saldo o estado)
  public Cuenta actualizarCuenta(Cuenta cuentaActualizada) {
    if (cuentaRepository.existsById(cuentaActualizada.getNumeroCuenta())) {
      return cuentaRepository.save(cuentaActualizada);
    } else {
      throw new IllegalArgumentException("La cuenta con el número " + cuentaActualizada.getNumeroCuenta() + " no existe.");
    }
  }

  // Método para eliminar una cuenta por su número
  public void eliminarCuenta(String numeroCuenta) {
    if (cuentaRepository.existsById(numeroCuenta)) {
      cuentaRepository.deleteById(numeroCuenta);
    } else {
      throw new IllegalArgumentException("La cuenta con el número " + numeroCuenta + " no existe.");
    }
  }

  public void depositar(String numeroCuenta, double monto) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  public void retirar(String numeroCuenta, double monto) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }
}
