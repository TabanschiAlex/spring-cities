package com.example.springfirstapp.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Region {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private Integer id;

  @Column(length = 50, nullable = false)
  private String name;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Country country;
}
