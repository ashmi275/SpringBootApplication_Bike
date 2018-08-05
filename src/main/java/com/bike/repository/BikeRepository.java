package com.bike.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.bike.entity.Bike;

public interface BikeRepository extends CrudRepository<Bike, Long>  {
    List<Bike> findByName(String name);
    List<Bike> findDistinctByModel(String model);
    List<Bike> findByNameAndModel(String name, String model);
} 

