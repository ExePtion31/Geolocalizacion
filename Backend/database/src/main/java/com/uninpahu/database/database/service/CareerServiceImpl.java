package com.uninpahu.database.database.service;

import com.uninpahu.database.database.entity.Careers;
import com.uninpahu.database.database.repository.IRepositoryCareers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CareerServiceImpl implements ICareerService{
    @Autowired
    IRepositoryCareers repository;

    @Override
    public List<Careers> listAll() {
        return repository.findAll();
    }
}
