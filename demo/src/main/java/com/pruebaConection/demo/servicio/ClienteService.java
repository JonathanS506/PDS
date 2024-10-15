package com.pruebaConection.demo.servicio;

import com.pruebaConection.demo.logicadenegocios.Cliente;
import com.pruebaConection.demo.logicadenegocios.ClienteFisico;
import com.pruebaConection.demo.logicadenegocios.ClienteJuridico;
import com.pruebaConection.demo.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  // Método para registrar un cliente físico
  public ClienteFisico registrarClienteFisico(ClienteFisico clienteFisico) {
    String idCliente = "CTE" + (clienteRepository.count() + 1);
    clienteFisico.setIdCliente(idCliente);
    return clienteRepository.save(clienteFisico);
  }

  // Método para registrar un cliente jurídico
  public ClienteJuridico registrarClienteJuridico(ClienteJuridico clienteJuridico) {
    String idCliente = "CTE" + (clienteRepository.count() + 1);
    clienteJuridico.setIdCliente(idCliente);
    return clienteRepository.save(clienteJuridico);
  }

  // Método para obtener todos los clientes
  public List<Cliente> obtenerTodosLosClientes() {
    return clienteRepository.findAll();
  }

  // Método para buscar un cliente por su ID
  public Optional<Cliente> obtenerClientePorId(String id) {
    return clienteRepository.findById(id);
  }

  // Método para actualizar cliente (teléfono y correo)
  public Cliente actualizarCliente(String idCliente, String nuevoTelefono, String nuevoCorreoElectronico) {
    Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
    if (clienteOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      cliente.setTelefono(nuevoTelefono);
      cliente.setCorreoElectronico(nuevoCorreoElectronico);
      return clienteRepository.save(cliente);
    } else {
      throw new IllegalArgumentException("Cliente no encontrado");
    }
  }

  // Método para cambiar el teléfono de un cliente
  public Cliente actualizarTelefono(String idCliente, String nuevoTelefono) {
    Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
    if (clienteOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      cliente.setTelefono(nuevoTelefono);
      return clienteRepository.save(cliente);
    } else {
      throw new IllegalArgumentException("Cliente no encontrado");
    }
  }

  // Método para cambiar el correo electrónico de un cliente
  public Cliente actualizarCorreo(String idCliente, String nuevoCorreoElectronico) {
    Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
    if (clienteOpt.isPresent()) {
      Cliente cliente = clienteOpt.get();
      cliente.setCorreoElectronico(nuevoCorreoElectronico);
      return clienteRepository.save(cliente);
    } else {
      throw new IllegalArgumentException("Cliente no encontrado");
    }
  }
}
