package com.yc.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.jee.util.VerifyCodeUtils;

@WebServlet("/vcode.s")
public class VcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String vcode = request.getParameter("vcode");
		if (vcode != null) {
			String scode = (String) request.getSession().getAttribute("vcode");
			if (vcode.equalsIgnoreCase(scode)) {
				response.getWriter().append("verification code is correct!");
			} else {
				response.getWriter().append("verification code is error!");
			}
		} else {
			String scode = VerifyCodeUtils.outputImage(response);
			session.setAttribute("vcode", scode);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
