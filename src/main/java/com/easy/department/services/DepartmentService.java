package com.easy.department.services;

import com.easy.department.models.Department;
import com.easy.department.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return ResponseEntity.ok().body(departments);
    }

    public Department addDepartment(Department department) {
     return departmentRepository.save(department);
    }

    public Department findDepartmentById(Integer id) {
        Optional<Department> d = departmentRepository.findById(id);
        if(d.isPresent())return d.get();
        return null;
    }
}
