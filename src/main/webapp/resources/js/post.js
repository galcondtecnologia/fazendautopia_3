const form = document.querySelector('#formulario');
let pedido = new Object(null);
let obs = document.querySelector('textarea');

form.addEventListener('submit', function (e) {
  e.preventDefault();
  criarPedido(form);
  pedido = JSON.stringify(pedido);
  enviarParaServidor();
});


function enviarParaServidor() {
    fetch('http://localhost:8080/fazendautopia/UsuarioServlet', {
	    method: 'POST',
	    body: pedido
	  })
	    .then(function (response) {
	      return response.json();
	    })
	    .then(function (response) {
	      console.log(response);
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
            pedido[input.name] = 'Sim';
          } else {
            pedido[input.name] = 'Nao';
          }
          break
        case "radio":
          if (input.checked) {
            pedido[input.name] = input.value;
          }
          break
        case "text":
        case "number":
/*            switch (input.name) {
	    case 'enderecoEntrega':
		pedido.regiao = enderecoStoragePedidos.regiao;
	    case 'nomeUsuario':
	    case 'totalPedido':
	    case 'valorFrete':
	          pedido[input.name] = input.value;
		break;
	    default:
		break;
	    }*/
            pedido[input.name] = input.value;
          break;
        default:
      }
    }
    //let produtos = localStorage.getItem('Pedidos');
   // pedido.produtos = JSON.parse(produtos);
    pedido.observacao = obs.value;
    pedido.regiao = enderecoStoragePedidos.regiao;
    console.log(pedido);
  }
criarPedido(form);










