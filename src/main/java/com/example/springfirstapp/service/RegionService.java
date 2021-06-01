package com.example.springfirstapp.service;

import com.example.springfirstapp.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
  @Autowired
  public RegionRepository regionRepository;
}
