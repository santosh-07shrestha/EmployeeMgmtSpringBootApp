package com.sshres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshres.binding.Employee;
import com.sshres.entity.EmployeeEntity;
import com.sshres.repositoty.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//autowird dynamically injects the dependencies
	@Autowired
	private EmployeeRepo empRepo;
	@Override
	public boolean addEmployee(Employee e) {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(e, empEntity);//copies e data into empEntity;; we can use setters and getters as well
		EmployeeEntity isSaved = empRepo.save(empEntity);
		if (isSaved != null)
			return true;
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empRecords = new ArrayList<Employee>();
		List<EmployeeEntity> empEntity = empRepo.findAll();
		for (EmployeeEntity ee : empEntity) {
			Employee emp = new Employee();
			BeanUtils.copyProperties(ee, emp);
			empRecords.add(emp);
		}
		return empRecords;
	}

	@Override
	public Employee getEmployeeById(int emp_id) {
		Employee emp = null;
		Optional<EmployeeEntity> findById = empRepo.findById(emp_id);
		if (findById.isPresent()) {
			EmployeeEntity empEntity = findById.get();
			emp = new Employee();
			BeanUtils.copyProperties(empEntity, emp);
		}
		return emp;
	}

	@Override
	public boolean updateEmployeee(Employee e) {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(e, empEntity);//copies e data into empEntity;; we can use setters and getters as well
		EmployeeEntity savedEntity = empRepo.save(empEntity);
		boolean flag = false;
		if(savedEntity.getEmp_id() != 0)
			flag = true;
		return flag;
	}

	@Override
	public void deleteEmployee(int emp_id) {
		//Employee emp = null;
		empRepo.deleteById(emp_id);
	}

}
