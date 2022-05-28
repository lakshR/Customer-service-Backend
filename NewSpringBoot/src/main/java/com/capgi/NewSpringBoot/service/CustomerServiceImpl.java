package com.capgi.NewSpringBoot.service;

import com.capgi.NewSpringBoot.dto.CustomerDTO;
import com.capgi.NewSpringBoot.entity.Address;
import com.capgi.NewSpringBoot.entity.Customer;
import com.capgi.NewSpringBoot.entity.Product;
import com.capgi.NewSpringBoot.entity.Users;
import com.capgi.NewSpringBoot.exception.CustomerNotFoundException;
import com.capgi.NewSpringBoot.exception.InvalidDateException;
import com.capgi.NewSpringBoot.repository.CustomerRepository;
import com.capgi.NewSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    UsersRepository usersRepository;

    @Override
    @Transactional
    public void createCustomerRecord(CustomerDTO customerDTO) {
        Customer customer= new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCoustomerType(customerDTO.getCoustomerType());
        Date currentDate = new Date();
        if(currentDate.compareTo(customerDTO.getDate() )> 0){
            customer.setDate(customerDTO.getDate());
        }
        else{
            throw new InvalidDateException("Invalid date");
        }

        Address address = new Address();
        address.setStreet(customerDTO.getAddressDTO().getStreet());
        address.setCity(customerDTO.getAddressDTO().getCity());
        customer.setAddress(address);
        List <Product> product =new ArrayList<>();

        for(int i=0;i<customerDTO.getProductDTO().size();i++) {
            Product p= new Product();
            p.setProductName(customerDTO.getProductDTO().get(i).getProductName());
            p.setProductId(customerDTO.getProductDTO().get(i).getProductId());
            product.add(p);
        }


        customer.setProduct(product);
        System.out.println(customer);
        customerRepository.save(customer);
    }



    @Override
    public CustomerDTO getCustomer(int id){
        Customer customer=null;
     CustomerDTO customerDTO = new CustomerDTO();
        Optional<Customer> optionalCustomerDTO= customerRepository.findById(id);
        if(optionalCustomerDTO.isPresent()){
            customer=optionalCustomerDTO.get();
           customerDTO.setFirstName(customer.getFirstName());
           customerDTO.setLastName(customer.getLastName());
           customerDTO.setEmail(customer.getEmail());
           customerDTO.setCoustomerType(customer.getCoustomerType());

           return  customerDTO;
        }
        else {
            throw  new CustomerNotFoundException("No one found :"+id);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> deleteCustomer(int id) {
        customerRepository.deleteById(id);
        System.out.println("Customer with"+id+" Deleted");
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAll(){
        customerRepository.deleteAll();
        System.out.println("All data deleted");
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Optional<Customer> customerDTOOptional = customerRepository.findById(customerId);

        return customerDTOOptional.get();

    }


    @Override
    public ResponseEntity<Customer> update(int id, Customer customer) {
        Optional<Customer> customerdata= customerRepository.findById(id);
        if(customerdata.isPresent()){
            Customer customer1 = customerdata.get();
            customer1.setCoustomerType(customer.getCoustomerType());
            customer1.setEmail(customer.getEmail());
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            return  new ResponseEntity<>(customerRepository.save(customer1),HttpStatus.OK);
        }
        else {
            throw  new CustomerNotFoundException("No one found :"+id);
        }
    }




    @Override
    public List<Customer> fetchCustomer() {
        List<Customer> customers = customerRepository.findAll();
        List<Customer> customerDTOList= new  ArrayList<>();
        customerDTOList = customers.stream().map(customer -> {
            Customer customerDTO =new Customer();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setCoustomerType(customer.getCoustomerType());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setDate(customer.getDate());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setProduct(customer.getProduct());

            return customerDTO;
        }).collect(Collectors.toList());

        return customerDTOList;
    }
    @Override
    public List<Users> readUsers() {
        return new ArrayList<>(usersRepository.findAll());
    }

    @Override
    public ResponseEntity<Customer> updatePatch(int id, Customer customer) {

        Optional<Customer> customer1 = customerRepository.findById(id);
        if(customer1.isPresent()){

            Customer customer2 = customer1.get();
            customer2.setEmail(customer.getEmail());
            customer2.setCoustomerType(customer.getCoustomerType());
            return new ResponseEntity<>(customerRepository.save(customer2),HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
