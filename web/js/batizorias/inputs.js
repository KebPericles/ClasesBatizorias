//Variables globales
var rangeCostoAsesoria = document.getElementById("rangeCostoAsesoria");
var txtCostoAsesoria = document.getElementById("txtCostoAsesoria");
var resetCrearAsesoria = document.getElementById("resetCrearAsesoria");

//Validar y coordinar input:range con input:text del costo de asesoria

var guardarCosto = 0;
txtCostoAsesoria.addEventListener("keypress", validarCostoAsesoria);
txtCostoAsesoria.addEventListener("input", cambioCosto);

rangeCostoAsesoria.addEventListener("change", cambioRangeCostoAsesoria);
rangeCostoAsesoria.addEventListener("input", cambioRangeCostoAsesoria);
resetCrearAsesoria.addEventListener("click", predeterminadosCrearAsesoria);

function cambioRangeCostoAsesoria(){
    txtCostoAsesoria.value = rangeCostoAsesoria.value;
}

function validarCostoAsesoria(){
    var patron = /^[0-9]{0,4}([.]{1}[0-9]{0,2})?$/;
    var numero = Number(txtCostoAsesoria.value);
    
    if(!patron.test(txtCostoAsesoria.value)){
        patron = /^[0-9]{0,4}[.]{1}$/;
        if (patron.test(txtCostoAsesoria.value)) {
            txtCostoAsesoria.value += "0";
        }else{
            event.preventDefault(); 
            txtCostoAsesoria.value = guardarCosto;
            guardarCosto = txtCostoAsesoria.value;
        }
    }else if(txtCostoAsesoria.value === ""){
        txtCostoAsesoria.value = "0";
    }

    guardarCosto = txtCostoAsesoria.value;
    patron = /^[0]+/;
    
    if (patron.test(txtCostoAsesoria.value)) {
        if(numero !== 0){
            txtCostoAsesoria.value = numero;
        }
    }
        
    if (numero >= 1000) {
        txtCostoAsesoria.value = 1000;
    }
}

function cambioCosto() {
    validarCostoAsesoria();
    var patron = /.+[.]$/;
    rangeCostoAsesoria.value = (!patron.test(txtCostoAsesoria.value))? txtCostoAsesoria.value : txtCostoAsesoria.value.substring(0,txtCostoAsesoria.value.length-1);
}

function predeterminadosCrearAsesoria(){
    cambioCostoAsesoria();
}