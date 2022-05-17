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
	
	public Produto getProduto(int idProduto)throws 
	SQLException {
	Produto produto = new Produto();
	sql = "SELECT idProduto, idFornecedor, nome, descricao, estoque, precoUnitario, nomeFoto, caminho, status " +
		  "FROM produto WHERE idProduto = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idProduto);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		produto.setIdProduto(rs.getInt("idProduto"));
		produto.setIdProduto(rs.getInt("idFornecedor"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setEstoque(rs.getInt("estoque"));
		produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
		produto.setNomeFoto(rs.getString("nomeFoto"));
		produto.setCaminho(rs.getString("caminho"));
		produto.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return produto;
}
	
	
	public ArrayList<Produto> getLista() throws SQLException{
		ArrayList<Produto> produtos = new ArrayList<>();
		sql = "SELECT idProduto, idFornecedor, nome, descricao, estoque, precoUnitario, nomeFoto, caminho, status " +
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
			produto.setEstoque(rs.getInt("estoque"));
			produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
			produto.setNomeFoto(rs.getString("nomeFoto"));
			produto.setCaminho(rs.getString("caminho"));
			produto.setStatus(rs.getInt("status"));
			
			produtos.add(produto);
			
		}
		
		ConexaoFactory.close(con);
		return produtos;
	}
	
	public boolean gravar(Produto produto) throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(produto.getIdProduto() == 0) {
			sql = "INSERT INTO produto (idFornecedor, nome, descricao, estoque, precoUnitario, nomeFoto, caminho, status ) VALUES (?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getIdFornecedor());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getEstoque());
			ps.setDouble(5, produto.getPrecoUnitario());
			ps.setString(6, produto.getNomeFoto());
			ps.setString(7, produto.getCaminho());
			ps.setInt(8, produto.getStatus());
			
		}else {
			sql = "UPDATE produto SET idProduto = ?,idFornecedor = ?, nome = ?, descricao = ?, estoque = ?, precoUnitario = ?, nomeFoto = ?, caminho= ?, status = ?" +
				   "WHERE idProduto = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getIdProduto());
			ps.setInt(2, produto.getIdFornecedor());
			ps.setString(3, produto.getNome());
			ps.setString(4, produto.getDescricao());
			ps.setInt(5, produto.getEstoque());
			ps.setDouble(6, produto.getPrecoUnitario());
			ps.setString(7, produto.getNomeFoto());
			ps.setString(8, produto.getCaminho());
			ps.setInt(9, produto.getStatus());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public Produto getCarregarPorId(int idProduto) throws 
		SQLException {
		Produto produto = new Produto();
		sql = "SELECT idProduto, idFornecedor, nome, descricao, estoque, precoUnitario,nomeFoto = ?, caminho= ?, status " +
			  "FROM produto WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idProduto);
		rs = ps.executeQuery();
		if(rs.next()) {
			produto.setIdProduto(rs.getInt("idProduto"));
			produto.setIdFornecedor(rs.getInt("idFornecedor"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setEstoque(rs.getInt("estoque"));
			produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
			produto.setNomeFoto(rs.getString("nomeFoto"));
			produto.setCaminho(rs.getString("caminho"));
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
	
// AQUI falta implementar os metodos incrementar e decrementar	
	
}
