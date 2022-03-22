package com.easy.cloudgateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/departmentsfallback")
    public String departmentsFallBack(){
        return "Department Service is taking longer than usual. Please try in a bit!";
    }

    @GetMapping("/employeesfallback")
    public String employeesfallback(){
        return "Employee is Service is taking longer than usual. Please try in a bit!";
    }
}
