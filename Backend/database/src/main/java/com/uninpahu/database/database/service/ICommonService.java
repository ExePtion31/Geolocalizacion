package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Student;

import java.util.Optional;

public interface ICommonService {


    boolean existByCorreo(String correo);

    Optional<Student> getByCorreo(String correo);

    Student save(Student student);

}
