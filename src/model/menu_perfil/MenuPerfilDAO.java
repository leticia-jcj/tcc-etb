package model.menu_perfil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConexaoFactory;

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

	
	
	
}

