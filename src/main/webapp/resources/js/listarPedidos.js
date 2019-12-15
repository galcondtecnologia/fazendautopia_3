
/*

 <div class="card" style="width: 100%;">
 <div class="card-body">
 <h5 class="card-title descricao-titulo">Cesta Mini 6 produtos</h5>
 <p class="card-text preco-do-item">R$ 50.91</p>
 </div>
 <ul class="list-group list-group-flush">
 <li class="list-group-item">Banana</li>
 <li class="list-group-item">Alface</li>
 <li class="list-group-item">Ovos</li>
 </ul>
 <div class="card-body">
 <p:commandButton value="Excluir" class="btn-excluir"></p:commandButton>
 <p:commandButton value="-"/><p:inputNumber size="5" value="1" decimalPlaces="0" class="btn-menos"/><p:commandButton value="+" class="btn-mais"/>
 </div>
 </div>

 */
var $enderecoDoUsuario = document.querySelector("#endereco-do-usuario");
var $ecobag = document.querySelector("#check-ecobag");
var divCards = document.querySelector("#div-pedido");
var divCarrinhoVazio = document.querySelector("#carrinho-vazio");
var formularioPedido = document.querySelector("#formulario");
var scrCarrinhoVazio = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPQAAAExCAMAAAB8o39/AAAC+lBMVEXJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJycnJyckDLunJAAAA/XRSTlMAAQIDBAUGBwgJCgsMDQ4PEBESExQVFhcYGRobHB0eHyAhIiMkJSYnKCkqKywtLi8wMTIzNDU2Nzg5Ojs8PT4/QEFCQ0RFRkdISUpLTE1OT1BRUlNU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';
var taxaCartao = 0;
var precoTotalEmPedido = 0;

function lerPedidosEmLocalStarage() {
    let localStoragePedidos = localStorage.getItem('Pedidos');
    localStoragePedidos = JSON.parse(localStoragePedidos);
    listaDePedidos.push(localStoragePedidos);
    criarCard(listaDePedidos);
    lerEnderecoLocalStarage();
    qtdDeComprasAdicionarEcobag();
    calcularValorTotal(listaDePedidos);
}

function lerEnderecoLocalStarage() {
    let enderecoStoragePedidos = localStorage.getItem('Endereco');
    enderecoStoragePedidos = JSON.parse(enderecoStoragePedidos);
    atribuirEnderecoEfrete(enderecoStoragePedidos.frete, enderecoStoragePedidos.nome, enderecoStoragePedidos.enderecoEntrega);
}


function atualizarPrecoTotal() {
    let localStoragePedidos = localStorage.getItem('Pedidos');
    localStoragePedidos = JSON.parse(localStoragePedidos);
    listaDePedidos.push(localStoragePedidos);
    calcularValorTotal(listaDePedidos);
}

var listaDePedidos = [];
var listaNaPagina = document.querySelector('#div-pedido');

function criarCard(listaDePedidos) {
    if(listaDePedidos == ''){
	carrinhoVazio();
    }else{
    for(var indice = 0; indice<listaDePedidos[0].length; indice++){
	let _titulo = criarTitulo(listaDePedidos.map(e => e[indice]._titulo), listaDePedidos.map(e =>e[indice]._preco),indice, listaDePedidos.map(e =>e[indice]._cod),indice);
	let _produtosList = criarListaDeItens(listaDePedidos.map(e =>e[indice]._produtos),indice);
	let _rodapeHtml = criarRodape(listaDePedidos.map(e =>e[indice]._qtd),indice);
	listaNaPagina.innerHTML = listaNaPagina.innerHTML + _titulo + _produtosList.innerHTML + _rodapeHtml;
    }
}
    addListenerNaLista();
}


function criarTitulo(descricao, preco, indice, codigoItem) {
    var titulo =  `<div class="card" style="width: 100%;"><input type="hidden" class="input-codigoItem" value="${codigoItem}">
    <div class="card-body">
    <input type="text" class="card-title descricao-titulo" readonly="readonly" value="${descricao}" name="produtodescricao${indice}"></input>
    <input class="card-text preco-do-item" readonly="readonly" value="R$ ${preco}" name="produtopreco${indice}"></input>
    </div>`
    return titulo;
}


// adicionar li para cada item da cesta
function criarListaDeItens(listaDeProdutos, indice) {
    let lista = listaDeProdutos[0];
    let ul = criarUl();
    for (var qtdItem = 0; qtdItem < lista.length; qtdItem++) {
	let li = criarLi();
	// li.textContent = lista[qtdItem];
	// -----------
	
	li.innerHTML = `<input type="text" class="itensDaLista" readonly="readonly" value="${lista[qtdItem]}" name="produto${indice}item${qtdItem}"></input>`
	
	// -----------
	ul.appendChild(li);
    }
    return ul;
}

function criarUl() {
    let ul = document.createElement('ul');
    ul.classList.toggle('list-group');
    ul.classList.toggle('list-group-flush');
    return ul;
}

function criarLi() {
    let li = document.createElement('li');
    li.classList.toggle('list-group-item');
    return li;
}


function criarRodape(_qtd, indice) {
   var rodape = `<div class="card-body"><input type="button" value="Excluir" class="btn-excluir">
   <input type="button" value="-"style="width:40px" class="btn-menos"/><input type="number" 
   value="${_qtd}" readonly="readonly" class="input-qtd" style="width:40px; text-align: center" max="36" name="qtdItem${indice}"/>
   <input type="button" value="+" class="btn-mais" style="width:40px"/></div></div>`
       return rodape;
}


function addListenerNaLista(){
   let cards = document.querySelectorAll('.card');
   let indice = 0;
   while(cards[indice]){
       
       let btnMais = cards[indice].querySelector('.btn-mais');
       let btnMenos = cards[indice].querySelector('.btn-menos');
       let btnExcluir = cards[indice].querySelector('.btn-excluir');
       
       btnExcluir.addEventListener('click', excluirItem);
       btnMais.addEventListener('click', somarMaisUm);
       btnMenos.addEventListener('click', diminuirUm);
       
       indice++;
   }
}


function somarMaisUm(e) {
    // Capturar todos os cards da lista
    let cards = divCards.querySelectorAll('.card');
    // Criar um array iteravel do array, pegando cada card
    let cardList = [...cards];
    
    // Identificar onde foi clicado
    let btn = e.target;
    // Identificar o card a ser alterado
    let card = btn.offsetParent;
    // Capturar o input campo que possui o valor de quantidade
    let inputQtd = card.querySelector('.input-qtd');
    // Atribuir o valor do campo input quantidade, somando mais 1 por ter
    // clicado no botao +
    inputQtd.value = parseInt(inputQtd.value)+1
    
    // Identificar qual é o indice do card na lista
    let indice = cardList.indexOf(card);
    
    // Capturar o codigo do item
    let codigoItem = card.querySelector('.input-codigoItem');
    
    // ------------------
    // Alterar a lista a quantidade do item no localStored
    listaDePedidos[0][indice]._qtd = inputQtd.value
    alterarPedidoEmLocalStarage(listaDePedidos[0]);
    alterarQuantidadeDeItensNoBanco(inputQtd.value, codigoItem, listaDePedidos[0]);
    atualizarPrecoTotal();
}

function diminuirUm(e) {
    let cards = divCards.querySelectorAll('.card');
    let cardList = [...cards];
    
    let btn = e.target;
    let card = btn.offsetParent;
    let inputQtd = card.querySelector('.input-qtd');
    if(inputQtd.value ==1){
	inputQtd.value = 1;
    }else{
	inputQtd.value = parseInt(inputQtd.value)-1
    }
    
    let indice = cardList.indexOf(card);

    // --------------------
    listaDePedidos[0][indice]._qtd = inputQtd.value
    alterarPedidoEmLocalStarage(listaDePedidos[0]);
    
    // -------------------Atualizar no banco a quantidade de item
    let codigoItem = card.querySelector('.input-codigoItem');
    alterarQuantidadeDeItensNoBanco(inputQtd.value, codigoItem, listaDePedidos[0]);
    
    
    atualizarPrecoTotal();
}

function excluirItem(e) {
    let cards = divCards.querySelectorAll('.card');
    let btn = e.target;
    let card = btn.offsetParent;
    let cardList = [...cards];
    let indice = cardList.indexOf(card);
   
    listaDePedidos[0].splice(indice,1);
    alterarPedidoEmLocalStarage(listaDePedidos[0]);
    
    let codigoItem = card.querySelector('.input-codigoItem');

    excluirItemNoBanco(codigoItem, listaDePedidos[0]);
    
    card.remove(card);
    if(listaDePedidos[0] == ''){
	carrinhoVazio();
    }
    atualizarPrecoTotal();
}


// Função que salva os dados alterados no local stored
function alterarPedidoEmLocalStarage(novaLista) {
    let _novaLista = JSON.stringify(novaLista);
    localStorage.setItem('Pedidos', _novaLista);
}


function carrinhoVazio() {
    formularioPedido.classList.toggle("displayNone");
    divCarrinhoVazio.innerHTML = `
    <div class="container" style="text-align: center">
    <img src=${scrCarrinhoVazio} alt="carrinho vazio" style="padding:2em; margin:auto">
    <h3>Carrinho vazio</h3><a href="../index.xhtml"><input type="button" value="Voltar às compras"
     style="margin:1em;border-radius:15px; border:none; padding:0.9em;
      background-color:#4f5e38; color:white"></a></div>`
}


function calcularValorTotal(listaDePedidos) {
    ecobag = document.querySelector("#check-ecobag");
    let frete = document.querySelector('#valor-frete');
    let total = document.querySelector('#valor-total-pedido');
    let soma = 0;
    let subtotal = 0;
    let lista = [...listaDePedidos[0]]
    for(let produto of lista){
    let preco = parseFloat(produto._preco);
    let qtd = parseFloat(produto._qtd);
    subtotal = preco * qtd;
    soma = subtotal + soma;
    }
    // -----------------------
    frete = parseFloat(frete.textContent);
    soma = soma + frete;
    
    // ---Verificar o calculo ao retirar a cesta
    if(ecobag.checked){
	soma = soma + 6;
    }
    // ---------------------------------------------------------
    total.value = soma.toFixed(2);
    precoTotalEmPedido = total.value;
    
    // Calcular a taxa de cartão de credito
    if(taxaCartao != 0){
	verificarTaxa(taxaCartao);	
    }
    // location.reload();
}

$ecobag.addEventListener('click', function() {
    atualizarPrecoTotal();
})

function atribuirEnderecoEfrete(frete = 0, nome, endereco) {
    let _frete = document.querySelector('#valor-frete');
    let _nome = document.querySelector('#nome');
    $enderecoDoUsuario.value = endereco;
    _frete.textContent = frete; 
    _nome.value = nome;
}



function verificarTaxa(taxa) {
    taxaCartao = taxa;
    let _taxa = taxa.split(',');
    let label = document.querySelector("#taxa-cartao");
    let total = document.querySelector('#valor-total-pedido');
    _taxa[1] = _taxa[1].trim();
    let taxaEmReais = (parseFloat(precoTotalEmPedido) * parseFloat(_taxa[1])) / 100;
    let totalCtaxa = (parseFloat(precoTotalEmPedido) + parseFloat(taxaEmReais));
    label.textContent = `Taxa: ${_taxa[1]}% R$ ${taxaEmReais.toFixed(2)}`;
    total.value = totalCtaxa.toFixed(2);
}



function qtdDeComprasAdicionarEcobag() {
    let qtdCompras = localStorage.getItem('QtdCompras');
    if(qtdCompras == 0){
	$ecobag.checked = true;	
    }
}




lerPedidosEmLocalStarage();





function alterarQuantidadeDeItensNoBanco(qtd, codigoItem, listaDeItens){
    alert("Chamou a função atualizar o codigo no banco: " + qtd + " "+ codigoItem.value);
   console.log(listaDeItens);
   let  codigo = parseInt(codigoItem.value);
   
   let itemToSave = {};
   for(let item of [...listaDeItens]){
       if(item._cod == codigo){
	   itemToSave = item;
       }
   }
   
   console.log(itemToSave);
   
   
	  itemToSave = JSON.stringify(itemToSave);

	    fetch(`http://localhost:8080/fazendautopia/rest/item/${codigo}`, {
		    method: 'PUT',
		    body: itemToSave
		  })
		    .then(function (response) {
		     return response.json();
		    }).then(function (response){
			alert('Resposta de sucesso do servidor: ' + JSON.stringify(response));
		    });

}



function excluirItemNoBanco(codigoItem, listaDeItens){
    alert("Chamou a função atualizar o codigo no banco: " + codigoItem.value);
   console.log(listaDeItens);
   let  codigo = parseInt(codigoItem.value);
   
   let itemToDel = {};
   for(let item of [...listaDeItens]){
       if(item._cod == codigo){
	   itemToDel = item;
       }
   }
   
   console.log(itemToDel);
   
   
   itemToDel = JSON.stringify(itemToDel);

	    fetch(`http://localhost:8080/fazendautopia/rest/item/${codigo}`, {
		    method: 'DELETE',
		    body: codigo
		  })
		    .then(function (response) {
		     return response.json();
		    }).then(function (response){
			alert('Resposta de sucesso do servidor: ' + JSON.stringify(response));
		    });

}


