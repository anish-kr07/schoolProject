package com.allstate.repositories;


import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.lang.model.type.ArrayType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer>{
    public ArrayList<Teacher> findByGender(Gender gender);
    public ArrayList<Teacher> findByAgeGreaterThan(int age);

    String sql1 = "select (klasses.name) from klasses where teacher_id = :teacherId";
    @Query(value = sql1, nativeQuery = true)
    public ArrayList<Klass> findAllClassesByTeacher(@Param("teacherId") int teacherId);
}
