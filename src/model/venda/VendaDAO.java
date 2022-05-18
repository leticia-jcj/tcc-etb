package model.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory.ConexaoFactory;


public class VendaDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;

	public Venda getVenda(int idVenda)throws 
	SQLException {
		Venda venda = new Venda();
	sql = "SELECT idVenda, "
			+ "totalVenda, "
			+ "status " +
		  "FROM venda WHERE idVenda = ?";
	
	con = ConexaoFactory.conectar();
	ps = con.prepareStatement(sql);
	ps.setInt(1, idVenda);
	rs = ps.executeQuery();
	
	if(rs.next()) {
		venda.setIdVenda(rs.getInt("idVenda"));
		venda.setTotalVenda(rs.getDouble("totalVenda"));
		venda.setStatus(rs.getInt("status"));
	}
	
	ConexaoFactory.desconectar(con);
	return venda;
}
	
	public ArrayList<Venda> getLista() throws SQLException{
		ArrayList<Venda> venda = new ArrayList<>();
		sql = "SELECT idVenda, "
				+ "totalVenda, "
				+ "status " +
			  "FROM venda";
		
		con = ConexaoFactory.conectar();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			Venda v = new Venda();
			v.setIdVenda(rs.getInt("idVenda"));
			v.setTotalVenda(rs.getInt("totalVenda"));
			v.setStatus(rs.getInt("status"));
			
			venda.add(v);
			
		}
		
		ConexaoFactory.close(con);
		return venda;
	}
	
	public boolean gravar(Venda venda)throws SQLException {
		con = ConexaoFactory.conectar();
		
		if(venda.getIdVenda() == 0) {
			sql = "INSERT INTO venda (totalVenda, status ) VALUES (?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setDouble(1, venda.getTotalVenda());
			ps.setInt(2, venda.getStatus());
			
		}else {
			sql = "UPDATE venda SET totalVenda = ?, status = ? " +
				   "WHERE idVenda = ?";
			
			ps = con.prepareStatement(sql);
			ps.setDouble(1, venda.getTotalVenda());
			ps.setInt(2, venda.getStatus());
			ps.setInt(3, venda.getIdVenda());
		}
		
		ps.executeUpdate();
		ConexaoFactory.close(con);
		return true;
		
	}
	
	public boolean ativar(Venda venda)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE venda SET  status = 1 " +
				   "WHERE idVenda = ?";
			
			con = ConexaoFactory.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, venda.getIdVenda());
			ps.executeUpdate();
			ConexaoFactory.close(con);
		
			return true;
		
	}
	
	public boolean desativar(Venda venda)throws SQLException {
		con = ConexaoFactory.conectar();
		
		
			sql = "UPDATE venda SET  status = 0 " +
				   "WHERE idVenda = ?";
			
			con = ConexaoFactory.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, venda.getIdVenda());
			ps.executeUpdate();
			ConexaoFactory.close(con);
			
			return true;
	}	
}
