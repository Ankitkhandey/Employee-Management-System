package com.employeemanagementsystem.emsbackend.service.Impl;

import com.employeemanagementsystem.emsbackend.dto.DepartmentDto;
import com.employeemanagementsystem.emsbackend.entity.Department;
import com.employeemanagementsystem.emsbackend.exception.ResourceNotFoundException;
import com.employeemanagementsystem.emsbackend.mapper.DepartmentMapper;
import com.employeemanagementsystem.emsbackend.repository.DepartmentRepository;
import com.employeemanagementsystem.emsbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        Department saveDepartment= departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department= departmentRepository.findById(departmentId)
                .orElseThrow( () -> new ResourceNotFoundException("Department with Id: "+ departmentId +" does not exist"));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> allEmployee = departmentRepository.findAll();
        return allEmployee
                .stream()
                .map((department)-> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId) {
        return null;
    }

    @Override
    public DepartmentDto deleteDepartment(Long departmentId) {
        return null;
    }
}
