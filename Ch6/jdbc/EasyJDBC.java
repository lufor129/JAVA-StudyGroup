package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
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

	// execute與executeUpdate的相同點：都可以執行增加，刪除，修改
	// 不同1：
	// execute可以执行查询语句
	// 然后通过getResultSet，把结果集取出来
	// executeUpdate不能执行查询语句
	// 不同2:
	// execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
	// executeUpdate返回的是int，表示有多少条数据受到了影响

	public void Compare() {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); Statement s = c.createStatement();) {
			String sql = "select * from hero";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

			// executeUpdate返回的是int，表示有多少條資料受到了影響

			String sqlUpdate = "update Hero set hp = 300 where id < 100";
			int number = s.executeUpdate(sqlUpdate);
			System.out.println(number);
		} catch (SQLException e) {
		}
	}

	// 事務:(手動提交)
	// 在事務中的多個操作，要麼都成功，要麼都失敗(避免少部分提交失敗導致數據混亂)
	// 通過 c.setAutoCommit(false);關閉自動提交excute();
	// 只有使用 c.commit();進行手動提交
	// 處於同一個事務當中，要麼都成功，要麼都失敗
	// 所以，雖然第一條SQL語句是可以執行的，但是第二條SQL語句有錯誤，其結果就是兩條SQL語句都沒有被提交。
	// 除非兩條SQL語句都是正確的，不然是不會被提交上去的

	// 刪除前10條，會問Y/N
	public void revise() {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "admin"); Statement Query = c.createStatement(); Statement Delete = c.createStatement();) {
			Scanner sc = new Scanner(System.in);
			// 關閉自動提交，有事務的前提下多操作要馬成功躍馬失敗
			c.setAutoCommit(false);

			ResultSet rs = Query.executeQuery("select id from hero order bu id asc limit 0,10");
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println("要刪除" + id);
				Delete.execute("delete frome hero where id = " + id);
			}

			while (true) {
				System.out.println("是否要刪除(Y/N)?");
				String str = sc.nextLine();

				if (str.equals("Y")) {
					// 手動提交
					c.commit();
					System.out.println("修改完畢");
				} else if (str.equals("N")) {
					System.out.println("已放棄提交");
					break;
				}
			}
		} catch (SQLException e) {
		}
	}
}
