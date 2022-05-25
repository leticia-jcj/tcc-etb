package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.menu.Menu;
import model.menu.MenuDAO;


@WebServlet("/gerenciarMenu")
public class GerenciarMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GerenciarMenu() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		String idMenu = request.getParameter("idMenu");
		String mensagem = "";
		
		Menu m = new Menu();
		MenuDAO mdao = new MenuDAO();
		
		try {
			if(acao.equals("ativar")){
				m.setIdMenu(Integer.parseInt(idMenu));
				if(mdao.ativar(m)) {
					
					mensagem = 
						"Menu ativado com sucesso da base de dados!";
					
				}else {
					mensagem =
						"Falha ao desativar o menu na base de dados!";
				}
			}
			
			if(acao.equals("desativar")){
				m.setIdMenu(Integer.parseInt(idMenu));
				if(mdao.desativar(m)) {
					
					mensagem = 
						"Menu desativado com sucesso da base de dados!";
					
				}else {
					mensagem =
						"Falha ao desativar o menu na base de dados!";
				}
			}
			
			if(acao.equals("alterar")) {
			 m = mdao.getMenu(Integer.parseInt(idMenu));
			 	if(m.getIdMenu() > 0) {
			 		RequestDispatcher dispatcher =
			 			getServletContext().
			 				getRequestDispatcher("/cadastrarMenu.jsp");
			 		request.setAttribute("menu",m);
			 		dispatcher.forward(request, response);
			 	}else {
			 		mensagem = 
			 		"Perfil não encontrado na base de dados";
			 	}
				
			}
			
		} catch (SQLException e) {
			mensagem = "Erro: " + e.getMessage();
			e.printStackTrace();
		}
		
		out.println(
			"<script type='text/javascript'>" +
			"alert('" + mensagem + "');" +
			"location.href='listarMenus.jsp';" +
			"</script>"
		);
		
	
		
		
	}


	protected void doPost(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException,IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String idMenu = request.getParameter("idMenu");
		String nome = request.getParameter("nome");
		String link = request.getParameter("link");
		String icone = request.getParameter("icone");
		String status = request.getParameter("status");
		String mensagem = "";
		
		Menu m = new Menu();
		
		if(!idMenu.isEmpty()){
			m.setIdMenu(Integer.parseInt(idMenu));
		}
		
		if(nome.equals("") || nome.isEmpty()) {
			mensagem = "Informe o nome do menu!";
		}else {
			m.setNome(nome);
			
		}
		
		if(link.equals("") || link.isEmpty()) {
			mensagem = "Informe o caminho do link!";
		}else {
			
			m.setLink(link);
		}
		
		if(status.equals("") || status.isEmpty()) {
			mensagem = "Informe o valor do campo status!";
		}else {
			m.setStatus(Integer.parseInt(status));
		}
		
		m.setIcone(icone);
		
		
		MenuDAO mdao = new MenuDAO();
		
		try {
			if(mdao.gravar(m)) {
				mensagem = 
						"Menu gravado com sucesso na base de dados!";
			}else {
				mensagem =
						"Falha ao gravar o menu na base de dados!";
			}
			
		} catch (SQLException e) {
			mensagem = "Erro: " + e.getMessage();
			e.printStackTrace();
		}
		
		out.println(
			"<script type='text/javascript'>" +
			"alert('" + mensagem + "');" +
			"location.href='listarMenus.jsp';" +
			"</script>"
				
				);
		
		}
}
