package com.lore.demo.Api;

import com.lore.demo.Config.SecurityConfig;
import com.lore.demo.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;
import com.lore.demo.Services.CustomerServices;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

  @Autowired
  private CustomerServices customerService;

  @RequestMapping(value = "/hello")
  private String sayHello()
  {
    return "hello world";
  }

  @GetMapping
  public List<Customer> getCustomer()
  {
    //SecurityConfig securityConfig = new SecurityConfig();

    return customerService.getCustomers();
  }

  @GetMapping("/{customerId}")
  public Customer getCustomers(@PathVariable("customerId") int customerId)
  {
    return customerService.getCustomer(customerId);
  }

  @PostMapping
  public Customer addCustomer(@RequestBody Customer customer)
  {
    return customerService.addCustomer(customer);
  }
  @PutMapping("/{customerId}")
  public Customer putCustomer(@PathVariable(value  = "customerId") int customerId, @RequestBody Customer customer)
  {
     return customerService.updateCustomerList(customerId, customer);
  }

  @DeleteMapping("/{customerId}")
  public void deleteCustomer(@PathVariable(value = "customerId") int customerId)
  {
    customerService.deleteCustomer(customerId);
  }




}
