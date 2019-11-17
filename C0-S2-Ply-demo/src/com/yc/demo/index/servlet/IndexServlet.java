package com.yc.demo.index.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.jee.common.Config;
import com.yc.jee.vo.EuiNode;

@WebServlet("/index.s")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path;
		String id = req.getParameter("id");
		if (id == null) {
			path = "/案例";
		} else {
			path = id;
		}
		String diskpath = req.getServletContext().getRealPath(path);
		EuiNode node = new EuiNode();
		String rootpath = req.getServletContext().getRealPath("/");
		for (File file : new File(diskpath).listFiles()) {
			node.pushChild(createEuiNode(file, rootpath));
		}
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().append(gson.toJson(node.getChildren()));
	}

	public EuiNode createEuiNode(File file, String rootPath) {
		String webpath = file.getPath().replace(rootPath, "");
		webpath = "/" + webpath.replaceAll("\\\\", "/");
		String state = file.isFile() ? "open" : "closed";
		String id = webpath;
		EuiNode en = new EuiNode(id, file.getName(), state);
		if (file.isFile()) {
			en.setAttribute("href", Config.PROPS.get("github") + "/WebContent" + id);
		}
		return en;
	}

}
