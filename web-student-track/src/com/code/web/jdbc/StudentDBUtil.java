package com.code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {
	
	private DataSource dataSource;
	
	public StudentDBUtil(DataSource theDataSource) {
		dataSource=theDataSource;
	}
	
	public List<Student> getStudents() throws Exception   {
		List<Student> students=new ArrayList<>();
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try {
		//get a connection
			myConn=dataSource.getConnection();
			
		
		//creat a sql statement
		String sql="select * from student order by last_name";
		// execute the query
		myStmt=myConn.createStatement();
		
		myRs=myStmt.executeQuery(sql);
		
		
		//process the request
		
		while(myRs.next()) {
			int id=myRs.getInt("id");
			String firstName=myRs.getString("first_name");
			String lastName=myRs.getString("last_Name");
			String email=myRs.getString("email");
			
			Student tempStudent=new Student(id, firstName, lastName, email);
			students.add(tempStudent);
			
			
		}
		
			
			return students;
		}
		finally {
			//close jdbc
			close (myConn, myStmt, myRs);
			
			
		}
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		
		try {
			if (myConn!=null) {
				myConn.close();
			}
			
			if (myStmt!=null) {
				myStmt.close();
			}
			
			if (myRs!=null) {
				myRs.close();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addStudent(Student theStudent) throws Exception{
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="INSERT INTO student (first_name, last_name, email)"
					+"VALUES (?,?,?)";
			
			myStmt=myConn.prepareStatement(sql);
			
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3,  theStudent.getEmail());
			
			
			myStmt.execute();
		}
		finally {
			close(myConn, myStmt, null);
		}
		
		 
		 
		
	}
	
	

}
