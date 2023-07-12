package com.lore.demo.models.persitence.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table( name = "cars")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uniqueId")
public class CarsJpa {
  @Id
  @Type(type = "uuid-char")
  @Column(name = "unique_id")
  private UUID uniqueId;
  private LocalDateTime created;
  private String marca;
  private String color;
  private int matricula;
}
