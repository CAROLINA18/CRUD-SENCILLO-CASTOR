package com.icodeap.ecommerce.application.service;


import com.icodeap.ecommerce.application.repository.EmployeeRepository;
import com.icodeap.ecommerce.domain.Employee;
import com.icodeap.ecommerce.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UploadFile uploadFile;

    public EmployeeService(EmployeeRepository employeeRepository, UploadFile uploadFile) {
        this.employeeRepository = employeeRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<Employee> getEmployees(){
        return  employeeRepository.getEmployee();
    }


    public Employee getEmployeeById(Integer id){
        return  employeeRepository.getEmployeeById(id);
    }

    public Employee saveEmployee(Employee employee ,MultipartFile multipartFile) throws IOException {
        if(employee.getId()==null){


            employee.setDateCreated(LocalDateTime.now());
            employee.setDateUpdated(LocalDateTime.now());
            employee.setRole(employee.getRole());
            log.info("role : {------------**********}", employee.getRole());
            employee.setImage(uploadFile.upload(multipartFile));
            return   employeeRepository.saveEmployee(employee);
        }else{
            Employee EmployeeDB= employeeRepository.getEmployeeById(employee.getId());
            log.info("employee : {}", EmployeeDB);
            //sino se carga la imagen toma la que se le guardó al registro
            if(multipartFile.isEmpty()){
                employee.setImage(EmployeeDB.getImage());
            }else{//guarda la que se le envía actualmente
                //antes se elimina pero si no es por defecto
                if (!EmployeeDB.getImage().equals("default.jpg")){
                    uploadFile.delete(EmployeeDB.getImage());
                }
               employee.setImage(uploadFile.upload(multipartFile));
            }
            employee.setIdentification(EmployeeDB.getIdentification());
            employee.setRole(EmployeeDB.getRole());
            employee.setDateCreated(EmployeeDB.getDateCreated());
            employee.setDateUpdated(LocalDateTime.now());
            return  employeeRepository.saveEmployee(employee);
        }

    }

    public void deleteEmployeeById(Integer id){
        employeeRepository.deleteEmployeeById(id);
    }



}
