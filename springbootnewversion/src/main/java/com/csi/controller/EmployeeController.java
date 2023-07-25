package com.csi.controller;

import com.csi.excepetion.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody  Employee employee){

        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){

        return ResponseEntity.ok(employeeServiceImpl.getalladata());
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getAllDataById(@PathVariable int empId){

        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @PutMapping("/updatedata/{empId}")
    public  ResponseEntity<Employee> updateData(@PathVariable int empId, @Valid@RequestBody Employee employee){

        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Employee Id Does Not Exists"));


        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());

        return new ResponseEntity<>(employeeServiceImpl.updataData(employee1), HttpStatus.CREATED);
    }

    @PatchMapping("/addresschange/{empId}/{empAddress}")
    public ResponseEntity<Employee> addressChange(@PathVariable int empId,@PathVariable String empAddress){

        Employee employee=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Employee Id Does Not Exists"));

   employee.setEmpAddress(empAddress);
   return ResponseEntity.ok(employeeServiceImpl.patchDataforAddressChange(employee));

    }

    @DeleteMapping("/deletedatabyid")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
       employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("DATA DELETED SUCCESSFULY");
    }
}
