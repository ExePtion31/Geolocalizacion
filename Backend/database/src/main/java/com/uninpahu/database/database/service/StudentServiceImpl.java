package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Student;
import com.uninpahu.database.database.repository.IRepositoryStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
    @Autowired
    IRepositoryStudents repository;

    @Override
    public boolean existById(int id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existByCorreo(String correo) {
        return repository.existsByCorreo(correo);
    }

    @Override
    public Optional<Student> getOne(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> listAll() {
        return repository.findAll();
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
