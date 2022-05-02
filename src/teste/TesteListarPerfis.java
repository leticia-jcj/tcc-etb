package teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Perfil;
import model.PerfilDAO;

public class TesteListarPerfis {

	public static void main(String[] args) {
		ArrayList<Perfil> perfis = new ArrayList();
		PerfilDAO pdao = new PerfilDAO();
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			perfis = pdao.getLista();
			for(Perfil p : perfis) {
				System.out.println(
					"\n Código do Perfil: " + p.getIdPerfil() +
					"\n Nome do Perfil: " + p.getNome() +
					"\n Data de Cadastro: " 
						+ df.format(p.getDataCadastro())
						
						);
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			
		}

	}

}
