package model.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.fornecedor.FornecedorDAO;

public class ProdutoDAO {

	Connection con;
	PreparedStatement ps;
	FornecedorDAO daoFornecedor;
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
	daoFornecedor = new FornecedorDAO();
	
	if(rs.next()) {
		produto.setIdProduto(rs.getInt("idProduto"));
		produto.setFornecedor(daoFornecedor.getFornecedor(
				rs.getInt("idFornecedor")));
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
		daoFornecedor = new FornecedorDAO();
		
		while(rs.next()) {
			Produto produto = new Produto();
			produto.setIdProduto(rs.getInt("idProduto"));
			produto.setFornecedor(daoFornecedor.getFornecedor(
					rs.getInt("idFornecedor")));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setEstoque(rs.getInt("estoque"));
			produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
			produto.setNomeFoto(rs.getString("nomeFoto"));
			produto.setCaminho(rs.getString("caminho"));
			produto.setStatus(rs.getInt("status"));
			
			produtos.add(produto);
			
		}
		
		ConexaoFactory.desconectar(con);
		return produtos;
	}
	
	public boolean gravar(Produto produto) throws SQLException {
		con = ConexaoFactory.conectar();
		
		
		if(produto.getIdProduto() == 0) {
			sql = "INSERT INTO produto (idFornecedor, nome, descricao, estoque, precoUnitario, nomeFoto, caminho, status ) VALUES (?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getFornecedor().getIdFornecedor());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setInt(4, produto.getEstoque());
			ps.setDouble(5, produto.getPrecoUnitario());
			ps.setString(6, produto.getNomeFoto());
			ps.setString(7, produto.getCaminho());
			ps.setInt(8, 1);
			
		}else {
			sql = "UPDATE produto SET idProduto = ?,idFornecedor = ?, nome = ?, descricao = ?, estoque = ?, precoUnitario = ?, nomeFoto = ?, caminho= ?, status = ?" +
				   "WHERE idProduto = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, produto.getIdProduto());
			ps.setInt(2, produto.getFornecedor().getIdFornecedor());
			ps.setString(3, produto.getNome());
			ps.setString(4, produto.getDescricao());
			ps.setInt(5, produto.getEstoque());
			ps.setDouble(6, produto.getPrecoUnitario());
			ps.setString(7, produto.getNomeFoto());
			ps.setString(8, produto.getCaminho());
			ps.setInt(9, produto.getStatus());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		return true;
		
	}
	
	public boolean desativar(Produto produto)throws SQLException{
		sql = "UPDATE produto set status = ? " +
			  "WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, produto.getIdProduto());
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean ativar(Produto produto)throws SQLException{
		sql = "UPDATE produto set status = 1 " +
			  "WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(1, produto.getIdProduto());
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean incrementar(int idProduto, int incremento) throws SQLException{
		//Pesquisar a estoque atual do produto
		//Atualizar a quantidade com o incremento
		
		Produto p = getProduto(idProduto);
		int novoEstoque = p.getEstoque() + incremento;
		
		sql = "UPDATE produto "
			+ "SET estoque = ? "
			+ "WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, novoEstoque);
		ps.setInt(2, idProduto);
		
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean decrementar(int idProduto, int decremento) throws SQLException{
		//Buscar estoque atual do produto
		//Atualizar a quantidade com decremento
		
		Produto p = getProduto(idProduto);
		int novoEstoque = p.getEstoque() - decremento;
		
		sql = "UPDATE produto "
			+ "SET estoque = ? "
			+ "WHERE idProduto = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, novoEstoque);
		ps.setInt(2, idProduto);
		
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}	
	
}
