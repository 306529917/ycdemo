package com.yc.market.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit.s")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/market";
			String user = "root";
			String password = "a";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from product where pid=?";
			// ÐÂÔö
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();
			Map<String,Object> row = new HashMap<>();
			if(rs.next()){
				row.put("pid",rs.getObject("pid"));
				row.put("pname",rs.getObject("pname"));
				row.put("pprice",rs.getObject("pprice"));
				row.put("cost",rs.getObject("cost"));
				row.put("inprice",rs.getObject("inprice"));
				row.put("ptype",rs.getObject("ptype"));
				row.put("pdesc",rs.getObject("pdesc"));
				row.put("pimg",rs.getObject("pimg"));
			}
			request.setAttribute("row", row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("editProduct.jsp").forward(request, response);
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
