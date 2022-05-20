package model.menu_perfil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.orcamento.Orcamento;

public class MenuPerfilDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public MenuPerfil getMenuPerfil(int idMenuPerfil)throws 
	SQLException {
		MenuPerfil mp = new MenuPerfil();
	sql = "SELECT idMenuPerfil, "
			+ "dataCadastro, " +
		  "FROM menuPerfil WHERE idMenuPerfil = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idMenuPerfil);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		mp.setIdMenuPerfil(rs.getInt("idMenuPerfil"));
		mp.setDataCadastro(rs.getDate("dataCadastro"));
	}
	
	ConexaoFactory.desconectar(con);
	return mp;
}

	public boolean gravar(MenuPerfil mp)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(mp.getIdMenuPerfil() == 0) {
			sql = "INSERT INTO menu_perfil (dataCadastro) VALUES (?)";
			
			ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(mp.getDataCadastro().getTime()));
			
		}else {
			sql = "UPDATE menu_perfil SET dataCadastro = ? " +
				   "WHERE idMenuPerfil = ?";
			
			ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(mp.getDataCadastro().getTime()));
			ps.setInt(2, mp.getIdMenuPerfil());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public boolean ativar(MenuPerfil mp)throws SQLException{
		sql = "UPDATE menu_perfil set status = 1 " +
			  "WHERE idMenuPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, mp.getIdMenuPerfil());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}
	
	public boolean desativar(MenuPerfil mp)throws SQLException{
		sql = "UPDATE menu_perfil set status = 0 " +
			  "WHERE idMenuPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, mp.getIdMenuPerfil());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}

	//AQUI --> falta implementar o metodo getListaMenu() e getLista()
	
}

