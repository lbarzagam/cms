package com.lore.demo.Services;

import com.lore.demo.Dao.CarsDao;
import com.lore.demo.Dao.CustomerDao;
import com.lore.demo.Models.Cars;
import com.lore.demo.Models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class CarServices {

  private final CarsDao carsDao;

  private int customerIdCount = 1;
  private List<Customer> customerList = new CopyOnWriteArrayList<>();

  public List<Cars> getCars() {
    return (List<Cars>) carsDao.findAll();
  }

  public Cars getCarById(Integer carId) {
    return carsDao.findById(carId).get();
  }

  public Cars createCar(Cars car) {
    return carsDao.save(car);
  }

  public void deleteCarById(Integer carId) {
     this.carsDao.deleteById(carId);
  }

  public Cars updateCar(Integer carId, Cars car) {
    this.carsDao.findById(carId).ifPresent(c -> {
      car.setId(car.getId());
      this.carsDao.save(car);
    });
    return car;
  }

}
