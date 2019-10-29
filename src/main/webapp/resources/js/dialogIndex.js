function capturarProdutosDaLista(){
    var lista = document.querySelector("#produtosList");
    var arr = lista.querySelectorAll("li .remove-icon");
    var i = 0;
    while(arr[i]){
	arr[i].addEventListener('click', remover);
	console.log(i);
	i++;
    }
}

function remover(e) {
    var item = e.path[10];
    somarMultiplicador(item);
    console.log(item);
    item.parentNode.removeChild(item);
    botao.style.display='block';

};
var botao = document.querySelector("#botaoAddProduto");
var multiplicador = 0;

function somarMultiplicador(_item) {
    var pesoMultiplicador = _item.querySelector('.multiplicador').textContent;
    multiplicador = multiplicador + parseInt(pesoMultiplicador);
    console.log('multiplicador = ',multiplicador);
}