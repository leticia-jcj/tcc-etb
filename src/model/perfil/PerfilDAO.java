package model.perfil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory.ConexaoFactory;
import model.perfil.Perfil;

public class PerfilDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public Perfil getPerfil(int idPerfil)throws 
		SQLException {
		Perfil perfil = new Perfil();
		sql = "SELECT idPerfil, "
				+ "nome, "
				+ "dataCadastro, "
				+ "status " +
			  " FROM perfil WHERE idPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idPerfil);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			perfil.setIdPerfil(rs.getInt("idPerfil"));
			perfil.setNome(rs.getString("nome"));
			perfil.setDataCadastro(rs.getDate("dataCadastro"));
			perfil.setStatus(rs.getInt("status"));
		}
		
		ConexaoFactory.desconectar(con);
		return perfil;
	}
	
	public ArrayList<Perfil> getLista() throws SQLException{
		ArrayList<Perfil> perfis = new ArrayList<>();
		sql = "SELECT idPerfil, "
				+ "nome, "
				+ "dataCadastro, "
				+ "status " +
			  "FROM perfil";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Perfil p = new Perfil();
			p.setIdPerfil(rs.getInt("idPerfil"));
			p.setNome(rs.getString("nome"));
			p.setDataCadastro(rs.getDate("dataCadastro"));
			p.setStatus(rs.getInt("status"));
			perfis.add(p);
			
		}
		
		ConexaoFactory.close(con);
		return perfis;
	}
	
	public boolean gravar(Perfil p)throws SQLException {
		con = ConexaoFactory.conectar();
		if(p.getIdPerfil() == 0) {
			sql = "INSERT INTO perfil (nome, dataCadastro, status) VALUES (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setDate(2, new Date(p.getDataCadastro().getTime()));
			ps.setInt(3, p.getStatus());
			
		}else {
			sql = "UPDATE perfil SET nome = ?, "
					+ "dataCadastro = ?, status = ? " +
				  "WHERE idPerfil = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setDate(2, new Date(p.getDataCadastro().getTime()));
			ps.setInt(3, p.getStatus());
			ps.setInt(4, p.getIdPerfil());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public boolean ativar(int idPerfil)throws SQLException{
		sql = "UPDATE perfil SET "
			+ "status = ? "
			+ "WHERE idPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, idPerfil);
	
		ps.executeUpdate();
		
		return true;
	}

	public boolean desativar(int idPerfil)throws SQLException{
		sql = "UPDATE perfil SET "
			+ "status = ? "
			+ "WHERE idPerfil = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, idPerfil);
		
		ps.executeUpdate();
		
		return true;
	}
	
}
