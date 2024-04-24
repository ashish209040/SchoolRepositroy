package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	@Query("SELECT teacher from Teacher teacher where teacher.email=:email")
	public Teacher getTeacherByUsername(@Param("email") String email);
}
