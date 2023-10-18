package com.employeemanagementsystem.emsbackend.service;

import com.employeemanagementsystem.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService{
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    void deleteEmployeeById(Long employeeId);

}
