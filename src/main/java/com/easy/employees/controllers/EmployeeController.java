package com.easy.employees.controllers;

import com.easy.employees.VO.EmployeeDto;
import com.easy.employees.models.Employee;
import com.easy.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/Employees/{id}")
    public EmployeeDto findEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }

    @PostMapping("/Employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
