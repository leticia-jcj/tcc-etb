<!DOCTYPE html>
<html>
<head>
	<title>Cadastrar Clientes</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/cliente.css" type="text/css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
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
				<h3
					style="text-align: center;"
					class="pb-3"
					>Cadastro de Clientes</h3>
					
				<div class="col-sm-12">
					<form action="gerenciarCliente" method="POST">
						<input type="hidden" id="idCliente" name="idCliente" value="${ cliente.idCliente }" />
						
						<div class="form-group">
							<label for="idNome">Nome</label>
							<input name="nome" type="text" class="form-control" id="idNome" aria-describedby="nomeHelp" placeholder="ex Admin" value="${ cliente.nome }">
							<small id="nomeHelp" class="form-text text-muted">Insira o nome do perfil a ser adicionado.</small>
						</div>
						
						<div class="form-group">
							<label for="idLink">Link</label>
							<input name="link" type="text" class="form-control" id="idLink" aria-describedby="nomeHelp" placeholder="ex Admin" value="${ cliente.link }">
							<small id="nomeHelp" class="form-text text-muted">Insira o link de redirecionamento.</small>
						</div>
						
						<div class="form-group">
							<label for="idIcone">Icone</label>
							<input name="icone" type="text" class="form-control" id="idIcone" aria-describedby="nomeHelp" placeholder="ex Admin" value='${ cliente.icone }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o ícone do cliente a ser exibido.</small>
						</div>
						
						
						<div class="mb-3">
							<label>Exibir</label>
							<div class="form-check">
							 	<input class="form-check-input" type="radio" name="status" id="idRadioNao" value="0" ${cliente.status==0?'checked':''} >
							  	<label class="form-check-label" for="idRadioNao">
							    	Não
							  	</label>
							</div>
							<div class="form-check">
							  	<input class="form-check-input" type="radio" name="status" id="idRadioSim" value="1" ${cliente.status==1?'checked':''} >
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
</html><!DOCTYPE html>
<html>
<head>
	<title>Cadastrar Clientes</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/cliente.css" type="text/css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
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
				<h3
					style="text-align: center;"
					class="pb-3"
					>Cadastro de Clientes</h3>
					
				<div class="col-sm-12">
					<form action="gerenciarCliente" method="POST">
						<input type="hidden" id="idCliente" name="idCliente" value="${ cliente.idCliente }" />
						
						<div class="form-group">
							<label for="idNome">Nome</label>
							<input name="nome" type="text" class="form-control" id="idNome" aria-describedby="nomeHelp" placeholder="ex Admin" value="${ cliente.nome }">
							<small id="nomeHelp" class="form-text text-muted">Insira o nome do perfil a ser adicionado.</small>
						</div>
						
						<div class="form-group">
							<label for="idCpf">CPF</label>
							<input name="cpf" type="text" class="form-control" id="idCpf" aria-describedby="nomeHelp" placeholder="" value="${ cliente.cpf }">
							<small id="nomeHelp" class="form-text text-muted">Insira o CPF do cliente</small>
						</div>
						
						<div class="form-group">
							<label for="idEndereco">Endereço</label>
							<input name="endereco" type="text" class="form-control" id="idEndereco" aria-describedby="nomeHelp" placeholder="" value='${ cliente.endereco }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o endereço do cliente.</small>
						</div>
						
						<div class="form-group">
							<label for="idEmail">Email</label>
							<input name="email" type="text" class="form-control" id="idEmail" aria-describedby="nomeHelp" placeholder="" value='${ cliente.email }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o email do cliente.</small>
						</div>
						
						<div class="form-group">
							<label for="idTelefone">Telefone</label>
							<input name="telefone" type="text" class="form-control" id="id|Telefone" aria-describedby="nomeHelp" placeholder="(Ex.: 61 9959-1414)" value='${ cliente.telefone }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o telefone do cliente.</small>
						</div>
						
						
						<div class="mb-3">
							<label>Exibir</label>
							<div class="form-check">
							 	<input class="form-check-input" type="radio" name="status" id="idRadioNao" value="0" ${cliente.status==0?'checked':''} >
							  	<label class="form-check-label" for="idRadioNao">
							    	Não
							  	</label>
							</div>
							<div class="form-check">
							  	<input class="form-check-input" type="radio" name="status" id="idRadioSim" value="1" ${cliente.status==1?'checked':''} >
							  	<label class="form-check-label" for="idRadioSim">
							    	Sim
							  	</label>
							</div>
							<small id="nomeHelp" class="form-text text-muted">Selecione uma opção.</small>
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