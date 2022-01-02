package com.lore.demo.Dao;

import com.lore.demo.Models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
