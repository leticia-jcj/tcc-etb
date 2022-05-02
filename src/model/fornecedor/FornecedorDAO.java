package model.fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class FornecedorDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public ArrayList<Fornecedor> getLista() throws SQLException{
		ArrayList<Fornecedor> fornecedores = new ArrayList<>();
		sql = "SELECT idFornecedor, razaoSocial, nomeContato, email, telefone, cnpj, status " +
					 "FROM fornecedor";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
			fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
			fornecedor.setNomeContato(rs.getString("nomeContato"));
			fornecedor.setEmail(rs.getString("email"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setStatus(rs.getInt("status"));
			
			fornecedores.add(fornecedor);
			
		}
		
		ConexaoFactory.close(con);
		return fornecedores;
	}
	
	public boolean gravar(Fornecedor fornecedor)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(fornecedor.getIdFornecedor() == 0) {
			sql = "INSERT INTO fornecedor (razaoSocial, nomeContato, email, telefone, cnpj, status) VALUES (?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, fornecedor.getRazaoSocial());
			ps.setString(2, fornecedor.getNomeContato());
			ps.setString(3, fornecedor.getEmail());
			ps.setString(4, fornecedor.getTelefone());			
			ps.setString(5, fornecedor.getCnpj());
			ps.setInt(6, fornecedor.getStatus());
			
		}else {
			sql = "UPDATE fornecedor SET razaoSocial = ?, nomeContato = ?, email = ?, telefone = ?, cnpj = ?, status = ?" +
				   "WHERE idFornecedor = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, fornecedor.getRazaoSocial());
			ps.setString(2, fornecedor.getNomeContato());
			ps.setString(3, fornecedor.getEmail());
			ps.setString(4, fornecedor.getTelefone());			
			ps.setString(5, fornecedor.getCnpj());
			ps.setInt(6, fornecedor.getStatus());
			ps.setInt(7, fornecedor.getIdFornecedor());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public Fornecedor getCarregarPorId(int idFornecedor)throws 
		SQLException {
		Fornecedor fornecedor = new Fornecedor();
		sql = "SELECT idFornecedor, razaoSocial, nomeContato, email, telefone, cnpj, status " +
			  " FROM fornecedor WHERE idFornecedor = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idFornecedor);
		rs = ps.executeQuery();
		if(rs.next()) {
			fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
			fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
			fornecedor.setNomeContato(rs.getString("nomeContato"));
			fornecedor.setEmail(rs.getString("email"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setStatus(rs.getInt("status"));
			
		}
		
		ConexaoFactory.close(con);
		return fornecedor;
	}
	
	public boolean deletar(int idFornecedor) throws SQLException {
		sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idFornecedor);
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
		
	}
	

}
