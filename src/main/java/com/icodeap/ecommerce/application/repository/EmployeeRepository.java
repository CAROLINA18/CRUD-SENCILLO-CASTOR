package com.icodeap.ecommerce.application.repository;

import com.icodeap.ecommerce.domain.Employee;

public interface EmployeeRepository {
    Iterable<Employee> getEmployee();
    Employee getEmployeeById(Integer id);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(Integer id);
}
