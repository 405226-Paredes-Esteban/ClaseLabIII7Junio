package com.example.chancha.repository;

import com.example.chancha.domain.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    //List<Carrera> findCarreraByMateriasId (Long id);
}