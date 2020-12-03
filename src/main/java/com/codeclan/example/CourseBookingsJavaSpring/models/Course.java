package com.codeclan.example.CourseBookingsJavaSpring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")


public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="location")
    private String location;
    @Column(name="starRating")
    private int starRating;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
//    @JsonIgnoreProperties({"courses"})
    @JsonBackReference
    private List<Booking> bookings;


    public Course(String name, String location, int starRating) {
        this.name = name;
        this.location = location;
        this.starRating = starRating;
        this.bookings = new ArrayList<>();
    }

    public void saveBookingToCourse(Booking booking){
        this.bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Course(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
}
