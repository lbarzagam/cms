package com.lore.demo.models.persitence.repository;

import com.lore.demo.models.persitence.entities.CarsJpa;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarsDao extends CrudRepository <CarsJpa, UUID> {
}
