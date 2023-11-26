package net.javaguide.emsbackend.mapper;

import net.javaguide.emsbackend.dto.EmployeeDto;
import net.javaguide.emsbackend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmpDto(Employee emp){
        return  new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
    }
    public static Employee mapToEmp(EmployeeDto empDto){
        return  new Employee(empDto.getId(),empDto.getFirstName(),empDto.getLastName(),empDto.getEmail());
    }
}
