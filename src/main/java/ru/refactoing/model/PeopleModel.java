package ru.refactoing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "PEOPLES")
public class PeopleModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PEOPLE_AGE")
    private Integer age;

    @Column(name = "PEOPLE_NAME")
    private String name;
}