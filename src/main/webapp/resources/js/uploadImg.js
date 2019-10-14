var $btnUploadImg = document.getElementById("foto");
var $fotoPreview = document.getElementById("foto-preview");

console.log($btnUploadImg);
console.log($fotoPreview);





function exibirImagem(imagem) {
    console.log("executou a funcao de atribuir a imagem");
    console.log(imagem[0].target);
    if (imagem && imagem[0]) {
	var reader = new FileReader();
	reader.onload = function(e) {
	    $fotoPreview.src = e.target.result;
	    //$fotoPreview.src = readAsDataURL(e);
	    console.log("Imagem.SRC: ", $fotoPreview.src);
	}
	reader.readAsDataURL(imagem[0]);
    }
}


$btnUploadImg.addEventListener('change', function(e) {
    console.log("executou a funcao change");
    exibirImagem(this.files);
});


function teste(e) {
    console.log("executou a funcao change");
    console.log(e.files);
    exibirImagem(e.files);
}