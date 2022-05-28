package com.capgi.NewSpringBoot.service;

import com.capgi.NewSpringBoot.dto.CustomerDTO;
import com.capgi.NewSpringBoot.entity.Customer;
import com.capgi.NewSpringBoot.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public void createCustomerRecord(CustomerDTO customerDTO);

    public List<Customer> fetchCustomer();

    CustomerDTO getCustomer(int id);

    ResponseEntity<HttpStatus> deleteCustomer(int id);

    ResponseEntity<HttpStatus> deleteAll();
    Customer getCustomerById(int customerId);
    ResponseEntity<Customer> update(int id, Customer customer);
    List<Users> readUsers();

    ResponseEntity<Customer> updatePatch(int id, Customer customer);
}
