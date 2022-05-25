package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import model.fornecedor.FornecedorDAO;
import model.produto.Produto;
import model.produto.ProdutoDAO;

public class TesteProdutoDAO {
	private static FornecedorDAO daoFornecedor;
	private static ProdutoDAO daoProduto;
	
	private static void printarTitulo(String metodo){
		System.out.println("\nExecutando teste: " + metodo);
	}
	
	private static void inicializar(){
		daoFornecedor = new FornecedorDAO();
		daoProduto = new ProdutoDAO();
	}
	
	private static void testeGetProduto() throws SQLException{
		printarTitulo("testeGetProduto");
		
		Produto p = daoProduto.getProduto(1);
		
		System.out.println(p.toString());
	}
	
	private static void testeGetLista() throws SQLException{
		printarTitulo("testeGetLista");
		
		ArrayList<Produto> lista = daoProduto.getLista();
		
		for(Produto p : lista){
			System.out.println(p.toString());
		}
	}
	
	private static void testeGravar() throws SQLException{
		printarTitulo("testeGravar");
		
		Produto p = new Produto();
		
		p.setFornecedor(daoFornecedor.getFornecedor(1));
		p.setNome("Teste de Gravação");
		p.setDescricao("Descrição teste");
		p.setEstoque(10);
		p.setPrecoUnitario(15);
		
		daoProduto.gravar(p);
		
		ArrayList<Produto> lista = daoProduto.getLista();
		
		for (Produto produto : lista){
			System.out.println(produto.toString());
		}
	}
	
	private static void testeAtivar(int idProduto) throws SQLException{
		printarTitulo("testeAtivar");
		
		Produto p = new Produto();
		p.setIdProduto(idProduto);
		
		daoProduto.ativar(p);
		
		int status = daoProduto.getProduto(idProduto).getStatus();
		
		System.out.printf("Produto(idProduto=%s, status=%s)", idProduto, status);
		System.out.println();
		
	}
	
	private static void testeDesativar(int idProduto) throws SQLException{
		printarTitulo("testeDesativar");
		
		Produto p = new Produto();
		p.setIdProduto(idProduto);
		
		daoProduto.desativar(p);
		
		int status = daoProduto.getProduto(idProduto).getStatus();
		
		System.out.printf("Produto(idProduto=%s, status=%s)", idProduto, status);
		System.out.println();
	}
	
	private static void testeIncrementar(int idProduto, int incremento) throws SQLException{
		printarTitulo("testeIncrementar");
		
		System.out.println("Estoque antes: " + 
				daoProduto.getProduto(idProduto).getEstoque());
		
		daoProduto.incrementar(idProduto, incremento);
		
		System.out.println("Estoque depois: " + 
				daoProduto.getProduto(idProduto).getEstoque());
		
	}
	
	private static void testeDecrementar(int idProduto, int decremento) throws SQLException{
		printarTitulo("testeDecrementar");
		
		System.out.println("Estoque antes: " + 
				daoProduto.getProduto(idProduto).getEstoque());
		
		daoProduto.decrementar(idProduto, decremento);
		
		System.out.println("Estoque depois: " + 
				daoProduto.getProduto(idProduto).getEstoque());
		
	}
	
	public static void main(String[] args) {
		inicializar();
		
		try{
			testeGetProduto();
			testeGetLista();
			//testeGravar();
			testeDesativar(3);
			testeAtivar(3);
			testeIncrementar(3, 10);
			testeDecrementar(3, 10);
			
			
		} catch (SQLException e){
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
