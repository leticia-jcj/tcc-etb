<!DOCTYPE html>
<html>
<head>
	<title>Cadastrar Menus</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/menu.css" type="text/css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
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
				<h3
					style="text-align: center;"
					class="pb-3"
					>Cadastro de Menus</h3>
					
				<div class="col-sm-12">
					<form action="gerenciarMenu" method="POST">
						<input type="hidden" id="idMenu" name="idMenu" value="${ menu.idMenu }" />
						
						<div class="form-group">
							<label for="idNome">Nome</label>
							<input name="nome" type="text" class="form-control" id="idNome" aria-describedby="nomeHelp" placeholder="ex Admin" value="${ menu.nome }">
							<small id="nomeHelp" class="form-text text-muted">Insira o nome do perfil a ser adicionado.</small>
						</div>
						
						<div class="form-group">
							<label for="idLink">Link</label>
							<input name="link" type="text" class="form-control" id="idLink" aria-describedby="nomeHelp" placeholder="ex Admin" value="${ menu.link }">
							<small id="nomeHelp" class="form-text text-muted">Insira o link de redirecionamento.</small>
						</div>
						
						<div class="form-group">
							<label for="idIcone">Icone</label>
							<input name="icone" type="text" class="form-control" id="idIcone" aria-describedby="nomeHelp" placeholder="ex Admin" value='${ menu.icone }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o �cone do menu a ser exibido.</small>
						</div>
						
						
						<div class="mb-3">
							<label>Exibir</label>
							<div class="form-check">
							 	<input class="form-check-input" type="radio" name="status" id="idRadioNao" value="0" ${menu.status==0?'checked':''} >
							  	<label class="form-check-label" for="idRadioNao">
							    	N�o
							  	</label>
							</div>
							<div class="form-check">
							  	<input class="form-check-input" type="radio" name="status" id="idRadioSim" value="1" ${menu.status==1?'checked':''} >
							  	<label class="form-check-label" for="idRadioSim">
							    	Sim
							  	</label>
							</div>
							<small id="nomeHelp" class="form-text text-muted">Selecione uma op��o para.</small>
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