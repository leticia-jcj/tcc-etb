package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import model.item_orcamento.ItemOrcamento;
import model.item_orcamento.ItemOrcamentoDAO;
import model.orcamento.Orcamento;
import model.produto.ProdutoDAO;

public class TesteItemOrcamentoDAO {
	private static ItemOrcamentoDAO daoItemOrcamento;
	private static ProdutoDAO daoProduto;
	
	private static void inicializar(){
		daoItemOrcamento = new ItemOrcamentoDAO();
		daoProduto = new ProdutoDAO();
		
	}
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void testeGetLista(Orcamento orcamento) throws SQLException{
		printarTitulo("testarGetLista");
		
		
		System.out.println("Para o orcamento com id = " 
				+ orcamento.getIdOrcamento()
				+ ", os itens são: ");
		
		ArrayList<ItemOrcamento> lista = daoItemOrcamento.getLista(orcamento);
		
		for(ItemOrcamento io : lista){
			System.out.println(io.toString());
		}
	}
	
	private static void testeGetTodos() throws SQLException {
		printarTitulo("testarGetTodos");
		
		ArrayList<ItemOrcamento> lista = daoItemOrcamento.getTodos();
		
		for (ItemOrcamento io : lista){
			System.out.println(io.toString());
		}
	}
	
	private static void testeGravar(ItemOrcamento io)throws SQLException{
		printarTitulo("testeGravar");
		
		System.out.println("Lista itens antes: ");
		
		for(ItemOrcamento itemOrcamento : daoItemOrcamento.getTodos()){
			System.out.println(itemOrcamento.toString());
		}
		
		daoItemOrcamento.gravar(io);
		
		System.out.println("Lista itens depois: ");
		
		for(ItemOrcamento itemOrcamento : daoItemOrcamento.getTodos()){
			System.out.println(itemOrcamento.toString());
		}
	}
	
	private static void testeAtivar(ItemOrcamento io) throws SQLException{
		printarTitulo("testeAtivar");
		
		System.out.println("Status antes: " + 
				daoItemOrcamento.getItemOrcamento(
				io.getIdItemOrcamento()).getStatus());
	
		daoItemOrcamento.ativar(io);
		
		System.out.println("Status antes: " + 
				daoItemOrcamento.getItemOrcamento(
				io.getIdItemOrcamento()).getStatus());
	
	}
	
	private static void testeDesativar(ItemOrcamento io) throws SQLException{
		printarTitulo("testeDesativar");
		
		System.out.println("Status antes: " + 
				daoItemOrcamento.getItemOrcamento(
				io.getIdItemOrcamento()).getStatus());
	
		daoItemOrcamento.desativar(io);
		
		System.out.println("Status antes: " + 
				daoItemOrcamento.getItemOrcamento(
				io.getIdItemOrcamento()).getStatus());
	
	}
	
	public static void main(String[] args) {
		inicializar();

		try{
			Orcamento o = new Orcamento();
			o.setIdOrcamento(1);
			
			ItemOrcamento io = new ItemOrcamento();
			io.setIdItemOrcamento(1);
			io.setOrcamento(o);
			io.setProduto(daoProduto.getProduto(2));
			io.setQuantidade(1);
			
			testeGetLista(o);
			testeGetTodos();
			//testeGravar(io);
			testeDesativar(io);
			testeAtivar(io);
			
		} catch (SQLException e){
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
