package com.lore.demo.Dao;

import com.lore.demo.Models.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarsDao extends CrudRepository <Cars, Integer> {
}
