package com.pruebaConection.demo.controllers;

import com.pruebaConection.demo.logicadenegocios.Cliente;
import com.pruebaConection.demo.logicadenegocios.ClienteFisico;
import com.pruebaConection.demo.logicadenegocios.ClienteJuridico;
import com.pruebaConection.demo.servicio.ClienteService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  //Presneta todos los clintes
  @GetMapping("/todos")
  public ResponseEntity<List<Map<String, Object>>> obtenerTodosLosClientes() {
    try {
      List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
      List<Map<String, Object>> clientesCompleto = clientes.stream().map(cliente -> {
        Map<String, Object> clienteMap = new HashMap<>();
        clienteMap.put("idCliente", cliente.getIdCliente());
        clienteMap.put("nombrePila", cliente.getNombrePila());
        clienteMap.put("primerApellido", cliente.getPrimerApellido());
        clienteMap.put("segundoApellido", cliente.getSegundoApellido());
        clienteMap.put("identificacion", cliente.getIdentificacion());
        clienteMap.put("telefono", cliente.getTelefono());
        clienteMap.put("correoElectronico", cliente.getCorreoElectronico());
        clienteMap.put("cantidadCuentas", cliente.getCantidadCuentas());

        if (cliente instanceof ClienteFisico) {
          ClienteFisico clienteFisico = (ClienteFisico) cliente;
          clienteMap.put("fechaNacimiento", clienteFisico.getFechaNacimiento());
        }

        if (cliente instanceof ClienteJuridico) {
          ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
          clienteMap.put("razonSocial", clienteJuridico.getRazonSocial());
          clienteMap.put("tipoNegocio", clienteJuridico.getTipoNegocio());
        }

        return clienteMap;
      }).collect(Collectors.toList());

      return ResponseEntity.ok(clientesCompleto);
    } catch (Exception e) {
      return ResponseEntity.status(500).body(List.of(Map.of("error", "No se pudieron obtener los clientes: " + e.getMessage())));
    }
  }

  // Método para registrar cliente físico
  @PostMapping("/fisico")
  public ResponseEntity<?> registrarClienteFisico(@RequestBody ClienteFisico clienteFisico) {
    try {
      if (clienteFisico.getNombrePila() == null || clienteFisico.getIdentificacion() == null) {
        return ResponseEntity.badRequest().body("Nombre o identificación faltante");
      }

      ClienteFisico clienteGuardado = clienteService.registrarClienteFisico(clienteFisico);
      return ResponseEntity.ok(clienteGuardado);
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al registrar cliente físico: " + e.getMessage());
    }
  }

  // Método para registrar cliente jurídico
  @PostMapping("/juridico")
  public ResponseEntity<?> registrarClienteJuridico(@RequestBody ClienteJuridico clienteJuridico) {
    try {
      if (clienteJuridico.getRazonSocial() == null || clienteJuridico.getIdentificacion() == null) {
        return ResponseEntity.badRequest().body("Razón social o identificación faltante");
      }

      ClienteJuridico clienteGuardado = clienteService.registrarClienteJuridico(clienteJuridico);
      return ResponseEntity.ok(clienteGuardado);
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al registrar cliente jurídico: " + e.getMessage());
    }
  }

  // Método para actualizar cliente (teléfono y correo)
  @PutMapping("/{idCliente}")
  public ResponseEntity<?> actualizarCliente(@PathVariable String idCliente,
          @RequestBody Map<String, String> cambios) {
    try {
      String nuevoTelefono = cambios.get("telefono");
      String nuevoCorreoElectronico = cambios.get("correoElectronico");

      Cliente clienteActualizado = clienteService.actualizarCliente(idCliente, nuevoTelefono, nuevoCorreoElectronico);
      return ResponseEntity.ok(clienteActualizado);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al actualizar el cliente: " + e.getMessage());
    }
  }

  // Método para cambiar el teléfono de un cliente
  @PutMapping("/telefono/{idCliente}")
  public ResponseEntity<?> cambiarTelefono(@PathVariable String idCliente, @RequestBody Map<String, String> cambios) {
    try {
      String nuevoTelefono = cambios.get("telefono");
      Cliente clienteActualizado = clienteService.actualizarTelefono(idCliente, nuevoTelefono);
      return ResponseEntity.ok(clienteActualizado);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al actualizar el teléfono: " + e.getMessage());
    }
  }

  // Método para cambiar el correo electrónico de un cliente
  @PutMapping("/correo/{idCliente}")
  public ResponseEntity<?> cambiarCorreo(@PathVariable String idCliente, @RequestBody Map<String, String> cambios) {
    try {
      String nuevoCorreo = cambios.get("correoElectronico");
      Cliente clienteActualizado = clienteService.actualizarCorreo(idCliente, nuevoCorreo);
      return ResponseEntity.ok(clienteActualizado);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("Error al actualizar el correo: " + e.getMessage());
    }
  }

  @GetMapping("/{idCliente}")
  public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable String idCliente) {
    Optional<Cliente> cliente = clienteService.obtenerClientePorId(idCliente);
    if (cliente.isPresent()) {
      return ResponseEntity.ok(cliente.get());
    } else {
      return ResponseEntity.status(404).body(null);
    }
  }

}
