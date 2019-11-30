<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Login</title>
	<link rel="shortcut icon" href="./resources/images/icons/logo.png" />
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous" />

	<link rel="stylesheet" type="text/css"
		href="./resources/css/cadastroLogin.css" />
	<h:outputStylesheet library="./resources/css"
		name="/cadastroLogin.css" />
		<link href='<html:rewrite page="./resources/css/cadastroLogin.css"/>' rel="stylesheet" type="text/css"> 
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<style type="text/css">
	
	@charset "ISO-8859-1";

	:root { 
	--cor-um: #4f5e38;
	--cor-dois: #8aa958;
	--cor-tres: #a2af89;
	--cor-quatro: #d3eaac;
	--cor-cinco: #a6ce74;
	--cor-seis: #edfeed;
	}
	.container{
	background-color: white;
	text-align: center;
	margin: auto;
	width: 90%;
	height: 90vh;
	margin-top: 1em;
	border-radius: 15px;
	box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
	min-width: 320px;
	max-width: 360px;
	min-height: 490px;
	}
	.titulo{
	margin: 0.8em; 
	color: var(--cor-um); 
	font-size: 1.2em;
	}
	/* Margem dos botoes */
	.margin{
	margin:2em 0 0 0.7em;
	}
	.botao-link{
	color: var(--cor-um);
	font-size: 1em;
	}
	.ajustebtnA{
	margin: 0 0 1em 0;
	}
	.ajustebtnB{
	margin: 1em 1em 1em 0;
	}
	.background-color{
	background-color: var(--cor-quatro);
	}
	
	.displaynone{
	width: 0;
    height: 0;
    overflow: hidden;
    opacity: 0;
    display: block;
	}
	.inputSize{
	width: 13em;
	}
	.ui-selectonemenu-trigger{
	margin: 0.5em;
	background: 0;
	border: none;
	box-shadow: none;
	}
	#numero{
    width: 6.8em ;
    }
    .tamanhoBtn{
    width: 8em;
    }
    
    .margem-topo{
    margin-top:3em;
    }
    


	/* Estilo valido somente para firefox*/
	@-moz-document url-prefix('') {
    #numero{
    width: 8.8em;
    }
    .inputSize{
	width: 15em;
	}
	 .tamanhoBtn{
    width: 9.3em;
    }
    .telefone input{
    width: 15em;
    }
	}
	
	
	
	

	@media only screen and (min-width: 820px){
	.container{
	background-color: white;
	text-align: center;
	margin: auto;
	width: 28%;
	height: 90vh;
	margin-top: 1em;
	border-radius: 15px;
	min-width: 380px;
	max-width: 420px;
	min-height: 490px;
	}
	.titulo{
	margin: 0.8em; 
	color: var(--cor-um); 
	font-size: 1.5em;
	}
	.margin{
	margin:2em;
	}
	.botao-link{
	color: var(--cor-um);
	font-size: 1em;
	}
	.ajustebtnA{
	margin: 0.6em;
	}
	.ajustebtnB{
	margin: 1em 1em 1em 0.6em;
	}
	.background-color{
	background-color: var(--cor-quatro);
	}
	.tamanhoBtn{
    width: 8.4em;
    }
		
	}
	
	
	</style>
</head>
<h:body class="background-color">

<div class="container">


		<div>
			<img src="http://www.fazendautopia.com/img/logo_fazenda_utopia_rodape.png" alt="logo"
				style="width: 7em; margin-top: 2em" />
		</div>

		<h1 class="titulo">Bem vindo a Fazenda Utopia</h1>



<form action="ServletAutenticacao" method="post" class="margin margem-topo" title="Login">



				<div
					class="alert alert-warning alert-dismissible fade show displaynone"
					id="alert-email">
					<strong>E-mail</strong> inválido, verifique!
					<button type="button" class="close" onclick="exibirOuOcultarMsg()">
						<span>&times;</span>
					</button>
				</div>



		<input readonly="readonly" type="hidden" id="url" name="url" 
			value="<%= request.getParameter("url") %>" />

			<div class="input-group flex-nowrap ajustebtnA">
					<div class="input-group-prepend">
						<span class="input-group-text" id="addon-wrapping"><i
							class="fa fa-envelope" style="width: 1em"></i></span>
					</div>
					<input type="text" alt="Email" onkeyup="atualizarEmail()" onchange="validMail()" id="email" placeholder="Email"
						class="inputSize" name="email" style="padding:0.3em; border-radius:0.2em;width: 100%"></input>
				</div>
			
				<div class="input-group flex-nowrap ajustebtnB">
					<div class="input-group-prepend">
						<span class="input-group-text" id="addon-wrapping"><i
							class="fa fa-lock" style="width: 1em"></i></span>
					</div>
					<input type="password" placeholder="Senha"
						class="inputSize" name="senha" style="padding:0.3em; border-radius:0.2em; width: 100%"></input>
				</div>


		<h:outputLink value="cadastro-usuario.xhtml"
					class="btn btn-light tamanhoBtn" onclick="location.href='cadastro-usuario.xhtml';">Cadastrar</h:outputLink>
				<input type="submit" value="Entrar" class="btn btn-success tamanhoBtn" />
		<div style="margin: 2em;">
		<h:outputLink value="cadastro-usuario.xhtml" class="btn btn-light" style="width:10em" onclick="location.href='cadastro-usuario.xhtml';">Esqueci a senha</h:outputLink>
						</div>
	</form>
	</div>
	<script src="./resources/js/validemail.js"></script>
</h:body>
</html>