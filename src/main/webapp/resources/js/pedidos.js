var $sessaoEntregar = document.getElementById("sessao1");
var $sessaoRetirar = document.getElementById("sessao2");
var $btnRetirar = document.getElementById("btnRetirar");
var $btnEntregar = document.getElementById("btnEntregar");
var $headerEntrega = document.getElementById("header-entrega");
var $headerRetirada = document.getElementById("header-retirada");
var $enderecoRetirada = document.getElementById("div-endereco-retirada");
var $inputs = document.querySelectorAll("input");
var $regioes = document.getElementById("regioes");


$btnRetirar.addEventListener("click", function(){
	$sessaoRetirar.classList.remove("displaynone");
	$headerRetirada.classList.remove("displaynone");
	$sessaoEntregar.classList.add("displaynone");
	$headerEntrega.classList.add("displaynone");
	PF('dlgEntrega').show();
})
$btnEntregar.addEventListener("click", function(){
	$sessaoRetirar.classList.add("displaynone");
	$sessaoEntregar.classList.remove("displaynone");
	$headerRetirada.classList.add("displaynone");
	$headerEntrega.classList.remove("displaynone");
	PF('dlgEntrega').show();
})

function exibirEnderecoRetirada() {
	$enderecoRetirada.classList.remove("displaynone");
}
function ativarCamposEndereco() {
	for(var i = 0;i < $inputs.length; i++){
		$inputs[i].classList.remove("ui-state-disabled");
		$inputs[i].removeAttribute("disabled");
	}
		$regioes.removeAttribute("disabled");
}