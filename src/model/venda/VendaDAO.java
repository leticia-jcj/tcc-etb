package model.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoFactory;
import model.cliente.ClienteDAO;
import model.orcamento.OrcamentoDAO;
import model.usuario.UsuarioDAO;


public class VendaDAO {
	
	UsuarioDAO daoUsuario;
	ClienteDAO daoCliente;
	OrcamentoDAO daoOrcamento;
	Venda venda;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;

	public Venda getVenda(int idVenda)throws 
	SQLException {
		venda = new Venda();
		daoUsuario = new UsuarioDAO();
		daoCliente = new ClienteDAO();
		daoOrcamento = new OrcamentoDAO();
		
	sql = "SELECT idVenda, "
			+ "idCliente, "
			+ "idOrcamento, "
			+ "idUsuario, "
			+ "status, "
			+ "totalVenda " +
		  "FROM venda WHERE idVenda = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idVenda);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		venda.setIdVenda(rs.getInt("idVenda"));
		venda.setCliente(daoCliente.getCliente(
				rs.getInt("idCliente")));
		venda.setOrcamento(daoOrcamento.getOrcamento(
				rs.getInt("idOrcamento")));
		venda.setUsuario(daoUsuario.getUsuario(
				rs.getInt("idUsuario")));
		venda.setStatus(rs.getInt("status"));
		venda.setTotalVenda(rs.getDouble("totalVenda"));
	}
	
	ConexaoFactory.desconectar(con);
	return venda;
}
	
	public ArrayList<Venda> getLista() throws SQLException{
		ArrayList<Venda> lista = new ArrayList<>();
		sql = "SELECT idVenda, "
				+ "idCliente, "
				+ "idOrcamento, "
				+ "idUsuario, "
				+ "status, "
				+ "totalVenda " +
			  "FROM venda";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			venda = new Venda();
			
			venda.setIdVenda(rs.getInt("idVenda"));
			venda.setCliente(daoCliente.getCliente(
					rs.getInt("idCliente")));
			venda.setOrcamento(daoOrcamento.getOrcamento(
					rs.getInt("idOrcamento")));
			venda.setUsuario(daoUsuario.getUsuario(
					rs.getInt("idUsuario")));
			venda.setStatus(rs.getInt("status"));
			venda.setTotalVenda(rs.getDouble("totalVenda"));
			
			lista.add(venda);
			
		}
		
		ConexaoFactory.desconectar(con);
		return lista;
	}
	
	public boolean gravar(Venda venda)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(venda.getIdVenda() == 0) {
			sql = "INSERT INTO venda ("
					+ "idCliente, "
					+ "idOrcamento, "
					+ "idUsuario, "
					+ "status, "
					+ "totalVenda) "
				+ "VALUES (?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, venda.getCliente().getIdCliente());
			ps.setInt(2, venda.getOrcamento().getIdOrcamento());
			ps.setInt(3, venda.getUsuario().getIdUsuario());
			ps.setInt(4, venda.getStatus());
			ps.setDouble(5, venda.getTotalVenda());
			
		}else {
			sql = "UPDATE venda SET "
					+ "idCliente = ?, "
					+ "idOrcamento = ?, "
					+ "idUsuario = ?, "
					+ "status = ?, "
					+ "totalVenda = ? "
				+ "WHERE idVenda = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, venda.getCliente().getIdCliente());
			ps.setInt(2, venda.getOrcamento().getIdOrcamento());
			ps.setInt(3, venda.getUsuario().getIdUsuario());
			ps.setInt(4, venda.getStatus());
			ps.setDouble(5, venda.getTotalVenda());
			ps.setInt(6, venda.getIdVenda());
		}
		
		ps.executeUpdate();
		ConexaoFactory.desconectar(con);
		return true;
		
	}
	
	public boolean ativar(Venda venda)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE venda SET  status = ? " +
				   "WHERE idVenda = ?";
			
			con = ConexaoFactory.conectar();
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, venda.getIdVenda());
			
			ps.executeUpdate();
			ConexaoFactory.desconectar(con);
		
			return true;
		
	}
	
	public boolean desativar(Venda venda)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE venda SET  status = ? " +
				   "WHERE idVenda = ?";
			
			con = ConexaoFactory.conectar();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 0);
			ps.setInt(2, venda.getIdVenda());
			ps.executeUpdate();
			ConexaoFactory.desconectar(con);
			
			return true;
	}	
}
