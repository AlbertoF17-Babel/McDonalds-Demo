package com.babel.McDonalds.controller;

import org.springframework.web.bind.annotation.RestController;

import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.service.EmpleadoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/employees")

public class EmpleadoController {

    private final EmpleadoService employeeService;

    public EmpleadoController(EmpleadoService EmployeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Empleado> getAllEmployees() {
        return EmpleadoService.getAllEmployees();
    }
    
    @PostMapping("/add")
    public void addEmployee(@RequestBody Empleado employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/remove/{dni}")
    public void removeEmployee(@PathVariable String dni) {
        employeeService.removeEmployee(dni);
    }

    @GetMapping("/{dni}")
    public Empleado getEmployeeByDNI(@PathVariable String dni) {
        return employeeService.getEmployeeByDNI(dni);
    }
    
    
}
