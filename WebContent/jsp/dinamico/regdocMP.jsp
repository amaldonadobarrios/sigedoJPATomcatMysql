<%-- 
    Document   : regdocMP
    Created on : 28/12/2017, 05:52:52 PM
    Author     : 31424836
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
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
		<c:if test="${msgok!=null}">
			<div class="alert alert-success">
				<strong>CORRECTO</strong> ${msgok}
			</div>
		</c:if>
		<c:if test="${msgnok!=null}">
			<div class="alert alert-danger">
				<strong>ERROR!</strong> ${msgnok}
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-6">

				<div class="card">
					<div class="card-header">Registrar un Documento</div>
					<div class="card-body">
						<form data-toggle="validator" role="form"
							action="<%=sWS %>/ServGestionDocumento" method="post" id="form1"
							name="form1">
							<input type="hidden" id="contexto" name="contexto"
								value="<%=sWS%>"> <input id="id_fichero"
								name="id_fichero" type="text" required class="hideme"> <input
								type="hidden" id="hdEvento" name="hdEvento"
								value="REGISTRAR_DOCUMENTO_MP">
							<!-- PRIMERA COLUMNA -->
							<div class="form-group">
								<label id="lbldocumento">TIPO DE DOCUMENTO</label> <select
									id="cbxdocumento" name="cbxdocumento"
									data-placeholder="Seleccion el tipo de documento"
									class=" form-control" tabindex="2" required>
									<option value="" selected>Seleccione</option>
									<c:forEach var="tipo" items="${combotipo}" varStatus="loop">
										<option data-tokens="ketchup mustard"
											value="${tipo.idTipoDoc}">${tipo.descripcion}</option>
									</c:forEach>
								</select> <input id="hdntipodocumento" type="hidden" value="">

							</div>
							<div class="form-group">
								<label id="lblnumero">NUMERO DEL DOCUMENTO</label> <input
									class="form-control"
									placeholder="INGRESAR NUMERO DEL DOCUMENTO"
									onkeypress="return solonumeritos(event)" MaxLength="10"
									id="txtnumero" name="txtnumero" value="" required>
							</div>
							<div class="form-group">
								<label id="lblsiglas">SIGLAS DEL DOCUMENTO</label> <input
									class="form-control"
									placeholder="INGRESAR SIGLAS DEL DOCUMENTO" MaxLength="50"
									id="txtsiglas" name="txtsiglas" value="" required>
							</div>

							<div class="form-group">
								<label id="lblfecha">FECHA DEL DOCUMENTO</label>
								<div class="input-group date datepicker">
									<input type="date" data-format="dd/mm/yyyy"
										class="form-control" id="txtfechadoc" name="txtfechadoc"
										required>
									<!-- 									<span -->
									<!-- 									class="input-group-addon"> <i -->
									<!-- 									class="fa fa-calendar bigger-110"></i> -->
									<!-- 								</span>	 -->
								</div>
							</div>


							<div class="form-group">
								<label id="lblcontenido">CLASIFICACION POR CONTENIDO</label> <select
									data-placeholder="Seleccione el tipo de contenido del documento"
									class="form-control" tabindex="2" id="cbxcontenido"
									name="cbxcontenido" required>
									<option value="" selected>Seleccione</option>
									<c:forEach var="cont" items="${combocont}" varStatus="loop">
										<option data-tokens="ketchup mustard"
											value="${cont.idClasContenidoDoc}">${cont.descripcion}
										</option>
									</c:forEach>

								</select> <input id="hdncontenido" type="hidden" value="">

							</div>
							<div class="form-group">
								<label id="lblfuncion">CLASIFICACION POR FUNCION</label> <select
									data-placeholder="Seleccione el tipo de función del documento"
									class="form-control" tabindex="2" id="cbxfuncion"
									name="cbxfuncion" required>
									<option value="" selected>Seleccione</option>
									<c:forEach var="fun" items="${combofunc}" varStatus="loop">
										<option data-tokens="ketchup mustard"
											value="${fun.idClasFuncionDoc}">${fun.descripcion}</option>
									</c:forEach>
								</select> <input id="hdnfuncion" type="hidden" value="">
							</div>
							<div class="form-group">
								<label id="lblprioridad">PRIORIDAD</label> <select
									data-placeholder="Seleccione la prioridad del documento"
									class="form-control" tabindex="2" id="cbxprioridad"
									name="cbxprioridad" required>
									<option value="" selected>Seleccione</option>
									<c:forEach var="pri" items="${comboprio}" varStatus="loop">
										<option data-tokens="ketchup mustard"
											value="${pri.idPrioridadDoc}">${pri.descripcion}</option>
									</c:forEach>
								</select> <input id="hdnprioridad" type="hidden" value="">
							</div>
							<div class="form-group">
								<input id="hdnremitente" type="hidden" value=""> <label
									id="lblremitente">REMITENTE</label> <select id="cbxremitente"
									name="cbxremitente" data-placeholder="Seleccion el remitente"
									class="form-control" tabindex="2" onchange="fn_remitente();"
									required>
									<option value="" selected>Seleccione</option>
									<c:forEach var="uni" items="${combounid}" varStatus="loop">
										<option data-tokens="ketchup mustard" value="${uni.idUnidad}">${uni.descripcion}
										</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label id="lblasunto">ASUNTO</label>
								<textarea class="form-control" rows="4" cols="50" id="txtasunto"
									name="txtasunto" required></textarea>
							</div>
					</div>
				</div>





			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">Subir Pdf</div>
					<div class="card-body" align="center">
						<div class="form-group">
							<label id="lblasunto">OBSERVACIONES</label>
							<textarea class="form-control" rows="4" cols="50"
								id="txtobservaciones" name="txtobservaciones" required></textarea>
						</div>
						<input type="submit" value="REGISTRAR"
							class="btn btn-success btn-lg">




						</form>
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
							<div style="clear: both" align="center">
								<iframe id="viewer" frameborder="0" scrolling="no" width="400"
									height="600"></iframe>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</ol>
<script type="text/javascript">
    function PreviewImage() {
    	$('#msjPDF').html('');
        var file = $('[name="myPDF"]');
        var filename = $.trim(file.val());
        if (filename !== '') {
            if (isJpg(filename) || isPdf(filename)) {
                $('#viewer').attr('src', 'about:blank');
                pdffile = document.getElementById("uploadPDF").files[0];
                pdffile_url = URL.createObjectURL(pdffile);
                $('#viewer').attr('src', pdffile_url);
            } else {
                $('#viewer').attr('src', 'about:blank');
                $('#uploadPDF').val('');
            }
        }
    }

    var isJpg = function (name) {
        return name.match(/jpg$/i)
    };
    var isPdf = function (name) {
        return name.match(/pdf$/i)
    };
    
  
    
    
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
if (${ht}!='') {
	var id_ht=${ht};
	window.open("ServGestionDocumento?hdEvento=VER_REPORTE&id="+id_ht, '_blank');
	
}


</script>




<style>
.hideme {
	display: none;
	visibility: hidden;
}

.showme {
	display: inline;
	visibility: visible;
}

button {
	font: 700 1em Tahoma, Arial, Verdana, sans-serif;
	color: #fff;
	background-color: #59B0E5;
	border: 1px solid #0074a5;
	border-top: 1px solid #004370;
	border-left: 1px solid #004370;
	cursor: pointer;
}

button {
	width: auto; /* ie */
	overflow: visible; /* ie */
	padding: 3px 8px 2px 6px; /* ie */
}

button[type] {
	padding: 4px 8px 4px 6px; /* firefox */
}
</style>