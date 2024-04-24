package com.school.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String name;
	private String fatherName;
	private String motherName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String className;
	private String dob;
	private String city;
	private String contact;
	@ManyToOne
	private Admin admin;
	@ManyToOne
	private Teacher teacher;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student(Integer studentId, String name, String fatherName, String motherName, String email, String password,
			Role role, String className, String dob, String city, String contact, Admin admin, Teacher teacher) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.className = className;
		this.dob = dob;
		this.city = city;
		this.contact = contact;
		this.admin = admin;
		this.teacher = teacher;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", email=" + email + ", password=" + password + ", role=" + role + ", className="
				+ className + ", dob=" + dob + ", city=" + city + ", contact=" + contact + ", admin=" + admin
				+ ", teacher=" + teacher + "]";
	}
	
	
	
	
}
