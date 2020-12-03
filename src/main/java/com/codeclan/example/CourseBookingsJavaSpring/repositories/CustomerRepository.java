package com.codeclan.example.CourseBookingsJavaSpring.repositories;

import com.codeclan.example.CourseBookingsJavaSpring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
