package com.siva.ems.controller;

import com.siva.ems.dto.EmployeeDto;
import com.siva.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saved  = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<EmployeeDto> getUser(@RequestParam Long myId){
        EmployeeDto saved  = employeeService.getEmployee(myId);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAllUsers(){
        List<EmployeeDto> saved  =  employeeService.getAllEmployee();
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto){
       EmployeeDto saved  =  employeeService.updateEmployee(id,employeeDto);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>( "Employee deleted Success fully",HttpStatus.OK);
    }

}
