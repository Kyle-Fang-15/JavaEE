package com.code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private StudentDBUtil studentDBUtil;
     @Resource(name="jdbc/web-student-track")
     private DataSource dataSource;
     
     
     
     
     

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			studentDBUtil=new StudentDBUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//
		try{
			
			String theCommand=request.getParameter("command");
			
			if(theCommand==null) {
				theCommand="list";
			}
			
			switch (theCommand) {
			case "list":
				listStudents(request, response);
				break;
			case "ADD":
				addStudent(request,response);
				break;
				
			default:
				listStudents(request, response);
			
			}
			
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	
	
	}


	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String firstName=request.getParameter("firstname");
	String lastName=request.getParameter("lastname");
	String email=request.getParameter("email");
	
	Student theStudent=new Student(firstName, lastName, email);
	
	studentDBUtil.addStudent(theStudent);
	
	listStudents(request,response);
		
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Student> students=studentDBUtil.getStudents();
		
		request.setAttribute("STUDENT_LIST", students);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/list-student.jsp");
	    dispatcher.forward(request,response);
	
	}

}
