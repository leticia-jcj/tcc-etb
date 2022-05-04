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
			<form action="gerenciarUsuario" method="POST">
			<h3 class="text-center mt-3">Cadastro de Usuário</h3>
			
			<input type="hidden" id="idusuario" name="idUsuario"
				value="${usuario.idUsuario}">
			<div class="form-group row offset-md-2 mt-3">
				<label for="idnome"
					   class="col-md-2 col-form-label">Nome</label>
				<div class="col-md-7">
					<input type="text" name="nome" id="nome"
							class="form-control"
							value="${usuario.nome }">
				
				</div>
			
			</div>
			
			<div class="form-group row offset-md-2">
				<label for="idlogin"
					class="col-md-2 col-form-label">Login</label>
				<div class="col-md-7 mt-2">
					<input type="text" name="login" id="idlogin"
							class="form-control"
							value="${usuario.login}"> 
				</div>
			
			</div>
			
			<div class="form-group row offset-md-2">
				<label for="idsenha"
					class="col-md-2 col-form-label">Senha</label>
				<div class="col-md-7 mt-2">
					<input type="password" name="senha" id="idsenha"
							class="form-control"
							value="${usuario.senha}"> 
				</div>
			
			</div>
			
			<div class="form-group row offset-md-2">
					<label for="idstatus"
						class="col-md-2 form-label">Status</label>
					<div class="col-md-6">
						<select id="idstatus" name="status" 
								class="form-control-md mt-2">
							<option value="1" 
								<c:if test="${usuario.status == 1 }" >
								</c:if> selected>Ativo
							</option>
							<option value="0"
								<c:if test="${usuario.status == 0 }" >
								</c:if> selected>Inativo
							</option>
						</select>
					</div>
			</div>
			
			<div class="form-group row offset-md-2">
					<label for="idperfil"
						class="col-md-2 form-label">Perfil</label>
					<div class="col-md-6">
						<select id="idperfil" name="idPerfil" 
								class="form-control-md mt-2">
							<jsp:useBean class="model.perfil.PerfilDAO" id="pdao"/>
							<c:forEach var="p" items="${pdao.lista}">
								<option value="${p.idPerfil }"
									<c:if test="${p.idPerfil == usuario.perfil.idPerfil}"> 
										selected
									</c:if>	>${p.nome}</option>
							</c:forEach>
							
						</select>
					</div>
			</div>
			
			
			
			
			<div class="d-grip gap-2 d-md-flex justify-content-md-end mr-3">
				<button class="btn btn-primary btn-md mr-2" >
					Gravar&nbsp;
					<i class="fa-solid fa-floppy-disk"></i>
				</button>
				<a href="listarUsuario.jsp"
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