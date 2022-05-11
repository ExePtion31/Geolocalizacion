package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    boolean existById(int id);

    Optional<Student> getOne(int id);

    List<Student> listAll();

    void delete(int id);
}
