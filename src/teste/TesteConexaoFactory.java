package teste;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConexaoFactory;

public class TesteConexaoFactory {
	public static void main(String[] args) {
		try {
			Connection con = ConexaoFactory.conectar();

			System.out.println("Conexão Estabelecida com sucesso!");

			ConexaoFactory.desconectar(con);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao se conectar ao banco de dados: "
					+ e.getMessage());
		}
		
		
	}
	
	
}
