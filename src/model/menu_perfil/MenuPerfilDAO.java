package model.menu_perfil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.menu.Menu;
import model.menu.MenuDAO;
import model.perfil.PerfilDAO;

public class MenuPerfilDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	PerfilDAO daoPerfil;
	MenuDAO daoMenu;
	MenuPerfil mp;
	
	public MenuPerfil getMenuPerfil(int idMenuPerfil)throws 
	SQLException {
		mp = new MenuPerfil();
		daoPerfil = new PerfilDAO();
		daoMenu = new MenuDAO();
		
	sql = "SELECT "
			+ "idMenuPerfil, "
			+ "idPerfil, "
			+ "idMenu, "
			+ "dataCadastro,"
			+ "status " +
		  "FROM menu_perfil WHERE idMenuPerfil = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idMenuPerfil);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		mp.setIdMenuPerfil(rs.getInt("idMenuPerfil"));
		mp.setPerfil(daoPerfil.getPerfil(
				rs.getInt("idPerfil")));
		mp.setMenu(daoMenu.getMenu(
				rs.getInt("idMenu")));
		mp.setDataCadastro(rs.getDate("dataCadastro"));
		mp.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return mp;
}

	public ArrayList<Menu> getListaMenu(int idPerfil) throws SQLException {
		ArrayList<Menu> lista = new ArrayList<>();
		
		sql = "SELECT "
				+ "idPerfil, "
				+ "idMenu "
			+ "FROM menu_perfil "
			+ "WHERE idPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idPerfil);
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			Menu m = daoMenu.getMenu(rs.getInt("idMenu"));
			
			lista.add(m);
		}
		
		ConexaoFactory.desconectar(con);
		
		return lista;
	}
	
	public ArrayList<MenuPerfil> getLista() throws SQLException {
		ArrayList<MenuPerfil> lista = new ArrayList<>();
		
		sql = "SELECT "
				+ "idMenuPerfil, "
				+ "idPerfil, "
				+ "idMenu, "
				+ "dataCadastro, "
				+ "status "
			+ "FROM menu_perfil";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()){
			mp.setIdMenuPerfil(rs.getInt("idMenuPerfil"));
			mp.setPerfil(daoPerfil.getPerfil(
					rs.getInt("idPerfil")));
			mp.setMenu(daoMenu.getMenu(
					rs.getInt("idMenu")));
			mp.setDataCadastro(new Date(rs.getDate("dataCadastro").getTime()));
		
			lista.add(mp);
		}
		
		return lista;
		
	}

	public boolean gravar(MenuPerfil mp)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(mp.getIdMenuPerfil() == 0) {
			sql = "INSERT INTO menu_perfil ("
					+ "idPerfil, "
					+ "idMenu, "
					+ "dataCadastro,"
					+ "status "
				+ ") VALUES (?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, mp.getPerfil().getIdPerfil());
			ps.setInt(2, mp.getMenu().getIdMenu());
			ps.setDate(3, new Date(mp.getDataCadastro().getTime()));
			ps.setInt(4, 1);
			
		}else {
			sql = "UPDATE menu_perfil SET "
					+ "idPerfil = ?, "
					+ "idMenu = ?, "
					+ "dataCadastro = ?,"
					+ "status = ? " +
				   "WHERE idMenuPerfil = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, mp.getIdMenuPerfil());
			ps.setInt(2, mp.getMenu().getIdMenu());
			ps.setDate(3, new Date(mp.getDataCadastro().getTime()));
			ps.setInt(4, mp.getIdMenuPerfil());
			ps.setInt(5, mp.getStatus());
		}
		
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		return true;
		
	}
	
	public boolean ativar(MenuPerfil mp)throws SQLException{
		sql = "UPDATE menu_perfil SET "
				+ "status = ? " +
			  "WHERE idMenuPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, mp.getIdMenuPerfil());
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean desativar(MenuPerfil mp) throws SQLException {
		sql = "UPDATE menu_perfil SET "
				+ "status = ? " +
			  "WHERE idMenuPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, mp.getIdMenuPerfil());
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
}

