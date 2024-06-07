package com.example.chancha.service;

import com.example.chancha.domain.Carrera;

import java.util.List;
import java.util.Optional;

public interface CarreraService {
    Carrera save(Carrera carrera);
    List<Carrera> findAll();
    Optional<Carrera> findById(Long id);
    void delete(Long id);
}