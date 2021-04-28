package com.javafullstack.springbootfilms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Director")
@Data
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

}
