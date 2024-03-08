package com.agenda.contacto.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.contacto.modelo.Contacto;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {

    List<Contacto> findByNombreContainingIgnoreCase(String nombre);
}
