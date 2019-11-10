/**
 * 
 */
var $sessao1 = document.getElementById("sessao1");
var $sessao2 = document.getElementById("sessao2");
var $sessaoNotice = document.getElementById("avise-me");
var $regiao = document.getElementById("regioes_label");
var $cep = document.getElementById("cep_input");
var $cidade = document.getElementById("cidade");
var $rua = document.getElementById("rua");
var $bairro = document.getElementById("bairro");
var $uf = document.getElementById("uf_label");
var $numero = document.getElementById("numero");
var $nome = document.getElementById("nome");
var $telefone = document.getElementById("telefone_input");

function proximoOuVoltar() {
    $sessao1.classList.toggle("displaynone");
    $sessao2.classList.toggle("displaynone");
}

function mostrarCheckBox() {
    if ($regiao.textContent == 'Nenhuma anterior') {
	$sessaoNotice.classList.remove("displaynone");
    } else {
	$sessaoNotice.classList.add("displaynone");
    }
}

var requisicao = new XMLHttpRequest();
function buscarCep(cep) {
    requisicao.open("GET", "https://viacep.com.br/ws/" + cep + "/json/");
    requisicao.send(null);
    requisicao.onreadystatechange = retornarEndereco;
}

function retornarEndereco() {
    if (requisicao.readyState === 4 && requisicao.status === 200
	    || requisicao.status === 304)
	var retorno = requisicao.responseText;
    retorno = JSON.parse(retorno);
    if (retorno !== undefined && retorno != null && retorno != '') {
	atribuirValoresAosCampos(retorno);
    }
}

function validPhone($phone) {
    return preg_match(
	    '/(\([1-9][0-9]\)?|[1-9][0-9])\s?([9]{1})?([0-9]{4})-?([0-9]{4})$/',
	    $phone);
}

function atribuirCep() {
    var cep = $cep.value;
    validCep(cep);
}

function validCep(_cep) {
    if (_cep != "") {
	var cep = _cep.replace(/\D/g, '');
	var cepValido = /^[0-9]{8}$/;
	if (cepValido.test(cep)) {
	    buscarCep(cep);
	}
    }
}

function atribuirValoresAosCampos(resposta) {
    $rua.value = resposta.logradouro;
    $cidade.value = resposta.localidade;
    $bairro.value = resposta.bairro;
    $uf.textContent = resposta.uf;
    $numero.focus();
    if ($uf.textContent != 'RJ') {
	$sessaoNotice.classList.remove("displaynone");
    } else {
	$sessaoNotice.classList.add("displaynone");
    }
}

var _tipo = '';
function salvarDadosEntrega() {
    var $uf = document.getElementById("uf_label");
    var $regiao = document.getElementById("regioes_label");
    var $nome = document.getElementById("nome");

    if (_tipo == 'Retirar') {
	// --------------Codigo para retirada aqui
	let $pontoDeRetirada = document.querySelector("#ponto-retirada_input").value;
	let enderecoEntrega = {
	    'nome' : $nome.value,
	    'enderecoEntrega' : `Retirada: ${$pontoDeRetirada}`,
	    'telefone' : $telefone.value,
	    'regiao' : $regiao.textContent,
	    'frete' : 0
	}
	let stringEnderecoEntrega = JSON.stringify(enderecoEntrega);
	localStorage.setItem('Endereco', stringEnderecoEntrega);
	window.open('confirmacao-pedidos.xhtml', '_self');

    } else {
	if ($nome.value == '' || $nome.value == null) {

	    return alert('Informe o nome');
	}
	if ($regiao.textContent.trim() == 'Região' || $regiao.textContent == '') {

	    return alert('Região inválida');
	}
	if ($uf.textContent.trim() != 'RJ') {
	    return alert('Não entregamos para o cep informado');
	}
	let enderecoEntrega = {
	    'nome' : $nome.value,
	    'enderecoEntrega' : `${$rua.value}, ${$numero.value}, ${$bairro.value}, ${$cep.value}, ${$cidade.value}, ${$uf.textContent}`,
	    'telefone' : $telefone.value,
	    'regiao' : $regiao.textContent,
	    'frete' : 9.90
	}
	let stringEnderecoEntrega = JSON.stringify(enderecoEntrega);
	localStorage.setItem('Endereco', stringEnderecoEntrega);
	window.open('confirmacao-pedidos.xhtml', '_self');
    }
}

function definirTipo(tipo) {
    _tipo = tipo;
    lerEnderecoLocalStarage();
}

function lerEnderecoLocalStarage() {
    let enderecoStoragePedidos = localStorage.getItem('Endereco');
    if (enderecoStoragePedidos != undefined && enderecoStoragePedidos != null
	    && enderecoStoragePedidos != '') {
	enderecoStoragePedidos = JSON.parse(enderecoStoragePedidos);
	atribuirValoresAosCampos2(enderecoStoragePedidos);
    }
}

//Atribuir valores aos campos de meio de entrega 
function atribuirValoresAosCampos2(arr) {
    let _arr = arr.enderecoEntrega.split(',');
    $nome.value = arr.nome;
    if (_arr[0] != undefined && _arr[0] != '') {
	$rua.value = _arr[0];
    }
    if (_arr[4] != undefined && _arr[4] != '') {
	$cidade.value = _arr[4];
    }
    if (_arr[2] != undefined && _arr[2] != '') {
	$bairro.value = _arr[2];
    }
    if (_arr[5] != undefined && _arr[5] != '') {
	$uf.textContent = _arr[5];
    }
    if (_arr[1] != undefined && _arr[1] != '') {
	$numero.value = _arr[1];
    }
    if (_arr[3] != undefined && _arr[3] != '') {
	$cep.value = _arr[3];
    }

    $telefone.value = arr.telefone;
    $regiao.textContent = arr.regiao;

}

function limparDados() {
    $nome.value = '';
    $rua.value = '';
    $cidade.value = '';
    $bairro.value = '';
    $uf.textContent = 'Uf';
    $telefone.value = '';
    $regiao.textContent = 'Região';
    $numero.value = '';
    $cep.value = '';
}
