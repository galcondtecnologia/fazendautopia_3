var $btnUploadImg = document.getElementById("foto");
var $fotoPreview = document.getElementById("foto-preview");



function exibirImagem(imagem) {
    var tamanoImagemMB = parseFloat(imagem[0].size) / 1024;
    console.log(imagem);
    
    // Tratar o tamanho da imagem
    if(tamanoImagemMB >= 60){
	console.log(tamanoImagemMB);
	alert("Imagem maior que o tamanho permitido,\n tente com uma imagem menor 200 x 200px");
    }else{  
    if (imagem && imagem[0]) {
	var reader = new FileReader();
	reader.onload = function(e) { 
	    document.getElementById("foto-preview").src = e.target.result;
	};
	reader.readAsDataURL(imagem[0]);
	
    }
}
}

function atribuirImagem(e) {
    exibirImagem(e.files);
}
