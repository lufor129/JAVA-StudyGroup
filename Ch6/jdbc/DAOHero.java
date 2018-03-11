package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DAOHero extends Hero implements DAO{

	public DAOHero() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
				"s2007tyu");
	}
	
	public int getTotal() {
		int total=0;
		try(Connection c=getConnection();Statement s=c.createStatement();){
			String sql="select count(*) from hero";
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()) {
				total=rs.getInt(1);
			}
		}catch(SQLException e) {}
		return total;
	}
	
	public void add(Hero hero) {
		String sql="insert into hero values(null,?,?,?)";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setString(2, hero.name);
			ps.setFloat(3, hero.hp);
			ps.setInt(4, hero.damage);
			
			ps.execute(sql);
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) {
				int id =rs.getInt(1);
				hero.id=id;
			}
		}catch(SQLException e) {}
	}
	
	public void update(Hero hero) {
		String sql="update hero set name= ? hp= ? damage= ? where id= ?";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setString(2, hero.name);
			ps.setFloat(3, hero.hp);
			ps.setInt(4, hero.damage);
			ps.setInt(1, hero.id);
			
			ps.execute();
		}catch(SQLException e) {}
	}
	
	public void delete(int id) {
		try(Connection c=getConnection();Statement s=c.createStatement();){
			String sql="delete from hero where id = "+id;
			s.execute(sql);
		}catch(SQLException e) {}
	}
	
	public Hero get(int id) {
		Hero hero=null;
		try(Connection c=getConnection();Statement s=c.createStatement();){
			String sql="select * from hero where id = "+id;
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()) {
				hero=new Hero();
				hero.name=rs.getString(2);
				hero.hp=rs.getFloat(3);
				hero.damage=rs.getInt(4);
				hero.id=rs.getInt(1);
			}
		}catch(SQLException e) {}
		return hero;
	}
	
	public List<Hero> list(int start,int count){
		List<Hero> heros=new ArrayList<>();
		String sql="select * from hero order by id desc limit ?,?";
		try(Connection c =getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, count);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Hero hero=new Hero(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
				heros.add(hero);
			}
		}catch(SQLException e) {}
		return heros;
	}
	
	public List<Hero> list(){
		List<Hero> list=list(0,Short.MAX_VALUE);
		return list;
	}
	
}
