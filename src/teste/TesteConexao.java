package teste;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConexaoFactory;

public class TesteConexao {

	public static void main(String[] args) {
		Connection conexao = null;
		
		try {
			conexao = ConexaoFactory.conectar();
			System.out.println("Conex�o efetuada com sucesso!");
			ConexaoFactory.desconectar(conexao);
			System.out.println("Conex�o Encerrada!");
			
		} catch (SQLException e) {
			System.out.println(
				"Falha na comunica��o com a base de dados: " +
					e.getMessage());
		}
		

	}

}
