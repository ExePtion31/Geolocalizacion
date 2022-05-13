package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.User;
import com.uninpahu.database.database.repository.IRepositoryStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{

    @Autowired
    IRepositoryStudents repository;

    @Override
    public boolean existById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<User> getOne(int id) {
        return repository.findById(id);
    }

    @Override
    public List<User> listAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
