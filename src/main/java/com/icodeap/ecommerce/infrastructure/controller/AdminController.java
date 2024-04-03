package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.EmployeeService;
import com.icodeap.ecommerce.domain.Employee;
import com.icodeap.ecommerce.domain.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final EmployeeService employeeService;

    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String home(Model model){
       // Role user = new Role();
       // user.setId(1);
        Iterable<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employee", employees);
        return "admin/home";
    }
}
