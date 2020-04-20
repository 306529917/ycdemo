package com.yc.jee.图书管理.vue.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yc.jee.util.DBHelper;
import com.yc.jee.vo.Result;
import com.yc.jee.图书管理.bean.Book;
import com.yc.jee.图书管理.servlet.BaseServlet;

@WebServlet("/图书管理/4.0/book.do")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from books where 1=1";
		List<Object> params = new ArrayList<>();
		sql = DBHelper.and(sql, "bookname like concat('%',?,'%')", request.getParameter("bookname"), params);
		sql = DBHelper.and(sql, "bookpress like concat('%',?,'%')", request.getParameter("bookpress"), params);
		sql = DBHelper.and(sql, "bookauthor like concat('%',?,'%')", request.getParameter("bookauthor"), params);
		response.getWriter().write(gson.toJson(DBHelper.selectList(sql,Book.class, params.toArray())));
	}
	
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "insert into books values(null,?,?,?,?,?,?)";
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			if(book.getBookid() > 0 && book.getBookid()<=10) {
				response.getWriter().print(Result.failure("演示数据不允许修改!"));
				return;
			}
			DBHelper.update(sql, book.getBookname(),
					book.getBookpress(),
					book.getPressdate(),
					book.getBookauthor(),
					book.getBookcount(),
					book.getBookimage());
			response.getWriter().print(Result.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(Result.failure("图书保存失败, 请联系管理员!"));
		}
	}
	
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("id");
		String sql = "delete from books where bookid=?";
		try {
			if(Long.valueOf(bookid)<=10) {
				response.getWriter().print(Result.failure("演示数据不允许删除!"));
				return;
			}
			DBHelper.update(sql, bookid);
			response.getWriter().print(Result.SUCCESS);
		} catch (RuntimeException e) {
			e.printStackTrace();
			response.getWriter().print(Result.failure("图书删除失败, 请联系管理员!"));
		}
	}


	public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid = request.getParameter("bookid");
		String sql = "select * from books where bookid=?";
		response.getWriter().write(gson.toJson(DBHelper.selectOne(sql, bookid)));
	}
	
	public void getPressItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select distinct bookpress from books";
		response.getWriter().write(gson.toJson(DBHelper.selectList(sql)));
	}

}
