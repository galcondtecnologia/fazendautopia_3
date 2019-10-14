var $btnUploadImg = document.getElementById("foto");
var $fotoPreview = document.getElementById("foto-preview");



function exibirImagem(imagem) {
    console.log(imagem[0].target);
    if (imagem && imagem[0]) {
	var reader = new FileReader();
	reader.onload = function(e) { 
	    document.getElementById("foto-preview").src = e.target.result;
	};
	reader.readAsDataURL(imagem[0]);
    }
}

function teste(e) {
    exibirImagem(e.files);
}
