package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

    private final EmployeeService employeeService;

    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("employee", employeeService.getEmployees());
        return "home";
    }

    @GetMapping("/employee-detail/{id}")
    public String employeeDetail(@PathVariable Integer id, Model model){
        log.info("Id employee: {}", id);
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "admin/employeedetail";
    }

}
