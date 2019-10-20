function alterarCheck() {
    var check = document.getElementById("status");
    var listCheck = document.getElementById("listCheck_label").textContent;
    if(listCheck == "Status: ativo"){
	check.checked = false;		
    }else{
	check.checked = true;
    }
}