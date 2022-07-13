package com.testing.mo22.soap;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.howtodoinjava.xml.school.Student;

@Component
public class StudentRespository {
	
	private static final Map<String, Student> students = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Student student = new Student();
		student.setName("Aye Aye");
		student.setStandard(5);
		student.setAddress("Mandalay");
		students.put(student.getName(), student);
		
		student = new Student();
		student.setName("Ko Ko");
		student.setStandard(4);
		student.setAddress("NayPyiTaw");
		students.put(student.getName(), student);
		
		student = new Student();
		student.setName("Khin Khin");
		student.setStandard(5);
		student.setAddress("Yangon");
		students.put(student.getName(), student);
	}
	
	public Student findStudent(String name) {
		Assert.notNull(name, "The Student's name must not be null");
		return students.get(name);
	}

}
