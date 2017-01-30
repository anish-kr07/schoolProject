package com.allstate.services;

import com.allstate.entities.Klass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    private KlassService service;

    @Test
    public void findById() throws Exception{
        Klass class1 = service.findById(2);
        assertEquals("ClassB", class1.getName());
    }
}