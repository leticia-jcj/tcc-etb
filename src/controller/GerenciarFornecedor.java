package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.fornecedor.*;

public class GerenciarFornecedor extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	 public GerenciarFornecedor() {
	        super();
	        
	    }

	    protected void doGet(HttpServletRequest request, 
	    		HttpServletResponse response) 
	    		throws ServletException, IOException {
	    		PrintWriter out = response.getWriter();
	    		String acao = request.getParameter("acao");
	    		String idFornecedor = request.getParameter("idFornecedor");
	    		String mensagem = "";
	    		
	    		Fornecedor fornecedor = new Fornecedor();
	    		FornecedorDAO fornecedordao = new FornecedorDAO();
	    		
	    			try {
	    			
	    				if(acao.equals("deletar")) {
	    					fornecedor.setIdFornecedor(Integer.parseInt(idFornecedor));
	    						if(fornecedordao.deletar(fornecedor.getIdFornecedor())) {
	    							mensagem = 
	    									"Fornecedor excluído da base de dados!";
	    					
	    						}else {
	    							mensagem = 
	    						"Falha ao excluir o fornecedor da base de dados!";
	    						}
	    				
	    				}
	    				if(acao.equals("alterar")){
	    					fornecedor = fornecedordao.getCarregarPorId(
	    							Integer.parseInt(idFornecedor));
	    					if(fornecedor.getIdFornecedor() > 0) {
	    						RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().
								getRequestDispatcher("/cadastrarFornecedor.jsp");
	    						request.setAttribute("fornecedor", fornecedor);
	    						dispatcher.forward(request, response);
	    						
	    					}else {
	    						mensagem = "Fornecedor não encontrado na base de dados!";
	    					}
	    				}
	    					
	    				
	    			} catch (SQLException e){
	    				mensagem = "Erro: " + e.getMessage();
	    				out.println(mensagem);
	    				e.printStackTrace();
	    			}
	    			
	    		out.println(
	    				"<script type='text/javascript'>" +
	    				"alert('" + mensagem + "');" +
	    				"location.href='listarFornecedor.jsp';" +
	    				"</script>");
	    }
	   
	    	
	  	
	    	protected void doPost(HttpServletRequest request, 
	    		HttpServletResponse response) 
	    		throws ServletException, IOException {
	    		response.setContentType("text/html; charset=UTF-8");
	    		PrintWriter out = response.getWriter();
	    		String idFornecedor = request.getParameter("idFornecedor");
	    		String razaoSocial = request.getParameter("razaoSocial");
	    		String nomeContato = request.getParameter("nomeContato");
	    		String email = request.getParameter("email");
	    		String cnpj = request.getParameter("cnpj");
	    		String status = request.getParameter("status");
	    		String telefone = request.getParameter("telefone");
	    		String mensagem = "";
	    		Fornecedor fornecedor  = new Fornecedor();
	    	FornecedorDAO fornecedordao = new FornecedorDAO();
	    		
	    		try {
	    			
	    			if(!idFornecedor.isEmpty()) {
	    				fornecedor.setIdFornecedor(Integer.parseInt(idFornecedor));
	    				
	    			}
	    			
	    			fornecedor.setIdFornecedor(Integer.parseInt(idFornecedor));
    				fornecedor.setRazaoSocial(razaoSocial);
    				fornecedor.setNomeContato(nomeContato);
    				fornecedor.setEmail(email);
    				fornecedor.setTelefone(telefone);
    				fornecedor.setCnpj(cnpj);
    				fornecedor.setStatus(Integer.parseInt(status));
	    			
	    			if(fornecedor.estaInvalido()) {
	    				mensagem = "Campos obrigatórios não informados";
	    				
	    			}else {
	    				
	    				if(fornecedordao.gravar(fornecedor)) {
	    					mensagem = 
	    						"Fornecedor gravado com sucesso na base de dados!";
	    				}else {
	    					mensagem =
	    						"Falha ao gravar o fornecedor na base de dados!";
	    					
	    				}
	    			}
	    		}
	    		catch (SQLException e) {
	    			mensagem = "Erro: " + e.getMessage();
	    			out.println(mensagem);
	    		}
	    		
	    		out.println(
	    			"<script type='text/javascript'>" +
	    			"alert('" + mensagem + "');" +
	    			"location.href='listarFornecedor.jsp';" +
	    			"</script>"
	    			
	    				);
	    		
	    	
	    	}
	    	

}
