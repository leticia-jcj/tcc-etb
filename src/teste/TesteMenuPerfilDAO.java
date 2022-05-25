package teste;

import java.sql.SQLException;
import java.util.Date;

import model.fornecedor.Fornecedor;
import model.menu.Menu;
import model.menu.MenuDAO;
import model.menu_perfil.MenuPerfil;
import model.menu_perfil.MenuPerfilDAO;
import model.perfil.PerfilDAO;

public class TesteMenuPerfilDAO {

	private static MenuPerfilDAO daoMenuPerfil;
	private static PerfilDAO daoPerfil;
	private static MenuDAO daoMenu;
	
	private static void inicializar(){
		daoMenuPerfil = new MenuPerfilDAO();
		daoPerfil = new PerfilDAO();
		daoMenu = new MenuDAO();
	}
	
	private static void printarTeste(String nomeDoTeste){
		System.out.println("\nExecutando " + nomeDoTeste );
	}
	
	public static void testeGetMenuPerfil(int idMenuPerfil) throws SQLException {
		printarTeste("testeGetMenuPerfil");
		
		System.out.println(daoMenuPerfil.getMenuPerfil(
				idMenuPerfil).toString());
	}
	
	public static void testeGetListaMenu(int idPerfil) throws SQLException {
		printarTeste("testeGetListaMenu");
		
		System.out.printf("Lista de menus do perfil %s: ", idPerfil);
		System.out.println();
		for(Menu m : daoMenuPerfil.getListaMenu(idPerfil)){
			System.out.println(m.toString());
		}
	}
	
	public static void testeGetLista() throws SQLException {
		printarTeste("testeGetLista");
		
		for(MenuPerfil mp : daoMenuPerfil.getLista()){
			System.out.println(mp.toString());
		}
	}
	
	public static void testeGravar(MenuPerfil mp) throws SQLException {
		printarTeste("testeGravar");
		
		System.out.println("Lista itens antes: ");
		for(MenuPerfil menuPerfil : daoMenuPerfil.getLista()){
			System.out.println(menuPerfil.toString());
		}
		
		daoMenuPerfil.gravar(mp);
		
		System.out.println("Lista itens depois: ");
		for(MenuPerfil menuPerfil : daoMenuPerfil.getLista()){
			System.out.println(menuPerfil.toString());
		}
	}
	
	public static boolean testeAtivar(MenuPerfil mp) throws SQLException {
		printarTeste("testeAtivar");

		System.out.println("Status antes: " + daoMenuPerfil.getMenuPerfil(
				mp.getIdMenuPerfil()).getStatus());
		
		daoMenuPerfil.ativar(mp);
		
		System.out.println("Status depois: " + daoMenuPerfil.getMenuPerfil(
				mp.getIdMenuPerfil()).getStatus());
		
		return true;
	}
	
	public static boolean testeDesativar(MenuPerfil mp) throws SQLException {
		printarTeste("testeDesativar");

		System.out.println("Status antes: " + daoMenuPerfil.getMenuPerfil(
				mp.getIdMenuPerfil()).getStatus());
		
		daoMenuPerfil.desativar(mp);
		
		System.out.println("Status depois: " + daoMenuPerfil.getMenuPerfil(
				mp.getIdMenuPerfil()).getStatus());
		
		return true;
	}
	
	public static void main(String[] args) {
		inicializar();

		try {
			MenuPerfil mp = new MenuPerfil();
			mp.setIdMenuPerfil(1);
			mp.setPerfil(daoPerfil.getPerfil(1));
			mp.setMenu(daoMenu.getMenu(1));
			mp.setDataCadastro(new Date());
			mp.setStatus(1);
			
			testeGetMenuPerfil(1);
			testeGetListaMenu(1);
			testeGetLista();
			//testeGravar(mp);
			testeAtivar(mp);
			testeDesativar(mp);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
