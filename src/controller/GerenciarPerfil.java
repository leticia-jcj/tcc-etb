package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.perfil.Perfil;
import model.perfil.PerfilDAO;
@WebServlet("/gerenciarPerfil")
public class GerenciarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GerenciarPerfil() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		String idPerfil = request.getParameter("idPerfil");
		String mensagem = "";
		
		Perfil p = new Perfil();
		
		PerfilDAO pdao = new PerfilDAO();
		
			try {
			
				if(acao.equals("deletar")) {
					p.setIdPerfil(Integer.parseInt(idPerfil));
						if(pdao.deletar(p.getIdPerfil())) {
							mensagem = 
									"Perfil excluído da base de dados!";
					
						}else {
							mensagem = 
						"Falha ao excluir o perfil da base de dados!";
						}
				
				}
				if(acao.equals("alterar")){
					p = pdao.getCarregarPorId(
							Integer.parseInt(idPerfil));
					if(p.getIdPerfil() > 0) {
						RequestDispatcher dispatcher =
								getServletContext().
								getRequestDispatcher("/cadastrarPerfil.jsp");
						request.setAttribute("perfil", p);
						dispatcher.forward(request, response);
						
					}else {
						mensagem = "Perfil não encontrado na base de dados!";
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
				"location.href='listarPerfis.jsp';" +
				"</script>");
		
	}

	
	protected void doPost(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String idPerfil = request.getParameter("idPerfil");
		String nome = request.getParameter("nome");
		String dataCadastro = request.getParameter("dataCadastro");
		String mensagem = "";
		Perfil p = new Perfil();
		PerfilDAO pdao = new PerfilDAO();
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			if(!idPerfil.isEmpty()) {
				p.setIdPerfil(Integer.parseInt(idPerfil));
				
			}
			
			if(nome.isEmpty() || nome.equals("")) {
				mensagem = "Campo Obrigatório";
				
			}else {
				p.setNome(nome);
				p.setDataCadastro(df.parse(dataCadastro));
				if(pdao.gravar(p)) {
					mensagem = 
						"Perfil gravado com sucesso na base de dados!";
				}else {
					mensagem =
						"Falha ao gravar o perfil na base de dados!";
					
				}
			}
			
		}catch (ParseException pe) {
			mensagem = "Erro: " + pe.getMessage();
			out.println(mensagem);
		}catch (SQLException e) {
			mensagem = "Erro: " + e.getMessage();
			out.println(mensagem);
		}
		
		out.println(
			"<script type='text/javascript'>" +
			"alert('" + mensagem + "');" +
			"location.href='listarPerfis.jsp';" +
			"</script>");
		
	
	}

}
