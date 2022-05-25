package model.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class MenuDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public Menu getMenu(int idMenu)
		throws SQLException {
		Menu m = new Menu();
		sql = "SELECT "
				+ "idMenu, "
				+ "nome, "
				+ "link, "
				+ "icone, "
				+ "status " +
			  "FROM menu WHERE idMenu = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idMenu);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			m.setIdMenu(rs.getInt("idMenu"));
			m.setNome(rs.getString("nome"));
			m.setLink(rs.getString("link"));
			m.setIcone(rs.getString("icone"));
			m.setStatus(rs.getInt("status"));
		}
		
		ConexaoFactory.desconectar(con);
		
		return m;
	}
	
	public ArrayList<Menu> getLista()throws SQLException{
		ArrayList<Menu> menus = new ArrayList<>();
		
		sql = "SELECT "
				+ "idMenu, "
				+ "nome, "
				+ "link, "
				+ "icone, "
				+ "status " +
			  "FROM menu";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Menu m = new Menu();
			m.setIdMenu(rs.getInt("idMenu"));
			m.setNome(rs.getString("nome"));
			m.setLink(rs.getString("link"));
			m.setIcone(rs.getString("icone"));
			m.setStatus(rs.getInt("status"));
			
			menus.add(m);
		}
		
		ConexaoFactory.desconectar(con);
		
		return menus;
			
	}
	
	public boolean gravar(Menu m)throws SQLException {
		
		con = ConexaoFactory.conectar();
		
		if(m.getIdMenu() == 0) {
			
			sql = "INSERT INTO menu ("
					+ "nome, "
					+ "link, "
					+ "icone, "
					+ "status"
					+ ") VALUES (?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setString(2, m.getLink());
			ps.setString(3, m.getIcone());
			ps.setInt(4, m.getStatus());
			
			
		}else {
			sql = "UPDATE menu SET "
					+ "nome = ?, "
					+ "link = ?, "
					+ "icone = ?, "
					+ "status = ? " +
				  "WHERE idMenu = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setString(2, m.getLink());
			ps.setString(3, m.getIcone());
			ps.setInt(4, m.getStatus());
			ps.setInt(5, m.getIdMenu());
			
		}
		
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean ativar(Menu m) throws SQLException{
		
		sql = "UPDATE menu SET "
				+ "status = ? "
			+ "WHERE idMenu = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, m.getIdMenu());
		
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}

	public boolean desativar(Menu m) throws SQLException{
		sql = "UPDATE menu SET "
				+ "status = ? "
			+ "WHERE idMenu = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, m.getIdMenu());
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
}
