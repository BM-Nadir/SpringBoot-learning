package com.second.secondproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
// if we didn't specify table annotation, JPA will name the table as the class name
@Table(name="employees")
public class Employee {
    // @Id will specify the primary key of the class entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
