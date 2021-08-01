package com.example.springjpa.controller;

import com.example.springjpa.model.Registration;
import com.example.springjpa.model.RegistrationReport;
import com.example.springjpa.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration") Registration registration) {
        return "registration";
    }

    @GetMapping("registrations")
    public @ResponseBody
    List<Registration> getRegistrations() {
        List<Registration> registrations = registrationService.findAll();
        return registrations;
    }

    @GetMapping("registration-reports")
    public @ResponseBody
    List<RegistrationReport> getRegistrationReports() {
        List<RegistrationReport> registrationReports = registrationService.findAllReports();
        return registrationReports;
    }

    @PostMapping("registration")
    public String addRegistration(@ModelAttribute ("registration")
                                          Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        } else {
            registrationService.addRegistration(registration);
        }

        System.out.println("Registration: " + registration.getName());

        return "redirect:registration";
    }

    @PostMapping("registration/update")
    public @ResponseBody Registration updateRegistration (@ModelAttribute("registration")
                                                                  Registration registration,
                                                          BindingResult result) {
        return registrationService.addRegistration(registration);
    }

}
