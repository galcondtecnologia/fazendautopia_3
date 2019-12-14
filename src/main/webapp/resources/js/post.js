const form = document.querySelector('#formulario');
let pedido = new Object(null);
let obs = document.querySelector('textarea');

form.addEventListener('submit', function (e) {
  e.preventDefault();
  criarPedido(form);
  _pedido = converterItensEmString(pedido);
  console.log(_pedido);
  pedido = JSON.stringify(pedido);
  // console.log(pedido);
  enviarParaServidor(pedido);
});


function enviarParaServidor(_pedido) {
    fetch('http://localhost:8080/fazendautopia/rest/pedido', {
	    method: 'POST',
	    body: _pedido
	  })
	    .then(function (response) {
	     return response.json();
	    }).then(function (response){
		alert('Resposta de sucesso do servidor: ' + JSON.stringify(response));
	    });
}



function criarPedido(form) {
    let enderecoStoragePedidos = localStorage.getItem('Endereco');
    enderecoStoragePedidos = JSON.parse(enderecoStoragePedidos);
    let inputs = form.querySelectorAll('input');
    for (let input of inputs) {
	switch (input.type) {
        case "checkbox":
          if (input.checked) {
            pedido[input.name] = true;
          } else {
            pedido[input.name] = false;
          }
          break
        case "radio":
          if (input.checked) {
            pedido[input.name] = input.value;
          }
          break
        case "text":
        case "number":
            switch (input.name) {
	    case 'enderecoEntrega':
		pedido.regiao = enderecoStoragePedidos.regiao;
	    case 'nomeRecebedor':
		pedido[input.name] = input.value;
		break;
	    case 'totalPedido':
	    case 'valorFrete':
	          pedido[input.name] = parseFloat(input.value);
		break;
	    default:
		break;
	    }
            // pedido[input.name] = input.value;
          break;
        default:
      }
    }
    let produtos = localStorage.getItem('Pedidos');
    pedido.itens = JSON.parse(produtos);
    pedido.observacao = obs.value;
    pedido.regiao = enderecoStoragePedidos.regiao;
    pedido.retirada = pedido.enderecoEntrega.slice(0,8) == "Retirada";
  }
criarPedido(form);

function converterItensEmString(pedido){
    //debugger;
    let total = pedido.itens.length;
    let i = indice =0;
    for(i; i<total; i++){
	let stringItens = pedido.itens[i]._produtos;
	pedido.itens[i]._produtos = stringItens.toString();
	//pedido.itens[i] = pedido.itens[i].toString();
    }
    console.log(pedido);
    return pedido;
}










