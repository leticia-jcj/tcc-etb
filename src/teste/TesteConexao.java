package teste;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConexaoFactory;

public class TesteConexao {

	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			conexao = ConexaoFactory.conectar();
			System.out.println("Conexão efetuada com sucesso!");
			ConexaoFactory.close(conexao);
			System.out.println("Conexão Encerrada!");
		} catch (SQLException e) {
			System.out.println(
				"Falha na comunicação com a base de dados: " +
					e.getMessage());
		}
		

	}

}
