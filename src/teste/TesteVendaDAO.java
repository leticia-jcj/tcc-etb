package teste;

import java.sql.SQLException;

import model.cliente.ClienteDAO;
import model.orcamento.OrcamentoDAO;
import model.perfil.Perfil;
import model.usuario.UsuarioDAO;
import model.venda.Venda;
import model.venda.VendaDAO;

public class TesteVendaDAO {
	private static VendaDAO daoVenda;
	private static ClienteDAO daoCliente;
	private static OrcamentoDAO daoOrcamento;
	private static UsuarioDAO daoUsuario;
	
	private static void inicializar(){
		daoVenda = new VendaDAO();
		daoCliente = new ClienteDAO();
		daoOrcamento = new OrcamentoDAO();
		daoUsuario = new UsuarioDAO();
		
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetVenda(Venda v) throws SQLException{
		printarTitulo("testeGetVenda");
		
		System.out.println(daoVenda.getVenda(v.getIdVenda()));
	}
	
	private static void testeGetLista() throws SQLException {
		printarTitulo("testeGetLista");
		
		for(Venda venda : daoVenda.getLista()){
			System.out.println(venda.toString());
		}
	}
	
	public static void testeGravar(Venda v) throws SQLException {
		printarTitulo("testeGravar");
		
		System.out.println("Lista antes: ");
		for(Venda venda : daoVenda.getLista()){
			System.out.println(venda.toString());
		}
		
		daoVenda.gravar(v);
		
		System.out.println("\nLista depois: ");
		for(Venda venda : daoVenda.getLista()){
			System.out.println(venda.toString());
		}
	}
	
	private static void testeAtivar(Venda v) throws SQLException {
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoVenda.getVenda(
				v.getIdVenda()).getStatus());
		
		daoVenda.ativar(v);
		
		System.out.println("Status antes: " + 
				daoVenda.getVenda(
				v.getIdVenda()).getStatus());
	}
	
	private static void testeDesativar(Venda v) throws SQLException {
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoVenda.getVenda(
				v.getIdVenda()).getStatus());
		
		daoVenda.desativar(v);
		
		System.out.println("Status antes: " + 
				daoVenda.getVenda(
				v.getIdVenda()).getStatus());
	}
	
	public static void main(String[] args) {
		inicializar();
		
		try {
			Venda v = new Venda();
			v.setIdVenda(2);
			v.setCliente(daoCliente.getCliente(1));
			v.setOrcamento(daoOrcamento.getOrcamento(1));
			v.setUsuario(daoUsuario.getUsuario(1));
			v.setStatus(1);
			v.setTotalVenda(20);
			
			testeGetVenda(v);
			testeGetLista();
			//testeGravar(v);
			testeAtivar(v);
			testeDesativar(v);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
