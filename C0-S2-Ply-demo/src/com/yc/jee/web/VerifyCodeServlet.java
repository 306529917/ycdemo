package com.yc.jee.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.jee.util.VerifyCodeUtils;

@WebServlet("/vcode.do")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 随机生成验证码
		String verifyCode = VerifyCodeUtils.outputImage(response);
		// 将验证码添加到会话中，注意：在会话中保存的验证码的名称 vcode
		request.getSession().setAttribute("vcode", verifyCode);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
