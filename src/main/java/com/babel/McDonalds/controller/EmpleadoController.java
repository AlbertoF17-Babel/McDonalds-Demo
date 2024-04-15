package com.babel.McDonalds.controller;

import org.springframework.web.bind.annotation.RestController;

import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.service.EmpleadoService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/employees")

public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }
    
    @PostMapping("/add")
    public int addEmployee(@RequestBody Empleado employee) {
        empleadoService.addEmployee(employee);
        return 1;
    }

    @DeleteMapping("/{dni}/remove")
    public int removeEmployee(@PathVariable String dni) {
        empleadoService.removeEmployee(dni);
        return 1;
    }

    @GetMapping("/{dni}")
    public Empleado getEmployeeByDNI(@PathVariable String dni) {
        return empleadoService.getEmployeeByDNI(dni);
    }
    
    
}
