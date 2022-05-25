package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.perfil.Perfil;
import model.perfil.PerfilDAO;

public class TestePerfilDAO {
	private static PerfilDAO daoPerfil;
	
	private static void inicializar(){
		daoPerfil = new PerfilDAO();
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetPerfil(int idPerfil) throws SQLException{
		printarTitulo("testeGetPerfil");
		
		System.out.println(daoPerfil.getPerfil(idPerfil).toString());
		
	}
	
	private static void testeGetLista()throws SQLException{
		printarTitulo("testeGetLista");
		
		ArrayList<Perfil> lista = daoPerfil.getLista();
		
		for(Perfil p : lista){
			System.out.println(p.toString());
		}
	}
	
	public static void testeGravar(Perfil perfil) throws SQLException{
		printarTitulo("testeGravar");
		
		System.out.println("Lista antes: ");
		for(Perfil p : daoPerfil.getLista()){
			System.out.println(p.toString());
		}
		
		daoPerfil.gravar(perfil);
		
		System.out.println("Lista depois: ");
		for(Perfil p : daoPerfil.getLista()){
			System.out.println(p.toString());
		}
	}
	
	private static void testeAtivar(Perfil p) throws SQLException {
		printarTitulo("testeAtivar");
		
		System.out.println("Status antes: " + 
				daoPerfil.getPerfil(
				p.getIdPerfil()).getStatus());
		
		daoPerfil.ativar(p);
		
		System.out.println("Status antes: " + 
				daoPerfil.getPerfil(
				p.getIdPerfil()).getStatus());
	}
	
	private static void testeDesativar(Perfil p) throws SQLException {
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoPerfil.getPerfil(
				p.getIdPerfil()).getStatus());
		
		daoPerfil.desativar(p);
		
		System.out.println("Status antes: " + 
				daoPerfil.getPerfil(
				p.getIdPerfil()).getStatus());
	}
	
	public static void main(String[] args) {
		inicializar();
		
		Perfil p = new Perfil();
		p.setIdPerfil(2);
		p.setNome("Alteração");
		p.setDataCadastro(new Date());
		p.setStatus(1);
		
		try {
			testeGetPerfil(1);
			testeGetLista();
			//testeGravar(p);
			testeAtivar(p);
			testeDesativar(p);
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
