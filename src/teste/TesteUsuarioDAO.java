package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import model.perfil.PerfilDAO;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

public class TesteUsuarioDAO {

	private static UsuarioDAO daoUsuario;
	private static PerfilDAO daoPerfil;
	
	private static void inicializar(){
		daoUsuario = new UsuarioDAO();
		daoPerfil = new PerfilDAO();
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetUsuario() throws SQLException {
		printarTitulo("testeGetUsuario");
		
		Usuario u = daoUsuario.getUsuario(1);
		
		System.out.println(u.toString());
	}
	
	private static void testeGetLista() throws SQLException {
		printarTitulo("testeGetLista");
		
		ArrayList<Usuario> lista = daoUsuario.getLista();
		
		System.out.println("Lista de Usuarios: ");
		for(Usuario u : lista){
			System.out.println(u.toString());
		}
	}
	
	private static void testeGravar(Usuario u) throws SQLException {
		printarTitulo("testeGravar");
		
		System.out.println("Lista antes: ");
		for(Usuario usuario : daoUsuario.getLista()){
			System.out.println(usuario.toString());
		}
		
		daoUsuario.gravar(u);
		
		System.out.println("Lista depois: ");
		for(Usuario usuario : daoUsuario.getLista()){
			System.out.println(usuario.toString());
		}
	}
	
	private static void testeAtivar(Usuario u) throws SQLException {
		printarTitulo("testeAtivar");
		
		System.out.println("Status antes: " + 
				daoUsuario.getUsuario(
				u.getIdUsuario()).getStatus());
		
		daoUsuario.ativar(u);
		
		System.out.println("Status depois: " + 
				daoUsuario.getUsuario(
				u.getIdUsuario()).getStatus());
	}
	
	private static void testeDesativar(Usuario u) throws SQLException {
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoUsuario.getUsuario(
				u.getIdUsuario()).getStatus());
		
		daoUsuario.desativar(u);
		
		System.out.println("Status depois: " + 
				daoUsuario.getUsuario(
				u.getIdUsuario()).getStatus());
	}
	
	public static void main(String[] args) {
		inicializar();
		
		try {
			Usuario u = new Usuario();
			u.setIdUsuario(2);
			u.setNome("Usuario Teste");
			u.setPerfil(daoPerfil.getPerfil(1));
			u.setLogin("loginteste");
			u.setSenha("1234");
			u.setStatus(1);
			
			testeGetUsuario();
			testeGetLista();
			//testeGravar(u);
			testeAtivar(u);
			testeDesativar(u);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
