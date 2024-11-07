package com.siva.ems.service;

import com.siva.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
