package com.sshres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sshres.binding.Employee;
import com.sshres.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empService;
	
	@GetMapping(value="/loadForm")
	public String loadForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employee";
	}
	
	@PostMapping("/addEmployee")
	public String handleForm(@ModelAttribute Employee emp, Model model) {
		String msg = "";
		boolean flag = empService.addEmployee(emp);
		if(flag) {
			msg = "Employee Addedd Successfully...";
			model.addAttribute("msg", msg);
		}
		else {
			msg = "Error... Adding Employee";
			model.addAttribute("msg", msg);
		}
		return "employee";
	}
	
	@GetMapping("/viewEmployee")
	public String viewAllEmployees(Model model) {
		List<Employee> empList = empService.getAllEmployees();
		model.addAttribute("employees", empList);
		return "viewEmployee";
	}
	
	@RequestMapping("/editEmp")
	public String edit(@RequestParam int emp_id, Model model) {
		Employee emp = empService.getEmployeeById(emp_id);
		model.addAttribute("employee", emp);
		return "editEmp";
	}
	
	@PostMapping("/editSave")
	public String editSave(@ModelAttribute("employee") Employee emp, Model model) {
		boolean isSaved = empService.updateEmployeee(emp);
		String msg = "";
		if(isSaved)
			msg = "Employee details updated successfully.";
		else
			msg = "Error while updating...";
		model.addAttribute("msg", msg);
		return "redirect:/viewEmployee";
	}
	
	@RequestMapping("/deleteEmp")
	public String delete(@RequestParam int emp_id, Model model) {
		empService.deleteEmployee(emp_id);
		System.out.println("deleteEmp");
		return "redirect:/viewEmployeee";
	}

}
