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
	requisicao.open("GET", "https://viacep.com.br/ws/"+ cep +"/json/");
	requisicao.send(null);
	requisicao.onreadystatechange = retornarEndereco;
}

function retornarEndereco() {
	if (requisicao.readyState === 4 && requisicao.status === 200
			|| requisicao.status === 304)
		var retorno = requisicao.responseText;
	retorno = JSON.parse(retorno);
	console.log(retorno);
	atribuirValoresAosCampos(retorno);
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
	if(_cep != ""){
		var cep = _cep.replace(/\D/g,'');
		var cepValido = /^[0-9]{8}$/;
		if(cepValido.test(cep)){
			buscarCep(cep);
		}
	}
}



function atribuirValoresAosCampos(resposta){
	$rua.value = resposta.logradouro;
	$cidade.value = resposta.localidade;
	$bairro.value = resposta.bairro;
	$uf.textContent = resposta.uf;
	$numero.focus();
}
