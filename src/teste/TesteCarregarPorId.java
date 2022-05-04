package teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.perfil.Perfil;
import model.perfil.PerfilDAO;

public class TesteCarregarPorId {

	public static void main(String[] args) {
		
		int idPerfil = 1;
		
		PerfilDAO pdao = new PerfilDAO();
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Perfil  p = new Perfil();
			p = (Perfil) pdao.getCarregarPorId(idPerfil);
			
			System.out.println(
				"Código do Perfil: " + p.getIdPerfil() +
				"\nNome do Perfil: " + p.getNome() +
				"\nData de Cadastro: " + df.format(p.getDataCadastro())
					
					);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}

	}

}
