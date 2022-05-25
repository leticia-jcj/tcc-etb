package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.cliente.ClienteDAO;
import model.orcamento.Orcamento;
import model.orcamento.OrcamentoDAO;

public class TesteOrcamentoDAO {
	private static OrcamentoDAO daoOrcamento;
	private static ClienteDAO daoCliente;
	
	private static void inicializar(){
		daoOrcamento = new OrcamentoDAO();
		daoCliente = new ClienteDAO();
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetOrcamento(int idOrcamento) throws SQLException {
		printarTitulo("testeGetOrcamento");
		
		System.out.println(daoOrcamento.getOrcamento(idOrcamento).toString());
	}
	
	private static void testeGetLista()throws SQLException{
		printarTitulo("testeGetLista");
		
		ArrayList<Orcamento> orcamentos = daoOrcamento.getLista();
		
		for(Orcamento o : orcamentos){
			System.out.println(o.toString());
		}
	}
	
	private static void testeGravar(Orcamento o) throws SQLException{
		printarTitulo("testeGravar");
		
		daoOrcamento.gravar(o);
		
		for(Orcamento orcamento : daoOrcamento.getLista()){
			System.out.println(orcamento.toString());
		}
	}
	
	private static void testeAtivar(int idOrcamento) throws SQLException{
		printarTitulo("testeAtivar");
		
		System.out.println("Status antes: " + 
				daoOrcamento.getOrcamento(idOrcamento).getStatus());
		
		daoOrcamento.ativar(idOrcamento);
		
		System.out.println("Status depois: " + 
				daoOrcamento.getOrcamento(idOrcamento).getStatus());
		
	}
	
	private static void testeDesativar(int idOrcamento) throws SQLException{
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoOrcamento.getOrcamento(idOrcamento).getStatus());
		
		daoOrcamento.desativar(idOrcamento);
		
		System.out.println("Status depois: " + 
				daoOrcamento.getOrcamento(idOrcamento).getStatus());
		
	}
	public static void main(String[] args) {
		inicializar();
		
		try {
			Orcamento o = new Orcamento();
			o.setIdOrcamento(2);
			o.setCliente(daoCliente.getCliente(1));
			o.setDataOrcamento(new Date());
			o.setStatus(1);
			o.setTotalOrcamento(100);
			
			testeGetOrcamento(1);
			testeGetLista();
			//testeGravar(o);
			testeAtivar(1);
			testeDesativar(1);
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
