
package com.lore.demo.Api;

import com.lore.demo.Models.Cars;
import com.lore.demo.Services.CarServices;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/cars")
public class CarsController {

  private final CarServices carServices;

  @GetMapping(value = "")
  public List<Cars> getCarList() {
    return carServices.getCars();
  }

  @GetMapping(value = "/{carId}")
  public ResponseEntity<Cars> getCarList(@PathVariable Integer carId) {
    return new ResponseEntity<>(carServices.getCarById(carId), HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<Cars> createCar(@RequestBody Cars car) {
    return new ResponseEntity<>(carServices.createCar(car), HttpStatus.OK);
  }

  @PutMapping(value = "/{carId}")
  public ResponseEntity<Cars> updateCar(@PathVariable Integer carId, @RequestBody Cars car) {
    return new ResponseEntity<>(carServices.updateCar(carId, car), HttpStatus.OK);
  }

  @SneakyThrows
  @DeleteMapping(value = "/{carId}")
  public ResponseEntity<?> deleteCar(@RequestParam Integer carId) {
    try {
      carServices.deleteCarById(carId);
      return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    catch (Exception ex) {
      throw new Exception(ex.getMessage().toString());
    }
  }

}
