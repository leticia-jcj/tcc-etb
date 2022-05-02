package model.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;

public class ProdutoDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public ArrayList<Produto> getLista() throws SQLException{
		ArrayList<Produto> produtos = new ArrayList<>();
		sql = "SELECT idProduto, idFornecedor, nome, descricao, quantidade, precoUnitario, status " +
					 "FROM produto";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Produto produto = new Produto();
			produto.setIdProduto(rs.getInt("idProduto"));
			produto.setIdFornecedor(rs.getInt("idFornecedor"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
			produto.setStatus(rs.getInt("status"));
			
			produtos.add(produto);
			
		}
		
		ConexaoFactory.close(con);
		return produtos;
	}
	
	public boolean gravar(Produto produto)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(produto.getIdProduto() == 0) {
			sql = "INSERT INTO produto (idFornecedor, nome, descricao, quantidade, precoUnitario, status ) VALUES (?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getIdFornecedor());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());			
			ps.setDouble(5, produto.getPrecoUnitario());
			ps.setInt(6, produto.getStatus());
			
		}else {
			sql = "UPDATE produto SET idFornecedor = ?, nome = ?, descricao = ?, quantidade = ?, precoUnitario = ?, status = ?" +
				   "WHERE idProduto = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getIdFornecedor());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getQuantidade());			
			ps.setDouble(5, produto.getPrecoUnitario());
			ps.setInt(6, produto.getStatus());
			ps.setInt(7, produto.getIdProduto());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public Produto getCarregarPorId(int idProduto)throws 
		SQLException {
		Produto produto = new Produto();
		sql = "SELECT idProduto, idFornecedor, nome, descricao, quantidade, precoUnitario, status " +
			  " FROM produto WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idProduto);
		rs = ps.executeQuery();
		if(rs.next()) {
			produto.setIdProduto(rs.getInt("idProduto"));
			produto.setIdFornecedor(rs.getInt("idFornecedor"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
			produto.setStatus(rs.getInt("status"));
			
		}
		
		ConexaoFactory.close(con);
		return produto;
	}
	
	public boolean deletar(int idProduto) throws SQLException {
		sql = "DELETE FROM produto WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idProduto);
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
		
	}
	
}
