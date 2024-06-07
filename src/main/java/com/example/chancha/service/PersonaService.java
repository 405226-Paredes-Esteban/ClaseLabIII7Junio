package com.example.chancha.service;

import org.springframework.stereotype.Service;
import com.example.chancha.domain.*;
import java.util.List;

public interface PersonaService {
    //Por lo general definimos el mismo tipo de la clase para el retorno
    Persona insertarPersona(Persona persona);
    List<Persona> buscarTodos();
    Persona buscarPersona(String nombre);
    Persona buscarPersona(Long id);
    void borrarPersona(Long id);
    //Por lo general al persistir datos, recuperamos el objeto para ver el objeto.
    Persona actualizarPersona(Long id,Persona persona);
    Persona insertarPersonaCarrera(Long id,Persona persona);
}
