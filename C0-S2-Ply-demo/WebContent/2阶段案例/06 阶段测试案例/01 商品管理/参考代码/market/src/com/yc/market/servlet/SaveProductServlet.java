package com.yc.market.servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save.s")
public class SaveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String cost = request.getParameter("cost");
		String inprice = request.getParameter("inprice");
		String ptype = request.getParameter("ptype");
		String pdesc = request.getParameter("pdesc");
		String pimg = request.getParameter("pimg");
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/market";
			String user = "root";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			if(pid==null || pid.trim().isEmpty()){
				String sql = "insert into product values(null,?,?,?,?,?,?,?)";
				// 新增
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, pname);
				ps.setString(2, pprice);
				ps.setString(3, cost);
				ps.setString(4, inprice);
				ps.setString(5, ptype);
				ps.setString(6, pdesc);
				ps.setString(7, pimg);
				ps.executeUpdate();
			} else {
				// 修改
				String sql = "update product set pname=?,pprice=?,"
						+ "cost=?,inprice=?,ptype=?,pdesc=?,pimg=? where pid=?";
				// 新增
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, pname);
				ps.setString(2, pprice);
				ps.setString(3, cost);
				ps.setString(4, inprice);
				ps.setString(5, ptype);
				ps.setString(6, pdesc);
				ps.setString(7, pimg);
				ps.setString(8, pid);
				ps.executeUpdate();
			}
			response.sendRedirect("query.s");
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("editProduct.jsp").forward(request, response);
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
