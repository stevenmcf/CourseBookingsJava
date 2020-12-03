package com.codeclan.example.CourseBookingsJavaSpring.repositories;

import com.codeclan.example.CourseBookingsJavaSpring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    List<Customer> findCustomersByBookingsCourseName(String name);
//    Get all customers in a given town for a given course
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String name);

}
