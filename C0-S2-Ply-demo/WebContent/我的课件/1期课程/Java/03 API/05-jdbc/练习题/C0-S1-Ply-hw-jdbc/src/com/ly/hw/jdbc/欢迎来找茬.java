package com.ly.hw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**
 *	使用 Junit 测试框架测试以下三个方法, 修改测试过程出现的错误
 */
public class 欢迎来找茬 {

	@Test
	public void test1() throws Exception {
		Class.forName("oracle.jdbc.driver.Oracledriver");
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user = "Scott";
		String password = "A";
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stat = conn.createStatement();

		String sql = "select * form dept";
		ResultSet rs = stat.executeQuery(sql);

		while (rs.next()) {
			System.out.print("编号：" + rs.getInt(1));
			System.out.print("\t名称：" + rs.getInt(2));
			System.out.print("\t地址：" + rs.getString("LCO"));
			System.out.println();
		}
		rs.close();
		stat.close();
		conn.close();
	}

	@Test
	public void test2() throws Exception {
		Class.forName("oracle.JDBC.driver.OracleDriver");
		String url = "jdbc：oracle：thin：@localhost：1521:：orcl";
		String user = "scott";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stat = conn.createStatement();
		String sql = "insert into dept values(30,'财务部','衡阳')";
		stat.executeQuery(sql);
		conn.close();
		stat.close();
	}

	@Test
	public void test3() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "a";
		Connection conn = DriverManager.getConnection(user, password, url);
		conn.setAutoCommit(false);
		String sql1 = "insert dept values( ? , ? , ? )";
		String sql2 = "update dept set"
				+ "dname = ? where deptno = ?";
		try {
			PreparedStatement ps1 = conn.prepareCall(sql1);
			ps1.setInt(0, 99);
			ps1.setString(1, "财务部");
			ps1.setString(2, "北京");
			ps1.executeUpdate(sql1);
			PreparedStatement ps2 = conn.prepareCall(sql2);
			ps2.setInt(1, 99);
			ps2.setString(2, "人事部");
			ps2.setString(3, "长沙");
			ps2.executeQuery(sql2);
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace(); // 打印或者抛出异常
			conn.commit();
		} finally {
			conn.close();
		}
	}

}
