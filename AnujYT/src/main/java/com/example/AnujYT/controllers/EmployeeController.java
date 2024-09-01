package com.example.AnujYT.controllers;

//get /employees
//post /employees
//delete /employee/{id}


//import org.springframework.stereotype.Controller;
import com.example.AnujYT.dto.EmployeeDTO;
import com.example.AnujYT.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{id}")
    public EmployeeDTO getEmployeebyId(@PathVariable("id") Long eid){  //pathVariable=needed @any cost, pathParam=optional
//        return new EmployeeDTO(eid, "saakshi", LocalDate.of(2024,02,15), true );
        return employeeService.getEmployeeById(eid);
    }

//    @GetMapping("/employees")
//    public String getData(@PathParam("sortBy") String sortBy,
//                          @PathParam("limit") Integer limit){
//        return "Hello "+sortBy+" "+limit;
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO getData(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path="/{id}")
    public boolean deleteemployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }

}
