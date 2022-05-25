package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import model.cliente.Cliente;
import model.cliente.ClienteDAO;

public class TesteClienteDAO {
	private static ClienteDAO daoCliente;
	
	private static void inicializar(){
		daoCliente = new ClienteDAO();
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetCliente(int idCliente) throws SQLException{
		printarTitulo("testeGetCliente");
		
		Cliente c = daoCliente.getCliente(idCliente);
		
		System.out.println(c.toString());
	}
	
	private static void testeGetLista() throws SQLException{
		printarTitulo("testeGetLista");
		
		ArrayList<Cliente> lista = daoCliente.getLista();
		
		for(Cliente c : lista){
			System.out.println(c.toString());
		}
	}
	
	private static void testeGravar(Cliente c) throws SQLException{
		printarTitulo("testeGravar");
		
		if(c.getIdCliente() > 0){
			System.out.println(daoCliente.getCliente(
					c.getIdCliente()).toString());
		}
		
		daoCliente.gravar(c);
		
		if(c.getIdCliente() > 0){
			System.out.println(daoCliente.getCliente(
					c.getIdCliente()).toString());
		}
		
	}
	
	private static void testeAtivar(int idCliente) throws SQLException{
		printarTitulo("testeAtivar");
		
		System.out.println("Status antes: " 
				+ daoCliente.getCliente(idCliente).getStatus());
		
		Cliente c = new Cliente();
		c.setIdCliente(idCliente);
		
		daoCliente.ativar(c);
		
		System.out.println("Status depois: " 
				+ daoCliente.getCliente(idCliente).getStatus());
		
	}
	
	private static void testeDesativar(int idCliente) throws SQLException{
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " 
				+ daoCliente.getCliente(idCliente).getStatus());
		
		Cliente c = new Cliente();
		c.setIdCliente(idCliente);
		
		daoCliente.desativar(c);
		
		System.out.println("Status depois: " 
				+ daoCliente.getCliente(idCliente).getStatus());
		
	}
	
	public static void main(String[] args) {
		inicializar();
		
		Cliente c = new Cliente();
		
		c.setNome("Cliente de Teste");
		c.setCpf("12345678949");
		c.setEndereco("Endereço de teste");
		c.setEmail("email@email.com");
		c.setTelefone("61999999999");
		
		try {
			testeGetCliente(1);
			testeGetLista();
			testeGravar(c);
			testeAtivar(5);
			testeDesativar(5);
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
