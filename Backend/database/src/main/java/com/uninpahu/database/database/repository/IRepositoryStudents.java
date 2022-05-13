package com.uninpahu.database.database.repository;

import com.uninpahu.database.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IRepositoryStudents extends JpaRepository<User, Integer> {
    Optional<User> getByCorreo(String correo);

    boolean existsByCorreo(String nombre);

    Optional<User> findById(int id);
}
