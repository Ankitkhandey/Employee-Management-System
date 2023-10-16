package com.employeemanagementsystem.emsbackend.service.Impl;

import com.employeemanagementsystem.emsbackend.dto.EmployeeDto;
import com.employeemanagementsystem.emsbackend.entity.Employee;
import com.employeemanagementsystem.emsbackend.mapper.EmployeeMapper;
import com.employeemanagementsystem.emsbackend.repository.EmployeeRepository;
import com.employeemanagementsystem.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee SavedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(SavedEmployee);
    }
}
