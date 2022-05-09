package com.tutorial.controller;

import com.tutorial.entity.Employee;
import com.tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees") // endpoint/url API .. contoh kursus "/employee" >> api/v1/employees
public class EmployeeResource {

    private final EmployeeService employeeService;

    // dependency injection
    @Autowired
    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // mendapatkan semua data employee
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    // mendapatkan data employee dengan id
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable("id") Long id){

        Employee employeeById = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    // input data employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        Employee addEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.OK);
    }

    // mengubah data employee
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){

        Employee updateEmployeeCuy = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployeeCuy, HttpStatus.OK);
    }

    // menghapus data employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){

        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
