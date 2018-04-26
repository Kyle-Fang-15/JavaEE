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

	public Student getStudent(String theStudentId) throws Exception {
		// TODO Auto-generated method stub
		Student theStudent=null;
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		int studentId;
		try {
			studentId=Integer.parseInt(theStudentId);
			myConn=dataSource.getConnection();
			String sql="SELECT * FROM student WHERE id=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, studentId);
			myRs=myStmt.executeQuery();
			
			if (myRs.next()) {
				String firstName=myRs.getString("first_name");
				String lastName=myRs.getString("last_name");
				String email=myRs.getString("email");
				theStudent=new Student(studentId, firstName, lastName, email);
			}else {
				throw new Exception("can not find student ID "+ studentId);
			}
			
			
			
			return theStudent;
			
		}
		finally {
			close(myConn, myStmt, myRs);
		}
		
	}

	public void updateStudent(Student theStudent) throws Exception{
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		
		try {
		myConn=dataSource.getConnection();
		String sql="update student "
				+"set first_name=?, last_name=?, email=? where id=?;";
		
		myStmt=myConn.prepareStatement(sql);
		
		myStmt.setString(1, theStudent.getFirstName());
		myStmt.setString(2, theStudent.getLastName());
		myStmt.setString(3, theStudent.getEmail());
		myStmt.setInt(4, theStudent.getId());
		
		myStmt.execute();
		}
		finally {
			
			close(myConn, myStmt, null);
		}
		

	}

	public void deleteStudent(int id) throws Exception{
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			myConn =dataSource.getConnection();
			
			String sql="delete from student where id=?;";
			
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			myStmt.execute();
			
			
		}
		finally {
			close(myConn, myStmt, null);
		}
		
	}
}
