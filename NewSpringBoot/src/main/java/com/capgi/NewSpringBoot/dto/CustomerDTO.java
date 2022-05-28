package com.capgi.NewSpringBoot.dto;

import com.capgi.NewSpringBoot.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CustomerDTO {
    //    private Integer customerId;
    @Pattern(regexp="^[A-Za-z]*$",message = "Name must contain only  alphabet")
    @NotBlank(message = "FirstName cant be empty")
    private String firstName;

    @Pattern(regexp="^[A-Za-z]*$",message = "Name must contain only  alphabet")
    @NotBlank(message = "lastName cant be empty")
    private String lastName;

    @NotBlank(message = "Email cant be empty")
    @Email(message ="enter valid email")
    private String email;



//    @Enumerated(EnumType.STRING)

    private CoustomerType coustomerType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date Date;

@Valid
    private AddressDTO addressDTO;
    @Valid
    private List<ProductDTO> productDTO;

    public CustomerDTO() {
    }

//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }


    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
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
    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<ProductDTO> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(List<ProductDTO> productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && coustomerType == that.coustomerType && Objects.equals(Date, that.Date) && Objects.equals(addressDTO, that.addressDTO) && Objects.equals(productDTO, that.productDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, coustomerType, Date, addressDTO, productDTO);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", coustomerType=" + coustomerType +
                ", Date=" + Date +
                ", addressDTO=" + addressDTO +
                ", productDTO=" + productDTO +
                '}';
    }
}