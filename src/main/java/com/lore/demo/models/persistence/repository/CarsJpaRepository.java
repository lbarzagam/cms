package com.lore.demo.models.persistence.repository;

import com.lore.demo.models.persistence.entities.CarsJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarsJpaRepository extends JpaRepository<CarsJpa, UUID>, JpaSpecificationExecutor<CarsJpa> {
}
