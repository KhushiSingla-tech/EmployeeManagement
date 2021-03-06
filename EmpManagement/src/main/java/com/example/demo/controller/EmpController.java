package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp", emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee emp, HttpSession session)
	{
		service.addEmp(emp);
		session.setAttribute("msg", "Employee Added Successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Employee e = service.getEmpById(id);
		m.addAttribute("emp", e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session)
	{
		service.addEmp(emp);
		session.setAttribute("msg", "Employee Updated Successfully");
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Deleted Successfully");
		
		return "redirect:/";
	}

}
