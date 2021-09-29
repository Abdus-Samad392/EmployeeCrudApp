package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;
import com.nit.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public String registerEmployee(Employee emp) {
		Employee savedEmp=repo.save(emp);
		return "Employee Saved With Id : "+savedEmp.getEmpId();
	}
	
	@Override
	public List<Employee> getAllEmployeesData() {
		
		return repo.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		
		return repo.findById(id);
	}
	
	@Override
	public String editEmployeeData(Employee emp) {
		Employee savedEmp=repo.save(emp);
		return "Employee With Id :"+savedEmp.getEmpId()+" Updated";
	}
	
	@Override
	public String deleteEmployeeById(Integer id) {
		repo.deleteById(id);
		return "Employee with Id :"+ id +" Deleted";
	}
}
