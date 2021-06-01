package com.example.springfirstapp.entity;

import javax.persistence.*;

@Entity
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private Integer id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, unique = true, length = 3)
  private String code;
}
