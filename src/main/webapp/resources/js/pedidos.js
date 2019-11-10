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
	var $pontoDeRetirada = document.querySelector("#ponto-retirada_input").value;
	$enderecoPontoRetirada = document.querySelector("#endereco-loja-retirada");
	$enderecoPontoRetirada.textContent = $pontoDeRetirada;
	inserirMapa($pontoDeRetirada);
}
function ativarCamposEndereco() {
	for(var i = 0;i < $inputs.length; i++){
		$inputs[i].classList.remove("ui-state-disabled");
		$inputs[i].removeAttribute("disabled");
	}
		$regioes.removeAttribute("disabled");
}

function inserirMapa(endereco) {
    //var mapa2 = `<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3657.1928273637627!2d-46.658149685022174!3d-23.561517084682755!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce59c94afa0643%3A0x5f441564de301cff!2sAv.%20Paulista%2C%201578%20-%20Bela%20Vista%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2001310-200!5e0!3m2!1sen!2sbr!4v1573355500997!5m2!1sen!2sbr" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>`
    var mapa = document.querySelector("#mapa");
    mapa.addEventListener('click', abrirMapa);
}

function abrirMapa() {
    var $pontoDeRetirada = document.querySelector("#ponto-retirada_input").value;
    var link = `//www.google.com.br/maps/search/${$pontoDeRetirada}`
    window.open(`${link}` ,"_blank" );
}


