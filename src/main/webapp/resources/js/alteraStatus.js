
function alterarCheck() {
    var check = document.getElementById("status");
    var listCheck = document.getElementById("listCheck_label").textContent;
    if(listCheck == "Status: ativo"){
	check.checked = false;		
    }else{
	check.checked = true;
    }
}

function statusCheck() {
    if(!check){
	listCheck = "Status: ativo"
	    console.log('Entrou para alterar o status', check);
    }
}


function alterarStatusList(){
    var check = document.getElementById("status");
    if(check.checked){
	document.getElementById("listCheck_label").textContent = "Status: inativo"
    }else{
	document.getElementById("listCheck_label").textContent = "Status: ativo"
    }
}
