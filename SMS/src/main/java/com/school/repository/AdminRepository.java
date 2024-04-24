package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
}
