package com.uninpahu.database.database.repository;

import com.uninpahu.database.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRepositoryStudents extends JpaRepository<Student, Integer> {
    Optional<Student> getByCorreo(String correo);

    boolean existsByCorreo(String nombre);

    Optional<Student> findById(int id);
}
