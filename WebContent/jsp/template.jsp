
<%-- 
    Document   : template
    Created on : 09/11/2017, 03:23:52 PM
    Author     : 31424836

     
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="shortcut icon" href="./images/escudo.ico" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SIGEDO PNP</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="css/sb-admin.css" rel="stylesheet">
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template
        -->
<link href="css/animate.css" rel="stylesheet">
<link href="css/chosen.min.css" rel="stylesheet">


<link href="bootstrap-datepicker/css/bootstrap-datepicker.css"
	rel="stylesheet">
<link href="bootstrap-datepicker/css/bootstrap-datepicker3.css"
	rel="stylesheet">
<link
	href="bootstrap-datepicker/css/bootstrap-datepicker.standalone.css"
	rel="stylesheet">
<link
	href="bootstrap-datepicker/css/bootstrap-datepicker3.standalone.css"
	rel="stylesheet">






</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
	<%@include file="head.jspf"%>
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="container-fluid">
				<div class="row" align="center">
					<div class="col-md-4"
						style="background-color: black; align-items: center;">
						<a class="navbar-brand" href="#">Unidad:
							${sessionScope.usuario[3].descripcion} </a>
					</div>
					<div class="col-md 4" style="background-color: black;">
						<a class="navbar-brand" href="#">Oficina:
							${sessionScope.usuario[4].descripcion}</a>
					</div>
					<div class="col-md 4" style="background-color: black;">
						<a class="navbar-brand" href="#">Perfil:
							${sessionScope.usuario[5].descripcion}</a>
					</div>
				</div>
			</div>

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Sigedo</a></li>
				<li class="breadcrumb-item active">${breadcrumb}</li>
			</ol>
			<c:import url="dinamico/${body}.jsp" />

			<script src="vendor/jquery/jquery.min.js"></script>
			<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
			<!-- Core plugin JavaScript-->
			<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
			<!-- Page level plugin JavaScript-->
			<script src="vendor/chart.js/Chart.min.js"></script>

			<!-- Custom scripts for all pages-->
			<script src="js/sb-admin.min.js"></script>
			<script src="js/sb-admin-charts.min.js"></script>
			<!-- Custom scripts for this page
               
                
                
                -->
			<script src="js/sb-admin-datatables.min.js"></script>
			<script src="vendor/datatables/jquery.dataTables.js"></script>
			<script src="vendor/datatables/dataTables.bootstrap4.js"></script>
			<script src="js/bootstrap-notify.min.js"></script>
			<script src="js/chosen.jquery.min.js"></script>
			<script src="js/dirtexto.js"></script>
			<script src="js/loader.js"></script>
			<script src="js/highcharts.js"></script>
			<script src="js/exporting.js"></script>




			<script src="bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
			<script
				src="bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js"></script>
		</div>
</body>
<footer class="sticky-footer">
	<div class="container">
		<div class="text-center">
			<small>Copyright © Maldonado 2018</small>
		</div>
	</div>
</footer>
<!-- Logout Modal-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Desea Salir del
					Sistema?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Seleccione "Cerrar Sesión" si está
				seguro de salir del sistema.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
				<a class="btn btn-primary" href="SPage?action=login">Cerrar
					Sesión</a>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="verPdf" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Archivo
					Digitalizado</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" align="center">
				<div id="divPdfView" align="center">
					<img src="images/reloj.gif">
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

			</div>
		</div>
	</div>
</div>





<script type="text/javascript">
	$(".chosen-select").chosen()

	function downloadfile(id_fichero) {
		window.open("ServBandejaAJAX?hdEvento=DOWNLOAD&id=" + id_fichero,
				'_blank');
	}

	function fnVerPDF(idfichero) {
		$("#verPdf").modal();
		if (idfichero != '') {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = 'VER_PDF';
			fn_ajax(vservlet, txtevento, idfichero);
		}
	}

	function fn_ajax(servlet, evento, id) {
		$
				.ajax({
					url : servlet,
					data : {
						hdEvento : evento,
						id_fichero : id
					},
					success : function(responseText) {
						var v_resultado = responseText + "";
						if (v_resultado == 'NOSESION') {
							window.location = 'SPage?action=login';
						} else if (v_resultado == 'VACIO') {
							$('#divPdfView').html(
									'No Se pudo Procesar Archivo PDF');
						} else {
							var frame = '<div style="clear: both" align="center"><iframe id="viewer" Width="600px" height="450px" align="center" scrolling="auto" frameborder="0" allowtransparency="true" border="0"></iframe></div>';
							var respuesta = v_resultado.split('||');
							var b64 = respuesta[0];
							var tipo = respuesta[1];
							$('#divPdfView').html(frame);
							$('#viewer').attr('src',
									//'data:application/pdf;base64,'
									'data:'+tipo+';base64,'
											+ b64);
						}
					}
				});
	}
</script>
<script type="text/javascript">
	function fnlistarBandeja(evento) {
		if (evento != '') {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = evento;
			var jqdata = {
				hdEvento : txtevento
			};

			fnEjecutarPeticion(vservlet, jqdata, txtevento);
		}
	}
	function fnEjecutarPeticion(vservlet, jdata, evento) {
		$.ajax({
			url : vservlet,
			method : 'POST',
			data : jdata,
			success : function(responseText) {
				fnControlEvento(evento, responseText + '');
			}
		});
	}
	function fnControlEvento(vevento, vvrespuesta) {
		if (vvrespuesta == 'ERROR_SESION') {
			window.location = 'SPage';
		} else {
			var v_resultado = vvrespuesta + "";
			if (v_resultado == 'NOSESION') {
				window.location = 'SPage?action=login';
			} else if (v_resultado == '') {
				//error
				danger('ERROR, No cargo lista de documentos')
			} else {
				if (vevento == 'BANDEJA_RECIBIDO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#trecibido').html(tabla);
					$('#lblrecibido').html(numero);
					$('#dataTable').DataTable();
				}
				if (vevento == 'BANDEJA_PENDIENTE') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblpendiente').html(numero);
					$('#tpendiente').html(tabla);
					$('#dataTable1').DataTable();
				}
				if (vevento == 'BANDEJA_DERIVADO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblderivado').html(numero);
					$('#tderivado').html(tabla);
					$('#dataTable2').DataTable();
				}
				if (vevento == 'BANDEJA_DEVUELTO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lbldevuelto').html(numero);
					$('#tdevuelto').html(tabla);
					$('#dataTable3').DataTable();
				}
				if (vevento == 'BANDEJA_APROBADO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblaprobado').html(numero);
					$('#taprobado').html(tabla);
					$('#dataTable4').DataTable();
				}
				if (vevento == 'BANDEJA_CONTESTADO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblcontestado').html(numero);
					$('#tcontestado').html(tabla);
					$('#dataTable5').DataTable();
				}
				if (vevento == 'BANDEJA_ARCHIVADO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblarchivado').html(numero);
					$('#tarchivado').html(tabla);
					$('#dataTable6').DataTable();
				}
				if (vevento == 'BANDEJA_RESPONDIDO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblrespuesta').html(numero);
					$('#trespuesta').html(tabla);
					$('#dataTable7').DataTable();
				}
				if (vevento == 'BANDEJA_ADMINISTRATIVO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lbladministrativo').html(numero);
					$('#tadministrativo').html(tabla);
					$('#dataTable8').DataTable();
				}
				if (vevento == 'BANDEJA_DESESTIMADO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lbldesaprobado').html(numero);
					$('#tdesaprobado').html(tabla);
					$('#dataTable9').DataTable();
				}
				if (vevento == 'BANDEJA_ARCHIVO_PENDIENTE') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblarchivopendiente').html(numero);
					$('#tarchivopendiente').html(tabla);
					$('#dataTable10').DataTable();
				}
				if (vevento == 'BANDEJA_ARCHIVO_DIGITALIZADO') {
					var respuesta = v_resultado.split('||');
					var tabla = respuesta[0];
					var numero = respuesta[1];
					$('#lblarchivodigitalizado').html(numero);
					$('#tarchivodigitalizado').html(tabla);
					$('#dataTable11').DataTable();
				}

				if (vevento == 'DERIVAR') {
					if (v_resultado != '0') {
						$('#modDerivar').modal('hide');
						alerta('Correcto, se derivo la Hoja de trámite!');
						fnlistarBandeja('BANDEJA_RECIBIDO');
						fnlistarBandeja('BANDEJA_DERIVADO');
						fnlistarBandeja('BANDEJA_DEVUELTO');
					} else {
						danger('Error, No se derivo la Hoja de trámite!');
					}
				}
				if (vevento == 'ARCHIVAR') {
					if (v_resultado != '0') {
						$('#modArchivar').modal('hide');
						alerta('Correcto, se Archivó la Hoja de trámite!');
						fnlistarBandeja('BANDEJA_RECIBIDO');
						fnlistarBandeja('BANDEJA_ARCHIVADO');
						fnlistarBandeja('BANDEJA_DEVUELTO');
					} else {
						danger('Error, No se Archivó Hoja de trámite!');
					}
				}
				if (vevento == 'VALIDAR RESPUESTA') {
					if (v_resultado != '0') {
						$('#modValidar').modal('hide');
						alerta('Correcto, se Validó la respuesta a la Hoja de trámite!');
						fnlistarBandeja('BANDEJA_RESPONDIDO');
						fnlistarBandeja('BANDEJA_APROBADO');
					} else {
						danger('Error, No se Archivó Hoja de trámite!');
					}
				}
				if (vevento == 'DEVOLVER') {
					if (v_resultado != '0') {
						$('#modDEVOLVER').modal('hide');
						alerta('Correcto, se Devolvió la Hoja de trámite!');
						fnlistarBandeja('BANDEJA_ADMINISTRATIVO');
						fnlistarBandeja('BANDEJA_DESESTIMADO');
					} else {
						danger('Error, No se Archivó Hoja de trámite!');
					}
				}
				if (vevento == 'RESPONDER') {
					if (v_resultado != '0') {
						$('#modRESPONDER').modal('hide');
						alerta('Correcto, se Respondió la Hoja de trámite!');
						fnlistarBandeja('BANDEJA_ADMINISTRATIVO');
						fnlistarBandeja('BANDEJA_DESESTIMADO');
					} else {
						danger('Error, No se Archivó Hoja de trámite!');
					}
				}
				if (vevento == 'CONTESTAR') {
					if (v_resultado != '0') {
						$('#modCONTESTAR').modal('hide');
						alerta('Correcto, se Contestó la Hoja de trámite!');
						fnlistarBandeja('BANDEJA_APROBADO');
						fnlistarBandeja('BANDEJA_CONTESTADO');
					} else {
						danger('Error, No se Contestó Hoja de trámite!');
					}
				}
				if (vevento == 'DIGITALIZAR') {
					if (v_resultado != '0') {
						$('#modDigitalizar').modal('hide');
						alerta('Correcto, se digitalizó el documento!');
						fnlistarBandeja('BANDEJA_ARCHIVO_PENDIENTE');
						fnlistarBandeja('BANDEJA_ARCHIVO_DIGITALIZADO');
					} else {
						danger('Error, No se digitalizó Hoja de trámite!');
					}
				}
				if (vevento == 'TRAZABILIDAD') {
					//alert(v_resultado);
						var respuesta = v_resultado.split('||');
						var tabla = respuesta[0];
						var numero = respuesta[1];
						if (numero=='0') {	
							$('#ttrazabilidad').html('');
							$('#dataTable12').DataTable();	
							danger('Error, No se encontró la Hoja de trámite!');
						}else{
							//$('#lblarchivodigitalizado').html(numero);
							$('#ttrazabilidad').html(tabla);
							$('#dataTable12').DataTable();	
						}	
				}
				if (vevento == 'BUSCAR_ARCHIVO') {
					//alert(v_resultado);
						var respuesta = v_resultado.split('||');
						var tabla = respuesta[0];
						var numero = respuesta[1];
						if (numero=='0') {	
							$('#tconsarchivo').html('');
							$('#dataTable13').DataTable();	
							danger('Error, No se encontró Documento ');
						}else{
							//$('#lblarchivodigitalizado').html(numero);
							$('#tconsarchivo').html(tabla);
							$('#dataTable13').DataTable();	
						}	
				}
				if (vevento == 'VER_GRAFICOS') {
					alert(v_resultado);
						var respuesta = v_resultado.split('||');
						var graf1 = respuesta[0];
						var graf2 = respuesta[1];
						var graf3 = respuesta[2];
						var graf4 = respuesta[3];
						graficoHigchar('titulo',graf1);
						graficoHigchar2('titulo',graf2);
						graficoHigchar3('titulo',graf3);
						graficoHigchar4('titulo',graf4);
							//$('#tconsarchivo').html(tabla);
							//$('#dataTable13').DataTable();	
							
				}
				

			}
		}
	}
</script>
  
<script>
	function alerta(msg) {
		var texto = msg;
		$.notify({
			title : '<strong>Mensaje:</strong>',
			message : texto
		}, {
			type : 'success'
		});
	}
	function danger(msg) {
		var texto = msg;
		$.notify({
			title : '<strong>Alerta:</strong>',
			message : texto
		}, {
			type : 'danger'
		});
	}
</script>
</html>

