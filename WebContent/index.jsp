<%@ page language="java" 
	contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- Diretivas
	São instruções processadas quando a página JPS é compilada
em um servlet. Elas são utilizadas para ajustar instruções no
nível da página, inserir dados de arquivos externos e para
especificar bibliotecas de tags (taglibs).
	Elas são definidas entre <%@ e %>

--%>

<%--Diretiva Page
	Define atributos que são aplicados a todo o arquivo JSP e a
	todos os arquivos incluídos de forma estática. Ela permite a
	importação de classes, customização de superclasses.
	
	A diretiva page tem a seguinte sintaxe:<%@ page %>
	Os atributos mais usados na diretiva page são:
	- language=”java” – Especifica a linguagem que  é utilizada.
	- Import=”pacote.classe.*” – Especifica a classe que deve ser 
	 importada pela página JSP.
	- contentType=”text/html” – Especifica informações sobre a página, o  MIME type do documento. Que tipo de conteúdo será exibido pela página. 
	

 --%>

<%-- Comentários de múltiplas linhas:
São similares aos comentários HTML, mas são tirados da página
quando o arquivo JSP é compilado em servlet. Isto significa que
os comentários JSP não aparecem no código fonte da página JSP
visualizada no navegador do usuário.
 --%> 


<%-- Este é um comentário de uma única linha --%>
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
			<h1>Bem-vindo(a) à Cafeteria LaCreme! </h1>
			<p class="textohome">
		   <h2>História do Café no Mundo</h2>
		    
		    
		    </p>
		
		
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