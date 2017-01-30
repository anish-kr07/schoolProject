package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = "/sql/seed.sql")
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void createTeacher() throws Exception{
        Teacher teacher = this.teacherService.create("Nathan", Gender.Male, 30);
        assertEquals(4, teacher.getId());
        assertEquals(Gender.Male, teacher.getGender());
        assertEquals("Nathan", teacher.getName());
    }

    @Test
    public void findById() throws Exception{
        Teacher teacher = this.teacherService.findById(2);
        assertEquals(2, teacher.getId());
        assertEquals(Gender.Male, teacher.getGender());
        assertEquals("Chyld", teacher.getName());
    }

    @Test
    public void findByGender() throws Exception{
        ArrayList<Teacher> teachers = this.teacherService.findByGender(Gender.Female);
        assertEquals(1,teachers.size());
    }

    @Test
    public void findByAgeGreaterThanGivenValue() throws Exception{
        ArrayList<Teacher> teachers = this.teacherService.findByAgeGreaterThan(25);
        assertEquals(1,teachers.size());
    }


    @Test
    //@Transactional // add this for test case to pass
    public void findAllCLassesByATeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findAllClassesByTeacher(2);
        assertEquals(2, klasses.size());
        assertEquals("ClassB", klasses.get(0).getName());
        assertEquals("ClassD", klasses.get(1).getName());
    }

}