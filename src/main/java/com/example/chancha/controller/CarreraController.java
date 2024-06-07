package com.example.chancha.controller;

import com.example.chancha.domain.Carrera;
import com.example.chancha.service.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {
    private final CarreraService carreraService;
    public CarreraController(CarreraService carreraService) {this.carreraService=carreraService;}

    @PostMapping("/")
    public ResponseEntity<Carrera> create(@RequestBody Carrera carrera) {
        Carrera result = carreraService.save(carrera);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Carrera>> getAll() {
        return ResponseEntity.ok(carreraService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<Carrera> getById(@PathVariable Long id) {
        return carreraService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carreraService.delete(id);
        return ResponseEntity.ok(null);
    }
}