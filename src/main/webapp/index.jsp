<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:p="http://primefaces.org/ui">
<h:head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Fazenda Utopia</title>
	<link rel="shortcut icon" href="./resources/images/icons/logo.png" />
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<h:outputStylesheet library="css" name="/main.css" />
	<link rel="stylesheet" type="text/css"
		href="./resources/css/cssformulariocontato.css" />
	<h:outputScript library="js" name="/" />
</h:head>
<h:body class="container">

	<!-- Sessao do cabe�alho com banner -->
	<div class="header">

		<ui:insert name="menu-superior">
			<ui:include src="/pages/template/menu-superior.xhtml" />
		</ui:insert>

		<div id="banner">
			<ui:insert name="banners">
				<ui:include src="/pages/template/banners.xhtml" />
			</ui:insert>
		</div>
	</div>
	<!-- Sessao do cabe�alho -->

	<div class="separador"></div>

	<!-- Sessao de cestas da semana SESSAO ANTIGA -->
	<h:form prependId="false">
		<div class="main">


			<!-- <div id="cestas" style="display: none">
				<h1>Cestas da semana</h1>
				<p>Selecione a cesta ideal para voc� e sua fam�lia</p>
				<p:carousel value="#{cestaBean.cestas}" var="cestas" numVisible="4"
					responsive="true" class="card" autoPlayInterval="7000">


					<div class="cesta-lista-item" onclick="PF('dlgCesta').show(cestas)">
						<div class="centralizar-imagem">
							<h:graphicImage
								value="./resources/images/upload/CestaSemIcone1.png"
								alt="icone cesta"
								class="icone-imagens-cestas .centralizar-imagem imagem-tamanho-p" />
						</div>
						<div>
							<h:outputText value="#{cestas.categoriaCesta.descricao}"
								class="titulo-cestas" />

							<div class="carrocel-dados-cestas">
								<div>
									<h:outputText value="#{cestas.descricao}" />
									<div>
										<h:outputText value="#{cestas.quantItens}" />
										<h:outputText value=" Produtos"></h:outputText>
									</div>
								</div>
								<h:outputText value="R$ " />
								<h:outputText value="#{cestas.precovenda}"
									style="font-size:1.5em; font-weight:bold" />
							</div>
						</div>

					</div>
				</p:carousel>
			</div>
 -->

			<!-- CESTA DA SEMANA EM DATAVIEW NOVA SESSAO-->
			<div class="sessao_cestas">
				<h1>Cestas da semana</h1>
				<p>Selecione a cesta ideal para voc� e sua fam�lia</p>
			</div>
			<div class="container-cesta-semana">
				<h:form id="form" prependId="false">
					<p:dataView var="cesta" value="#{cestaBean.cestas}" rows="3"
						paginator="true" rowsPerPageTemplate="3,6,9"
						paginatorTemplate="{FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}"
						gridIcon="fa fa-th" listIcon="fa fa-th-list"
						style="width:95%; margin:auto; padding:0;">


						<p:dataViewGridItem styleClass="viewGrid" class="viewCard">
							<p:panel header="#{cesta.categoriaCesta.descricao}"
								style="text-align:center;">

								<h:panelGrid columns="1"
									style="width:88%; border:1px solid #ccc; border-radius:10px; padding:0">

									<h:graphicImage value="#{cesta.imagemnome}"
										class="icone-imagens-cestas .centralizar-imagem imagem-tamanho-p" />
									<h:outputText value="#{cesta.descricao}" />
									<div style="display: grid">
										<h:outputText value="#{cesta.quantItens} PRODUTOS" />

										<hr></hr>

										<h:outputText value="#{cesta.dualListModelProdu.target}"
											style="font-size:1em;text-transform: lowercase;" />

										<h:outputText value="R$ #{cesta.precovenda}0"
											style="font-size:1.5em; font-weight:bold" />
									</div>
									<p:commandButton update=":formCesta"
										oncomplete="PF('dlgCesta').show()" title="Ver Detalhes"
										styleClass="btn-lista-de-itens"
										actionListener="#{cestaBean.selecionarCesta}">
										<f:attribute name="cestaSelecionada" value="#{cesta}" />
										<f:actionListener
											type="org.omnifaces.eventlistener.ResetInputAjaxActionListener" />
									</p:commandButton>


								</h:panelGrid>
							</p:panel>
						</p:dataViewGridItem>


						<p:dataViewListItem>

							<h:panelGrid columns="2">
								<h:panelGrid style="width:10%;">
									<h:graphicImage value="#{cesta.imagemnome}"
										class="imagem-tamanho-p" />
									<p:commandButton update=":formCesta"
										oncomplete="PF('dlgCesta').show()" title="Detalhes"
										styleClass="btn-lista-de-itens"
										actionListener="#{cestaBean.selecionarCesta}">
										<f:attribute name="cestaSelecionada" value="#{cesta}" />
										<f:actionListener
											type="org.omnifaces.eventlistener.ResetInputAjaxActionListener" />
									</p:commandButton>
								</h:panelGrid>
								<h:panelGrid style="width:98%">
									<h:outputText value="#{cesta.descricao}" />

									<h:outputText value="#{cesta.quantItens} PRODUTOS" />
									<div style="margin: 1em"></div>

									<h:outputText value="#{cesta.dualListModelProdu.target}"
										style="font-size:1em;text-transform: lowercase;" />

									<h:outputText value="R$ #{cesta.precovenda}0"
										style="font-size:1.5em; font-weight:bold" />

								</h:panelGrid>
							</h:panelGrid>
						</p:dataViewListItem>

					</p:dataView>


					<!-- Sessao dialog da cesta selecionada -->
					<p:dialog header="Selecionado" widgetVar="dlgCesta"
						minimizable="true" minHeight="540" minWidth="480" modal="true"
						maximizable="true" id="dialog" closeOnEscape="true"
						responsive="true" resizable="true"
						style="width: 100vw !important; z-index: 9000; margin:0; padding:0"
						position="top" fitViewport="true"
						onShow="capturarProdutosDaLista();">
						<p:outputPanel id="cestaDetail">
							<!-- Formulario da cesta selecionada -->
							<h:form prependId="false" id="formCesta">
								<div class="centralizar-imagem">
									<!-- Imagem da cesta selecionada -->
									<img src="./resources/images/upload/CestaSemIcone1.png"
										alt="icone cesta" class="centralizar-imagem imagem-tamanho-m" />

									<!-- Inserir a imagem aqui_______________ -->
									<h:graphicImage value=""
										class="icone-imagens-cestas .centralizar-imagem imagem-tamanho-p"
										alt="" />
								</div>
								<div class="div-titulo-dialog">

									<!-- Informa��es da cesta selecionada (Descri��o + qtd itens) -->
									<h:outputLabel style="padding:0.9em" id="label-cesta-descricao"
										value="#{cestaBean.cesta.descricao} Cesta..."></h:outputLabel>

									<!-- Informa��es da cesta selecionada () -->
									<h:outputLabel style="padding:0.9em">R$</h:outputLabel>
									<h:outputLabel style="padding:0.9em" id="preco-cesta"
										value="50.90"></h:outputLabel>

								</div>
								<div class="alert alert-warning alert-dismissible fade"
									style="display: none" id="dialogCestaAlerta"
									onclick="fecharAlerta()">
									Voc� atingiu o <strong>limite</strong> de altera��es
									<button type="button" class="close">
										<span>&times;</span>
									</button>
								</div>
								<div style="margin-bottom: 1em">
									<p:dataScroller value="#{cestaBean.produtos}" var="Produtos"
										chunkSize="10" class="main__produtos" id="produtosList">
										<p:panelGrid columns="3">
											<i class="fa fa-product-hunt"></i>
											<p:outputPanel>
												<h:panelGrid columns="4" cellpadding="10">

													<!-- Informa��es dos produtos da cesta (Descri��o) -->
													<h:outputText value="#{Produtos.descricao}"
														class="descricao-produto" id="descricao-cesta" />

													<h:outputText class="multiplicador" style="display: none"
														value="1" />

													<!-- Icone para alterar o produto da cesta -->
													<i class="fa fa-times remove-icon"
														style="padding-left: 3em; color: red"></i>


												</h:panelGrid>
											</p:outputPanel>
										</p:panelGrid>
									</p:dataScroller>
								</div>

								<!-- Botao calcular frete desabilitado -->
								<p:commandButton value="" id="calcular-frete-cesta"
									style="margin:1.2em 0 0.5em 1.5em; font-size:0.7em; font-weight:normal; background-color:white display: none; width: 0; height: 0;"></p:commandButton>

								<div class="calcular-frete displaynone"
									id="div-calcular-frete-cesta"
									style="display: none; width: 0; height: 0;">
									<p:selectOneMenu id="select-calcular-frete-cesta" value="9.22"
										style="width:200px">
										<f:selectItem itemLabel="Selecione sua regi�o" itemValue=""></f:selectItem>
										<f:selectItem itemLabel="Regi�o um" itemValue="9.00"></f:selectItem>
										<f:selectItem itemLabel="Regi�o dois" itemValue="9.20"></f:selectItem>
										<f:selectItem itemLabel="Regi�o tres" itemValue="9.15"></f:selectItem>
										<f:selectItems value="" itemLabel="" itemValue=""></f:selectItems>
									</p:selectOneMenu>
									<div style="padding: 0.5em 0 0.8em 0">
										<p:outputLabel value="Frete R$ 9.15" id="label-frete-cesta"></p:outputLabel>
									</div>
								</div>

								<div
									style="display: inline-block; margin: auto; width: 100%; text-align: center">

									<!-- Total (Soma do pre�o qtd de itens x pre�o de cada iten) -->
									<h:outputText value=" Total R$">
									</h:outputText>
									<h:outputText value="50.90"
										style="font-weight: bold; padding:0.2em; font-size: 1.3em"
										class="preco-produto" id="total-cesta" />

									<!-- Bot�o para diminuir 1 (uma) unidade na quantidade de item -->
									<p:commandButton value="-" id="bt-dialog-menos-cesta"
										style="background-color:white"></p:commandButton>

									<p:inputNumber id="input-qtd-cesta" value="1" minValue="1"
										maxValue="99" disabled="true"></p:inputNumber>

									<!-- Bot�o para aumentar 1 (uma) unidade na quantidade de item -->
									<p:commandButton value="+" id="bt-dialog-mais-cesta"
										style="background-color:white"></p:commandButton>
								</div>
								<div class="btn-inserir-no-carrinho"
									style="display: inline-block; width: 100%; text-align: center;">
									<p:commandButton value="Colocar no carrinho"
										class="botao-colocar-no-carrinho"
										oncomplete="PF('dlgCesta').hide()"></p:commandButton>
								</div>

								<div class="fab" id="botaoAddProduto" style="display: none">
									<p:commandButton class="main-btn"
										onclick="PF('dlgProdutosParaSelecao').show()" value="" />
								</div>
							</h:form>
						</p:outputPanel>
					</p:dialog>
					<!-- fim dialog cesta selecionada________________________________________________________________ -->

				</h:form>
			</div>



			<!-- Sessao de cestas da semana_________________________________________________________________ -->

			<div class="separador"></div>
			<div class="separador"></div>


			<!-- 
			<div class="fundo-separador">
				<div class="sessao-produtos" id="produtos-mobile">
					<p:dataScroller value="#{produtoBean.produtos}" var="produto1"
						chunkSize="10" class="main__produtos">
						<f:facet name="header" class="titulo-produtos">
          			 			Produtos dispon�veis
        				</f:facet>
						<p:panelGrid columns="4">
							<h:graphicImage value="#{produto1.imagemnome}" width="60"
								height="60" />
							<p:outputPanel>
								<h:panelGrid columns="4" cellpadding="1"
									onclick="PF('dlgProduto').show(); capturarProdutoClicado(this)">
									<h:outputText value="#{produto1.descricao}"
										class="descricao-produto" />
									<h:outputLabel>R$</h:outputLabel>
									<h:outputText value="#{produto1.precoVenda}"
										style="font-weight: bold" class="preco-produto" />
									<span class="ui-inputgroup-addon"><i
										class="fa fa-shopping-cart"></i></span>
								</h:panelGrid>
							</p:outputPanel>
						</p:panelGrid>
					</p:dataScroller>
				</div>
			</div>

			<div class="fundo-separador-desktop">
				<div class="sessao-produtos-desktop" id="produtos-desktop">
					<h3>Produtos Extras</h3>
					<p:dataGrid value="#{produtoBean.produtos}" var="produto2"
						columns="4" rows="12">
						<p:column header="#{produto2.codigo}"
							class="coluna-desktop-produto">
							<p:panel class="quadrante-produto-desktop">
								<h:outputText value="#{produto2.descricao}"
									style="font-weight:bold" class="descricao-produto" />
								<h:panelGrid columns="1"
									onclick="capturarProdutoClicadoDesktop(this); PF('dlgProduto').show();">

									<h:graphicImage value="#{produto2.imagemnome}"
										alt="icone cesta"
										class="icone-imagens-cestas .centralizar-imagem imagem-tamanho-p" />
									<h:outputLabel value="#{produto2.informacoes}"
										style="display: inline-block; width: 100%; background-color: #4f5e38; height: 1em; color:white; padding:0.2em; overflow:auto"
										class="informacoes-nutricionais" />
									<div>
										<h:outputLabel value="R$:" />
										<h:outputText value="#{produto2.precoVenda}"
											class="preco-produto"
											style="font-size:1.5em; font-weight:bold" />
									</div>

								</h:panelGrid>
							</p:panel>


						</p:column>
					</p:dataGrid>
				</div>
			</div>

 -->









			<!-- PRODUTO EXTRA EM DATAVIEW NOVA SESSAO-->
			<div class="sessao_cestas">
				<h1>Produtos extras</h1>
				<p>Selecione os produtos extras para incrementar sua semana</p>
			</div>
			<!-- 			<div class="container-cesta-semana"> -->
			<!-- 				<h:form id="form-produto" prependId="false" -->
			<!-- 					enctype="multipart/form-data"> -->
			<%-- 					<p:dataView var="produto" value="#{produtoBean.produtos}" rows="3" --%>
			<!-- 						paginator="true" rowsPerPageTemplate="3,6,9" -->
			<!-- 						paginatorTemplate="{FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {RowsPerPageDropdown}" -->
			<!-- 						gridIcon="fa fa-th" listIcon="fa fa-th-list" -->
			<!-- 						style="width:95%; margin:auto; padding:0;"> -->


			<!-- 						<p:dataViewGridItem styleClass="viewGrid" class="viewCard"> -->
			<!-- 							<p:panel header="Produto Extra" style="text-align:center;"> -->

			<!-- 								<h:panelGrid columns="1" -->
			<!-- 									style="width:88%; border:1px solid #ccc; border-radius:10px; padding:0"> -->

			<%-- 									<h:graphicImage value="#{produto.imagemnome}" --%>
			<!-- 										class="icone-imagens-cestas .centralizar-imagem imagem-tamanho-p" /> -->
			<!-- 									<div style="display: grid"> -->
			<%-- 										<h:outputText value="#{produto.descricao}" --%>
			<!-- 											style="font-size:1.2em;" /> -->

			<!-- 										<hr></hr> -->

			<!-- 										<h:outputText value="" -->
			<!-- 											style="font-size:1em;text-transform: lowercase;" /> -->

			<%-- 										<h:outputText value="R$ #{produto.precoVenda}" --%>
			<!-- 											style="font-size:1.5em; font-weight:bold" /> -->
			<!-- 									</div> -->
			<!-- 									<p:commandButton update=":formCadastro" -->
			<!-- 										oncomplete="PF('dlgProduto').show()" title="Ver Detalhes" -->
			<!-- 										styleClass="btn-lista-de-itens" -->
			<%-- 										actionListener="#{produtoBean.selecionar}"> --%>
			<%-- 										<f:attribute name="produtoSelecionado" value="#{produto}" /> --%>
			<!-- 										<f:actionListener type="org.omnifaces.eventlistener.ResetInputAjaxActionListener" /> -->
			<!-- 									</p:commandButton> -->
			<!-- 								</h:panelGrid> -->
			<!-- 							</p:panel> -->
			<!-- 						</p:dataViewGridItem> -->


			<!-- 						<p:dataViewListItem> -->

			<!-- 							<h:panelGrid columns="2"> -->
			<!-- 								<h:panelGrid style="width:10%;"> -->
			<%-- 									<h:graphicImage value="#{produto.imagemnome}" --%>
			<!-- 										class="imagem-tamanho-p" /> -->

			<!-- 								</h:panelGrid> -->
			<!-- 								<h:panelGrid style="width:98%"> -->
			<%-- 									<h:outputText value="#{produto.descricao}" /> --%>

			<%-- 									<h:outputText value="R$ #{produto.precoVenda}" --%>
			<!-- 										style="font-size:1.2em; font-weight:bold;" /> -->
			<!-- 									<p:commandButton update=":formCadastro" -->
			<!-- 										oncomplete="PF('dlgProduto').show()" title="Detalhes" -->
			<!-- 										styleClass="btn-lista-de-itens" -->
			<%-- 										actionListener="#{produtoBean.selecionar}"> --%>
			<%-- 										<f:attribute name="produtoSelecionado" value="#{produto}" /> --%>
			<!-- 										<f:actionListener type="org.omnifaces.eventlistener.ResetInputAjaxActionListener" /> -->
			<!-- 									</p:commandButton> -->

			<!-- 								</h:panelGrid> -->
			<!-- 							</h:panelGrid> -->
			<!-- 						</p:dataViewListItem> -->

			<!-- 					</p:dataView> -->




			<!-- 					<p:dialog header="Produto - Cadastro" widgetVar="dialogo" -->
			<!-- 						draggable="false" resizable="false" modal="true" closable="false" -->
			<!-- 						closeOnEscape="true"> -->
			<!-- 						<h:form id="formCadastro" enctype="multipart/form-data" -->
			<!-- 							prependId="false"> -->
			<!-- 							<h:panelGrid columns="2"> -->
			<!-- 							<h:outputLabel value="Descri��o: " for="descricao" /> -->
			<!-- 							<p:inputText maxlength="33" size="38" id="descricao" -->
			<%-- 								required="true" rendered="true" value="#{produtoBean.produto.descricao}" /> --%>
			<!-- 								</h:panelGrid> -->
			<!-- 						</h:form> -->
			<!-- 					</p:dialog> -->





			<!-- 					DIALOG PRODUTO -->
			<!-- 					Sessao dialog produto selecionado -->
			<!-- 					<p:dialog header="Selecionado" widgetVar="dlgProduto" -->
			<!-- 						minimizable="true" minHeight="540" minWidth="480" modal="true" -->
			<!-- 						maximizable="true" id="dialog-produto" closeOnEscape="true" -->
			<!-- 						responsive="true" resizable="true" -->
			<!-- 						style="width: 100vw !important; z-index: 9000; margin:0; padding:0" -->
			<!-- 						position="top" fitViewport="true"> -->

			<!-- 						Formulario do produto selecionada -->
			<!-- 						<h:form prependId="false" id="formProduto" -->
			<!-- 							enctype="multipart/form-data"> -->
			<!-- 							<div class="centralizar-imagem"> -->

			<!-- 								Imagem do produto selecionado -->
			<!-- 								<img src="./resources/images/upload/azeite.png" -->
			<!-- 									alt="imagem do produto" -->
			<!-- 									class="centralizar-imagem imagem-tamanho-m" -->
			<!-- 									id="imagem-produto-dialog" /> -->
			<!-- 							</div> -->
			<!-- 							<div class="div-titulo-dialog" style="margin-bottom: 0.5em"> -->

			<!-- 								Informa��es do produto selecionado (Descri��o + qtd itens) -->
			<!-- 								<h:outputLabel style="padding:0.9em" class="descricao-produto" -->
			<!-- 									id="descricao-produto" value="Azeite 200ml Und"></h:outputLabel> -->

			<!-- 								Informa��es do produto selecionado (Pre�o com cifr�o o padr�o deve ser R$ 99,99) -->
			<!-- 								<h:outputLabel style="padding:0.9em;">R$</h:outputLabel> -->
			<!-- 								<h:outputLabel style="padding:0.9em;" id="preco-produto" -->
			<%-- 									value="#{produtoBean.produto.precoVenda} 1.00"></h:outputLabel> --%>

			<!-- 							</div> -->
			<!-- 							<div style="margin-bottom: 1em"> -->
			<!-- 								<h:outputText value="Especiais" -->
			<!-- 									style="padding:1em; font-size:0.9em" /> -->
			<!-- 								<div style="width: 90%; padding: 1em; text-align: left;"> -->
			<!-- 									<h:outputText -->
			<!-- 										value="Produtos 100% org�nicos. Cultivados sem agrot�xicos. Selecionados e com selo de qualidade" -->
			<!-- 										style="font-size:0.8em;" -->
			<!-- 										id="informacoes-nutricionais-dialog-produto" /> -->
			<!-- 								</div> -->

			<!-- 								Botao calcular frete desabilitado -->
			<!-- 								<p:commandButton value="" id="calcular-frete-produto" -->
			<!-- 									style="margin:1.2em 0 0.5em 1.5em; font-size:0.7em; font-weight:normal; background-color:white; display: none; width: 0; height: 0;"></p:commandButton> -->


			<!-- 								<div class="calcular-frete displaynone" -->
			<!-- 									id="div-calcular-frete-produto"> -->
			<!-- 									<p:selectOneMenu id="select-calcular-frete-produto" -->
			<!-- 										value="9.22" autoWidth="false"> -->
			<!-- 										<f:selectItem itemLabel="Selecione sua regi�o" -->
			<!-- 											noSelectionOption="true" style="width:1em"></f:selectItem> -->
			<!-- 										<f:selectItem itemLabel="Regi�o um" itemValue="9.00"></f:selectItem> -->
			<!-- 										<f:selectItem itemLabel="Regi�o dois" itemValue="9.20"></f:selectItem> -->
			<!-- 										<f:selectItem itemLabel="Regi�o tres" itemValue="9.15"></f:selectItem> -->
			<!-- 										<f:selectItems value="" itemLabel="" itemValue=""></f:selectItems> -->
			<!-- 									</p:selectOneMenu> -->
			<!-- 									<div style="padding: 0.5em 0 0.8em 0"> -->
			<!-- 										<p:outputLabel value="Frete R$ 9.15" id="label-frete-produto"></p:outputLabel> -->
			<!-- 									</div> -->
			<!-- 								</div> -->

			<!-- 							</div> -->

			<!-- 							<div -->
			<!-- 								style="display: inline-block; margin: auto; width: 100%; text-align: center"> -->

			<!-- 								Total (Soma do pre�o qtd de itens x pre�o de cada iten) -->
			<!-- 								<h:outputLabel style="padding:0.9em" value="Total R$"></h:outputLabel> -->
			<!-- 								<h:outputText value="12.90" -->
			<!-- 									style="font-weight: bold; padding:0.2em; font-size:1.3em" -->
			<!-- 									class="preco-produto" id="total-produto" /> -->

			<!-- 								Bot�o para diminuir 1 (uma) unidade na quantidade de item -->
			<!-- 								<p:commandButton value="-" id="bt-dialog-menos-produto" -->
			<!-- 									style="background-color:white"></p:commandButton> -->

			<!-- 								<p:inputNumber id="input-qtd-produto" value="1" minValue="1" -->
			<!-- 									maxValue="99" disabled="true"></p:inputNumber> -->

			<!-- 								Bot�o para aumentar 1 (uma) unidade na quantidade de item -->
			<!-- 								<p:commandButton value="+" id="bt-dialog-mais-produto" -->
			<!-- 									style="background-color:white"></p:commandButton> -->
			<!-- 							</div> -->
			<!-- 							<div -->
			<!-- 								style="display: inline-block; width: 100%; text-align: center; margin-bottom: 0.2em;"> -->
			<!-- 								<p:commandButton value="Colocar no carrinho" -->
			<!-- 									class="botao-colocar-no-carrinho" -->
			<!-- 									id="botao-colocar-produto-extra-no-carrinho" -->
			<!-- 									oncomplete="PF('dlgProduto').hide()"></p:commandButton> -->
			<!-- 							</div> -->
			<!-- 						</h:form> -->
			<!-- 					</p:dialog> -->
			<!-- 					fim dialog produto selecionado________________________________________________________________ -->

			<!-- 					fim dialog cesta selecionada________________________________________________________________ -->
			<!-- 				</h:form> -->
			<!-- 			</div> -->
























			<div class="separador"></div>

			<!-- Sessao sobre a empresa -->
			<div class="sessao-sobre" id="sobre">
				<h1>Sobre n�s</h1>
				<h4>Quem somos</h4>
				<div class="div-somos">
					<p class="p-texto-somos">
						Somos uma iniciativa que engloba um grupo de produtores parceiros
						(agricultores familiares locais), todos devidamente certificados
						no <strong>cultivo org�nico</strong> dos alimentos e fazemos a
						liga��o entre as lavouras e a sua mesa. Levando comida de verdade,
						<strong>livre de venenos</strong> para sua casa e ao mesmo tempo
						incentivando os pequenos produtores.
					</p>

					<div class="separador"></div>
				</div>
				<div id="galeria_mobile" style="width: 100%">
					<ui:insert name="galeria">
						<ui:include src="/pages/template/galeria_mobile.xhtml" />
					</ui:insert>
				</div>

				<div id="galeria_desktop" style="width: 100%">
					<ui:insert name="galeria">
						<ui:include src="/pages/template/galeria_desktop.xhtml" />
					</ui:insert>
				</div>
			</div>
			<!-- fim da sessao sobre a empresa________________________________________________________________ -->

			<div class="separador"></div>
			<div class="separador"></div>

			<!-- Sessao missao da empresa -->
			<div class="main" style="width: 80%; color: #4f5e38">
				<h1>Nossa Miss�o</h1>
				<p>
					Levar at� voc� toda semana op��es de <strong>produtos
						org�nicos</strong>, plantados e colhidos com todo carinho.
				</p>
				<div style="width: 30%; background-color: #d3eaac; height: 1em;"></div>
			</div>
			<!-- fim Sessao missao________________________________________________________________ -->

			<div class="separador"></div>
			<div class="separador"></div>

			<!-- Sessao de feedback -->
			<div class="sessao-feedbacks">
				<h1>O que nossos clientes dizem</h1>
				<h4>feedbacks</h4>
				<div class="container-feedback" id="feedback">
					<div class="container-card">
						<img src="./resources/images/icons/Clientes.jpg" alt="Avatar"
							style="width: 50px" />
						<h5>
							<b>Sheila Jbv</b>
						</h5>
						<q>Recomendo, excelentes produtos e atendimento excepcional.</q>
					</div>

					<div class="container-card">
						<img src="./resources/images/icons/Clientes.jpg" alt="Avatar"
							style="width: 50px" />
						<h5>
							<b>Viviane Paganini Polido</b>
						</h5>
						<q>Org�nicos de qualidade e �timas variedades.</q>
					</div>

					<div class="container-card">
						<img src="./resources/images/icons/Clientes.jpg" alt="Avatar"
							style="width: 50px" />
						<h5>
							<b>Nath�lia Netto</b>
						</h5>
						<q>Muito bom, adorei em todos os sentidos. Higiene,
							organiza��o, fresquinhos e pre�o justo.</q>
					</div>

					<div class="container-card">
						<img src="./resources/images/icons/Clientes.jpg" alt="Avatar"
							style="width: 50px" />
						<h5>
							<b>Liliane Senra</b>
						</h5>
						<q>�timos produtos, excelente qualidade e um �timo
							atendimento!</q>
					</div>

				</div>
			</div>
			<!-- fim Sessao de feedbacks________________________________________________________________ -->

			<div class="separador"></div>
			<div class="separador"></div>



			<!--  contato section goes here -->
			<!-- Rodape buscando base template -->
			<div id="contato" class="background-formulario-contato">
				<ui:insert name="contato">
					<ui:include src="/pages/template/contato.xhtml" />
				</ui:insert>
			</div>


		</div>
	</h:form>







	<!-- 

	<p:dialog header="Selecionado" widgetVar="dlgProduto"
		minimizable="true" minHeight="540" minWidth="480" modal="true"
		maximizable="true" id="dialog-produto" closeOnEscape="true"
		responsive="true" resizable="true"
		style="width: 100vw !important; z-index: 9000; margin:0; padding:0"
		position="top" fitViewport="true">

		Formulario do produto selecionada
		<h:form prependId="false" id="formProduto">
			<div class="centralizar-imagem">

				Imagem do produto selecionado
				<img src="./resources/images/upload/azeite.png"
					alt="imagem do produto" class="centralizar-imagem imagem-tamanho-m"
					id="imagem-produto-dialog" />
			</div>
			<div class="div-titulo-dialog" style="margin-bottom: 0.5em">

				Informa��es do produto selecionado (Descri��o + qtd itens)
				<h:outputLabel style="padding:0.9em" class="descricao-produto"
					id="descricao-produto" value="Azeite 200ml Und"></h:outputLabel>

				Informa��es do produto selecionado (Pre�o com cifr�o o padr�o deve ser R$ 99,99)
				<h:outputLabel style="padding:0.9em;">R$</h:outputLabel>
				<h:outputLabel style="padding:0.9em;" id="preco-produto"
					value="12.90"></h:outputLabel>

			</div>
			<div style="margin-bottom: 1em">
				<h:outputText value="Especiais" style="padding:1em; font-size:0.9em" />
				<div style="width: 90%; padding: 1em; text-align: left;">
					<h:outputText
						value="Produtos 100% org�nicos. Cultivados sem agrot�xicos. Selecionados e com selo de qualidade"
						style="font-size:0.8em;"
						id="informacoes-nutricionais-dialog-produto" />
				</div>

				Botao calcular frete desabilitado
				<p:commandButton value="" id="calcular-frete-produto"
					style="margin:1.2em 0 0.5em 1.5em; font-size:0.7em; font-weight:normal; background-color:white; display: none; width: 0; height: 0;"></p:commandButton>


				<div class="calcular-frete displaynone"
					id="div-calcular-frete-produto">
					<p:selectOneMenu id="select-calcular-frete-produto" value="9.22"
						autoWidth="false">
						<f:selectItem itemLabel="Selecione sua regi�o"
							noSelectionOption="true" style="width:1em"></f:selectItem>
						<f:selectItem itemLabel="Regi�o um" itemValue="9.00"></f:selectItem>
						<f:selectItem itemLabel="Regi�o dois" itemValue="9.20"></f:selectItem>
						<f:selectItem itemLabel="Regi�o tres" itemValue="9.15"></f:selectItem>
						<f:selectItems value="" itemLabel="" itemValue=""></f:selectItems>
					</p:selectOneMenu>
					<div style="padding: 0.5em 0 0.8em 0">
						<p:outputLabel value="Frete R$ 9.15" id="label-frete-produto"></p:outputLabel>
					</div>
				</div>

			</div>

			<div
				style="display: inline-block; margin: auto; width: 100%; text-align: center">

				Total (Soma do pre�o qtd de itens x pre�o de cada iten)
				<h:outputLabel style="padding:0.9em" value="Total R$"></h:outputLabel>
				<h:outputText value="12.90"
					style="font-weight: bold; padding:0.2em; font-size:1.3em"
					class="preco-produto" id="total-produto" />

				Bot�o para diminuir 1 (uma) unidade na quantidade de item
				<p:commandButton value="-" id="bt-dialog-menos-produto"
					style="background-color:white"></p:commandButton>

				<p:inputNumber id="input-qtd-produto" value="1" minValue="1"
					maxValue="99" disabled="true"></p:inputNumber>

				Bot�o para aumentar 1 (uma) unidade na quantidade de item
				<p:commandButton value="+" id="bt-dialog-mais-produto"
					style="background-color:white"></p:commandButton>
			</div>
			<div
				style="display: inline-block; width: 100%; text-align: center; margin-bottom: 0.2em;">
				<p:commandButton value="Colocar no carrinho"
					class="botao-colocar-no-carrinho"
					id="botao-colocar-produto-extra-no-carrinho"
					oncomplete="PF('dlgProduto').hide()"></p:commandButton>
			</div>
		</h:form>
	</p:dialog>




 -->



	<!-- dialog lista de produtos adicionais para sele��o________________________________________________________________ -->
	<p:dialog header="Selecione" widgetVar="dlgProdutosParaSelecao"
		minimizable="true" minHeight="540" minWidth="480" modal="true"
		maximizable="true" id="dialogListaProdutosParaSelecao"
		closeOnEscape="true" responsive="true" resizable="true"
		style="width: 100vw !important; z-index: 9000; margin:0; padding:0"
		position="top" fitViewport="true">

		<!-- Formulario da cesta selecionada -->
		<h:form prependId="false" id="formProdutosSelecao"
			enctype="multipart/form-data">
			<div class="div-titulo-dialog">

				<!-- Informa��es da cesta selecionada (Descri��o + qtd itens) -->
				<h:outputLabel style="padding:0.9em"
					id="label-produto-selecao-descricao">Produto que voc� deseja adicionar</h:outputLabel>


			</div>
			<div style="margin-bottom: 1em">
				<p:dataScroller value="#{cestaBean.produtos}" var="Produtos"
					chunkSize="10" class="main__produtos" id="data-produtos-selecao">
					<p:panelGrid columns="3">
						<i class="fa fa-product-hunt"></i>
						<p:outputPanel>
							<h:panelGrid columns="4" cellpadding="10"
								onclick="PF('dlgProdutosParaSelecao').hide()">

								<!-- Informa��es dos produtos da cesta (Descri��o) -->
								<h:outputText value="#{Produtos.descricao}"
									class="descricao-produto" id="lista-produtos-para-selecao" />

								<h:outputText class="multiplicador" style="display: none"
									value="1" />

								<!-- Icone para alterar o produto da cesta -->
								<i class="fa fa-plus" style="padding-left: 3em;"></i>


							</h:panelGrid>
						</p:outputPanel>
					</p:panelGrid>
				</p:dataScroller>
			</div>
		</h:form>
	</p:dialog>
	<!-- fim dialog lista de produtos para sele��o________________________________________________________________ -->








	<!-- Rodape buscando base template -->
	<div id="footer">
		<ui:insert name="footer">
			<ui:include src="/pages/template/footer.xhtml" />
		</ui:insert>
	</div>

	<!-- Recurso java script adicionado comentario -->
	<script src="./resources/js/dadosLoginUsuario.js"></script>
	<script src="./resources/js/app.js"></script>
	<script src="./resources/js/dialogIndex.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


</h:body>

</html>