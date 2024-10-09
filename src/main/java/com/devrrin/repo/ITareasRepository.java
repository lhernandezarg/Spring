package com.devrrin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devrrin.model.Tareas;

public interface ITareasRepository extends JpaRepository<Tareas, Integer> {

}
