
    
    
 var cnpj ="";   
 var $cnpj = document.getElementById("cnpj");

function buscarCnpj(cnpj) {
    return new Promise(function(resolve, reject) { 
	var requisicao = new XMLHttpRequest();
	requisicao.open("GET", cnpj);
	requisicao.send();
	
	requisicao.onload = function() {
	    // verificar o retorno
	    if(requisicao.status == 200){
		resolve(requisicao.response);
	    }else{
		reject(requisicao.statusText);
	    }
	}
    });
}



function atribuirCnpj() {
var cnpjValido = /\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}/g
cnpj = $cnpj.value;
if(cnpjValido.test(cnpj)){
    while (cep.includes(".") || cep.includes("/") || cep.includes("-")) {
        if (cep.includes(".")) {
          cep = cep.replace(".", "");
        }
        if (cep.includes("/")) {
          cep = cep.replace("/", "");
        }
        if (cep.includes("-")) {
          cep = cep.replace("-", "");
        }
        buscarCnpj("https://www.receitaws.com.br/v1/cnpj/" + cnpj).then(resposta =>{
            console.log("Resposta", resposta);
        }).catch(error=>{
            console.log("Erro: ", error);
        })
      }   
}}