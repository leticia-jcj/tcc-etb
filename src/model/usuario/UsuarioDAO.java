package model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class UsuarioDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public ArrayList<Usuario> getLista() throws SQLException{
		ArrayList<Usuario> usuarioes = new ArrayList<>();
		sql = "SELECT idUsuario, nome, login, senha, status " +
					 "FROM usuario";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt("idUsuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setStatus(rs.getInt("status"));
			
			usuarioes.add(usuario);
			
		}
		
		ConexaoFactory.close(con);
		return usuarioes;
	}
	
	public boolean gravar(Usuario usuario)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(usuario.getIdUsuario() == 0) {
			sql = "INSERT INTO usuario (nome, login, senha, status ) VALUES (?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getStatus());
			
		}else {
			sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, status = ?" +
				   "WHERE idUsuario = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getStatus());
			ps.setInt(5, usuario.getIdUsuario());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public boolean ativar(Usuario usuario)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE usuario SET  status =1" +
				   "WHERE idUsuario = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getIdUsuario());
					
		
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public boolean desativar(Usuario usuario)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE usuario SET  status =0" +
				   "WHERE idUsuario = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getIdUsuario());
					
		
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public Usuario getCarregarPorId(int idUsuario)throws 
		SQLException {
		Usuario usuario = new Usuario();
		sql = "SELECT idUsuario, nome, login, senha, status " +
			  " FROM usuario WHERE idUsuario = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idUsuario);
		rs = ps.executeQuery();
		if(rs.next()) {
			usuario.setIdUsuario(rs.getInt("idUsuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setStatus(rs.getInt("status"));
			
		}
		
		ConexaoFactory.close(con);
		return usuario;
	}
	
	public boolean deletar(int idUsuario) throws SQLException {
		sql = "DELETE FROM usuario WHERE idUsuario = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idUsuario);
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
		
	}
	
}
