package com.employeemanagementsystem.emsbackend.service;

import com.employeemanagementsystem.emsbackend.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
     DepartmentDto createDepartment(DepartmentDto departmentDto);
     DepartmentDto getDepartmentById(Long departmentId);
     List<DepartmentDto> getAllDepartment();
     DepartmentDto updateDepartment(Long departmentId, DepartmentDto newDepartmentDto);
     void deleteDepartment(Long departmentId);
}
