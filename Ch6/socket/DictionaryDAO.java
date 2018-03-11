package socket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {

	public DictionaryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8", "root",
				"s2007tyu");
	}
	
	public List<Dictionary> query(String recieve){
		List<Dictionary> ds=new ArrayList<Dictionary>();
		String sql="select * from dictionary where recieve = ?";
		
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setString(1, recieve);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Dictionary d=new Dictionary();
				int id=rs.getInt(1);
				String receive=rs.getString(2);
				String response=rs.getString(3);
				d.id=id;
				d.recieve=receive;
				d.response=response;
				ds.add(d);
			}
		}catch(SQLException e) {
			
		}
		return ds;
	}
}
