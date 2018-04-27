package multiEapp;

import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userObj= new User();


        request.setAttribute("name", request.getParameter("loginName"));
        request.setAttribute("password", request.getParameter("password"));

        if(userObj.isValidUserCrendentials(request.getParameter("loginName"), request.getParameter("password"))){
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }else{
            request.setAttribute("errorMessage", "invalid login");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
