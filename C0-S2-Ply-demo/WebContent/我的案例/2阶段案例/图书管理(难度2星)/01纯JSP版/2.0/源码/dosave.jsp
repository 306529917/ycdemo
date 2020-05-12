<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	
	String id = request.getParameter("id");
	String bookname = request.getParameter("bookname");
	String bookpress = request.getParameter("bookpress");
	String pressdate = request.getParameter("pressdate");
	String bookauthor = request.getParameter("bookauthor");
	String bookcount = request.getParameter("bookcount");

	if(id==null || id.trim().isEmpty()){
		// 新增图书没有ID
		String sql = "insert into books values(null,?,?,?,?,?)";
		DBHelper.update(sql, bookname, bookpress, pressdate, bookauthor, bookcount);
	} else {
		// 修改的图书有ID
		String sql = "update books set bookname=?,bookpress=?,pressdate=?,"
			+ "bookauthor=?,bookcount=? where id=?";
		DBHelper.update(sql, bookname, bookpress, pressdate, bookauthor, bookcount, id);
	}
	
	response.sendRedirect("bookList.jsp");

%>