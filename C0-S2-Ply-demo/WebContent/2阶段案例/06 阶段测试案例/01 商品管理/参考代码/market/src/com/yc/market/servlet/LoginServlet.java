package com.yc.market.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.s")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/market";
			String user = "root";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from user where account=? and pwd=? and isadmin=1";
			// 新增
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			Map<String,Object> row = new HashMap<>();
			if(rs.next()){
				row.put("id",rs.getObject("id"));
				row.put("name",rs.getObject("name"));
				row.put("tel",rs.getObject("tel"));
				row.put("email",rs.getObject("email"));
				row.put("pwd",rs.getObject("pwd"));
				row.put("account",rs.getObject("account"));
				row.put("isadmin",rs.getObject("isadmin"));
				request.getSession().setAttribute("loginedUser", row);
				response.sendRedirect("query.s");
			} else {
				request.setAttribute("msg", "用户名或密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
