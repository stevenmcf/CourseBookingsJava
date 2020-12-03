package com.codeclan.example.CourseBookingsJavaSpring;

import com.codeclan.example.CourseBookingsJavaSpring.models.Course;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.BookingRepository;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.CourseRepository;
import com.codeclan.example.CourseBookingsJavaSpring.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseBookingsJavaSpringApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCourseByRating(){
		List<Course> foundCourse = courseRepository.findByStarRating(1);
		assertEquals(1, foundCourse.size());
	}

}
