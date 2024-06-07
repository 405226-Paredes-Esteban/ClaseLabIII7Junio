package com.example.chancha.service.impl;

import com.example.chancha.domain.Carrera;
import com.example.chancha.domain.Persona;
import com.example.chancha.repository.CarreraRepository;
import com.example.chancha.repository.PersonaRepository;
import com.example.chancha.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImplementation implements PersonaService {
    //final para tener una unica instancia para ingresar a la BD
    private final PersonaRepository personaRepository;
    private final CarreraRepository carreraRepository;
    //POdemos tener 1implementacion con diferentes repositorios y se inicializan todos aca!
    public PersonaServiceImplementation(PersonaRepository personaRepository, CarreraRepository carreraRepository) {
        this.personaRepository = personaRepository;
        this.carreraRepository = carreraRepository;
    }

    @Override
    public Persona insertarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> buscarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Persona buscarPersona(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    @Override
    public Persona buscarPersona(Long id) {
        //Devuelve opcional q tiene la ventaja q siempre te puede devolver algo o no!
        //Si no devuelve nada no hace excepcion y deuvelve null!
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona insertarPersonaCarrera(Long id, Persona persona){
        Optional<Carrera> carrera = carreraRepository.findById(id);
        if(carrera.isPresent()){
            persona.setCarrera(carrera.get());
        }
        return persona;
    }

    @Override
    public Persona actualizarPersona(Long id ,Persona persona) {
        //Primero buscamos q exista el id y esa persona.
        Optional<Persona> base = personaRepository.findById(id);
        if(base.isPresent()){
            base.get().setNombre(persona.getNombre());
            base.get().setApellido(persona.getApellido());
            base.get().setEdad(persona.getEdad());
            return personaRepository.save(base.get());
        }
        else{
            //Quiero modificar algo, pero sino existe lo creo!
            return personaRepository.save(persona);
        }
    }
}
