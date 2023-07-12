package com.lore.demo.models.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uniqueId")
public class Cars {
  private UUID uniqueId = UUID.randomUUID();
  private LocalDateTime created;
  private String marca;
  private String color;
  private int matricula;
}
