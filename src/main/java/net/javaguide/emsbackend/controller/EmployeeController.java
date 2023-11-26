package net.javaguide.emsbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.javaguide.emsbackend.dto.EmployeeDto;
import net.javaguide.emsbackend.entity.Employee;
import net.javaguide.emsbackend.mapper.EmployeeMapper;
import net.javaguide.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService empService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployeeDto=  empService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployeeDto, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") @RequestBody Long empId){
        return  ResponseEntity.ok(empService.getEmployeeById(empId));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return  ResponseEntity.ok(empService.getEmployees());
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")  @RequestBody Long empId, EmployeeDto empUpdate){
        return  ResponseEntity.ok(empService.updateEmployee(empId,empUpdate));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") @RequestBody Long empId){
        empService.deleteEmployeeById(empId);
        return  ResponseEntity.ok("Employee id "+empId+" was delete");
    }
}
