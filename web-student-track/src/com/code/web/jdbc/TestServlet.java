package com.code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //define datasource connection
	
	@Resource(name="jdbc/web_student_track")
	private DataSource dataSource;
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//set up the printwriter
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		
		
		//get a connection to the database
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
		//create sql statement
		myConn=dataSource.getConnection();
		String sql="select * from student";
		myStmt=myConn.createStatement();
		
		myRs=myStmt.executeQuery(sql);
		while(myRs.next()) {
			String email=myRs.getString("email");
			out.println(email);
		}
		out.println("fss");
		//
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	}

}
