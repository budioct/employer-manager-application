package com.tutorial.service;

import com.tutorial.Repository.EmployeeRepository;
import com.tutorial.entity.Employee;
import com.tutorial.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Di
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){

        employee.setEmplyeeCode(UUID.randomUUID().toString()); // code empoloye akan di masukan secara acak dan code uniq
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){

        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){

        return employeeRepository.findEmployeeById(id).
                orElseThrow(() ->
                    new UserNotfoundException("User by id " + id + " was not found")
                );
    }

    public void deleteEmployee(Long id){

        employeeRepository.findById(id); // temukan id
        boolean exists = employeeRepository.existsById(id); // ada tidak ada di binding boolean untuk di validasi

        if (!exists){
            throw new IllegalStateException("Employee with id " + id + " doest not exists");
        }
        employeeRepository.deleteById(id);
    }


}
