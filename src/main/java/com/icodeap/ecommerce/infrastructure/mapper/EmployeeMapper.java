package com.icodeap.ecommerce.infrastructure.mapper;

import com.icodeap.ecommerce.domain.Employee;
import com.icodeap.ecommerce.infrastructure.entity.EmployeeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "identification", target = "identification"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated"),
                    @Mapping(source = "role", target = "role"),

            }
    )
    Employee toEmployee(EmployeeEntity employeeEntity);
    Iterable<Employee> toEmployess (Iterable<EmployeeEntity> employeeEntities);

    @InheritInverseConfiguration
    EmployeeEntity toEmployeesEntity (Employee employee);
}
