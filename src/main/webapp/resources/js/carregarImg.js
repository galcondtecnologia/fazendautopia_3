var itens = document.querySelectorAll("#tabela_data tr");
var icon = document.getElementById("foto-preview");
var item;


    for (var i = 0; itens.length > i; i++) {
	itens[i].addEventListener('click', function(e) {
	   item = e.path[i];
	   var image = item.querySelector("td img");
	   console.log("entrou");
	   checkImg(image);
	});
    }

function checkImg(image) {
    setTimeout(() => {
	icon.src = image.src;	
    }, 200);
}