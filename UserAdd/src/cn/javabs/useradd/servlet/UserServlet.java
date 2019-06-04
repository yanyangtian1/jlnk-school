package cn.javabs.useradd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.javabs.useradd.entity.User;
import cn.javabs.useradd.service.UserService;
import cn.javabs.useradd.service.impl.UserServiceImpl;


@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charest=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		System.out.println(username+":"+password+":"+sex);
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setSex(sex);
 		UserService service = new UserServiceImpl();
		 int rows = service.addUser(u);	 
		 if (rows>0) {
			response.getWriter().write("添加用户成功");
		}else{
			response.getWriter().write("添加用户失败");
		}  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
