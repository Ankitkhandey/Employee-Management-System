package com.employeemanagementsystem.emsbackend.service.Impl;

import com.employeemanagementsystem.emsbackend.dto.EmployeeDto;
import com.employeemanagementsystem.emsbackend.entity.Employee;
import com.employeemanagementsystem.emsbackend.exception.ResourceNotFoundException;
import com.employeemanagementsystem.emsbackend.mapper.EmployeeMapper;
import com.employeemanagementsystem.emsbackend.repository.EmployeeRepository;
import com.employeemanagementsystem.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceAccessException("Employee with id "+ employeeId +" doesn't exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList= employeeRepository.findAll();
        return employeeList
                .stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id "+ employeeId +" doesn't exist")
                );
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee newEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(newEmployee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id "+ employeeId +" doesn't exist")
                );

        employeeRepository.deleteById(employeeId);
    }
}
