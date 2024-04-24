package com.school.config.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.school.entities.Student;
import com.school.repository.StudentRepository;

public class StudentUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = this.studentRepository.getStudentByUsername(username);
		if(student==null) {
			throw new UsernameNotFoundException("Username doesn't exist");
		}
		return new StudentUserDetails(student);
	}

}
