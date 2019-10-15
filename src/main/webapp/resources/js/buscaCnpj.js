
var $cnpj = document.getElementById("cnpj");
/*
var $razaoSocial = document.getElementById("razacaosocial");
var $nomeFantasia = document.getElementById("fantasia");
var $cep = document.getElementById("cep");
var $cidade = document.getElementById("cidade");
var $estado = document.getElementById("estado");
var $logradouro = document.getElementById("endereco");
var $numero = document.getElementById("n");
var $bairro = document.getElementById("bairro");
*/

function obterCnpj(cnpj) {
    var script = document.createElement('script');
    script.src = 'https://www.receitaws.com.br/v1/cnpj/' + cnpj
	    + '?callback=retorno'
    document.body.appendChild(script);
    console.log("Buscou os dados: " + cnpj);
}


function atribuirCnpj() {
    console.log("Entrou na funcao para atribuir o cnpj: " + cnpj);
    //var cnpjValido = /\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}/g
    var cnpj = document.getElementById("cnpj").value;
    //if (cnpjValido.test(cnpj)) {
	while (cnpj.includes(".") || cnpj.includes("/") || cnpj.includes("-")) {
	    if (cnpj.includes(".")) {
		cnpj = cnpj.replace(".", "");
	    }
	    if (cnpj.includes("/")) {
		cnpj = cnpj.replace("/", "");
	    }
	    if (cnpj.includes("-")) {
		cnpj = cnpj.replace("-", "");
	    }
	}
	obterCnpj(cnpj);
    }
//}

function retorno(dados) {
    console.log(dados);
    if(dados.status == "ERROR"){
	alert("CNPJ inválido");
    }else{
	
    document.getElementById("razacaosocial").value = dados.nome;
    document.getElementById("fantasia").value = dados.fantasia;
    document.getElementById("cep").value = dados.cep;
    document.getElementById("cidade").value = dados.municipio;
    document.getElementById("estado").value = dados.uf;
    document.getElementById("endereco").value = dados.logradouro;
    document.getElementById("n").value = dados.numero;
    document.getElementById("bairro").value = dados.bairro;
    document.getElementById("email").value = dados.email;
    document.getElementById("telefone").value = dados.telefone;
    }

  }














