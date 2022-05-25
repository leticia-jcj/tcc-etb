package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import model.fornecedor.Fornecedor;
import model.fornecedor.FornecedorDAO;

public class TesteFornecedorDAO {
	private static FornecedorDAO daoFornecedor;
	private static Fornecedor f;
	
	private static void printarTeste(String nomeDoTeste){
		System.out.println("\nExecutando " + nomeDoTeste );
	}
	
	private static void inicializar(){
		daoFornecedor = new FornecedorDAO();
		f = new Fornecedor();
	}
	
	private static boolean testeGetFornecedor(int idFornecedor) throws SQLException {
		printarTeste("testeGetFornecedor");
		Fornecedor f = daoFornecedor.getFornecedor(idFornecedor);
			
		System.out.println(f.toString());
		
		return true;
	}
	
	public static boolean testeGetLista() throws SQLException {
		printarTeste("testeGetLista");
		ArrayList<Fornecedor> lista = daoFornecedor.getLista();
			
		for (Fornecedor f : lista){
			System.out.println(f.toString());
		}

		return true;
	}
	
	public static boolean testeGravar(Fornecedor fornecedor) throws SQLException {
		printarTeste("testeGravar");

		if(fornecedor.getIdFornecedor() > 0){
			System.out.println(daoFornecedor.getFornecedor(fornecedor.getIdFornecedor()));
		}
		
		daoFornecedor.gravar(fornecedor);
		System.out.println("Fornecedor salvo com sucesso!");

		if(fornecedor.getIdFornecedor() > 0){
			System.out.println(daoFornecedor.getFornecedor(fornecedor.getIdFornecedor()));
		}
		
		return true;
	}

	
	public static boolean testeAtivar(int idFornecedor) throws SQLException {
		printarTeste("testeAtivar");
		
		Fornecedor f = new Fornecedor();
		f.setIdFornecedor(idFornecedor);
		
		daoFornecedor.ativar(f);
		
		if(daoFornecedor.getFornecedor(idFornecedor).getStatus() == 1){
			System.out.println("Usuário ativado com sucesso!");
		}
		
		return true;
	}
	
	public static boolean testeDesativar(int idFornecedor) throws SQLException {
		printarTeste("testeDesativar");
		
		Fornecedor f = new Fornecedor();
		f.setIdFornecedor(idFornecedor);
		
		daoFornecedor.desativar(f);
		
		if(!(daoFornecedor.getFornecedor(1).getStatus() == 0)){
			System.out.println("Falha ao ativar usuário.");
			return false;
		}
		
		System.out.println("Usuário desativado com sucesso!");
	
		return true;
	}
	
	public static void main(String[] args) {
		inicializar();
		
		f.setRazaoSocial("Novo teste");
		f.setNomeContato("TesteGravar NomeContato");
		f.setEmail("TesteGravar@email.com");
		f.setTelefone("99999999999");
		f.setCnpj("12345612345");
		f.setStatus(1);
		
		try{
			testeGetFornecedor(1);
			testeGetLista();
			testeGravar(f);
			testeAtivar(1);
			testeDesativar(1);
			
		} catch (SQLException e){
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
