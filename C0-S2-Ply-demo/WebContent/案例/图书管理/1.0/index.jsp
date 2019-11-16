<%@page import="com.yc.jee.util.DBHelper"%>
<%@page import="com.yc.jee.util.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	DBHelper.init("jdbc:mysql://127.0.0.1/test");
	WebHelper.executeSqlAtJsp("题目/数据库脚本.sql", request, application);
	response.sendRedirect("bookList.jsp");
%>
