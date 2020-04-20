package com.yc.jee.图书管理.v3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.jee.util.DBHelper;

@WebServlet("/图书管理/3.0/dosave.jsp")
public class DoSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String bookpress = request.getParameter("bookpress");
		String pressdate = request.getParameter("pressdate");
		String bookauthor = request.getParameter("bookauthor");
		String bookcount = request.getParameter("bookcount");

		if(bookid==null || bookid.trim().isEmpty()){
			// 新增图书没有ID
			String sql = "insert into books values(null,?,?,?,?,?)";
			DBHelper.update(sql, bookname, bookpress, pressdate, bookauthor, bookcount);
		} else {
			// 修改的图书有ID
			String sql = "update books set bookname=?,bookpress=?,pressdate=?,"
				+ "bookauthor=?,bookcount=? where bookid=?";
			DBHelper.update(sql, bookname, bookpress, pressdate, bookauthor, bookcount, bookid);
		}
		
		response.sendRedirect("bookList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
