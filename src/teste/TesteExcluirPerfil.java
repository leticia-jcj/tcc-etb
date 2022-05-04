package teste;

import java.sql.SQLException;

import model.perfil.Perfil;
import model.perfil.PerfilDAO;

public class TesteExcluirPerfil {

	public static void main(String[] args) {
		Perfil p = new Perfil();
		int idPerfil = 6;
		
		PerfilDAO pdao = new PerfilDAO();
		try {
			pdao.deletar(idPerfil);
			System.out.println("Perfil exclu�do com sucesso!");
		} catch (SQLException e) {
			System.out.println(
				"Falha ao excluir o perfil da base de Dados: " +
					e.getMessage());
			e.printStackTrace();
		}

	}

}
