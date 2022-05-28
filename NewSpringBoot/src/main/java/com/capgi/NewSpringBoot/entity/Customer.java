package com.capgi.NewSpringBoot.entity;


import com.capgi.NewSpringBoot.dto.CoustomerType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "capg_customers2")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
    private String firstName;
    private String lastName;
    private String email;
private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Enumerated(EnumType.STRING)
    private CoustomerType coustomerType;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id",unique=true)
    private Address address;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(unique=false)
    private List<Product> product;


    public Customer(){}

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CoustomerType getCoustomerType() {
        return coustomerType;
    }

    public void setCoustomerType(CoustomerType coustomerType) {
        this.coustomerType = coustomerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(date, customer.date) && coustomerType == customer.coustomerType && Objects.equals(address, customer.address) && Objects.equals(product, customer.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, firstName, lastName, email, date, coustomerType, address, product);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", coustomerType=" + coustomerType +
                ", address=" + address +
                ", product=" + product +
                '}';
    }

    public Integer getCustomerId() {

        return customerID;
    }

    public void setCustomerId(Integer customerId ) {
        this.customerID=customerId;
    }
}