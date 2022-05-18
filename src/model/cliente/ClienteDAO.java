package model.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class ClienteDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public Cliente getCliente(int idCliente)throws 
	SQLException {
		Cliente cliente = new Cliente();
	sql = "SELECT idCliente, "
			+ "nome, "
			+ "cpf, "
			+ "endereco, "
			+ "email, "
			+ "telefone, "
			+ "status " +
		  "FROM cliente WHERE idCliente = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idCliente);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		cliente.setIdCliente(rs.getInt("idCliente"));
		cliente.setNome(rs.getString("nome"));
		cliente.setCpf(rs.getString("cpf"));
		cliente.setEndereco(rs.getString("endereco"));
		cliente.setEmail(rs.getString("email"));
		cliente.setTelefone(rs.getString("telefone"));
		cliente.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return cliente;
}
		
	public ArrayList<Cliente> getLista() throws SQLException{
		ArrayList<Cliente> clientes = new ArrayList<>();
		sql = "SELECT idCliente,"
				+ "nome, "
				+ "cpf, "
				+ "endereco, "
				+ "email, "
				+ "telefone "
				+ "status" +
			  "FROM cliente";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(rs.getInt("idCliente"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setEmail(rs.getString("email"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setStatus(rs.getInt("status"));
			clientes.add(cliente);
			
		}
		
		ConexaoFactory.close(con);
		return clientes;
	}
	
	public boolean gravar(Cliente cliente)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(cliente.getIdCliente() == 0) {
			sql = "INSERT INTO cliente (nome, cpf, email, endereco, telefone, status) VALUES (?,?.?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getTelefone());
			ps.setInt(6, cliente.getStatus());
			
		}else {
			sql = "UPDATE cliente SET nome = ?, cpf = ? , email= ? , endereco = ? , telefone= ? " +
				   "WHERE idCliente = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getTelefone());
			ps.setInt(6, cliente.getStatus());
			ps.setInt(7, cliente.getIdCliente());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	/*
	public Cliente getCarregarPorId(int idCliente)throws 
		SQLException {
		Cliente cliente = new Cliente();
		sql = "SELECT idCliente, "
				+ "nome, "
				+ "cpf, "
				+ "email, "
				+ "endereco, "
				+ "telefone, "
				+ "status " +
			  " FROM cliente WHERE idCliente = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idCliente);
		rs = ps.executeQuery();
		if(rs.next()) {
			cliente.setIdCliente(rs.getInt("idCliente"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setEmail(rs.getString("email"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setStatus(rs.getInt("status"));
		
		}
		
		ConexaoFactory.close(con);
		
		return cliente;
	}
	
	public boolean deletar(int idCliente) throws SQLException {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idCliente);
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}
	*/
	
	public boolean desativar(Cliente cliente)throws SQLException{
		sql = "UPDATE cliente set status = 0 " +
			  "WHERE idCliente = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, cliente.getIdCliente());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}
	
	public boolean ativar(Cliente cliente)throws SQLException{
		sql = "UPDATE cliente set status = 1 " +
			  "WHERE idCliente = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, cliente.getIdCliente());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}

}
