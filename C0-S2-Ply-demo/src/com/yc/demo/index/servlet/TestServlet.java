package com.yc.demo.index.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet("/test.s")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "https://github.com/306529917/ycdemo/blob/master/C0-S2-Ply-demo/WebContent/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		Document doc = Jsoup.connect(url).get();
		Elements es = doc.head().select("link");
		for(Element e : es) {
			String href = e.attr("href");
			if(href.endsWith("css")) {
				request.getSession().setAttribute(href.hashCode()+"", href);
				String link = "<link rel=\"stylesheet\" href=\"css.s?id="+href.hashCode()+"\" />";
				out.print(link);
			}
		}
		out.print("</head><body>");
		Element body = doc.selectFirst("div[itemprop=\"text\"]");
		String b = body.html();
		out.print(b);
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 2、 创建 get 对象
		HttpGet post = new HttpGet(url);
		// 3、 执行 get 请求
		CloseableHttpResponse resp = httpClient.execute(post);
		// 4、 获取返回结果 HttpEntity 对象
		HttpEntity entity = resp.getEntity();
		// 5、获取返回结果中的数据
		String data = EntityUtils.toString(entity);
		// 6、 关闭 response、 关闭 httpClient
		resp.close();
		httpClient.close();
		System.out.println(data);
		response.getWriter().print(data);
	}

}
