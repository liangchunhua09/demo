package com.xxx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxx.dao.UserDao;
import com.xxx.entity.User;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/login")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置中文编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获取jsp中的username，password  这里要和jsp里的name名一致
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//之后封装到JavaBean里边，于是建立一个实体类 
		User user=new User(username,password);
		UserDao ud =new UserDao();
		boolean result =ud.login(user);
		if(result){
			request.getRequestDispatcher("file.jsp").forward(request, response);
		}else{
			response.sendRedirect("defeat.jsp");
		}
		
	}

}
