package com.silen.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.silen.biz.UserService;
import com.silen.biz.impl.UserServiceImpl;
import com.silen.entity.po.User;

public class UserModifyServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public UserModifyServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usn = request.getParameter("usn");
		User user = userService.selectUserByUsn(usn);
		String name = user.getName();
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");

		String mobilestr = request.getParameter("mobile");

		String postCartstr = request.getParameter("postcart");

		String address = request.getParameter("address");

		User newUser = new User(usn, repwd, name, "男", "1", mobilestr, postCartstr, address, 0);
		int res = userService.updateUser(newUser);
		HttpSession session = request.getSession();
		session.setAttribute("usn", usn);
		if (res > 0 && pwd.equals(repwd)) {
			response.sendRedirect("userCenterServlet");
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
