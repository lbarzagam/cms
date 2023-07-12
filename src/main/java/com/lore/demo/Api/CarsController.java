
package com.lore.demo.Api;

import com.lore.demo.models.domain.Cars;
import com.lore.demo.models.persitence.entities.CarsJpa;
import com.lore.demo.services.CarServices;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/cars")
public class CarsController {

  private final CarServices carServices;

  @GetMapping(value = "")
  public List<CarsJpa> getCarList() {
    return carServices.getCars();
  }

  @GetMapping(value = "/{carId}")
  public ResponseEntity<CarsJpa> getCarList(@PathVariable UUID carId) {
    return new ResponseEntity<>(carServices.getCarById(carId), HttpStatus.OK);
  }
  @PostMapping("/createCars")
  public ResponseEntity<CarsJpa> createCar(@RequestBody CarsJpa car) {
    return new ResponseEntity<>(carServices.createCar(car), HttpStatus.OK);
  }

  @PutMapping(value = "/{carId}")
  public ResponseEntity<CarsJpa> updateCar(@PathVariable UUID carId, @RequestBody CarsJpa car) {
    return new ResponseEntity<>(carServices.updateCar(carId, car), HttpStatus.OK);
  }

  @SneakyThrows
  @DeleteMapping(value = "/{carId}")
  public ResponseEntity<?> deleteCar(@RequestParam UUID carId) {
    try {
      carServices.deleteCarById(carId);
      return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    catch (Exception ex) {
      throw new Exception(ex.getMessage().toString());
    }
  }

}
