package com.silen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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

		HttpSession session = request.getSession();
		// 电影票
		List<String> covers = new ArrayList<String>();
		List<String> productCovers = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			String[] cs = ("1#2#3#4#5#6#7#8#9#0").split("#");
			covers.add(cs[0]);
		}
		// 商品
		for (int i = 0; i < 9; i++) {
			String[] cs = ("a#b#c#d#e#f#g#h#i#j").split("#");
			productCovers.add(cs[0]);
		}

		// 获取账号
		// String usn = request.getParameter("usn");
		String usn = (String) session.getAttribute("usn");
		session.setAttribute("movieTicketUps", null);
		session.setAttribute("productUps", null);
		session.setAttribute("covers", covers);
		session.setAttribute("usn", usn);
		session.setAttribute("productCovers", productCovers);
		response.sendRedirect("index.html");
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
