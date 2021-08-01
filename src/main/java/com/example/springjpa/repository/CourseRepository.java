package com.example.springjpa.repository;

import com.example.springjpa.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
    Course save(Course course);
}
