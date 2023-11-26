package net.javaguide.emsbackend.service;

import net.javaguide.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee );
    void deleteEmployeeById(Long employeeId);

}
