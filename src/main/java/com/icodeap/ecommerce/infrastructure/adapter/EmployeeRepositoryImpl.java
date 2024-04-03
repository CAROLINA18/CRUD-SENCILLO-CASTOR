package com.icodeap.ecommerce.infrastructure.adapter;

import com.icodeap.ecommerce.application.repository.EmployeeRepository;
import com.icodeap.ecommerce.domain.Employee;
import com.icodeap.ecommerce.infrastructure.mapper.EmployeeMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeCrudRepository employeeCrudRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeRepositoryImpl(EmployeeCrudRepository employeeCrudRepository, EmployeeMapper employeeMapper) {
        this.employeeCrudRepository = employeeCrudRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Iterable<Employee> getEmployee() {
        return employeeMapper.toEmployess(employeeCrudRepository.findAll());
    }


    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.toEmployee(employeeCrudRepository.findById(id).get());
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeMapper.toEmployee( employeeCrudRepository.save(employeeMapper.toEmployeesEntity(employee) ) );
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeCrudRepository.deleteById(id);
    }
}
