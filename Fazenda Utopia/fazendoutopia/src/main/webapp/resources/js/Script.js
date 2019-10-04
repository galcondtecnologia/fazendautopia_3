/**
 * 
 */

Function(consultarCep)
{
	var cep = $("#cep").val();
	$.getJON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function(
			dados) {
		if (!("erro" in dados)) {
			
			$("#cidade").val(dados.localidade);
			$("#estado").val(dados.uf);
			$("#logradouro").val(dados.logradouro);
			$("#numero").val(dados.uf);
		} else {
			$("#cep").val('');
			$("#logradouro").val('');
			$("#cidade").val('');
			$("#estado").val('');
			alert("CEP não encontrado.");
		}
	});

}

$(document).ready(function(){
	$("input[name=cep]").blur(function(){
		var cep = $(this).val().replace(/[^0-9]/, '');
		if(cep){
			var url = 'https://correiosapi.apphb.com/cep/' + cep;
			 $.ajax({
                    url: url,
                    dataType: 'jsonp',
                    crossDomain: true,
                    contentType: "application/json",
					success : function(json){
						if(json.logradouro){
							$("input[name=rua]").val(json.logradouro);
							$("input[name=bairro]").val(json.bairro);
							$("input[name=cidade]").val(json.cidade);
							$("input[name=uf]").val(json.estado);
						}
					}
			});
		}
					
	});
	
});