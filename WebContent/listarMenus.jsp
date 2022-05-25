<%--
	Diretivas instruções específicas para realizar 
	ações ao carregar a página

--%>

<%-- Diretivas para páginas estáticas --%>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"
%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>Listar Menus</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/menu.css" type="text/css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<link rel="stylesheet" href="datatables/dataTables.bootstrap4.min.css"/>
  	<link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
  	<link href="fonts/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container" class="d-flex flex-column align-items-stretch">
		<div id="header">
			<!--<jsp:include page="template/banner.jsp"></jsp:include>-->
		</div>
		
		<div id="menu">
			<!--<jsp:include page="template/menu.jsp"></jsp:include>
			<i class="fa-solid fa-bars-filter"></i>-->
		</div>
		
		<div id="content">
			<div class="
				h-100
				justify-content-center
				align-items-center 
				ml-auto mr-auto
				box-cadastro
				">
				<div class="col-sm-12">
					<div>
						<h2 style="text-align: center;">Listagem de Menus</h2>				
					</div>
					<div class="col-sm-2 col-12 p-1 mb-2  flex d-flex">
						<a type="button" class="btn btn-outline-secondary btn-md mr-2" onclick="history.back()">
							<i class="fa-solid fa-arrow-left mr-2"></i>
							Voltar
						</a>
						<a type="button" class="btn btn-primary btn-md mr-2" href="cadastrarMenu.jsp">
							<i class="fa-solid fa-floppy-disk mr-2"></i>
							Novo Cadastro
						</a>
					</div>
					<div class="table-responsive" >
						<table id="listarMenus" class=" table table-bordered table-hover">
							<thead class="bg-dark text-light">
								<tr>
									<th>Código</th>
									<th>Nome</th>
									<th>Link</th>
									<th>Icone</th>
									<th>Exibir</th>
									<th>Ações</th>
								</tr>
							</thead>
							<tbody>
							<%-- JSP Action --%>
							<%-- Cria uma instancia de alguma classe --%>
								<jsp:useBean class="model.menu.MenuDAO" id="mdao"></jsp:useBean> 
								<c:forEach var="m" items="${ mdao.lista }">
									<tr>
										<td>${ m.idMenu }</td>
										<td>${ m.nome }</td>
										<td>${ m.link }</td>
										<td>${ m.icone }</td>
										<td>
											<c:if test="${ m.status == 1 }">Sim</c:if>
											<c:if test="${ m.status == 0 }">Não</c:if>
										</td>
										<td>
											<script type="text/javascript">
												function confirmarExclusao(id, nome){
													if(confirm("Deseja realmente excluir o menu '"
															+ nome + "' ?")){
														location.href = "gerenciarMenu?acao=deletar&idMenu=" + id
													}
												}
											</script>
											<a
												role="button"
												href="gerenciarMenu?acao=alterar&idMenu=${ m.idMenu }"
												class="btn btn-primary btn-md"
												>
													Alterar
													<i class="fa-solid fa-pencil ml-2"></i>
											</a>
											
											<button
												class="btn btn-danger btn-md"
												onclick="confirmarExclusao( ${ m.idMenu }, '${ m.nome }')">
													Excluir
													<i class="fa-solid fa-trash ml-2"></i>
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
	<script src="javascript/jquery-3.2.1.slim.min.js"></script>
	<script src="datatables/jquery.dataTables.min.js" type="text/javascript"></script>
	
	<!-- Pooper via cdn -->
	<script src="javascript/popper.min.js"></script>
	
	<!-- Bootstrap.js -->
	<script src="javascript/bootstrap.min.js"></script>
	<script src="datatables/dataTables.bootstrap4.min.js" type="text/javascript"></script>
	
	<script>
    	$(document).ready(function () {
			$("#listarMenus").dataTable({
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
