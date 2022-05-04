package teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.perfil.Perfil;
import model.perfil.PerfilDAO;

public class TesteGravarPerfil {

	public static void main(String[] args) {
		Perfil p = new Perfil();
		
		/* como fazer os testes
		 * atribua 0 para a propriedade idPerfil para salvar
		 * atribua outro valor diferente de zero para a
		 * propriedade idPerfil para gravar.
		 * 
		 */
		p.setIdPerfil(0);
		PerfilDAO pdao = new PerfilDAO();
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			if (p.getIdPerfil() == 0) {
				p.setNome("Colaborador");
				p.setDataCadastro(df.parse("20-03-2022"));
				pdao.gravar(p);
				System.out.println("Menu salvo com sucesso!");

			} else {
				p.setNome("Professor");
				p.setDataCadastro(df.parse("20-03-2022"));
				p.setIdPerfil(5);
				pdao.gravar(p);
				System.out.println("Menu atualizado com sucesso!");
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();

		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			ex.printStackTrace();
	

		}

	}

}
