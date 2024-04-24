package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.school.entities.Role;
import com.school.entities.Student;
import com.school.repository.StudentRepository;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public String index() {
		return "";
	}
	
	@GetMapping("/add-student")
	public String addStudent(){
		return "teacher/add_student";
	}
	
	@PostMapping("/add-student")
	public String processStudent(@ModelAttribute Student student){
		
		student.setRole(Role.STUDENT);
		student.setPassword(this.bCryptPasswordEncoder.encode(student.getPassword()));
		System.out.println(student);
		this.studentRepository.save(student);
		return "teacher/add_student";
	}
	
}
