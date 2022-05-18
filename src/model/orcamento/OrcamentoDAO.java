package model.orcamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.orcamento.Orcamento;

public class OrcamentoDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	public Orcamento getOrcamento(int idOrcamento)throws 
	SQLException {
		Orcamento orcamento = new Orcamento();
	sql = "SELECT idOrcamento, "
			+ "dataOrcamento, "
			+ "totalOrcamento, "
			+ "totalVenda, "
			+ "status " +
		  "FROM orcamento WHERE idOrcamento = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idOrcamento);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
		orcamento.setDataOrcamento(rs.getDate("dataOrcamento"));
		orcamento.setTotalOrcamento(rs.getInt("totalOrcamento"));
		orcamento.setTotalVenda(rs.getInt("totalVenda"));
		orcamento.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return orcamento;
}
		
	public ArrayList<Orcamento> getLista() throws SQLException{
		ArrayList<Orcamento> orcamentos = new ArrayList<>();
		sql = "SELECT idOrcamento,"
				+ "dataOrcamento, "
				+ "totalOrcamento, "
				+ "totalVenda, "
				+ "status " +
			  "FROM orcamento";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Orcamento orcamento = new Orcamento();
			orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
			orcamento.setDataOrcamento(rs.getDate("dataOrcamento"));
			orcamento.setTotalOrcamento(rs.getInt("totalOrcamento"));
			orcamento.setTotalVenda(rs.getInt("totalVenda"));
			orcamento.setStatus(rs.getInt("status"));
			orcamentos.add(orcamento);
		}
		
		ConexaoFactory.close(con);
		return orcamentos;
	}
	
	public boolean gravar(Orcamento orcamento)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(orcamento.getIdOrcamento() == 0) {
			sql = "INSERT INTO orcamento (dataOrcamento, totalOrcamento, totalVenda, status) VALUES (?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(orcamento.getDataOrcamento().getTime()));
			ps.setDouble(2, orcamento.getTotalOrcamento());
			ps.setDouble(3, orcamento.getTotalVenda());
			ps.setInt(4, orcamento.getStatus());
			
		}else {
			sql = "UPDATE orcamento SET dataOrcamento = ?, totalOrcamento = ? , totalVenda = ? , status = ? " +
				   "WHERE idOrcamento = ?";
			
			ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(orcamento.getDataOrcamento().getTime()));
			ps.setDouble(2, orcamento.getTotalOrcamento());
			ps.setDouble(3, orcamento.getTotalVenda());
			ps.setInt(4, orcamento.getStatus());
			ps.setInt(5, orcamento.getIdOrcamento());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public boolean desativar(Orcamento orcamento)throws SQLException{
		sql = "UPDATE orcamento set status = 0 " +
			  "WHERE idOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, orcamento.getIdOrcamento());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}
	
	public boolean ativar(Orcamento orcamento)throws SQLException{
		sql = "UPDATE orcamento set status = 1 " +
			  "WHERE idOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, orcamento.getIdOrcamento());
		ps.executeUpdate();
		ConexaoFactory.close(con);
		
		return true;
	}

	//AQUI FALTA IMPLEMENTAR O METODO ALTERAR()
}
