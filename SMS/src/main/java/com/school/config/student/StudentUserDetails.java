package com.school.config.student;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.school.entities.Role;
import com.school.entities.Student;
import com.school.repository.StudentRepository;

public class StudentUserDetails implements UserDetails{

	private Student student;
	
	public StudentUserDetails(Student student) {
		this.student=student;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Role role=student.getRole();
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.toString());
		return List.of(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return student.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
