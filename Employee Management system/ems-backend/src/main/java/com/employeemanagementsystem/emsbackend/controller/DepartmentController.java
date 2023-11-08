package com.employeemanagementsystem.emsbackend.controller;

import com.employeemanagementsystem.emsbackend.dto.DepartmentDto;
import com.employeemanagementsystem.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long employeeId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(employeeId);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }



}
