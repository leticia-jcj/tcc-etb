package model.orcamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.cliente.ClienteDAO;

public class OrcamentoDAO {

	Connection con;
	PreparedStatement ps;
	ClienteDAO daoCliente;
	ResultSet rs;
	String sql;
	
	public Orcamento getOrcamento(int idOrcamento) throws 
	SQLException {
		daoCliente = new ClienteDAO();
		
		Orcamento orcamento = new Orcamento();
	sql = "SELECT idOrcamento, "
			+ "idCliente, "
			+ "dataOrcamento, "
			+ "status, "
			+ "totalOrcamento " + 
		  "FROM orcamento WHERE idOrcamento = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idOrcamento);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
		orcamento.setCliente(daoCliente.getCliente(rs.getInt("idCliente")));
		orcamento.setDataOrcamento(rs.getDate("dataOrcamento"));
		orcamento.setTotalOrcamento(rs.getInt("totalOrcamento"));
		orcamento.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return orcamento;
}
		
	public ArrayList<Orcamento> getLista() throws SQLException{
		ArrayList<Orcamento> orcamentos = new ArrayList<>();
		sql = "SELECT idOrcamento, "
				+ "idCliente, "
				+ "dataOrcamento, "
				+ "status, "
				+ "totalOrcamento "
			+ "FROM orcamento";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Orcamento orcamento = new Orcamento();
			
			orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
			orcamento.setCliente(daoCliente.getCliente(rs.getInt("idCliente")));
			orcamento.setDataOrcamento(rs.getDate("dataOrcamento"));
			orcamento.setTotalOrcamento(rs.getInt("totalOrcamento"));
			orcamento.setStatus(rs.getInt("status"));
			
			orcamentos.add(orcamento);
		}
		
		ConexaoFactory.desconectar(con);
		return orcamentos;
	}
	
	public boolean gravar(Orcamento orcamento)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(orcamento.getIdOrcamento() == 0) {
			sql = "INSERT INTO orcamento ("
					+ "idCliente, "
					+ "dataOrcamento,"
					+ "status, "
					+ "totalOrcamento "
				+ ") VALUES (?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, orcamento.getCliente().getIdCliente());
			ps.setDate(2, new Date(orcamento.getDataOrcamento().getTime()));
			ps.setInt(3, orcamento.getStatus());
			ps.setDouble(4, orcamento.getTotalOrcamento());
			
		}else {
			sql = "UPDATE orcamento SET "
					+ "idCliente = ?, "
					+ "dataOrcamento = ?, "
					+ "status = ?, "
					+ "totalOrcamento = ? " +
				   "WHERE idOrcamento = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, orcamento.getCliente().getIdCliente());
			ps.setDate(2, new Date(orcamento.getDataOrcamento().getTime()));
			ps.setInt(3, orcamento.getStatus());
			ps.setDouble(4, orcamento.getTotalOrcamento());
			ps.setInt(5, orcamento.getIdOrcamento());
					
		}
		
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		return true;
		
	}
	
	public boolean desativar(int idOrcamento)throws SQLException{
		sql = "UPDATE orcamento set status = ? " +
			  "WHERE idOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 0);
		ps.setInt(2, idOrcamento);
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}
	
	public boolean ativar(int idOrcamento)throws SQLException{
		sql = "UPDATE orcamento set status = ? " +
			  "WHERE idOrcamento = ?";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setInt(2, idOrcamento);
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		
		return true;
	}

}
