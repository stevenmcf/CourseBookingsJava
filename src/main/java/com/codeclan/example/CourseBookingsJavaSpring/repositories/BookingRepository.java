package com.codeclan.example.CourseBookingsJavaSpring.repositories;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Long> {
}
