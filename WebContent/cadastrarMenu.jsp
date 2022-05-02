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
			<form action="gerenciarMenu" method="POST">
				<h3 class="text-center mt-3">Cadastro de Menu</h3>
			
				<input type="hidden" id="idmenu" name="idMenu"
				   value="${menu.idMenu}">
			
				<div class="form-group row offset-md-2">
					<label for="idnome"
						class="col-md-2 form-label">Nome</label>
					<div class="col-md-6">
						<input type="text" class="form-control" 
						name="nome" id="idnome"
						value="${menu.nome }">
					</div>
				</div>
				<div class="form-group row offset-md-2">
					<label for="idlink"
						class="col-md-2 form-label">Link</label>
					<div class="col-md-6">
						<input type="text" class="form-control" 
						name="link" id="idlink"
						value="${menu.link }">
					</div>
				</div>
				<div class="form-group row offset-md-2">
					<label for="idicone"
						class="col-md-2 form-label">icone</label>
					<div class="col-md-6">
						<input type="text" class="form-control" 
						name="icone" id="idicone"
						value="${menu.icone}">
					</div>
				</div>
				<div class="form-group row offset-md-2">
					<label for="idexibir"
						class="col-md-2 form-label">Exibir</label>
					<div class="col-md-6">
						<select id="exibir" name="exibir" 
								class="form-control-md mt-2">
							<c:if test="${menu.exibir == null}">
								<option value="1">Sim</option>
								<option value="0">Não</option>	
							</c:if>
							<c:if test="${menu.exibir == 1 }">
								<option value="${menu.exibir }" selected>Sim</option>
								<option value="0">Não</option>
							</c:if>
							<c:if test="${menu.exibir == 0 }">
								<option value="1">Sim</option>
								<option value="${menu.exibir == 0 }"selected>Não</option>
							</c:if>
						
						</select>
					</div>
				</div>
				<div class="d-grip gap-2 d-md-flex justify-content-md-end mr-3">
					<button class="btn btn-primary btn-md mr-2">
						Gravar&nbsp;
						<i class="fa-solid fa-floppy-disks"></i>
					</button>
					<a href="listarMenus.jsp"
							class="btn btn-info btn-md"
							role="button">
							Voltar&nbsp;
							<i class="fa-solid fa-circle-left"></i>
					</a>
				</div>
			
			</form>
		
		</div>
	</div>
	<!-- JQuery.js -->
	<script src="js/jquery.min.js"></script>
	
	
	<!-- Popper via cdn -->
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
   integrity = "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
   crossorigin = "anonymous">
	</script>
	
	<!-- Bootstrap.js -->
	<script src="js/bootstrap.min.js"></script>
	
	
</body>
</html>