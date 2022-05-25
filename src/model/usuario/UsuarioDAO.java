package model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.perfil.PerfilDAO;

public class UsuarioDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	PerfilDAO daoPerfil;

	public Usuario getUsuario(int idUsuario)throws 
	SQLException {
		Usuario usuario = new Usuario();
		daoPerfil = new PerfilDAO();
	sql = "SELECT idUsuario, "
			+ "idPerfil, "
			+ "nome, "
			+ "login, "
			+ "senha, "
			+ "status " +
		  "FROM usuario WHERE idUsuario = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idUsuario);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		usuario.setIdUsuario(rs.getInt("idUsuario"));
		usuario.setPerfil(daoPerfil.getPerfil(
				rs.getInt("idPerfil")));
		usuario.setNome(rs.getString("nome"));
		usuario.setLogin(rs.getString("login"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return usuario;
}
	
	public ArrayList<Usuario> getLista() throws SQLException{
		ArrayList<Usuario> usuario = new ArrayList<>();
		sql = "SELECT idUsuario, "
				+ "idPerfil, "
				+ "nome, "
				+ "login, "
				+ "senha, "
				+ "status " +
			  "FROM usuario";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Usuario u = new Usuario();
			u.setIdUsuario(rs.getInt("idUsuario"));
			u.setPerfil(daoPerfil.getPerfil(
					rs.getInt("idPerfil")));
			u.setNome(rs.getString("nome"));
			u.setLogin(rs.getString("login"));
			u.setSenha(rs.getString("senha"));
			u.setStatus(rs.getInt("status"));
			
			usuario.add(u);
			
		}
		
		ConexaoFactory.desconectar(con);
		return usuario;
	}
	
	public boolean gravar(Usuario usuario)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(usuario.getIdUsuario() == 0) {
			sql = "INSERT INTO usuario ("
					+ "idPerfil, "
					+ "nome, "
					+ "login, "
					+ "senha, "
					+ "status "
				+ ") VALUES (?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getPerfil().getIdPerfil());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setInt(5, usuario.getStatus());
			
		}else {
			sql = "UPDATE usuario SET "
					+ "idPerfil = ?, "
					+ "nome = ?, "
					+ "login = ?, "
					+ "senha = ?, "
					+ "status = ? " +
				   "WHERE idUsuario = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getPerfil().getIdPerfil());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setInt(5, usuario.getStatus());
			ps.setInt(6, usuario.getIdUsuario());
		}
		
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		return true;
		
	}
	
	public boolean ativar(Usuario usuario)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE usuario SET status = ? " +
				   "WHERE idUsuario = ?";
			
			con = ConexaoFactory.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, usuario.getIdUsuario());
			ps.executeUpdate();
			ConexaoFactory.desconectar(con);
		
			return true;
		
	}
	
	public boolean desativar(Usuario usuario)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE usuario SET status = ? " +
				   "WHERE idUsuario = ?";
			
			con = ConexaoFactory.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, usuario.getIdUsuario());
			ps.executeUpdate();
			ConexaoFactory.desconectar(con);
			
			return true;
	}


	public Usuario login(String login, String hash) throws SQLException{
		Usuario u = new Usuario();
		
		sql = "SELECT "
				+ "idUsuario, "
				+ "idPerfil, "
				+ "nome, "
				+ "login, "
				+ "senha, "
				+ "status "
			+ "WHERE login = ? AND senha = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setString(1, login);
		ps.setString(2, hash);
		
		rs = ps.executeQuery();
		
		if(rs.next()){
			if(rs.getInt("idUsuario") != 0){
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setPerfil(daoPerfil.getPerfil(
						rs.getInt("idPerfil")));
				u.setNome(rs.getString("nome"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setStatus(rs.getInt("status"));
			}
		}
		
		ConexaoFactory.desconectar(con);
		
		return u;
	}
	
}
