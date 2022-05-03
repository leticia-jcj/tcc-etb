<%@ page language="java" 
	contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html>
<html>
<head>
	<title>Projeto ETB</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="content-type" content="text/html">
	<meta name="viewport" content="width=device-width, 
				initial-scale=1.0, shrink-to-fit=no">
	<link rel="stylesheet" href="css/styles.css" type="text/css">
	<link rel="stylesheet" href="css/menu.css" type="text/css">
	<link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="datatables/dataTables.bootstrap4.min.css" type="text/css">
	<link rel="stylesheet" href="datatables/jquery.dataTables.min.css" type="text/css">
	<link rel="stylesheet" href="fonts/css/all.css" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="template/banner.jsp"></jsp:include>
		
		</div>
		<div id="menu">
			<jsp:include page="template/menu.jsp"></jsp:include>

		</div> <!-- fim da div menu -->
		
		<div id="conteudo" class="bg-background">
			<div class="h-100 justify-content-center align-items-center">
				<div class="col-12">
					<div>
						<h2 class="text-center">Listagem de Usuários</h2>
					</div>
					<div class="col-sm-2 col-12" style="padding-bottom: 15px">
						<a class="btn btn-primary btn-md" 
							href="cadastrarUsuario.jsp"
							role="button">NOVO CADASTRO&nbsp;<i class="fa-solid fa-floppy-disk"></i>
						</a>
					
					</div>
					<div class="table-responsive">
						<table class="table table-hover table-bordered" id="listarUsuarios">
							<thead class="bg-primary">
								<tr class="text-white">
									<th>Código</th>
									<th>Nome</th>
									<th>Login</th>
									<th>Senha</th>
									<th>Status</th>
									<th>Ação</th>
								</tr>
							
							</thead>
							<tbody>
								<jsp:useBean class="model.usuario.UsuarioDAO" id="usuariodao" />
								<c:forEach var="usuario" items="${usuariodao.lista }">
								<tr>
									<td>${usuario.idUsuario}</td>
									<td>${usuario.nome}</td>
									<td>${usuario.login}</td>
									<td>${usuario.senha}</td>
									<td>${usuario.status}</td>
									
									<td>
										<a href="gerenciarUsuario?acao=alterar&idUsuario=${usuario.idUsuario}" 
											class="btn btn-primary btn-sm" 
											role="button">Alterar&nbsp;
											<i class="fa-solid fa-pen-to-square"></i>
										</a>
										<script type="text/javascript">
											function confirmExclusao(id,nome, login, senha, status){
												if(confirm('Deseja realmente excluir o usuário?'
														+nome+ ' ?, ?, ?, ?')){
												location.href="gerenciarUsuario?acao=deletar&idUsuario="+id;
												}
											}
										
										</script>
										
										<button class="btn btn-danger btn-sm"
											onclick="confirmExclusao('${usuario.idUsuario}','${usuario.nome}','${usuario.login}','${usuario.senha}','${usuario.status}')">
												Excluir&nbsp;
											<i class="fa-solid fa-trash-can"></i>
										</button>
										
									</td>
								
								
								</tr>
								</c:forEach>
							
							
							</tbody>
						
						
						</table>
					
					
					</div>
					
				
				</div>
			
			</div>
		
		
		</div>
	</div>
	<!-- JQuery.js -->
	<script src="js/jquery.min.js"></script>
	<script src="datatables/jquery.dataTables.min.js"></script>

	
	
	<!-- Popper via cdn -->
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
   integrity = "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
   crossorigin = "anonymous">
	</script>
	
	<!-- Bootstrap.js -->
	<script src="js/bootstrap.min.js"></script>
	<script src="datatables/dataTables.bootstrap4.min.js"></script>
	
	
	            <script>
                                $(document).ready(function () {
                                    $("#listarUsuario").dataTable({
                                        "bJQueryUI": true,
                                        "lengthMenu": [[5, 10, 20, 25, -1], [5, 10, 20, 25, "Todos"]],
                                        "oLanguage": {
                                            "sProcessing": "Processando..",
                                            "sLengthMenu": "Mostrar _MENU_ registros",
                                            "sZeroRecords": "Não foram encontrados resultados",
                                            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                            "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                                            "sInfoFiltered": "",
                                            "sInfoPostFix": "",
                                            "sSearch": "Pesquisar",
                                            "sUrl": "",
                                            "oPaginate": {
                                                "sFirst": "Primeiro",
                                                "sPrevious": "Anterior",
                                                "sNext": "Próximo",
                                                "sLast": "Último"
                                            }

                                        }
                                    });
                                });


                            </script>

	

	
</body>
</html>