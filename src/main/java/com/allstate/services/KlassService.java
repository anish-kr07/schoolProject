package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {
    @Autowired
    private IKlassRepository repository;

    public Klass findById(int id){
        return this.repository.findOne(id);
    }
}
