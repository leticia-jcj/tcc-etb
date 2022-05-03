package controller;

import model.Cliente;
import model.ClienteDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gerenciarCliente")
public class GerenciarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GerenciarCliente() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    		PrintWriter out = response.getWriter();
    		String acao = request.getParameter("acao");
    		String idCliente = request.getParameter("idCliente");
    		String mensagem = "";
    		
    		Cliente cliente = new Cliente();
    		ClienteDAO clientedao = new ClienteDAO();
    		
    			try {
    			
    				if(acao.equals("deletar")) {
    					cliente.setIdCliente(Integer.parseInt(idCliente));
    						if(clientedao.deletar(cliente.getIdCliente())) {
    							mensagem = "Cliente excluído da base de dados!";
    					
    						}else {
    							mensagem = "Falha ao excluir o cliente da base de dados!";
    						}
    				
    				}
    				if(acao.equals("alterar")){
    					cliente = clientedao.getCarregarPorId(
    							Integer.parseInt(idCliente));
    					if(cliente.getIdCliente() > 0) {
    						RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().
							getRequestDispatcher("/cadastrarCliente.jsp");
    						request.setAttribute("cliente", cliente);
    						dispatcher.forward(request, response);
    						
    					}else {
    						mensagem = "Cliente não encontrado na base de dados!";
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
    				"location.href='listarCliente.jsp';" +
    				"</script>");
    }
   
    	
  	
    	protected void doPost(HttpServletRequest request, 
    		HttpServletResponse response) 
    		throws ServletException, IOException {
    		response.setContentType("text/html; charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		String idCliente = request.getParameter("idCliente");
    		String nome = request.getParameter("nome");
    		String cpf = request.getParameter("cpf");
    		String endereco = request.getParameter("endereco");
    		String email = request.getParameter("email");
    		String telefone = request.getParameter("telefone");
    		String status = request.getParameter("status");
    		
    		String mensagem = "";
    		Cliente cliente  = new Cliente();
    		ClienteDAO clientedao = new ClienteDAO();
    		
    		try {
    			
    			if(!idCliente.isEmpty()) {
    				cliente.setIdCliente(Integer.parseInt(idCliente));
    			}
    			
    			cliente.setIdCliente(Integer.parseInt(idCliente));
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setEndereco(endereco);
				cliente.setEmail(email);
				cliente.setTelefone(telefone);
				cliente.setStatus(Integer.parseInt(status));
    			
    			if(cliente.estaInvalido()) {
    				mensagem = "Campos obrigatórios não informados";
    				
    			}else {
    				
    				if(clientedao.gravar(cliente)) {
    					mensagem = 
    						"Cliente gravado com sucesso na base de dados!";
    				}else {
    					mensagem =
    						"Falha ao gravar o cliente na base de dados!";
    					
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
    			"location.href='listarCliente.jsp';" +
    			"</script>"
    			
    				);
    		
    	
    	}
}
