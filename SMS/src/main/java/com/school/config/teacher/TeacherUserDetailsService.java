package com.school.config.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.school.entities.Teacher;
import com.school.repository.TeacherRepository;

public class TeacherUserDetailsService implements UserDetailsService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		Teacher teacher = this.teacherRepository.getTeacherByUsername(username);
		if(teacher==null) {
			throw new UsernameNotFoundException("Username Doesn't exist in server");
		}
		return new TeacherUserDetails(teacher);
	}

}
   