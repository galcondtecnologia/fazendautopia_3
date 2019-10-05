/**
 * 
 */

var $alertemail = document.getElementById("alert-email");

var email = '';
function atualizarEmail() {
	email = document.getElementById("email").value;
}

function validMail() {
	if (email != "") {
		var validemail = /\b[\w\.-]+@[\w\.-]+\.\w{2,4}\b/gi;
		if (!validemail.test(email)) {
			exibirOuOcultarMsg();
		}
	}
}

function exibirOuOcultarMsg() {
	$alertemail.classList.toggle("displaynone");
}