package com.ly.book.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.util.DBHelper;

@WebServlet("/book.do")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();

	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from books where 1=1";
		List<Object> params = new ArrayList<>();
		sql = DBHelper.and(sql, "bookname like concat('%',?,'%')", request.getParameter("bookname"), params);
		sql = DBHelper.and(sql, "bookpress like concat('%',?,'%')", request.getParameter("bookpress"), params);
		sql = DBHelper.and(sql, "bookauthor like concat('%',?,'%')", request.getParameter("bookauthor"), params);
		response.getWriter().write(gson.toJson(DBHelper.selectList(sql, params.toArray())));
	}

	public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		String sql = "select * from books where bookid=?";
		response.getWriter().write(gson.toJson(DBHelper.selectList(sql, bookid)));
	}

}
