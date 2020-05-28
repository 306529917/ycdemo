package com.yc.demo.servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.jee.util.EmailUtils;

@WebServlet("/vmail.s")
public class VmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vcode = request.getParameter("vcode");
		String email = request.getParameter("email");
		if (vcode != null && vcode.trim().isEmpty() == false) {
			String scode = (String) request.getSession().getAttribute("vcode");
			if (vcode.equalsIgnoreCase(scode)) {
				response.getWriter().append("verification code is correct!");
			} else {
				System.out.println("vcode:" + vcode + " != scode" + scode);
				response.getWriter().append("verification code is error!");
			}
		} else if (email != null && email.trim().isEmpty() == false) {
			String scode = (System.currentTimeMillis() + "");
			scode = scode.substring(scode.length() - 4);
			request.getSession().setAttribute("vcode", scode);
			try {
				EmailUtils.send(email, "廖老师的邮箱验证测试邮件", "重置密码的验证码是:" + scode);
				response.getWriter().append("send email success!");
			} catch (MessagingException e) {
				e.printStackTrace();
				response.getWriter().append("send email failure!");
			}
		} else {
			response.getWriter().append("please input email or vcode!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
