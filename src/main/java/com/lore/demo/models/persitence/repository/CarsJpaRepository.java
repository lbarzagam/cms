package com.lore.demo.models.persitence.repository;

import com.lore.demo.models.persitence.entities.CarsJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarsJpaRepository extends JpaRepository<CarsJpa, UUID>, JpaSpecificationExecutor<CarsJpa> {
}
