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
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(name="name", required = false)String name, @RequestParam(name="town", required = false)String town){
        if (town != null && name !=null) {
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, name), HttpStatus.OK);
        }
        if (name != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseName(name), HttpStatus.OK);
        }
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

    @DeleteMapping("/customers/{id}/delete")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Void>customerToChange(@RequestBody Customer customer, @PathVariable("id") Long id){
        customerRepository.save(customer);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PatchMapping("/customers/{id}/edit")
    public ResponseEntity<Void>customerToUpdate(@RequestBody Customer partialUpdate, @PathVariable("id") Long id){
        customerRepository.save(partialUpdate);
        return new ResponseEntity<Void>(HttpStatus.OK);

}
