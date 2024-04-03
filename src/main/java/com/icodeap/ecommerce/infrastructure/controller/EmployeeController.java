package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.EmployeeService;
import com.icodeap.ecommerce.domain.Employee;
import com.icodeap.ecommerce.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/employees")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/create")
    public String create(){
        return "admin/employees/create";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(Employee employee, @RequestParam("img") MultipartFile multipartFile) throws IOException {
        log.info("Nombre de empleado: {}", employee);
        employeeService.saveEmployee(employee, multipartFile);
        return "redirect:/admin";
    }
    @GetMapping("/show")
    public String showEmployees(Model model){
       // Role user = new Role();
       // user.setId(1);
        Iterable<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "admin/employees/show";
    }


    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        log.info("employee obtenido editar: {}", employee);
        model.addAttribute("employee",employee);
        return "admin/employees/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/admin/employees/show";
    }


}
