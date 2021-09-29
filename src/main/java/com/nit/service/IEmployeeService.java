package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Employee;

public interface IEmployeeService {

	String registerEmployee(Employee emp);
	List<Employee> getAllEmployeesData();
	Optional<Employee> getEmployeeById(Integer id);
	String editEmployeeData(Employee emp);
	String deleteEmployeeById(Integer id);
}
