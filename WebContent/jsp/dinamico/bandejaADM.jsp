<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String sWS = request.getContextPath();
%>
<jsp:useBean id="now" class="java.util.Date" scope="request" />
<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
<script type="text/javascript">
function fn_subirFichero(){
    var file = $('[name="myPDF"]');
    var filename = $.trim(file.val());
    if (filename !== '') {
    	 if (updateSize('uploadPDF') < 5000000) {
    		 var contexto = document.getElementById("contexto").value;
    			var vservlet = contexto + '/ServFicheroDoc';
    	 		var load='<img  height="100px" width="100px" src="'+contexto+'/images/reloj.gif">';
    	 	     	$('#msjPDF').html(load);
    	 	     	fn_upload_ajax(vservlet);
         } else {
        	 var contexto = document.getElementById("contexto").value;
         	 $('#viewer').attr('src', 'about:blank');
              $('#uploadPDF').val('');
              var load='<img  height="50px" width="50px" src="'+contexto+'/images/error.png">';
             document.getElementById("msjPDF").innerHTML =  load+' ERROR, ARCHIVO SUPERA LOS 5MB';
         }
    	
    	
    }
}
function fn_upload_ajax(vservlet){
	$.ajax({
        url: vservlet,
        type: "POST",
        data: new FormData(document.getElementById("fileForm")),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
      }).done(function(data) {
    	//alert(data);
    	if (data!=null) {
    		if (data=='0') {
    			var contexto = document.getElementById("contexto").value;
            	 $('#viewer').attr('src', 'about:blank');
                 $('#uploadPDF').val('');
                 var load='<img  height="50px" width="50px" src="'+contexto+'/images/error.png">';
                document.getElementById("msjPDF").innerHTML =  load+' ERROR, NOMBRE MUY EXTENSO';	
			}else{
				var contexto = document.getElementById("contexto").value;
	    		var load ='<img  height="50px" width="50px" src="'+contexto+'/images/check.jpg">';
	    		$('#msjPDF').html(load);
	    		document.getElementById("id_fichero").value=data;		
			}
    		
    		
		}
      }).fail(function(jqXHR, textStatus) {
    	  //alert(jqXHR.responseText);
    	  alert('File upload failed ...');
      });
}
</script>
<ol class="breadcrumb">
	<div class="container-fluid">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_ADMINISTRATIVO')">
				<a class="nav-link active primary" data-toggle="tab"
				href="#Administrativo" role="tab">Recibido <span
					class="badge badge-pill badge-primary"><div id="lbladministrativo"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_DESESTIMADO')">
				<a class="nav-link" data-toggle="tab" href="#Desaprobado" role="tab">Desaprobado
					<span class="badge badge-pill badge-primary"><div
							id="lbldesaprobado"></div></span>
			</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="Administrativo" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tadministrativo"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Desaprobado" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tdesaprobado"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
		</div>
	</div>
</ol>
<div class="modal fade" id="modDerivar" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					DERIVAR HOJA DE TRÁMITE N° <label id="lblht"></label>
				</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" align="justify">
				<label id="lblasunto">Asunto: </label><br> <label
					id="lbldocumento">Asunto: </label> <input type="hidden" id="id_ht">
				<input type="hidden" id="id_doc"> <input type="hidden"
					id="id_unidad">
				
				<div class="form-group">
					<label id="lbloficina">Oficina</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxoficina" name="cbxoficina" required="required"
						onchange="fn_listar_administrativos();">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>

					</select>

				</div>
				<div class="form-group">
					<label id="lblusuario">Administrativos</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxusuario" name="cbxusuario" required="required">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>

					</select>

				</div>
				<div class="form-group">
					<label id="lblobs">OBSERVACIONES</label>
					<textarea class="form-control" rows="4" cols="50"
						id="txtobservaciones" name="txtobservaciones" required></textarea>
				</div>

			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" type="button"
					onclick="fnreg_derivar();">Aceptar</button>
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="modDEVOLVER" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					DEVOLVER HOJA DE TRÁMITE N° <label id="lblhtArchiv"></label>
				</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" align="justify">
				<label id="lblasuntoArchiv">Asunto: </label><br> <label
					id="lbldocumentoArchiv">Asunto: </label> <input type="hidden"
					id="id_htArchiv"> <input type="hidden" id="id_docArchiv">
				<input type="hidden" id="id_unidadArchiv">
				<div class="form-group">
					<label id="lblobsArchiv">OBSERVACIONES</label>
					<textarea class="form-control" rows="4" cols="50"
						id="txtobservacionesArchiv" name="txtobservaciones" required></textarea>
				</div>

			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" type="button"
					onclick="fnreg_Devolver();">Aceptar</button>
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="modRESPONDER" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					RESPONDER HOJA DE TRÁMITE N° <label id="lblhtRESPONDER"></label>
				</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" align="justify">
				<label id="lblasuntoRESPONDER">Asunto: </label><br> <label
					id="lbldocumentoRESPONDER">Asunto: </label> <input type="hidden"
					id="id_htRESPONDER"> <input type="hidden" id="id_docRESPONDER">
				<input type="hidden" id="id_unidadRESPONDER">
				<input id="id_fichero" name="id_fichero" type="hidden" required>
				<div class="form-group">
				<div class="card">
					<div class="card-header">Subir Archivo respuesta</div>
					<div class="card-body" align="center">
						<div class="form-group">
							<label id="lblobsResponder">OBSERVACIONES</label>
							<textarea class="form-control" rows="4" cols="50"
								id="txtobservacionesRESPONDER" name="txtobservacionesRESPONDER" required></textarea>
						</div>

						<form id="fileForm">
							<div class="form-group" align="center">
								<input id="uploadPDF" type="file" name="myPDF"
									onchange="PreviewImage();" />&nbsp;
								<button type="button" onclick="fn_subirFichero();">
									<img src="<%=sWS %>/images/save.png" width="20" height="20">
									Guardar fichero
								</button>
								<div id="msjPDF"></div>
							</div>
						</form>

					</div>
				</div>
			</div>

			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" type="button"
					onclick="fnreg_RESPONDER();">Aceptar</button>
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function fnreg_RESPONDER(){
	var id_ht= document.getElementById("id_htRESPONDER").value;
	var id_doc=document.getElementById("id_docRESPONDER").value;
	var id_unidad=document.getElementById("id_unidadRESPONDER").value;
	var observaciones=document.getElementById("txtobservacionesRESPONDER").value;
	var id_fichero=document.getElementById("id_fichero").value;
if (validarRESPONDER()) {
	var contexto = document.getElementById("contexto").value;
	var vservlet = contexto + '/ServBandejaAJAX';
	var txtevento = 'RESPONDER';
	var jqdata = {
		hdEvento : txtevento,
		id_ht : id_ht,
		id_doc : id_doc,
		id_usuario_destino : '0',
		id_unidad_destino : id_unidad,
		id_oficina_destino : '0',
		observaciones : observaciones,
		id_fichero: id_fichero
	};
	if (confirm('Esta seguro de Responder la Hoja de Trámite N°' + id_ht)) {
		fnEjecutarPeticion(vservlet, jqdata, txtevento);
	}	
}	
}
function validarRESPONDER() {
	var validar = true;
	var txtobservacionesRESPONDER = document
			.getElementById('txtobservacionesRESPONDER').value;
	var id_fichero=document.getElementById('id_fichero').value;
	$('#lblobsResponder').css("color", "black");
	$('#uploadPDF').css("color", "black");
	if (txtobservacionesRESPONDER == '') {
		$('#lblobsResponder').css("color", "red");
		validar = false;
	}
	if (id_fichero == '') {
		$('#uploadPDF').css("color", "red");
		validar = false;
	}
	return validar;
}
function fnResponder(idht, asu, doc, idunireg, iddoc) {
		$('#lblhtRESPONDER').html(idht);
		$('#lblasuntoRESPONDER').html('Asunto: ' + asu);
		$('#lbldocumentoRESPONDER').html('Documento: ' + doc);
		document.getElementById("id_htRESPONDER").value = idht;
		document.getElementById("id_docRESPONDER").value = iddoc;
		document.getElementById("id_unidadRESPONDER").value = idunireg;
		document.getElementById("txtobservacionesRESPONDER").value = '';
		document.getElementById("id_fichero").value = '';
		 $('#uploadPDF').val('');
		 document.getElementById("msjPDF").innerHTML ='';
		$('#lblobsResponder').css("color", "black");
		$('#uploadPDF').css("color", "black");
		$('#modRESPONDER').modal();
	}


//---------------------------DEVOLVER----------------

 function fnDevolver(idht, asu, doc, idunireg, iddoc) {
		$('#lblhtArchiv').html(idht);
		$('#lblasuntoArchiv').html('Asunto: ' + asu);
		$('#lbldocumentoArchiv').html('Documento: ' + doc);
		document.getElementById("id_htArchiv").value = idht;
		document.getElementById("id_docArchiv").value = iddoc;
		document.getElementById("id_unidadArchiv").value = idunireg;
		document.getElementById("txtobservacionesArchiv").value = '';
		$('#lblobsArchiv').css("color", "black");
		$('#modDEVOLVER').modal();
	}
	function validardevolver() {
		var validar = true;
		var txtobservacionesArchiv = document
				.getElementById('txtobservacionesArchiv').value;
		$('#lblobsArchiv').css("color", "black");
		if (txtobservacionesArchiv == '') {
			$('#lblobsArchiv').css("color", "red");
			validar = false;
		}
		return validar;
	}
function fnreg_Devolver() {
		var id_unidad_destino = document.getElementById("id_unidadArchiv").value;
		var observaciones = document.getElementById("txtobservacionesArchiv").value;
		var id_ht = document.getElementById("id_htArchiv").value;
		var id_doc = document.getElementById("id_docArchiv").value;
		if (validardevolver()) {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = 'DEVOLVER';
			var jqdata = {
				hdEvento : txtevento,
				id_ht : id_ht,
				id_doc : id_doc,
				id_usuario_destino : '0',
				id_unidad_destino : id_unidad_destino,
				id_oficina_destino : '0',
				observaciones : observaciones
			};
			if (confirm('Esta seguro de Devolver la Hoja de Trámite N°' + id_ht)) {
				fnEjecutarPeticion(vservlet, jqdata, txtevento);
			}
		}

	}

</script>
<script type="text/javascript">

    
    function updateSize(elementId) {
        var nBytes = 0,
                oFiles = document.getElementById(elementId).files,
                nFiles = oFiles.length;

        for (var nFileId = 0; nFileId < nFiles; nFileId++) {
            nBytes += oFiles[nFileId].size;
        }
        var sOutput = nBytes + " bytes";
        // optional code for multiples approximation
        for (var aMultiples = ["K", "M", "G", "T", "P", "E", "Z", "Y"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
            sOutput = " (" + nApprox.toFixed(3) + aMultiples[nMultiple] + ")";
        }

        return nBytes;
    }
 
    
</script>
<script type="text/javascript">
	window.onload = function() {
		fnlistarBandeja('BANDEJA_ADMINISTRATIVO');
		fnlistarBandeja('BANDEJA_DESESTIMADO');
	}
</script>



