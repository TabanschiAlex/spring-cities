package com.example.springfirstapp.service;

import com.example.springfirstapp.entity.Region;
import com.example.springfirstapp.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
  @Autowired
  public RegionRepository regionRepository;

  public List<Region> getRegions(Integer page, String sort) {
    Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
    return regionRepository.findAll(pageable).toList();
  }

  public Optional<Region> getRegionById(Integer id) {
    return regionRepository.findById(id);
  }

  public Region addRegion(Region region) {
    return regionRepository.save(region);
  }

  public Region updateRegion(Region region) {
    Region data = regionRepository.findById(region.getId()).get();
    System.out.println(data);
    data.setName(region.getName());
    data.setCountry(region.getCountry());
    regionRepository.save(data);

    return regionRepository.save(region);
  }

  public void deleteRegion(Integer id) {
    regionRepository.deleteById(id);
  }
}
