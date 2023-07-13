package com.lore.demo.services;

import com.lore.demo.models.domain.Customer;
import com.lore.demo.models.persistence.entities.CarsJpa;
import com.lore.demo.models.persistence.mappers.CarMapper;
import com.lore.demo.models.persistence.repository.CarsDao;
import com.lore.demo.models.persistence.repository.CarsJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Component
@RequiredArgsConstructor
public class CarServices {

  private final CarsDao carsDao;
  private final CarsJpaRepository carsJpaRepository;
  //private final CarMapper carMapper;

  private int customerIdCount = 1;
  private List<Customer> customerList = new CopyOnWriteArrayList<>();

  public List<CarsJpa> getCars() {
    return (List<CarsJpa>) carsDao.findAll();
  }

  public CarsJpa getCarById(UUID carId) {
    return carsDao.findById(carId).get();
  }

  public CarsJpa createCar(CarsJpa car) {
    //CarsJpa carsJpa = carsMapper.toJpaModel(car);
    return carsJpaRepository.save(car);
  }

  public void deleteCarById(UUID carId) {
     this.carsDao.deleteById(carId);
  }

  public CarsJpa updateCar(UUID carId, CarsJpa car) {
    this.carsDao.findById(carId).ifPresent(c -> {
      car.setUniqueId(car.getUniqueId());
      this.carsDao.save(car);
    });
    return car;
  }

}
