package com.lore.demo.models.persistence.repository;

import com.lore.demo.models.persistence.entities.CarsJpa;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarsDao extends CrudRepository <CarsJpa, UUID> {
}
