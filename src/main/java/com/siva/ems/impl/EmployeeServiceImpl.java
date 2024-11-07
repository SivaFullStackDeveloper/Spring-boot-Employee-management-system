package com.siva.ems.impl;

import com.siva.ems.dto.EmployeeDto;
import com.siva.ems.entity.Employee;
import com.siva.ems.mapper.EmployeeMapper;
import com.siva.ems.repository.EmployeeRepo;
import com.siva.ems.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.employeeMapper(employeeDto);
        Employee savedemployee = employeeRepo.save(employee);
        return EmployeeMapper.employeeDtoMapper(savedemployee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));


        return EmployeeMapper.employeeDtoMapper(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> all = employeeRepo.findAll();
        return all.stream().map(EmployeeMapper::employeeDtoMapper).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto) {
       Employee employee =  employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmailId(employeeDto.getEmailId());
        Employee savedEmployee =  employeeRepo.save(employee);
        return EmployeeMapper.employeeDtoMapper(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
         employeeRepo.deleteById(employee.getId());

    }
}
