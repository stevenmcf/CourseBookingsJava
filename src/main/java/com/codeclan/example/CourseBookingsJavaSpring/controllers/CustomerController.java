package com.codeclan.example.CourseBookingsJavaSpring.controllers;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import com.codeclan.example.CourseBookingsJavaSpring.models.Course;
import com.codeclan.example.CourseBookingsJavaSpring.models.Customer;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value ="/customers")
    public ResponseEntity<Customer>createCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

}
