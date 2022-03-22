package com.easy.employees.VO;

import com.easy.employees.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Employee employee;
    private EmployeeDepartment employeeDepartment;

}
