package com.easy.department.controllers;
import com.easy.department.models.Department;
import com.easy.department.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/Departments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/Departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Integer id){
        return departmentService.findDepartmentById(id);
    }
    @PostMapping("/Departments")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }


}
