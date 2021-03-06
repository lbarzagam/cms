package com.lore.demo.Services;

import com.lore.demo.Models.Customer;
import com.lore.demo.Dao.CustomerDao;
import com.lore.demo.Exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerServices {

  @Autowired
  private CustomerDao customerDao;

  private int customerIdCount = 1;
  private List<Customer> customerList = new CopyOnWriteArrayList<>();

  public Customer addCustomer(Customer customer)
  {
    return customerDao.save(customer);

    /*customer.setCustomerId(customerIdCount);
    customerList.add(customer);
    customerList.add(customer);
    customerIdCount ++;
    return customer;*/
  }

  public List<Customer>  getCustomers()
  {
    return (List<Customer>) customerDao.findAll();
    //return customerList;
  }

  public Customer getCustomer(int id) {

    Optional<Customer> optionalCustomer = customerDao.findById(id);
    if(!optionalCustomer.isPresent())
        throw new CustomerNotFoundException("The customer record is not available");

    return optionalCustomer.get();

    /*return customerList
                 .stream()
                 .filter(c->c.getCustomerId() == id)
                 .findFirst()
                 .get();*/
  }
  public Customer updateCustomerList(int id, Customer customer) {
    /*customerList
      .stream()
      .forEach(c-> {
        if ( c.getCustomerId() == id )
        {
          c.setCustomerFirstName(customer.getCustomerFirstName());
          c.setCustomerLastName(customer.getCustomerLastName());
          c.setCustomerEmail(customer.getCustomerEmail());
        }
      });
    return customerList
      .stream()
      .filter(c->c.getCustomerId() == id)
      .findFirst()
      .get();*/
    customerDao.findById(id).ifPresent(c-> {
        customer.setCustomerId(id);
        customerDao.save(customer);
    });
    return customer;
  }

  public void deleteCustomer(int customerId)
  {
    /*customerList
      .stream()
      .forEach(c-> {
        if ( c.getCustomerId() == customerId )
        {
          customerList.remove(c);
        }
      });*/
    customerDao.deleteById(customerId);
  }

}
