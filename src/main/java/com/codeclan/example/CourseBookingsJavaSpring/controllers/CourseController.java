package com.codeclan.example.CourseBookingsJavaSpring.controllers;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import com.codeclan.example.CourseBookingsJavaSpring.models.Course;
import com.codeclan.example.CourseBookingsJavaSpring.models.Customer;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.CourseRepository;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(@RequestParam(name="starRating", required = false) Integer starRating){
        if (starRating != null){
            return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value ="/courses")
    public ResponseEntity<Course>createFolder(@RequestBody Course course){
        Course newCourse = courseRepository.save(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
}
