package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee saveData(Employee employee) {

        return employeeRepoImpl.save(employee);
    }
    public List<Employee> getalladata() {

        return employeeRepoImpl.findAll();
    }
    public Optional<Employee> getDataById(int empId) {

        return employeeRepoImpl.findById(empId);
    }
    public Employee updataData(Employee employee) {

        return employeeRepoImpl.save(employee);
    }
    public Employee patchDataforAddressChange(Employee employee) {

        return employeeRepoImpl.save(employee);

    }
    public void deleteDataById(int empId) {

        employeeRepoImpl.findById(empId);
    }

}
