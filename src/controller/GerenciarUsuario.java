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

import model.Perfil;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

@WebServlet("/gerenciarUsuario")
public class GerenciarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GerenciarUsuario() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String acao = request.getParameter("acao");
		String idUsuario = request.getParameter("idUsuario");
		String mensagem = "";
		
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		
		try {
			if(acao.equals("alterar")){
				u = udao.getCarregarPorId(
						Integer.parseInt(idUsuario));
				if(u.getIdUsuario() > 0) {
					RequestDispatcher dispatcher =
							getServletContext().
								getRequestDispatcher(
										"/cadastrarUsuario.jsp");
				request.setAttribute("usuario", u);
				dispatcher.forward(request, response);
					
				}else {
					mensagem = 
						"O usuário nãp foi encontrado na base de dados!";
				}
			}
			
			
			if(acao.equals("desativar")) {
				u.setIdUsuario(Integer.parseInt(idUsuario));
				if(udao.desativar(u)) {
					mensagem = "Usuário desativado com sucesso!";
					
				}else {
					mensagem = "Falha ao desativar o usuário!";
				}
				
				
			}
			
			if(acao.equals("ativar")) {
				u.setIdUsuario(Integer.parseInt(idUsuario));
				if(udao.ativar(u)) {
					mensagem = "Usuário ativado com sucesso!";
				}else {
					mensagem = "Falha ao ativar o usuário";
				}
			}
			
		} catch (SQLException e) {
			mensagem = "Erro: " + e.getMessage();
			e.printStackTrace();
		}
		
		out.println(
				"<script type='text/javascript'>" +
				"alert('" + mensagem + "');" +
				"location.href='listarUsuario.jsp';" +
				"</script>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String idUsuario = request.getParameter("idUsuario");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String status = request.getParameter("status");
		String idPerfil = request.getParameter("idPerfil");
		String mensagem = "";
		
		Usuario u = new Usuario();
		
		if(!idUsuario.isEmpty()) {
			u.setIdUsuario(Integer.parseInt(idUsuario));
		}
		
		if(nome.equals("") || nome.isEmpty()) {
			mensagem = "Informe o nome do usuário!";
		}else {
			u.setNome(nome);
		}
		
		if(login.equals("") || login.isEmpty()) {
			mensagem = "Informe o nome login do usuário!";
		}else {
			u.setLogin(login);
		}
		
		if(senha.equals("") || senha.isEmpty()) {
			mensagem = "Informe a senha do usuário!";
		}else {
			u.setSenha(senha);
		}

		
		if(status.equals("") || status.isEmpty()){
			mensagem = "Informe o status do usuário!";
		}else {
			u.setStatus(Integer.parseInt(status));
		}
		
		Perfil p = new Perfil();
		p.setIdPerfil(Integer.parseInt(idPerfil));
		u.setIdPerfil(p);
		
		UsuarioDAO udao = new UsuarioDAO();
		try {
			if(udao.gravar(u)) {
				mensagem = 
					"Usuário gravado com sucesso na base de dados!";
			}else {
				mensagem = 
					"Falha ao gravar o usuário na base de dados!";
			}
		
		} catch (SQLException e) {
			mensagem = "Erro: " + e.getMessage();
		}
		
		out.println(
				"<script type='text/javascript'>" +
				"alert('" + mensagem + "');" +
				"location.href='listarUsuario.jsp';" +
				"</script>"	);	

}
}
