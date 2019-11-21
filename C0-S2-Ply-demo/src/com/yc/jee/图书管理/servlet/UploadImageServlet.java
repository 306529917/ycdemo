package com.yc.jee.图书管理.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/图书管理/3.0/uploadImage.s")
public class UploadImageServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置字符集
		//request.setCharacterEncoding("utf-8");
		// 设置响应内容类型
		response.setContentType("text/html; charset=utf-8");
		
		SmartUpload su = new SmartUpload();
		// 设置运行上传文件的类型
		su.setAllowedFilesList("png,gif,jpg,bmp");
		// 初始化 SmartUpload 文件上传对象
		su.initialize(this,request,response);
		// 获取工程名 bbs
		String webPath = request.getContextPath();
		// 设置图片文件夹路径
		webPath += "/图书管理/3.0/images/";
		try {
			su.upload();
			File file = su.getFiles().getFile(0);
			String path = request.getServletContext().getRealPath("/图书管理/3.0/images/");
			path += file.getFileName();
			file.saveAs(path);
			webPath += file.getFileName();
		} catch (SmartUploadException e) {
			e.printStackTrace();
			webPath += "选择书籍图片.jpg";
		}
		response.getWriter().append(webPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
