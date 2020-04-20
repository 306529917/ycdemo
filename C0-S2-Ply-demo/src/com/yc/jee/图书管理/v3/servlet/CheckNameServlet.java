package com.yc.jee.图书管理.v3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.jee.util.DBHelper;

@WebServlet("/图书管理/3.0/checkName.s")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		if(name==null || name.trim().isEmpty()) {
			out.print("请输入书名！");
		} else {
			String sql = "select 1 from books where bookname=?";
			if(DBHelper.selectList(sql, name).size() > 0) {
				out.print("系统已经有该图书了！");
			} else {
				out.print("这是一本新书！");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
