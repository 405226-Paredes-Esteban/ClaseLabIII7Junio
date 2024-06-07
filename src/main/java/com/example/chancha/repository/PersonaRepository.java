package com.example.chancha.repository;

import com.example.chancha.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    //Podemos definir busquedas especificas, pero x defecto vienen las cosas de CRUD realizadas previamente.
    //Tambien hay formas de hacer consultas sin escribir codigo SQL!
    Persona findByNombre(String nombre);
    Persona findById(long id);
    //JPA Organiza los campos con los atributos!
}