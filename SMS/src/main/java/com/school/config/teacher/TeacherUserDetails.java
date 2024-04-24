package com.school.config.teacher;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.school.entities.Role;
import com.school.entities.Teacher;

public class TeacherUserDetails implements UserDetails {

	private Teacher teacher;
	
	public TeacherUserDetails(Teacher teacher) {
		this.teacher=teacher;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Role role=teacher.getRole();
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.toString());
		return List.of(authority);
	}

	@Override
	public String getPassword() {
		return teacher.getPassword();
	}

	@Override
	public String getUsername() {
		return teacher.getContact();
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
