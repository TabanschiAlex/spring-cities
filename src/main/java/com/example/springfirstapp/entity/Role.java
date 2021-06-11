package com.example.springfirstapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Integer id;

  @Column(length = 20, unique = true, nullable = false)
  private String name;

  public Role() {}

  public Role(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
