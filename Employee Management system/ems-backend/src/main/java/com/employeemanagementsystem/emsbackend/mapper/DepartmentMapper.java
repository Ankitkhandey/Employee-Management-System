package com.employeemanagementsystem.emsbackend.mapper;

import com.employeemanagementsystem.emsbackend.dto.DepartmentDto;
import com.employeemanagementsystem.emsbackend.entity.Department;

import javax.management.DescriptorAccess;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
