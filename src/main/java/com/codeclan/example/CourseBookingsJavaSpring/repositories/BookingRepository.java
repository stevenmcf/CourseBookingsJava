package com.codeclan.example.CourseBookingsJavaSpring.repositories;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Long> {

    List<Booking> findByDate(String date);
    List<Booking> findCustomerByCourseName(String name);
}
