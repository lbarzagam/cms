package com.lore.demo.models.persitence.mappers;

import com.lore.demo.models.domain.Cars;
import com.lore.demo.models.persitence.entities.CarsJpa;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public abstract class CarsMapper implements BaseJpaMapper<Cars, CarsJpa> {
}
