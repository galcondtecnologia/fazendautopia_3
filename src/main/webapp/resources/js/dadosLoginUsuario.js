	

function checkLogin() {
    let user = localStorage.getItem('Endereco');
    if (user == undefined || user == null
	    || user == '') {
    let enderecoEntrega = {
	    'nome' : 'User Name',
	    'enderecoEntrega' : `Rua.., Número.., Bairro.., 00000000, Cidade.., Uf`,
	    'telefone' : 'XX000000000',
	    'regiao' : 'Região',
	    'frete' : 0
	}
	let stringEnderecoEntrega = JSON.stringify(enderecoEntrega);
	localStorage.setItem('Endereco', stringEnderecoEntrega); 
    }
}


function qtdComprasDoUsuario(qtd = 0) {
    let compras = qtd;
    compras = JSON.stringify(compras);
    localStorage.setItem('QtdCompras', compras); 
}

checkLogin();
qtdComprasDoUsuario(0);