package com.lore.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "cars")
public class Cars implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @JsonProperty("id")
  @GeneratedValue( strategy = GenerationType.AUTO)
  private Integer  id ;
  @NonNull
  private String make;
  @NonNull
  private String model;
  @NonNull
  private String color;
  @NonNull
  private int year;
  @NonNull
  private int door;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @NonNull
  public String getMake() {
    return make;
  }

  public void setMake(@NonNull String make) {
    this.make = make;
  }

  @NonNull
  public String getModel() {
    return model;
  }

  public void setModel(@NonNull String model) {
    this.model = model;
  }

  @NonNull
  public String getColor() {
    return color;
  }

  public void setColor(@NonNull String color) {
    this.color = color;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getDoor() {
    return door;
  }

  public void setDoor(int door) {
    this.door = door;
  }

  public Cars(Integer id, @NonNull String make, @NonNull String model, @NonNull String color, int year, int door) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.color = color;
    this.year = year;
    this.door = door;
  }

  public Cars() {
  }
}
