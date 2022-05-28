package com.capgi.NewSpringBoot.controller;

import com.capgi.NewSpringBoot.dto.CustomerDTO;
import com.capgi.NewSpringBoot.entity.Customer;
import com.capgi.NewSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
public ResponseEntity<String>createACustomerRecord(@Valid @RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
customerService.createCustomerRecord(customerDTO);
        return new ResponseEntity<>("Creation successful",HttpStatus.OK);
}


@GetMapping("/all")
public List<Customer> fetchCustomers(){
        return customerService.fetchCustomer();
}

@GetMapping("/customer/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") int id){
        return  customerService.getCustomer(id);
}

@DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustById(@PathVariable("id")int id){

    customerService.deleteCustomer(id);
    return new ResponseEntity<>("Deletion successful",HttpStatus.OK);
    }
    public ResponseEntity<HttpStatus> deleteAllCustomer(){
        return  customerService.deleteAll();
    }

@PutMapping("/customer/{id}")
    public ResponseEntity<Customer>updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
    System.out.println(customer);
        return customerService.update(id, customer);
    }
    @PatchMapping("/customer/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Customer customer){
        customerService.updatePatch(id, customer);
        return new ResponseEntity<>("Customer record updated Successfully", HttpStatus.OK);
    }

}
