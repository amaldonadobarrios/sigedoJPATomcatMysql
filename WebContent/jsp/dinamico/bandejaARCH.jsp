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
function fn_subirFichero2(){
    var file = $('[name="myPDF2"]');
    var filename = $.trim(file.val());
    if (filename !== '') {
    	 if (updateSize('uploadPDF2') < 5000000) {
    		 var contexto = document.getElementById("contexto").value;
    			var vservlet = contexto + '/ServFicheroDoc';
    	 		var load='<img  height="100px" width="100px" src="'+contexto+'/images/reloj.gif">';
    	 	     	$('#msjPDF2').html(load);
    	 	     	fn_upload_ajax2(vservlet);
         } else {
        	 var contexto = document.getElementById("contexto").value;
         	 $('#viewer2').attr('src', 'about:blank');
              $('#uploadPDF2').val('');
              var load='<img  height="50px" width="50px" src="'+contexto+'/images/error.png">';
             document.getElementById("msjPDF2").innerHTML =  load+' ERROR, ARCHIVO SUPERA LOS 5MB';
         }
    	
    	
    }
}
function fn_upload_ajax2(vservlet){
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
            	 $('#viewer2').attr('src', 'about:blank');
                 $('#uploadPDF2').val('');
                 var load='<img  height="50px" width="50px" src="'+contexto+'/images/error.png">';
                document.getElementById("msjPDF2").innerHTML =  load+' ERROR, NOMBRE MUY EXTENSO';	
			}else{
				var contexto = document.getElementById("contexto").value;
	    		var load ='<img  height="50px" width="50px" src="'+contexto+'/images/check.jpg">';
	    		$('#msjPDF2').html(load);
	    		document.getElementById("id_fichero").value=data;		
			}
    		
    		
		}
      }).fail(function(jqXHR, textStatus) {
    	  //alert(jqXHR.responseText);
    	  alert('File upload failed ...');
      });
}
</script>
<script type="text/javascript">
    function PreviewImage2() {
    	$('#msjPDF2').html('');
        var file = $('[name="myPDF2"]');
        var filename = $.trim(file.val());
        if (filename !== '') {
            if (isJpg(filename) || isPdf(filename)) {
                $('#viewer2').attr('src', 'about:blank');
                pdffile = document.getElementById("uploadPDF2").files[0];
                pdffile_url = URL.createObjectURL(pdffile);
                $('#viewer2').attr('src', pdffile_url);
            } else {
                $('#viewer2').attr('src', 'about:blank');
                $('#uploadPDF2').val('');
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
<script language="JavaScript" type="text/javascript">

    /**
    * definimos las variables que almacenar&aacute;n los componentes de la fecha actual
    */
    ahora      = new Date();
    ahoraDay   = ahora.getDate();
    ahoraMonth = ahora.getMonth();
    ahoraYear  = ahora.getYear();

    /**
	* Nestcape Navigator 4x cuenta el anyo a partir de 1900, por lo que es necesario
	* sumarle esa cantidad para obtener el anyo actual adecuadamente
	**/
	if (ahoraYear < 2000) 
        ahoraYear += 1900;

    /**
	* funcion para saber cuantos dias tiene cada mes
	*/
    function cuantosDias(mes, anyo)
    {
        var cuantosDias = 31;
        if (mes == "Abril" || mes == "Junio" || mes == "Septiembre" || mes == "Noviembre")
		    cuantosDias = 30;
        if (mes == "Febrero" && (anyo/4) != Math.floor(anyo/4))
		    cuantosDias = 28;
        if (mes == "Febrero" && (anyo/4) == Math.floor(anyo/4))
		    cuantosDias = 29;
        return cuantosDias;
    }

    /**
	* una vez que sabemos cuantos dias tiene cada mes
	* asignamos dinamicamente este numero al combo de los dias dependiendo 
	* del mes que aparezca en el combo de los meses
	*/
    function asignaDias()
    {
        comboDias = document.formFecha.seleccionaDia;
        comboMeses = document.formFecha.seleccionaMes;
        comboAnyos = document.formFecha.seleccionaAnyo;

        Month = comboMeses[comboMeses.selectedIndex].text;
        Year = comboAnyos[comboAnyos.selectedIndex].text;

        diasEnMes = cuantosDias(Month, Year);
        diasAhora = comboDias.length;

        if (diasAhora > diasEnMes)
        {
            for (i=0; i<(diasAhora-diasEnMes); i++)
            {
                comboDias.options[comboDias.options.length - 1] = null
            }
        }
        if (diasEnMes > diasAhora)
        {
            for (i=0; i<(diasEnMes-diasAhora); i++)
            {
                sumaOpcion = new Option(comboDias.options.length + 1);
                comboDias.options[comboDias.options.length]=sumaOpcion;
            }
        }
        if (comboDias.selectedIndex < 0) 
	         comboDias.selectedIndex = 0;
     }

    /**
	* ahora selecionamos en los combos los valores correspondientes 
	* a la fecha actual del sistema
	*/
    function ponDia()
    {
        comboDias = eval("document.formFecha.seleccionaDia");
        comboMeses = eval("document.formFecha.seleccionaMes");
        comboAnyos = eval("document.formFecha.seleccionaAnyo");

        comboAnyos[0].selected = true;
        comboMeses[ahoraMonth].selected = true;
  
        asignaDias();

        comboDias[ahoraDay-1].selected = true;
    }

    /**
	* esta funcion crea dinamicamente el comb o de los anyos, empezando
	* por el actual y acabando por el actual+masAnyos
	*/
    function rellenaAnyos(masAnyos)
    {
        cadena = "";

        for (i=0; i<masAnyos; i++)
        {
            cadena += "<option>";
            cadena += ahoraYear + i;
        }
        return cadena;
    }

  </script>
<ol class="breadcrumb">
	<div class="container-fluid">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item"
				onclick="fnlistarBandeja('BANDEJA_ARCHIVO_PENDIENTE')"><a
				class="nav-link active primary" data-toggle="tab"
				href="#Archivopendiente" role="tab">Digitalización Pendiente <span
					class="badge badge-pill badge-primary"><div
							id="lblarchivopendiente"></div></span>
			</a></li>
			<li class="nav-item"
				onclick="fnlistarBandeja('BANDEJA_ARCHIVO_DIGITALIZADO')"><a
				class="nav-link primary" data-toggle="tab"
				href="#ArchivoDigitalizado" role="tab">Archivo Digitalizado <span
					class="badge badge-pill badge-primary"><div
							id="lblarchivodigitalizado"></div></span>
			</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="Archivopendiente" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tarchivopendiente"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="ArchivoDigitalizado" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tarchivodigitalizado"></div>
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
<div class="modal fade animated bounceIn" id="modDigitalizar"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					DIGITALIZAR CARGO ASIGNADO A LA HOJA DE TRÁMITE N° <label
						id="lblhtDigitalizar"></label>
				</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" align="justify">
				<label id="lblasuntoDigitalizar">Asunto: </label><br> <label
					id="lbldocumentoDigitalizar">Asunto: </label> <input type="hidden"
					id="id_htDigitalizar"> <input type="hidden"
					id="id_docDigitalizar"> <input type="hidden"
					id="id_archivo">
				<div class="row">
					<div class="col-md-6">

						<div class="card">
							<div class="card-header">REFERENCIA DE ALMACENAMIENTO</div>
							<div class="card-body">

								<input id="id_fichero" name="id_fichero" type="hidden" required
									class="hideme">
								<!-- PRIMERA COLUMNA -->
								<div class="form-group">
									<label id="lblarchivador">ARCHIBADOR</label> <select
										class="form-control" tabindex="2" id="cbxarchivador"
										name="cbxarchivador" required>
									</select>

								</div>
								<div class="form-group">
									<label id="lblanio">AÑO ARCHIVO</label> <select
										name="seleccionaAnyo" id="seleccionaAnyo" class="fecha form-control"
										onchange="asignaDias()">
										<script language="JavaScript" type="text/javascript">
										document.write(rellenaAnyos(5));
    									</script>
									</select>
								</div>
								<div class="form-group">
									<label id="lblsecuencia">SECUENCIA</label>
									<input id="secuencia" name="secuencia" class="fecha form-control">
								</div>
								<div class="form-group">
									<label id="lblpalabras">PALABRAS CLAVE</label>
									<textarea class="form-control" rows="4" cols="50"
										id="txtpalabras" name="txtpalabras" required></textarea>
								</div>
							</div>
						</div>





					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-header">Subir Pdf</div>
							<div class="card-body" align="center">
								<div class="form-group">
									<label id="lblobservacionesDigitalizar">OBSERVACIONES</label>
									<textarea class="form-control" rows="4" cols="50"
										id="txtobservacionesDigitalizar"
										name="txtobservacionesDigitalizar" required></textarea>
								</div>





								<form id="fileForm">
									<div class="form-group" align="center">
										<input id="uploadPDF2" type="file" name="myPDF2"
											onchange="PreviewImage2();" style="font-size: 80%;" />&nbsp;<br>
										<button type="button" onclick="fn_subirFichero2();">
											<img src="<%=sWS%>/images/save.png" width="20" height="20">
											Guardar fichero
										</button>
										<div id="msjPDF2"></div>
									</div>
									<div style="clear: both" align="center">
										<iframe id="viewer2" frameborder="0" scrolling="no"
											width="350" height="550"></iframe>
									</div>
								</form>

							</div>

						</div>
						<div class="modal-footer">
							<button class="btn btn-primary btn-lg" type="button"
								onclick="fnreg_digitalizar();">Registrar</button>
							<button class="btn btn-secondary btn-lg" type="button"
								data-dismiss="modal">Cancelar</button>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</div>
<script type="text/javascript">
function fnreg_digitalizar(){
	if (validardigitalizar()) {
		var cbxarchivador = document.getElementById('cbxarchivador').value;
		var seleccionaAnyo = document.getElementById('seleccionaAnyo').value;
		var secuencia = document.getElementById('secuencia').value;
		var txtpalabras = document.getElementById('txtpalabras').value;
		var txtobservacionesDigitalizar = document.getElementById('txtobservacionesDigitalizar').value;
		var id_fichero = document.getElementById('id_fichero').value;
		var idht=document.getElementById("id_htDigitalizar").value;
		var iddoc=document.getElementById("id_docDigitalizar").value;
		var id_archivo=document.getElementById("id_archivo").value;
		var contexto = document.getElementById("contexto").value;
		var vservlet = contexto + '/ServBandejaAJAX';
		var txtevento = 'DIGITALIZAR';
		var jqdata = {
			hdEvento : txtevento,
			id_ht : idht,
			iddoc : iddoc,
			id_archivo : id_archivo,
			cbxarchivador: cbxarchivador,
			seleccionaAnyo: seleccionaAnyo,
			secuencia: secuencia,
			txtpalabras: txtpalabras,
			txtobservaciones: txtobservacionesDigitalizar,
			id_fichero: id_fichero
		};
		if (confirm('Esta seguro de Digitalizar el Cargo relacionado a la Hoja de Trámite N°' + idht)) {
			fnEjecutarPeticion(vservlet, jqdata, txtevento);
		}
	}
}
function limpiarDigitalizar(){
	document.getElementById('secuencia').value='';	
	document.getElementById('txtpalabras').value='';	
	document.getElementById('txtobservacionesDigitalizar').value='';	
	document.getElementById('id_fichero').value='';	
	document.getElementById('id_fichero').value='';	
	 $('#viewer2').attr('src', 'about:blank');
     $('#uploadPDF2').val('');
    document.getElementById("msjPDF2").innerHTML =  '';
	$('#lblarchivador').css("color", "black");
	$('#lblanio').css("color", "black");
	$('#lblsecuencia').css("color", "black");
	$('#lblpalabras').css("color", "black");
	$('#lblobservacionesDigitalizar').css("color", "black");
	$('#uploadPDF2').css("color", "black");
}
function validardigitalizar(){
	var validar = true;
	var cbxarchivador = document.getElementById('cbxarchivador').value;
	var seleccionaAnyo = document.getElementById('seleccionaAnyo').value;
	var secuencia = document.getElementById('secuencia').value;
	var txtpalabras = document.getElementById('txtpalabras').value;
	var txtobservacionesDigitalizar = document.getElementById('txtobservacionesDigitalizar').value;
	var id_fichero = document.getElementById('id_fichero').value;
	$('#lblarchivador').css("color", "black");
	$('#lblanio').css("color", "black");
	$('#lblsecuencia').css("color", "black");
	$('#lblpalabras').css("color", "black");
	$('#lblobservacionesDigitalizar').css("color", "black");
	$('#uploadPDF2').css("color", "black");
	if (cbxarchivador == '') {
		$('#lblarchivador').css("color", "red");
		validar = false;
	}
	if (seleccionaAnyo == '') {
		$('#lblanio').css("color", "red");
		validar = false;
	}
	if (secuencia == '') {
		$('#lblsecuencia').css("color", "red");
		validar = false;
	}
	if (txtpalabras == '') {
		$('#lblpalabras').css("color", "red");
		validar = false;
	}
	if (txtobservacionesDigitalizar == '') {
		$('#lblobservacionesDigitalizar').css("color", "red");
		validar = false;
	}
	if (id_fichero == '') {
		$('#uploadPDF2').css("color", "red");
		validar = false;
	}
	
	return validar;	
}

	
function fndigitalizar(idht, asu, doc, idArchivo, idDoc) {
		limpiarDigitalizar();
		$('#lblhtDigitalizar').html(idht);
		$('#lblasuntoDigitalizar').html('Asunto: ' + asu);
		$('#lbldocumentoDigitalizar').html('Documento: ' + doc);
		document.getElementById("id_htDigitalizar").value = idht;
		document.getElementById("id_docDigitalizar").value = idDoc;
		document.getElementById("id_archivo").value = idArchivo;
		$("#modDigitalizar").modal();

	}
	function fnlistarOficinax(id){
		var x = id;
		var contexto = document.getElementById("contexto").value;
		var vservlet = contexto + '/ServAdministracionAJAX';
		var txtevento = 'COMBO_OFICINA';
		fn_ajax_ofix(vservlet, txtevento, x);		
	}
	function fn_ajax_ofix(servlet, evento, id) {
		$.ajax({
			url : servlet,
			data : {
				hdEvento : evento,
				id_unidad : id
			},
			success : function(responseText) {
				var v_resultado = responseText + "";
				if (v_resultado == 'NOSESION') {
					window.location = 'SPage?action=login';
				} else if (v_resultado == 'VACIO') {
					$("#cbxarchivador").empty();
				} else {
					//alert(v_resultado);
					$("#cbxarchivador").empty();
					var arr = JSON.parse(v_resultado);
					ShareInfoLength = arr.length;
					//alert(ShareInfoLength);
					$("<option/>").attr("value", '').text('Seleccione')
							.appendTo("#cbxarchivador");
					for (var i = 0; i < ShareInfoLength; i++) {
						$("<option/>").attr("value", arr[i].id).text(
								arr[i].detalle).appendTo("#cbxarchivador");
					}
				}
			}
		});
	}
</script>
<script type="text/javascript">
	window.onload = function() {
		fnlistarBandeja('BANDEJA_ARCHIVO_PENDIENTE');
		fnlistarBandeja('BANDEJA_ARCHIVO_DIGITALIZADO');
	}
</script>




