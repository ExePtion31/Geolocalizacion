package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Careers;
import com.uninpahu.database.database.repository.IRepositoryCareers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CareerServiceImpl implements ICareerService{
    @Autowired
    IRepositoryCareers repository;

    @Override
    public List<Careers> listAll() {
        return repository.findAll();
    }

    @Override
    public boolean existById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<Careers> getOne(int id) {
        return repository.findById(id);
    }

    @Override
    public Careers save(Careers carrera) {
        return repository.save(carrera);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
