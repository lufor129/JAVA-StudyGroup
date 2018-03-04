package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class EasyJDBC {

	public EasyJDBC() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
	}

	public void execute(String sql) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); Statement s = c.createStatement();) {

			s.execute(sql);
			System.out.println("done");
		} catch (SQLException e) {
		}
	}

	public ArrayList<Hero> search() {
		ArrayList<Hero> heros = new ArrayList<>();
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); Statement s = c.createStatement();) {
			// 執行查詢語句，並把結果集返回給ResultSet
			String sqlsearch = "select * from hero";
			ResultSet rs = s.executeQuery(sqlsearch);

			while (rs.next()) {

				// 注意!!!，ResultSet為從1開始算，和PreparedStatement一樣
				// 使用字段名
				int id = rs.getInt("id");
				// 使用字段順序
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				heros.add(new Hero(id, name, hp, damage));
			}
		} catch (SQLException e) {
		}

		return heros;
	}

	// 2.查找特定值是否存在，String有單引號
	// String name = "Sombra";
	// String sql = "select * from hero where name = '" + name + "' and hp =" + 200;
	// ResultSet rs = s.executeQuery(sql);if(rs.next())
	// {
	// System.out.println("存在");
	// }else
	// {
	// System.out.println("not exist");
	// }

	// 3.數據總數
	// String sql = "select count(*) from hero";
	// int total = 0;
	// ResultSet rs = s.executeQuery(sql);while(rs.next())
	// {
	// total = rs.getInt(1);
	// }

	public void list(int start, int count) {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); Statement s = c.createStatement();) {

			String sql = "select * from limit " + start + "," + count;
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.println(id + name + hp + damage);
			}
		} catch (SQLException e) {
		}
	}

	public void preparedstatment(String name, float hp, int damage) {
		// 和 Statement一樣，PreparedStatement也是用來執行sql語句的
		// 與創建Statement不同的是，需要根據sql語句創建PreparedStatement
		// 除此之外，還能能夠通過設置參數，指定相應的值，而不是Statement那樣使用字串拼接

		String sql = "insert into hero value(null,?,?,?)";
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); PreparedStatement ps = c.prepareStatement(sql);) {
			
			// 事後設定
			ps.setString(1, "Orisa");
			ps.setFloat(2, 600f);
			ps.setInt(3, 50);

			// 執行
			ps.execute();

		} catch (SQLException e) {
		}
	}

}
