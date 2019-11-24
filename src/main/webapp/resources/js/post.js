const form = document.querySelector('#formulario');
let pedido = new Object(null);

form.addEventListener('submit', function (e) {
  e.preventDefault();
  criarPedido(form);
  enviarParaServidor();
});


function enviarParaServidor() {
    fetch('https://reqres.in/api/users', {
	    method: 'POST',
	    body: JSON.stringify(pedido)
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
            switch (input.name) {
	    case 'enderecoEntrega':
	    case 'nomeUsuario':
	    case 'totalPedido':
	    case 'valorFrete':
	          pedido[input.name] = input.value;
		break;
	    default:
		break;
	    }
          break;
        default:
      }
    }
    pedido.produtos = localStorage.getItem('Pedidos');
    console.log(pedido);
    console.log(JSON.stringify(pedido));
  }
criarPedido(form);










