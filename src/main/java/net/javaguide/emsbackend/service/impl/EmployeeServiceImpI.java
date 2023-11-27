package net.javaguide.emsbackend.service.impl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguide.emsbackend.dto.EmployeeDto;
import net.javaguide.emsbackend.entity.Employee;
import net.javaguide.emsbackend.excetion.ResourceNotFoundException;
import net.javaguide.emsbackend.mapper.EmployeeMapper;
import net.javaguide.emsbackend.repository.EmployeeRepository;
import net.javaguide.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor


public class EmployeeServiceImpI implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(@Valid EmployeeDto employeeDto) {
        Employee ConvertToEmployee= EmployeeMapper.mapToEmp(employeeDto);
        employeeRepository.findByEmail(employeeDto.getEmail()).ifPresent((employee) -> {
           throw new ResourceNotFoundException(
                   "Email has been used ");
        });

        Employee saveEmployee= employeeRepository.save(ConvertToEmployee);
        return EmployeeMapper.mapToEmpDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

     Employee emp= employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee ID :"+employeeId+" is not found"));
      return EmployeeMapper.mapToEmpDto(emp);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> AllEmployees= employeeRepository.findAll();
        return AllEmployees.stream().map(EmployeeMapper::mapToEmpDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee FindEmployeeForUpdate=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee id "+employeeId+"not found"));
        FindEmployeeForUpdate.setEmail(updateEmployee.getEmail());
        FindEmployeeForUpdate.setFirstName(updateEmployee.getFirstName());
        FindEmployeeForUpdate.setLastName(updateEmployee.getLastName());
        Employee EmployeeUpdated=employeeRepository.save(FindEmployeeForUpdate);

        return EmployeeMapper.mapToEmpDto(EmployeeUpdated);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("ID not found"));
        employeeRepository.deleteById(employeeId);
    }


}
