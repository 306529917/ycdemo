package com.yc.jee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.jee.util.JNDIUtils;

@WebServlet("/jndi.s")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(int i=0;i<15;i++) {
			Connection conn = JNDIUtils.getConnection("mysql/test");
			out.println(conn + "<br>");
			// 连接池配置连接数量为5
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		out.println("<hr>");
		
		Connection conn = JNDIUtils.getConnection("mysql/test");
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from books");
			while (rs.next()) {
				out.print(rs.getString("bookname") + "<br>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
