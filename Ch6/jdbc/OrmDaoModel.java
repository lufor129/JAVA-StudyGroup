package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class OrmDaoModel {

	public OrmDaoModel() {
		try {
			Class.forName("com.mysql.jdbc.DriverManager");
		} catch (ClassNotFoundException e) {
		}
	}

	// ORM=Object Relationship Database Mapping
	// 對象和關聯式資料庫的映射
	//
	// 簡單說，一個物件，對應資料庫裡的一條記錄
	public Hero get(int id) {
		Hero hero = null;
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "s2007tyu"); Statement s = c.createStatement();) {

			String sql = "select * from hero where id = " + id;
			ResultSet rs = s.executeQuery(sql);

			// 因為id是唯一的，ResultSet最多只能有一條記錄
			// 所以使用if代替while

			if (rs.next()) {
				String name = rs.getString(2);
				float hp = rs.getFloat(3);
				int damage = rs.getInt(4);
				hero = new Hero(name, hp, damage);
			}

		} catch (SQLException e) {

		}
		return hero;
	}

	// DAO=DataAccess Object
	//
	// 資料庫訪問物件
	//
	// 實際上就是運用了練習-ORM中的思路，把資料庫相關的操作都封裝在這個類裡面，其他地方看不到JDBC的代碼


}
