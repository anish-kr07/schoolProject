package com.allstate.entities;

import com.allstate.enums.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by localadmin on 30/01/17.
 */
@Entity
@Table(name = "klasses")
@Data
public class Klass {
    @Id
    @Generated
    private int id;

    @Version
    private int version;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private Date semester ;

    @Column(nullable = false)
    private int credits;

    @Column(nullable = false, columnDefinition = "ENUM(SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY')")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(nullable = false)
    private double fee ;

    @CreationTimestamp
    private Date  created;

    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    @JsonIgnore
    private Teacher teacher;
}
