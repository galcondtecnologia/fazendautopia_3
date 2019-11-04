
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
function lerPedidosEmLocalStarage() {
    let localStoragePedidos = localStorage.getItem('Pedidos');
    localStoragePedidos = JSON.parse(localStoragePedidos);
    listaDePedidos.push(localStoragePedidos);
    criarCard(listaDePedidos);
}

var listaDePedidos = [];
var listaNaPagina = document.querySelector('#div-pedido');

function criarCard(listaDePedidos) {
    if(listaDePedidos == ''){
	console.log('Carrinho vazio :(')
    }else{
    for(var indice = 0; indice<listaDePedidos[0].length; indice++){
	let _titulo = criarTitulo(listaDePedidos.map(e => e[indice]._titulo), listaDePedidos.map(e =>e[indice]._preco));
	let _produtosList = criarListaDeItens(listaDePedidos.map(e =>e[indice]._produtos));
	let _rodapeHtml = criarRodape(listaDePedidos.map(e =>e[indice]._qtd));
	listaNaPagina.innerHTML = listaNaPagina.innerHTML + _titulo + _produtosList.innerHTML + _rodapeHtml;
    }
}
}


function criarTitulo(descricao, preco) {
    var titulo =  `<div class="card" style="width: 100%;">
    <div class="card-body">
    <h4 class="card-title descricao-titulo">${descricao}</h4>
    <h5 class="card-text preco-do-item">R$ ${preco}</h5>
    </div>`
    return titulo;
}


// adicionar li para cada item da cesta
function criarListaDeItens(listaDeProdutos) {
    let lista = listaDeProdutos[0];
    let ul = criarUl();
    for (var qtdItem = 0; qtdItem < lista.length; qtdItem++) {
	let li = criarLi();
	li.textContent = lista[qtdItem];
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


function criarRodape(_qtd) {
   var rodape = `<div class="card-body"><input type="button" value="Excluir" class="btn-excluir"><input type="button" value="-"style="width:40px"/><input type="number" value="${_qtd}" class="btn-menos" style="width:40px; text-align: center"/><input type="button" value="+" class="btn-mais" style="width:40px"/></div></div>`
       return rodape;
}
lerPedidosEmLocalStarage();


