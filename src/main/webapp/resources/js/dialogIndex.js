var qtdAlteracoesPermitidas = 2;
var qtdProdutosRetirados = 0;
var alerta = document.querySelector("#dialogCestaAlerta");


function capturarProdutosDaLista() {
    var lista = document.querySelector("#produtosList");
    var arr = lista.querySelectorAll("li .remove-icon");
    var i = 0;
    while (arr[i]) {
	arr[i].addEventListener('click', remover);
	console.log(i);
	i++;
    }
}

function remover(e) {
    var item = e.path[10];
    var saldoRetiradas = somarMultiplicador(item);

    item.parentNode.removeChild(item);
    
    botao.style.display = 'block';
    let _lista = document.querySelector("#produtosList");
    let _iconesRemover = _lista.querySelectorAll("li .remove-icon");
    
    if (qtdProdutosRetirados == qtdAlteracoesPermitidas) {
	for (var indice = 0; indice < _iconesRemover.length; indice++) {
	    _iconesRemover[indice].style.visibility = "hidden";
	}
	alerta.style.display = 'block';
    }
};
var botao = document.querySelector("#botaoAddProduto");
var multiplicador = 0;

function somarMultiplicador(_item) {
    var pesoMultiplicador = _item.querySelector('.multiplicador').textContent;
    multiplicador = multiplicador + parseInt(pesoMultiplicador);
    console.log('multiplicador = ', multiplicador);
    
    qtdProdutosRetirados = qtdProdutosRetirados + 1;
}

function ocultarIconRemove(icons) {
    icons.style.display = 'none';
}

function fecharAlerta() {
    alerta.style.display = 'none';
}