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
		String rpath = req.getServletContext().getRealPath("/");
		for (File f : new File(diskpath).listFiles()) {
			String fpath = f.getPath().replace(rpath, "");
			fpath = "/" + fpath.replaceAll("\\\\", "/");
			String state = f.isFile() ? "open" : "closed";
			EuiNode en = node.appendChild(new EuiNode(path + "/" + f.getName(), f.getName(), state));
			if(f.isFile()) {
				en.setAttribute("href", Config.PROPS.get("github"));
			}
		}
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().append(gson.toJson(node.getChildren()));
	}

}
