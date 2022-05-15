package com.uninpahu.database.database.repository;

import com.uninpahu.database.database.entity.Careers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRepositoryCareers extends JpaRepository<Careers, Integer> {

    Optional<Careers> findByCarrera(String nombre);

    boolean existsByCarrera(String nombre);
}
