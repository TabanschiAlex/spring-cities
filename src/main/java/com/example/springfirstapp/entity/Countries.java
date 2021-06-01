package com.example.springfirstapp.entity;


import javax.persistence.*;
import java.util.Set;


@Entity
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 3)
    private String code;

    @OneToMany
    @JoinTable
    private Set<Regions> region;
}
