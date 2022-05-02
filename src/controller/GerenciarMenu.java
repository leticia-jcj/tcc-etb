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

import model.Menu;
import model.MenuDAO;


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
			
			if(acao.equals("deletar")){
				m.setIdMenu(Integer.parseInt(idMenu));
				if(mdao.deletar(m.getIdMenu())) {
					
					mensagem = 
						"Menu exclu�do com sucesso da base de dados!";
					
				}else {
					mensagem =
						"Falha ao excluir o menu da base de dados!";
				}
			}
			if(acao.equals("alterar")) {
			 m = mdao.getCarregarPorId(Integer.parseInt(idMenu));
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
		String exibir = request.getParameter("exibir");
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
		
		if(exibir.equals("") || exibir.isEmpty()) {
			mensagem = "Informe o valor do campo exibir!";
		}else {
			m.setExibir(Integer.parseInt(exibir));
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
