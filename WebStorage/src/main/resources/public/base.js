checkCompatibility();
actualizaSuma();
function suma() {
	sessionStorage["suma"] = parseInt(document.getElementById("operando1").value) + parseInt(document.getElementById("operando2").value);
	actualizaSuma();
    $.ajax({
        type: "POST",
        url: "rest/suma",
        data: sessionStorage["suma"],
        contentType: "text/plain",
        crossDomain: true,
        success: function (data, status, jqXHR) {
        	$("#notificaciones").html("El navegador ha recibido su mensaje.")
        	.fadeIn(2000).fadeOut(2000);
        },

        error: function (jqXHR, status) {
        	$("#notificaciones").html("Error al comunicar con el servidor.")
        	.fadeIn(2000).fadeOut(2000);
        }
     });
}

function actualizaSuma() {
	$("#resultado").html( sessionStorage["suma"]);
}

function checkCompatibility() {
	if(!sessionStorage)
		alert("Su navegador no soporta SessionStorage");
}

function enterSuma(e) {
	if( e.keyCode == 13)
		suma();
}