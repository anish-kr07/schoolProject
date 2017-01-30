package com.allstate.services;


import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private ITeacherRepository repository;

    public Teacher create(String name, Gender gender, int age){
        Teacher teacher = new Teacher();
        teacher.setAge(age);
        teacher.setGender(gender);
        teacher.setName(name);
        return this.repository.save(teacher);
    }

    public Teacher findById(int id){
        return this.repository.findOne(id);
    }

    public ArrayList<Teacher> findByGender(Gender gender){
        return this.repository.findByGender(gender);
    }
    public ArrayList<Teacher> findByAgeGreaterThan(int age){
        return this.repository.findByAgeGreaterThan(age);
    }

    @Transactional
    public List<Klass> findAllClassesByTeacher(int id){
        return findById(id).getKlassList();
    }
}
