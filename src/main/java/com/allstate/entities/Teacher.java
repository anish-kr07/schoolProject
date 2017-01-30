package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="teachers")
@Data
public class Teacher {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @NotNull
    private  String name;

    @NotNull
    private int age;

    @Column(columnDefinition = "ENUM('Male','Female')")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    private Date  created;

    @UpdateTimestamp
    private Date modified;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    @JsonIgnore
    private List<Klass> klassList;
}
