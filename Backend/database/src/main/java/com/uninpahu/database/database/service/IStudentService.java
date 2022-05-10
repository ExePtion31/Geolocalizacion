package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Student;
import java.util.*;

public interface IStudentService {

    boolean existById(int id);

    boolean existByCorreo(String correo);

    Optional<Student> getOne(int id);

    List<Student> listAll();

    Student save(Student student);

    void delete(int id);
}
