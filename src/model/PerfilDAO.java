package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class PerfilDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public ArrayList<Perfil> getLista() throws SQLException{
		ArrayList<Perfil> perfis = new ArrayList<>();
		sql = "SELECT idPerfil, nome, dataCadastro " +
					 "FROM perfil";
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			Perfil p = new Perfil();
			p.setIdPerfil(rs.getInt("idPerfil"));
			p.setNome(rs.getString("nome"));
			p.setDataCadastro(rs.getDate("dataCadastro"));
			perfis.add(p);
			
		}
		
		ConexaoFactory.close(con);
		return perfis;
	}
	
	public boolean gravar(Perfil p)throws SQLException {
		con = ConexaoFactory.conectar();
		if(p.getIdPerfil() == 0) {
			sql = "INSERT INTO perfil (nome, dataCadastro) VALUES (?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setDate(2, new Date(p.getDataCadastro().getTime()));
			
			
		}else {
			sql = "UPDATE perfil SET nome = ?, dataCadastro = ? " +
				   "WHERE idPerfil = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setDate(2, new Date(p.getDataCadastro().getTime()));
			ps.setInt(3, p.getIdPerfil());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public Perfil getCarregarPorId(int idPerfil)throws 
		SQLException {
		Perfil p = new Perfil();
		sql = "SELECT idPerfil, nome, dataCadastro " +
			  "FROM perfil WHERE idPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idPerfil);
		rs = ps.executeQuery();
		if(rs.next()) {
			p.setIdPerfil(rs.getInt("idPerfil"));
			p.setNome(rs.getString("nome"));
			p.setDataCadastro(rs.getDate("dataCadastro"));
		}
		
		ConexaoFactory.close(con);
		
		return p;
	}
	
	public boolean deletar(int idPerfil) throws SQLException {
		sql = "DELETE FROM perfil WHERE idPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idPerfil);
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
		
	}
}
