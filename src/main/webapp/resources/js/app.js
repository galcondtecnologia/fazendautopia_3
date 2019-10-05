/**
 * 
 */
 
		var $menu = document.getElementById("menu");
		var $listaMenu = document.getElementById("menu-mobile");
		var $ul = document.querySelectorAll(".ul-mobile");
		$menu.addEventListener("click", function() {
			exibirOuOcultarMenu();
		});
		
		
		function exibirOuOcultarMenu() {
			$listaMenu.classList.toggle("show-menu");
		}
		
		$ul[0].addEventListener("click", function(event){
			exibirOuOcultarMenu();
		});
		
		
		//Variaveis da pagina inicial

		var $btmaisCesta = document.getElementById("bt-dialog-mais-cesta");
		var $btmenosCesta = document.getElementById("bt-dialog-menos-cesta");
		var $inputqtdCesta = document.getElementById("input-qtd-cesta_input");
		var $totalCesta = document.getElementById("total-cesta");
		var $precoCesta = document.getElementById("preco-cesta");
		
		var $btmaisProduto = document.getElementById("bt-dialog-mais-produto");
		var $btmenosProduto = document.getElementById("bt-dialog-menos-produto");
		var $inputqtdProduto = document.getElementById("input-qtd-produto_input");
		var $totalProduto = document.getElementById("total-produto");
		var $precoProduto = document.getElementById("preco-produto");
		
		

		//Função adicionar mais um item cesta
		$btmaisCesta.addEventListener("click", function() {
			var qtd = (parseInt($inputqtdCesta.value)) + 1;
			$inputqtdCesta.value = qtd;
			var precoItem = tratarPreco($precoCesta.textContent)
			var resultado = calcularTotal(qtd, precoItem);
			$totalCesta.innerHTML = "Total R$ " + resultado.toFixed(2);
		});
		
		//Função diminuir um item cesta
		$btmenosCesta.addEventListener("click", function() {
			if (parseInt($inputqtdCesta.value) == 1) {
				return
			}
			
			var qtd = (parseInt($inputqtdCesta.value)) - 1;
			$inputqtdCesta.value = qtd;
			var precoItem = 0;
			precoItem = tratarPreco($precoCesta.textContent)
			var resultado = calcularTotal(qtd, precoItem);
			$totalCesta.innerHTML = "Total R$ " + resultado.toFixed(2);
			
		});
		
		
		//--------------------
		//Função adicionar mais um item de produto
		$btmaisProduto.addEventListener("click", function() {
			var qtd = 0;
			qtd = (parseInt($inputqtdProduto.value)) + 1;
			$inputqtdProduto.value = qtd;
			var precoItem = 0;
			precoItem = tratarPreco($precoProduto.textContent)
			var resultado = calcularTotal(qtd, precoItem);
			$totalProduto.innerHTML = "Total R$ " + resultado.toFixed(2);
			
		});
		
		//Função diminuir um item de produto
		$btmenosProduto.addEventListener("click", function() {
			if (parseInt($inputqtdProduto.value) == 1) {
				return
			}
			
			var qtd = (parseInt($inputqtdProduto.value)) - 1;
			$inputqtdProduto.value = qtd;
			var precoItem = 0;
			precoItem = tratarPreco($precoProduto.textContent)
			var resultado = 0;
			resultado = calcularTotal(qtd, precoItem);
			$totalProduto.innerHTML = "Total R$ " + resultado.toFixed(2);
			
		});
		
		
		
		
		
		
		
		//Função calcular o total 
		function calcularTotal(qtd, valor) {
			var total = 0;
			total = qtd * valor;
			return total
		}
		
		//Função tratar o preço transformar string em numero
		function tratarPreco(str) {
			var numero = 0;
			numero = str.replace(",",".");
			numero = numero.slice(3,8);
			numero = parseFloat(numero);
			return numero;
		}
		
		
		
		
		
		//-------------------------Calcular frete----------------------
		
		var $btnCalcularFreteCesta = document.getElementById("calcular-frete-cesta");
		var $btnCalcularFreteProduto = document.getElementById("calcular-frete-produto");
		var $divCalcularFreteCesta = document.getElementById("div-calcular-frete-cesta");
		var $divCalcularFreteProduto = document.getElementById("div-calcular-frete-produto");
		var $selectCalcularFreteProduto = document.getElementById("select-calcular-frete-produto");
		var $selectCalcularFretecesta = document.getElementById("select-calcular-frete-cesta");
		var $labelFreteCesta = document.getElementById("label-frete-cesta");
		var $labelFreteProduto = document.getElementById("label-frete-produto");
		
		
		
		$btnCalcularFreteCesta.addEventListener("click", function(){
			$divCalcularFreteCesta.classList.toggle("displaynone");
		})
		
		$btnCalcularFreteProduto.addEventListener("click", function(){
			$divCalcularFreteProduto.classList.toggle("displaynone");
		})
		
		
		
		
		
		
		