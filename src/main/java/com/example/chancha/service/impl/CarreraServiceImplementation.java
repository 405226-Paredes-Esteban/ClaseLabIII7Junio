package com.example.chancha.service.impl;

import com.example.chancha.domain.Carrera;
import com.example.chancha.repository.CarreraRepository;
import com.example.chancha.service.CarreraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImplementation implements CarreraService {
    private final CarreraRepository carreraRepository;

    public CarreraServiceImplementation(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    @Override
    public Carrera save(Carrera carrera) {
       return carreraRepository.save(carrera);
    }

    @Override
    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    public Optional<Carrera> findById(Long id) {
        return carreraRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        carreraRepository.deleteById(id);
    }
}
