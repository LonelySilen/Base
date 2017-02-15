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

public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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

		doPost(request, response);
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
		String pwd = request.getParameter("pwd");
		String repwd = request.getParameter("repwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String cover = request.getParameter("cover");
		String mobile = request.getParameter("mobile");
		String postCart = request.getParameter("postCart");
		String address = request.getParameter("address");
		Double blance = 0.0;
		boolean res = userService.isValidate(usn);
		// ------------------------判断验证码--------------------------------------------
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		System.out.println(code);
		String validateCode = (String) session.getAttribute("validateCode");

		// --------------------------------------------------------------------
		if (res) {
			String error = "用户名重复！！！";
			session.setAttribute("usnError", error);
			response.sendRedirect("register.jsp");
		} else {
			if (!pwd.equals(repwd)) {
				String error = "两次输入的密码不一致！！！";
				session.setAttribute("pwdError", error);
				response.sendRedirect("register.jsp");
			} else {
				if (code.equals(validateCode)) {
					// 注册信息都正确
					User user = new User(usn, pwd, name, "男", "1", mobile, postCart, address, 0);
					int result = userService.insertUser(user);
					if (result > 0) {
						response.sendRedirect("login.jsp");
					} else {
						String error = "注册失败！";

						session.setAttribute("registerError", error);
						response.sendRedirect("register.jsp");
					}
				} else {
					String error = "验证码不正确！！！";
					session.setAttribute("codeError", error);
					response.sendRedirect("register.jsp");
				}

			}
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
