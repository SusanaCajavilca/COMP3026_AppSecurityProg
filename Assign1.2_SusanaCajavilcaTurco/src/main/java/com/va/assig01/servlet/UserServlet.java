package com.va.assig01.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.va.assig01.dao.UserDao;
import com.va.assig01.model.User;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDao usDao;

	public void init() {
		usDao = new UserDao();
	}
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    // we dont code in doGet 
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String userId= request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String country = request.getParameter("country");
		String zipCode = request.getParameter("zipCode");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String[] languages = request.getParameterValues("language");
		String language = "";

		if (languages != null) {
		    language = String.join(", ", languages);
		}
		
		String about = request.getParameter("about");
		
		
		User userr = new User();
		
		userr.setUserId(userId);
		userr.setPassword(password);
		userr.setName(name);
		userr.setAddress(address);
		userr.setCountry(country);
		userr.setZipCode(zipCode);
		userr.setEmail(email);
		userr.setSex(sex);
		userr.setLanguage(language);
		userr.setAbout(about);
		
		System.out.println("Values: " + userId +  "- " + password + "- " + name +
				            "- " + address +  "- " + country +  "- " + zipCode + 
				            "- " + email + "- " + sex + "- " + language + "- " + about
				            );
		
		
		try {
			usDao.registerUser(userr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("success.jsp");
		
	
	}

}
