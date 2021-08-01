package com.example.springjpa.service;

import com.example.springjpa.model.Course;
import com.example.springjpa.model.Registration;
import com.example.springjpa.model.RegistrationReport;
import com.example.springjpa.repository.CourseRepository;
import com.example.springjpa.repository.RegistrationRepository;


import java.util.List;

public class RegistrationServiceImpl implements RegistrationService{

   private final RegistrationRepository registrationRepository;
   private final CourseRepository courseRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Registration addRegistration(Registration registration) {
        registration = registrationRepository.save(registration);
        if(registration.getId() == null) {
            Course course = new Course();
            course.setName("Intro");
            course.setDescription("Every attendee must comple the intro.");
            course.setRegistration(registration);

            courseRepository.save(course);
        }

        return registration;
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public List<RegistrationReport> findAllReports() {
        return registrationRepository.registrationReport();
    }
}
