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
	<title>Listar Clientes</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/cliente.css" type="text/css"/>
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
		
		<div id="cliente">
			<!--<jsp:include page="template/cliente.jsp"></jsp:include>
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
						<h2 style="text-align: center;">Listagem de Clientes</h2>				
					</div>
					<div class="col-sm-2 col-12 p-1 mb-2  flex d-flex">
						<a type="button" class="btn btn-outline-secondary btn-md mr-2" onclick="history.back()">
							<i class="fa-solid fa-arrow-left mr-2"></i>
							Voltar
						</a>
						<a type="button" class="btn btn-primary btn-md mr-2" href="cadastrarCliente.jsp">
							<i class="fa-solid fa-floppy-disk mr-2"></i>
							Novo Cadastro
						</a>
					</div>
					<div class="table-responsive" >
						<table id="listarClientes" class=" table table-bordered table-hover">
							<thead class="bg-dark text-light">
								<tr>
									<th>Código</th>
									<th>Nome</th>
									<th>CPF</th>
									<th>Endereço</th>
									<th>Email</th>
									<th>Telefone</th>
									<th>Ações</th>
								</tr>
							</thead>
							<tbody>
							<%-- JSP Action --%>
							<%-- Cria uma instancia de alguma classe --%>
								<jsp:useBean class="model.cliente.ClienteDAO" id="clientedao"></jsp:useBean> 
								<c:forEach var="cliente" items="${ clientedao.lista }">
									<tr>
									<td>${ cliente.idCliente }</td>
									<td>${ cliente.nome }</td>
									<td>${ cliente.cpf }</td>
									<td>${ cliente.email }</td>
									<td>${ cliente.endereco }</td>
									<td>${ cliente.telefone }</td>
										<td>
											<c:if test="${ cliente.status == 1 }">Sim</c:if>
											<c:if test="${ cliente.status == 0 }">Não</c:if>
										</td>
										<td>
											<script type="text/javascript">
												function confirmarExclusao(id, nome){
													if(confirm("Deseja realmente excluir o cliente '"
															+ nome + "' ?")){
														location.href = "gerenciarCliente?acao=deletar&idCliente=" + id
													}
												}
											</script>
											<a
												role="button"
												href="gerenciarCliente?acao=alterar&idCliente=${ cliente.idCliente }"
												class="btn btn-primary btn-md"
												>
													Alterar
													<i class="fa-solid fa-pencil ml-2"></i>
											</a>
											
											<button
												class="btn btn-danger btn-md"
												onclick="confirmarExclusao( ${ cliente.idCliente }, 
												'${ cliente.nome }',
												'${ cliente.cpf }',
											    '${ cliente.endereco },
											    , '${ cliente.email }' 
											    '${ cliente.telefone }')">
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
			$("#listarClientes").dataTable({
				"bJQueryUI": true,
				"lengthCliente": [[5, 10, 20, 25, -1], [5, 10, 20, 25, "Todos"]],
				"oLanguage": {
					"sProcessing": "Processando..",
					"sLengthCliente": "Mostrar _CLIENTE_ registros",
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
