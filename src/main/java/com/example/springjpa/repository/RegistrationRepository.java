package com.example.springjpa.repository;

import com.example.springjpa.model.Registration;
import com.example.springjpa.model.RegistrationReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<RegistrationReport> registrationReport();
}
