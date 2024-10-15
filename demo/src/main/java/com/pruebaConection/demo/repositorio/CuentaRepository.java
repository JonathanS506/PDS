package com.pruebaConection.demo.repositorio;

import com.pruebaConection.demo.logicadenegocios.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CuentaRepository extends JpaRepository <Cuenta, String> {
  
}
