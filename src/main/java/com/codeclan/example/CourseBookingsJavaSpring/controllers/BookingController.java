package com.codeclan.example.CourseBookingsJavaSpring.controllers;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import com.codeclan.example.CourseBookingsJavaSpring.models.Customer;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(name="date", required = false) String date, @RequestParam(name="name", required = false)String name){
        if (date != null) {
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        if (name != null) {
            return new ResponseEntity<>(bookingRepository.findCustomerByCourseName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value ="/bookings")
    public ResponseEntity<Booking>createBooking(@RequestBody Booking booking){
        Booking newBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

}
