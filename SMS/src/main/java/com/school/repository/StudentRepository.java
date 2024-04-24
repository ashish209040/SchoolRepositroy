package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.entities.Student;

public interface StudentRepository extends JpaRepository< Student, Integer>{
	@Query("SELECT student FROM Student student where student.email=:email")
	public Student getStudentByUsername(@Param("email") String email);
}
