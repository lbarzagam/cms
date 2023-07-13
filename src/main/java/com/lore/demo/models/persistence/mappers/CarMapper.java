package com.lore.demo.models.persistence.mappers;

import com.lore.demo.models.domain.Cars;
import com.lore.demo.models.persistence.entities.CarsJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper extends BaseJpaMapper<Cars, CarsJpa> {
}
