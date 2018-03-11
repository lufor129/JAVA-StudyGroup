package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test {
	public static void main(String[] args) {

		Connection c = null;
		Statement s = null;

		try {
			// Diriver begin
			Class.forName("com.mysql.jdbc.Driver");

			// 建立與資料庫的Connection連接
			// 這裡需要提供：
			// 資料庫所處於的ip:127.0.0.1 (本機)
			// 資料庫的埠號： 3306 （mysql專用埠號）
			// 資料庫名稱 how2java
			// 編碼方式 UTF-8
			// 帳號 root
			// 密碼 admin

			// Connect with Mysql
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
					"s2007tyu");
			System.out.println(c);

			// 建立Statement對象來使用SQL語句
			s = c.createStatement();

			// 使用SQL語句，字串符要用單引號
			String sql = "insert into hero values(null," + "'Reaper'" + "," + 250 + "," + 70 + ")";
			s.execute(sql);
			System.out.println("done");
			
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			e.getSQLState();
		} finally {
			// 關閉流(也可把Connection和Statement建在try)
			// 先關statement
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
				}
			}

			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
		// 增加、刪除、修改語法
		// 1.增加
		// String sql="insert into hero values(null," + "'Reaper'" + "," + 250 + "," +
		// 70 + ")";
		//
		// 2.刪除
		// String sql="delete from hero where id =5";
		//
		// 3.修改
		// String sql="update hero set name='id 5' where id =3";
	
	}
}
