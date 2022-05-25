package model.item_orcamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.orcamento.Orcamento;
import model.orcamento.OrcamentoDAO;
import model.produto.ProdutoDAO;

public class ItemOrcamentoDAO {
	Connection con;
	PreparedStatement ps;
	OrcamentoDAO daoOrcamento;
	ProdutoDAO daoProduto;
	ResultSet rs;
	String sql;
	
	public ItemOrcamento getItemOrcamento(int idItemOrcamento) throws SQLException{
		ItemOrcamento io = new ItemOrcamento();
		
		sql = "SELECT "
				+ "idItemOrcamento, "
				+ "idOrcamento, "
				+ "idProduto, "
				+ "quantidade,"
				+ "status "
			+ "FROM item_orcamento "
			+ "WHERE idItemOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, idItemOrcamento);
		
		rs = ps.executeQuery();
		
		if(rs.next()){
			io.setIdItemOrcamento(rs.getInt("idOrcamento"));
			io.setOrcamento(daoOrcamento.getOrcamento(
					rs.getInt("idOrcamento")));
			io.setProduto(daoProduto.getProduto(
					rs.getInt("idProduto")));
			io.setQuantidade(rs.getInt("quantidade"));
			io.setStatus(rs.getInt("status"));
			
		}
		ConexaoFactory.desconectar(con);
		
		return io;
	}
	
	public ArrayList<ItemOrcamento> getLista(Orcamento o) throws SQLException{
		ArrayList<ItemOrcamento> itensOrcamento = new ArrayList<>();
		daoOrcamento = new OrcamentoDAO();
		daoProduto = new ProdutoDAO();
		
		
		sql = "SELECT "
				+ "idItemOrcamento, "
				+ "idOrcamento, "
				+ "idProduto, "
				+ "quantidade,"
				+ "status "
			+ "FROM item_orcamento "
			+ "WHERE idOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, o.getIdOrcamento());
		
		rs = ps.executeQuery();
		
		while(rs.next()){
			ItemOrcamento io = new ItemOrcamento();
			
			io.setIdItemOrcamento(rs.getInt("idItemOrcamento"));
			io.setOrcamento(daoOrcamento.getOrcamento(
					rs.getInt("idOrcamento")));
			io.setProduto(daoProduto.getProduto(
					rs.getInt("idProduto")));
			io.setQuantidade(rs.getInt("quantidade"));
			io.setStatus(rs.getInt("status"));
			
			itensOrcamento.add(io);
			
		}
		
		ConexaoFactory.desconectar(con);
		
		return itensOrcamento;
	}

	public ArrayList<ItemOrcamento> getTodos() throws SQLException {
		ArrayList<ItemOrcamento> itensOrcamentos = new ArrayList<>();
		
		sql = "SELECT "
				+ "idItemOrcamento, "
				+ "idOrcamento, "
				+ "idProduto, "
				+ "quantidade, "
				+ "status "
			+ "FROM item_orcamento";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()){
			ItemOrcamento io = new ItemOrcamento();
			
			io.setIdItemOrcamento(rs.getInt("idItemOrcamento"));
			io.setOrcamento(daoOrcamento.getOrcamento(
					rs.getInt("idOrcamento")));
			io.setProduto(daoProduto.getProduto(
					rs.getInt("idProduto")));
			io.setQuantidade(rs.getInt("quantidade"));
			io.setStatus(rs.getInt("status"));
			
			itensOrcamentos.add(io);
			
		}
		
		ConexaoFactory.desconectar(con);
		
		return itensOrcamentos;
	}

	public boolean gravar(ItemOrcamento itemOrcamento) throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(itemOrcamento.getIdItemOrcamento() > 0){
			sql = "UPDATE item_orcamento SET "
					+ "idOrcamento = ?, "
					+ "idProduto = ?, "
					+ "quantidade = ?,"
					+ "status = ? "
				+ "WHERE idItemOrcamento = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, itemOrcamento.getOrcamento().getIdOrcamento());
			ps.setInt(2, itemOrcamento.getProduto().getIdProduto());
			ps.setInt(3, itemOrcamento.getQuantidade());
			ps.setInt(4, itemOrcamento.getIdItemOrcamento());
			ps.setInt(5, itemOrcamento.getStatus());
		} else {
			sql = "INSERT INTO item_orcamento ("
					+ "idOrcamento, "
					+ "idProduto, "
					+ "quantidade,"
					+ "status  "
				+ ") values (?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, itemOrcamento.getOrcamento().getIdOrcamento());
			ps.setInt(2, itemOrcamento.getProduto().getIdProduto());
			ps.setInt(3, itemOrcamento.getQuantidade());
			ps.setInt(4, 1); 
		}
		
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}

	public boolean ativar(ItemOrcamento itemOrcamento) throws SQLException{
		sql = "UPDATE item_orcamento SET "
				+ "status = ? "
			+ "WHERE idItemOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, itemOrcamento.getIdItemOrcamento());
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean desativar(ItemOrcamento itemOrcamento) throws SQLException{
		sql = "UPDATE item_orcamento SET "
				+ "status = ? "
			+ "WHERE idItemOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, itemOrcamento.getIdItemOrcamento());
		ps.executeUpdate();
		
		ConexaoFactory.desconectar(con);
		
		return true;
	}
}
