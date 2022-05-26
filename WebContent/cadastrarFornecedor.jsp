<!DOCTYPE html>
<html>
<head>
	<title>Cadastrar Fornecedores</title>
	<meta charset="UTF-8"/>
	<meta http-equiv="content-type" content="text/html"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<meta name="viewport" content="width=device-width, inicial-scale=1" />
	<link rel="stylesheet" href="css/styles.css"  type="text/css"/>
	<link rel="stylesheet" href="css/fornecedor.css" type="text/css"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
  	<link href="fonts/css/all.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container" class="d-flex flex-column align-items-stretch">
		<div id="header">
			<!--<jsp:include page="template/banner.jsp"></jsp:include>-->
		</div>
		
		<div id="fornecedor">
			<!--<jsp:include page="template/fornecedor.jsp"></jsp:include>
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
					>Cadastro de Fornecedores</h3>
					
				<div class="col-sm-12">
					<form action="gerenciarFornecedor" method="POST">
						<input type="hidden" id="idFornecedor" name="idFornecedor" value="${ fornecedor.idFornecedor }" />
						
						<div class="form-group">
							<label for="idRazaoSocial">Razão Social</label>
							<input name="razaosocial" type="text" class="form-control" id="idRazaoSocial" aria-describedby="nomeHelp" placeholder="" value="${ fornecedor.razaosocial }">
							<small id="nomeHelp" class="form-text text-muted">Insira a razão social do fornecedor.</small>
						</div>
						
						<div class="form-group">
							<label for="idNomeContato">Nome do Contato</label>
							<input name="nomecontato" type="text" class="form-control" id="idNomeContato" aria-describedby="nomeHelp" placeholder="" value="${ fornecedor.nomecontato }">
							<small id="nomeHelp" class="form-text text-muted">Insira o nome do contato do fornecedor.</small>
						</div>
						
						<div class="form-group">
							<label for="idEmail">Email</label>
							<input name="email" type="text" class="form-control" id="idEmail" aria-describedby="nomeHelp" placeholder="exemplo@gmail.com" value='${ fornecedor.email }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o email do fornecedor.</small>
						</div>
						
						<div class="form-group">
							<label for="idTelefone">Telefone</label>
							<input name="telefone" type="text" class="form-control" id="iidTelefone" aria-describedby="nomeHelp" placeholder="exemplo@gmail.com" value='${ fornecedor.telefone }'>
							<small id="nomeHelp" class="form-text text-muted">Insira o telefone do fornecedor.</small>
						</div>
						
						<div class="form-group">
							<label for="idCnpj">CNPJ</label>
							<input name="cnpj" type="text" class="form-control" id="idCnpj" aria-describedby="nomeHelp" placeholder="" value="${ fornecedor.cnpj }">
							<small id="nomeHelp" class="form-text text-muted">Insira o CNPJ do fornecedor.</small>
						</div>
						
						<div class="mb-3">
							<label>Exibir</label>
							<div class="form-check">
							 	<input class="form-check-input" type="radio" name="status" id="idRadioNao" value="0" ${fornecedor.status==0?'checked':''} >
							  	<label class="form-check-label" for="idRadioNao">
							    	Não
							  	</label>
							</div>
							<div class="form-check">
							  	<input class="form-check-input" type="radio" name="status" id="idRadioSim" value="1" ${fornecedor.status==1?'checked':''} >
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