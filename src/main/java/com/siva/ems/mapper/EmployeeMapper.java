package com.siva.ems.mapper;

import com.siva.ems.dto.EmployeeDto;
import com.siva.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto employeeDtoMapper(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getEmployeeName(),
                employee.getLastName(),
                employee.getEmailId()
        );
    }


    public static Employee employeeMapper(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getEmployeeName(),
                employeeDto.getLastName(),
                employeeDto.getEmailId()
        );
    }
}
