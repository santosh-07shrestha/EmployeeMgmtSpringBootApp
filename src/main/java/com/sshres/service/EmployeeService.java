package com.sshres.service;

import java.util.List;

import com.sshres.binding.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int emp_id);
	public boolean updateEmployeee(Employee e);
	public void deleteEmployee(int emp_id);
}
