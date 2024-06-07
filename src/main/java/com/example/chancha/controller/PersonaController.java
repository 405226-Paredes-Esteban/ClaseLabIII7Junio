package com.example.chancha.controller;

import com.example.chancha.domain.Persona;
import com.example.chancha.service.PersonaService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Sem q viene swagger
@RestController
@RequestMapping("/api")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    //Crear Endpoints => Saber diferentes verbos HTML get,put,post
    @PostMapping("/persona")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona result = personaService.insertarPersona(persona);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(result);
    }

    @GetMapping("/persona/all")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        return ResponseEntity.ok(personaService.buscarTodos());
    }

    @GetMapping("/persona")
    //Request param nos permite hacer querystring con la url!
    public Persona findByNombre(@RequestParam String nombre) {
        return personaService.buscarPersona(nombre);
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Persona> deletePersona(@PathVariable Long id) {
        personaService.borrarPersona(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.actualizarPersona(id,persona));
    }
}