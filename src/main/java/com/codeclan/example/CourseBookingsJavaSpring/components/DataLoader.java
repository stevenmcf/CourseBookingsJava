package com.codeclan.example.CourseBookingsJavaSpring.components;

import com.codeclan.example.CourseBookingsJavaSpring.models.Booking;
import com.codeclan.example.CourseBookingsJavaSpring.models.Customer;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.BookingRepository;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Harrison", "Edinburgh", 12);
        Customer customer2 = new Customer("Eugene", "Glasgow", 15);

        Booking booking1 = new Booking("12/12/2020", customer1);
        Booking booking2 = new Booking("13/12/2020", customer1);
        Booking booking3 = new Booking("15/12/2020", customer1);
        Booking booking4 = new Booking("11/12/2020", customer2);
        Booking booking5 = new Booking("10/12/2020", customer2);
    }
}
