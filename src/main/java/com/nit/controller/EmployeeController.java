package com.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.entity.Employee;
import com.nit.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/register")
	public String displayRegisterPage() {
		return "Register_Employee";
	}
	
	@PostMapping("/register")
	public String registerEmployee(RedirectAttributes attrs,@ModelAttribute Employee emp) {
		String message=service.registerEmployee(emp);
		attrs.addFlashAttribute("message", message);
		return "redirect:get_all_employee";
	}
	
	@GetMapping("/get_all_employee")
	public String getAllEmployeesData(Model model) {
		List<Employee> list= service.getAllEmployeesData();
		model.addAttribute("employees", list);
		return "All_Employees_Data";
	}
	
	@GetMapping("/edit_employee_page")
	public String launchEditPage(Model model,@RequestParam Integer id) {
		Optional<Employee> opt= service.getEmployeeById(id);
		Employee emp=null;
		if(opt.isPresent()) {
			emp=opt.get();
			System.out.println(emp.getEmpTimings()[0]);
			System.out.println(emp.getEmpTimings()[1]);
			//System.out.println(emp.getEmpTimings()[2]);
			System.out.println(emp.getEmpTimings().length);
		}
		model.addAttribute("employee", emp);
		return "Edit_Employee";
	}
	
	@PostMapping("/edit_employee")
	public String editEmployeeData(RedirectAttributes attrs,@ModelAttribute("employee") Employee emp) {
		String result=service.editEmployeeData(emp);
		attrs.addFlashAttribute("result", result);
		return "redirect:get_all_employee";
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployeeData(RedirectAttributes attrs, @RequestParam Integer id) {
		String message=service.deleteEmployeeById(id);
		attrs.addFlashAttribute("message",message);
		return "redirect:get_all_employee";
	}
}
