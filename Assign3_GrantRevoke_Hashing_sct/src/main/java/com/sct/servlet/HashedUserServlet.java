package com.sct.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.sct.model.HashedUser;
import com.sct.dao.HashedUserDao;
import com.sct.security.HashedUserSecurity;

@WebServlet("/HashedUserServlet")
public class HashedUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    private HashedUserDao userDao;

    public void init() {
        userDao = new HashedUserDao();
    }
    
    
    // we do not code in doGet , we code in doPost
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // getting form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailId = request.getParameter("emailId");

        // hashing password using SHA-512
        String hashedPassword = HashedUserSecurity.hashPassword(password);

        // creating model object
        HashedUser user = new HashedUser();
        
        // setting the values
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setMobileNumber(mobileNumber);
        user.setEmailId(emailId);

        try {
            // INSERT
            userDao.registerUser(user);

            // SELECT
            List<HashedUser> users = userDao.getAllUsers();
            request.setAttribute("users", users);

            // forward to result page
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
