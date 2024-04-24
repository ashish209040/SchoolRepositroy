package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.entities.Role;
import com.school.entities.Teacher;
import com.school.repository.AdminRepository;
import com.school.repository.TeacherRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/add-teacher")
	public String addTeacher() {
		return "admin/add_teacher";
	}

	@PostMapping("/add-teacher")
	public String processTeacher(@ModelAttribute Teacher teacher, Model model) {

		model.addAttribute("teacher", teacher);
		teacher.setPassword(this.bCryptPasswordEncoder.encode(teacher.getPassword()));
		teacher.setRole(Role.TEACHER);
		this.teacherRepository.save(teacher);
		System.out.println(teacher);
		return "redirect:/admin/add-teacher";
	}
}
