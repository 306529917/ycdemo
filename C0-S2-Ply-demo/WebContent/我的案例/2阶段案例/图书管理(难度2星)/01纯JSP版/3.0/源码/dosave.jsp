<%@page import="com.jspsmart.upload.*"%>
<%@page import="com.yc.jee.util.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%

	/**
		文件上传方式的表单提交，获取请求参数的方式有变化
	*/
	SmartUpload su = new SmartUpload();			// 创建文件上传对象
	su.initialize(pageContext);					// 重要：su 初始化，出入页面上下文对象
	su.setAllowedFilesList("jpg,png,gif,bmp");	// 设置允许上传的文件类型（后缀名）
	su.setMaxFileSize(1024 * 1024 * 5);			// 设置允许上传单个文件大小的最大值 5M
	su.setTotalMaxFileSize(1024 * 1024 * 50);	// 设置允许上传总的文件大小的最大值 5M
	//su.setCharset("utf-8");						// 设置字符集
	su.upload();								// 上传文件	
	
	String bookimage = null;
	if(su.getFiles().getCount()>0){
		File file = su.getFiles().getFile(0);	// 注意：该 File 是 su 提供的 File 类
		String diskpath = application.getRealPath("/入门案例/图书管理/3.0/源码/upload");
		// 注意：因为 su 的 File 与 java.io.File 同名，请注意这里的写法
		java.io.File diskpathFile = new java.io.File(diskpath);
		if(diskpathFile.exists() == false){
			diskpathFile.mkdirs();				// 如果目标文件夹不存在，则创建文件夹
		}
		// 保存文件（只保存一个文件）
		file.saveAs(diskpathFile.getPath() + "/" + file.getFileName());
		// 构建图片的 web 路径，存放到图书的图片字段中
		bookimage = "upload/" + file.getFileName(); 
	}

	Request suReq = su.getRequest();			// 文件上传方式的请求参数，要从su的请求对象中获取
	String id = suReq.getParameter("id");
	String bookname = suReq.getParameter("bookname");
	String bookpress = suReq.getParameter("bookpress");
	String pressdate = suReq.getParameter("pressdate");
	String bookauthor = suReq.getParameter("bookauthor");
	String bookcount = suReq.getParameter("bookcount");

	if(id==null || id.trim().isEmpty()){
		// 新增图书没有ID
		String sql = "insert into books values(null,?,?,?,?,?,?)";
		DBHelper.update(sql, bookname, bookpress, pressdate, bookauthor, bookcount, bookimage);
	} else {
		// 修改的图书有ID
		String sql = "update books set bookname=?,bookpress=?,pressdate=?,"
			+ "bookauthor=?,bookcount=?,bookimage=?";
		// 图片字段单独处理
		sql += bookimage == null ? "" : ",bookimage='" + bookimage + "'";
		sql += " where id=?";
		DBHelper.update(sql, bookname, bookpress, pressdate, bookauthor, bookcount, id);
	}
	
	response.sendRedirect("bookList.jsp");

%>