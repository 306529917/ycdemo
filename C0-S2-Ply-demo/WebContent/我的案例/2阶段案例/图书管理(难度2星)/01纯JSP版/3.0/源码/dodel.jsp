<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	
	String id = request.getParameter("id");
	String sql = "delete from books where id = ?";
	DBHelper.update(sql, id);
	
	response.sendRedirect("bookList.jsp");

%>