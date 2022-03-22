package com.easy.employees.services;

import com.easy.employees.VO.EmployeeDepartment;
import com.easy.employees.VO.EmployeeDto;
import com.easy.employees.models.Employee;
import com.easy.employees.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;


//    log.info("getting all Employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    public EmployeeDto findById(Integer id){
        EmployeeDto response = new EmployeeDto();
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            Integer deptId = employee.get().getDepartmentId();

            String URL = "http://DEPARTMENT-SERVICE/Departments/"+deptId;
            EmployeeDepartment d = restTemplate.getForObject(URL, EmployeeDepartment.class);

            response.setEmployee(employee.get());
            response.setEmployeeDepartment(d);
        }

        return response;
    }


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
