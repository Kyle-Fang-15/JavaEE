package com.lovetocode.servletdemo.mvc2;

import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {
	
	public static List<Student> getStudents(){
		//List
		
		List<Student> students=new ArrayList<Student>();
		
		students.add(new Student("Mary1", "Public1", "112@ewrw1.com"));
		students.add(new Student("Mary2", "Public2", "112@ewrw2.com"));
		students.add(new Student("Mary3", "Public3", "112@ewrw3.com"));
		
		return students;
		
	}

}
