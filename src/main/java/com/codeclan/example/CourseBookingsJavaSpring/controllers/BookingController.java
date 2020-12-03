package com.codeclan.example.CourseBookingsJavaSpring.controllers;

import com.codeclan.example.CourseBookingsJavaSpring.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

}
