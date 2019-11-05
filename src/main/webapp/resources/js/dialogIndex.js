var qtdAlteracoesPermitidas = 8;
var qtdProdutosRetirados = 0;
var qtdProdutosInseridos = 0;
var alerta = document.querySelector("#dialogCestaAlerta");
var lista = document.querySelector("#produtosList ul");
var $precoCesta = document.getElementById("preco-cesta");
var $precoCesta = document.getElementById("preco-cesta");

var botaoColocarNoCarrinho = document
	.querySelector(".botao-colocar-no-carrinho");

/*
 * Coloca um evento listener de click em cada produto da lista de produtos da
 * cesta selecionada Para identificar qual produto o usuário deseja retirar da
 * cesta e efetuar a troca
 */
//Funcao executada ao abrir o dialog de cesta clicada
function capturarProdutosDaLista() {
    var arr = lista.querySelectorAll("li");
    var i = 0;
    //Se a cesta tiver itens ocultar o botao adicionar itens, para que o usuario exclua um item para poder adicionar outro
    if(arr.length >0){
    while (arr[i]) {
	arr[i].addEventListener('click', remover);
	i++;
    }
    }else{
	//Se a lista for vazia, exibir o botao para adicionar produtos a cesta
	botao.style.display = 'block';
    }
}

// Identifica qual produto o usuario clicou e deseja remover
function remover(e) {
    var item = e.currentTarget;
    var saldoRetiradas = somarMultiplicador(item);

    // remove o produto clicado
    item.parentNode.removeChild(item);

    // adiciona o botao add para o usuário clicar e inserir um novo produto
    botao.style.display = 'block';
    let _lista = document.querySelector("#produtosList");
    let _iconesRemover = _lista.querySelectorAll("li .remove-icon");
    var arr = lista.querySelectorAll("li");

    /*
     * verifica a quantidade de alterações o usuário já realizou se for igual a
     * quantidade limite remove o evento remover e limita novas alterações
     */
    if (qtdProdutosRetirados == qtdAlteracoesPermitidas) {
	for (var indice = 0; indice < _iconesRemover.length; indice++) {
	    _iconesRemover[indice].style.visibility = "hidden";
	    arr[indice].removeEventListener('click', remover);
	}
    }
};

var botao = document.querySelector("#botaoAddProduto");
var multiplicador = 0;

/*
 * Funcao para somar o multiplicador, pois deve-se aplicar um filtro para a
 * lista de novos itens adicionais baseado no multiplicador, ou seja o usuário
 * só pode visualizar os produtos adicionais para seleção se o multiplicador for
 * igual ou menor que o número desta variável
 */
function somarMultiplicador(_item) {
    var pesoMultiplicador = _item.querySelector('.multiplicador').textContent;
    multiplicador = multiplicador + parseInt(pesoMultiplicador);
    qtdProdutosRetirados = qtdProdutosRetirados + 1;
}

// Ocultar o icone x (Remover) da lista de produtos
function ocultarIconRemove(icons) {
    icons.style.display = 'none';
}

// Fechar a mensagem do dialog cesta
function fecharAlerta() {
    alerta.style.display = 'none';
}

// Capturar produto da lista de adicionais e adicionar na cesta que está
// personalizando
function capturarProdudoAdicional(e) {
    if (qtdProdutosInseridos < qtdAlteracoesPermitidas
	    && qtdProdutosInseridos < qtdProdutosRetirados) {
	// remover o evento click dos produtos adicionais, o qual é responsável
	// por adicionar os itens na cesta
	e.currentTarget.removeEventListener('click', capturarProdudoAdicional);
	// Adicionar o item clicado na lista de produtos da cesta
	lista.appendChild(e.currentTarget);
	// Somar um valor na variável de quantidade de produtos inseridos
	qtdProdutosInseridos = qtdProdutosInseridos + 1;
	// verificar se a quantidade de produtos inseridos está dentro do limite
	// de alterações permitidas
	if (qtdProdutosInseridos == qtdAlteracoesPermitidas) {
	    botao.style.display = 'none';
	    alerta.style.display = 'block';
	}
    } else {
	botao.style.display = 'none';
	alerta.style.display = 'block';
    }
}

var dataProdutosSelecao = document.querySelector("#data-produtos-selecao");

// Adicionar o evento listener para cada item da lista de produtos adicionais
function load() {
    const itens = dataProdutosSelecao.querySelectorAll(".ui-datascroller-item");
    let ne = 0;
    while (itens[ne]) {
	itens[ne].addEventListener('click', capturarProdudoAdicional);
	ne++;
    }
}
load();

// ----Adicionar cesta ao carrinho---------------------------
var arrayDeProdutosDaCesta = [];
botaoColocarNoCarrinho
	.addEventListener(
		'click',
		function colocaNoCarrinho() {
		    arrayDeProdutosDaCesta = [];
		    var totalCesta = document.querySelector("#total-cesta").textContent;
		    let listaDeProdutosParaCarrinho = lista
			    .querySelectorAll('li .descricao-produto');
		    let descricaoDaCestaSelecionada = document
			    .querySelector('.div-titulo-dialog #label-cesta-descricao').textContent;
		    let quantidadeDeCestas = document
			    .querySelector('#input-qtd-cesta_input').value;

		    indice = 0;
		    while (listaDeProdutosParaCarrinho[indice]) {
			arrayDeProdutosDaCesta
				.push(listaDeProdutosParaCarrinho[indice].textContent);
			indice++;
		    }
		    var _cesta = new cesta(descricaoDaCestaSelecionada,
			    arrayDeProdutosDaCesta, totalCesta,
			    quantidadeDeCestas);
		    adicionarProdutoNaCesta(_cesta);
		});

var listaDePedidos = [];
function adicionarProdutoNaCesta(_cesta) {
    listaDePedidos.push(_cesta);
    salvarEmLocalStored(listaDePedidos);
    notificar('Cesta adicionada');
}

function cesta(titulo, produtos, preco, qtd) {
    this._titulo = titulo;
    this._produtos = produtos;
    this._preco = preco;
    this._qtd = qtd
}
// -----------------------------------------

// Adicionar produto em pedidos
/*
 * descricao quantidade preco unitario botao colocar no carrinho
 */
var $descricaoDoProduto = document.querySelector('#descricao-produto');
var $quantidadeDeProdutoExtra = document
	.querySelector('#input-qtd-produto_input');
var $precoTotal = document.querySelector('#total-produto');
var btnColocarProdutoExtraNoCarrinho = document
	.querySelector('#botao-colocar-produto-extra-no-carrinho');
var $precoProduto = document.getElementById("preco-produto");
var $imagemDoProdutoNoDialog = document.getElementById("imagem-produto-dialog");
var $totalProdutoDialog = document.getElementById("total-produto");

btnColocarProdutoExtraNoCarrinho.addEventListener('click',
	addProdutoExtraNoCarrinho);

function addProdutoExtraNoCarrinho() {
    let criarProduto = new produto($descricaoDoProduto.textContent,
	    $precoTotal.textContent, $quantidadeDeProdutoExtra.value);
    listaDePedidos.push(criarProduto);
    salvarEmLocalStored(listaDePedidos);
    notificar('Produto adicionado');
}

function produto(descricao, precoTotal, qtd) {
    this._titulo = descricao;
    this._preco = precoTotal;
    this._qtd = qtd;
    this._produtos = new Array(descricao);
}

function capturarProdutoClicado(a) {
    let produtoClicado = a.parentNode.parentNode.parentNode;
    let imagemProdutoClicado = produtoClicado.querySelector('img');
    let descricaoProdutoClicado = produtoClicado.querySelector('.descricao-produto');
    let precoProdutoClicado = produtoClicado.querySelector('.preco-produto');

    // popular o dialog com os dados do produto clicado
    $descricaoDoProduto.textContent = descricaoProdutoClicado.textContent;
    $precoProduto.textContent = precoProdutoClicado.textContent;
    $imagemDoProdutoNoDialog.src = imagemProdutoClicado.src;
    $totalProdutoDialog.textContent = precoProdutoClicado.textContent;
    $quantidadeDeProdutoExtra.value = 1;
}

function capturarProdutoClicadoDesktop(a) {
    let produtoClicado = a.parentNode;

    let imagemProdutoClicado = produtoClicado.querySelector('img');
    let descricaoProdutoClicado = produtoClicado.querySelector('.descricao-produto');
    let precoProdutoClicado = produtoClicado.querySelector('.preco-produto');

    // popular o dialog com os dados do produto clicado
    $descricaoDoProduto.textContent = descricaoProdutoClicado.textContent;
    $precoProduto.textContent = precoProdutoClicado.textContent;
    $imagemDoProdutoNoDialog.src = imagemProdutoClicado.src;
    $totalProdutoDialog.textContent = precoProdutoClicado.textContent;
    $quantidadeDeProdutoExtra.value = 1;
  
}

function notificar(mensagem) {
    swal("Obrigado!", mensagem, "success");
}


function salvarEmLocalStored(item) {
    let _item = JSON.stringify(item);
    localStorage.setItem('Pedidos', _item);
}
