package teste;

import java.sql.SQLException;

import model.menu.Menu;
import model.menu.MenuDAO;

public class TesteMenuDAO {
	private static MenuDAO daoMenu;
	
	private static void inicializar(){
		daoMenu = new MenuDAO();
		
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetMenu(Menu m) throws SQLException {
		printarTitulo("testeGetMenu");
		
		System.out.println(daoMenu.getMenu(m.getIdMenu()));
	}
	
	private static void testeGetLista() throws SQLException {
		printarTitulo("testeGetLista");
		
		for(Menu m : daoMenu.getLista()){
			System.out.println(m.toString());
		}
	}
	
	private static void testeGravar(Menu m) throws SQLException {
		printarTitulo("testeGravar");
		
		System.out.println("Menus antes: ");
		for(Menu menu : daoMenu.getLista()){
			System.out.println(menu.toString());
		}
		
		daoMenu.gravar(m);
		
		System.out.println("\nMenus antes: ");
		for(Menu menu : daoMenu.getLista()){
			System.out.println(menu.toString());
		}
	}
	
	private static void testeAtivar(Menu m) throws SQLException {
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoMenu.getMenu(m.getIdMenu()).getStatus());
		
		daoMenu.ativar(m);
		
		System.out.println("Status antes: " + 
				daoMenu.getMenu(m.getIdMenu()).getStatus());
	}
	
	private static void testeDesativar(Menu m) throws SQLException {
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoMenu.getMenu(m.getIdMenu()).getStatus());
		
		daoMenu.desativar(m);
		
		System.out.println("Status antes: " + 
				daoMenu.getMenu(m.getIdMenu()).getStatus());
	}
	
	public static void main(String[] args) {
		inicializar();
		
		Menu m = new Menu();
		m.setIdMenu(2);
		m.setNome("Teste");
		m.setLink("/teste.jsp");
		m.setIcone("<i class='fa-solid fa-home'></i>");
		m.setStatus(1);
		
		try {
			testeGetMenu(m);
			testeGetLista();
			//testeGravar(m);
			testeAtivar(m);
			testeDesativar(m);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
