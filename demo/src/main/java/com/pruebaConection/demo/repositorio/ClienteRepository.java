package com.pruebaConection.demo.repositorio;

import com.pruebaConection.demo.logicadenegocios.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, String> {
  
}

