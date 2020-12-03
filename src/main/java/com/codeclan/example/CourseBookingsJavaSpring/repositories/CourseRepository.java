package com.codeclan.example.CourseBookingsJavaSpring.repositories;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import com.codeclan.example.CourseBookingsJavaSpring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {

}
