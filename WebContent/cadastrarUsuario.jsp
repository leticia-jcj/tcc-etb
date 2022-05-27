<!DOCTYPE html>
<html>
<head>
	<title>Cadastrar Usuários</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/usuario.css" type="text/css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
  	<link href="fonts/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container" class="d-flex flex-column align-items-stretch">
		<div id="header">
			<!--<jsp:include page="template/banner.jsp"></jsp:include>-->
		</div>
		
		<div id="usuario">
			<!--<jsp:include page="template/usuario.jsp"></jsp:include>
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
				<h3
					style="text-align: center;"
					class="pb-3"
					>Cadastro de Usuários</h3>
					
				<div class="col-sm-12">
					<form action="gerenciarUsuario" method="POST">
						<input type="hidden" id="idUsuario" name="idUsuario" value="${ usuario.idUsuario }" />
						
						<div class="form-group">
							<label for="idNome">Nome</label>
							<input name="nome" type="text" class="form-control" id="idNome" aria-describedby="nomeHelp" placeholder="" value="${ usuario.nome }">
							<small id="nomeHelp" class="form-text text-muted">Insira o nome do usuário.</small>
						</div>
						
						<div class="form-group">
							<label for="idLogin">Login</label>
							<input name="login" type="text" class="form-control" id="idLogin" aria-describedby="nomeHelp" placeholder="" value="${ usuario.login }">
							<small id="nomeHelp" class="form-text text-muted">Insira o login do usuário.</small>
						</div>
						
						<div class="form-group">
							<label for="idSenha">Senha</label>
							<input name="senha" type="text" class="form-control" id="idSenha" aria-describedby="nomeHelp" placeholder="" value='${ usuario.senha }'>
							<small id="nomeHelp" class="form-text text-muted">Insira a senha do usuário.</small>
						</div>
						
						<div class="mb-3">
							<label>Exibir</label>
							<div class="form-check">
							 	<input class="form-check-input" type="radio" name="status" id="idRadioNao" value="0" ${usuario.status==0?'checked':''} >
							  	<label class="form-check-label" for="idRadioNao">
							    	Não
							  	</label>
							</div>
							<div class="form-check">
							  	<input class="form-check-input" type="radio" name="status" id="idRadioSim" value="1" ${usuario.status==1?'checked':''} >
							  	<label class="form-check-label" for="idRadioSim">
							    	Sim
							  	</label>
							</div>
							<small id="nomeHelp" class="form-text text-muted">Selecione uma opção para.</small>
						</div>
						
						<div class="p-grip gap-2 flex justify-content-md-between">
							<a role="button" class="btn btn-outline-secondary" onclick="history.back()">
								<i class="fa-solid fa-arrow-left mr-1"></i>
								Voltar
							</a>
							<button type="submit" class="btn btn-primary">
								<i class="fa-solid fa-floppy-disk mr-1"></i>
								Cadastrar
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- JQuery.js -->
	<script src="javascript/jquery-3.2.1.slim.min.js"></script>
	
	<!-- Pooper via cdn -->
	<script src="javascript/popper.min.js"></script>
	
	<!-- Bootstrap.js -->
	<script src="javascript/bootstrap.min.js"></script>
</body>
</html>