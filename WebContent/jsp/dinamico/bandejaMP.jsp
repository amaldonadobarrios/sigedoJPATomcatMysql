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
<ol class="breadcrumb">
	<div class="container-fluid">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_PENDIENTE')">
				<a class="nav-link active primary" data-toggle="tab"
				href="#Pendiente" role="tab">Pendiente <span
					class="badge badge-pill badge-primary"><div
							id="lblpendiente"></div></span></a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_RECIBIDO')">
				<a class="nav-link" data-toggle="tab" href="#Recibido" role="tab">Recibido
					<span class="badge badge-pill badge-primary"><div
							id="lblrecibido"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_DEVUELTO')">
				<a class="nav-link" data-toggle="tab" href="#Devuelto" role="tab">Devuelto
					<span class="badge badge-pill badge-primary"><div
							id="lbldevuelto"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_DERIVADO')">
				<a class="nav-link" data-toggle="tab" href="#Derivados" role="tab">Derivado
					<span class="badge badge-pill badge-info"><div
							id="lblderivado"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_APROBADO')">
				<a class="nav-link" data-toggle="tab" href="#Aprobado" role="tab">Aprobado
					<span class="badge badge-pill badge-primary"><div
							id="lblaprobado"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_CONTESTADO')">
				<a class="nav-link" data-toggle="tab" href="#Contestado" role="tab">Contestado
					<span class="badge badge-pill badge-info"><div
							id="lblcontestado"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('BANDEJA_ARCHIVADO')">
				<a class="nav-link" data-toggle="tab" href="#Archivado" role="tab">Archivado
					<span class="badge badge-pill badge-info"><div
							id="lblarchivado"></div></span>
			</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="Pendiente" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tpendiente"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Recibido" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="trecibido"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Devuelto" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tdevuelto"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Derivados" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tderivado"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Aprobado" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="taprobado"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Contestado" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tcontestado"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
				</div>
			</div>
			<div class="tab-pane" id="Archivado" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tarchivado"></div>
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
<div class="modal fade" id="modArchivar" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					ARCHIVAR HOJA DE TRÁMITE N° <label id="lblhtArchiv"></label>
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
					onclick="fnreg_archivar();">Aceptar</button>
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

			</div>
		</div>
	</div>
</div>
<div class="modal fade animated bounceIn" id="modCONTESTAR" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					CONTESTAR HOJA DE TRÁMITE N° <label id="lblhtCONTESTAR"></label>
				</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body" align="justify">
				<label id="lblasuntoCONTESTAR">Asunto: </label><br> <label
					id="lbldocumentoCONTESTAR">Asunto: </label> <input type="hidden"
					id="id_htCONTESTAR"> <input type="hidden" id="id_docCONTESTAR">
				<input type="hidden" id="id_unidadCONTESTAR">









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
			<div class="modal-footer">
				<button class="btn btn-primary" type="button"
					onclick="fnreg_archivar();">Aceptar</button>
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>

			</div>
		</div>
	</div>
</div>
</div>
</div>


<script type="text/javascript">
//-----CONTESTAR-----------------------------------------------------------
function fnContestar(idht, asu, doc, idunireg, iddoc, idusureg) {
		$('#lblhtCONTESTAR').html(idht);
		$('#lblasuntoCONTESTAR').html('Asunto: ' + asu);
		$('#lbldocumentoCONTESTAR').html('Documento: ' + doc);
		document.getElementById("id_htCONTESTAR").value = idht;
		document.getElementById("id_docCONTESTAR").value = iddoc;
		document.getElementById("id_unidadCONTESTAR").value = idunireg;
		
		$('#lblobsCONTESTAR').css("color", "black");
		$("#modCONTESTAR").modal();
	}



//----ARCHIVAR-------------------------------------------------------------
	function fnreg_archivar() {
		var id_unidad_destino = document.getElementById("id_unidadArchiv").value;
		var observaciones = document.getElementById("txtobservacionesArchiv").value;
		var id_ht = document.getElementById("id_htArchiv").value;
		var id_doc = document.getElementById("id_docArchiv").value;
		if (validarARCHIVAR()) {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = 'ARCHIVAR';
			var jqdata = {
				hdEvento : txtevento,
				id_ht : id_ht,
				id_doc : id_doc,
				id_usuario_destino : '0',
				id_unidad_destino : id_unidad_destino,
				id_oficina_destino : '0',
				observaciones : observaciones
			};
			if (confirm('Esta seguro de Archivar la Hoja de Trámite N°' + id_ht)) {
				fnEjecutarPeticion(vservlet, jqdata, txtevento);
			}
		}

	}
	function validarARCHIVAR() {
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
	function fnarchivar(idht, asu, doc, idunireg, iddoc) {
		$('#lblhtArchiv').html(idht);
		$('#lblasuntoArchiv').html('Asunto: ' + asu);
		$('#lbldocumentoArchiv').html('Documento: ' + doc);
		document.getElementById("id_htArchiv").value = idht;
		document.getElementById("id_docArchiv").value = iddoc;
		document.getElementById("id_unidadArchiv").value = idunireg;
		document.getElementById("txtobservacionesArchiv").value = '';
		$('#lblobsArchiv').css("color", "black");
		$("#modArchivar").modal();
	}
	// DERIVAR-----------------------------------------------------------------------------------------------------
	function fnreg_derivar() {
		var id_oficina_destino = document.getElementById("cbxoficina").value;
		var id_unidad_destino = document.getElementById("id_unidad").value;
		var id_usuario_destino = document.getElementById("cbxusuario").value;
		var observaciones = document.getElementById("txtobservaciones").value;
		var id_ht = document.getElementById("id_ht").value;
		var id_doc = document.getElementById("id_doc").value;
		if (validar()) {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = 'DERIVAR';
			var jqdata = {
				hdEvento : txtevento,
				id_ht : id_ht,
				id_doc : id_doc,
				id_usuario_destino : id_usuario_destino,
				id_unidad_destino : id_unidad_destino,
				id_oficina_destino : id_oficina_destino,
				observaciones : observaciones
			};
			if (confirm('Esta seguro de Derivar la Hoja de Trámite N°' + id_ht)) {
				fnEjecutarPeticion(vservlet, jqdata, txtevento);
			}
		}
	}
	function validar() {
		var validar = true;
		var ofi = document.getElementById('cbxoficina').value;
		var usu = document.getElementById('cbxusuario').value;
		$('#lbloficina').css("color", "black");
		$('#lblusuario').css("color", "black");
		if (ofi == '') {
			$('#lbloficina').css("color", "red");
			validar = false;
		}
		if (usu == '') {
			$('#lblusuario').css("color", "red");
			validar = false;
		}
		return validar;
	}
	function fn_listar_administrativos() {
		var id_oficina = document.getElementById("cbxoficina").value;
		var id_unidad = document.getElementById("id_unidad").value;
		if (id_oficina != '' && id_unidad != '') {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServAdministracionAJAX';
			var txtevento = 'COMBO_ADMINISTRATIVO';
			fn_ajax_administrativos(vservlet, txtevento, id_unidad, id_oficina);
		}
		function fn_ajax_administrativos(servlet, evento, unidad, oficina) {
			$.ajax({
				url : servlet,
				data : {
					hdEvento : evento,
					id_unidad : unidad,
					id_oficina : oficina
				},
				success : function(responseText) {
					var v_resultado = responseText + "";
					if (v_resultado == 'NOSESION') {
						window.location = 'SPage?action=login';
					} else if (v_resultado == 'VACIO') {
						$("#cbxusuario").empty();
					} else {
						//alert(v_resultado);
						$("#cbxusuario").empty();
						var arr = JSON.parse(v_resultado);
						ShareInfoLength = arr.length;
						//alert(ShareInfoLength);
						$("<option/>").attr("value", '').text('Seleccione')
								.appendTo("#cbxusuario");
						for (var i = 0; i < ShareInfoLength; i++) {
							$("<option/>").attr("value", arr[i].id).text(
									arr[i].detalle).appendTo("#cbxusuario");
						}
					}
				}
			});

		}

	}
	function fnlistarOficinax(id) {
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
					$("#cbxoficina").empty();
				} else {
					//alert(v_resultado);
					$("#cbxoficina").empty();
					var arr = JSON.parse(v_resultado);
					ShareInfoLength = arr.length;
					//alert(ShareInfoLength);
					$("<option/>").attr("value", '').text('Seleccione')
							.appendTo("#cbxoficina");
					for (var i = 0; i < ShareInfoLength; i++) {
						$("<option/>").attr("value", arr[i].id).text(
								arr[i].detalle).appendTo("#cbxoficina");
					}
				}
			}
		});
	}
	function fnderivar(idht, asu, doc, idunireg, iddoc) {
		$('#lblht').html(idht);
		$('#lblasunto').html('Asunto: ' + asu);
		$('#lbldocumento').html('Documento: ' + doc);
		document.getElementById("id_ht").value = idht;
		document.getElementById("id_doc").value = iddoc;
		document.getElementById("id_unidad").value = idunireg;
		document.getElementById("txtobservaciones").value = '';
		$("#cbxusuario").empty();
		$("#modDerivar").modal();
		$('#lbloficina').css("color", "black");
		$('#lblusuario').css("color", "black");

	}
	// RECIBIR-----------------------------------------------------------------------------------------------------
	function fnrecibir(idht, iduni, idofi, idusu, iddoc) {
		if (idht != '' && iduni != '' && idofi != '' && idusu != ''
				&& iddoc != '') {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = 'RECIBIR';
			var jdata = {
				hdEvento : txtevento,
				id_ht : idht,
				id_uni : iduni,
				id_ofi : idofi,
				id_usu : idusu,
				id_doc : iddoc
			};
			if (confirm('Esta seguro de recibir la Hoja de Trámite N°' + idht)) {
				fnrecibir_ajax(vservlet, txtevento, jdata);
			}

		}
	}

	function fnrecibir_ajax(servlet, evento, jdata) {
		$.ajax({
			url : servlet,
			data : jdata,
			success : function(responseText) {
				var v_resultado = responseText + "";
				if (v_resultado == 'NOSESION') {
					window.location = 'SPage?action=login';
				} else if (v_resultado == '0') {
					//error	
					danger('Error, no se recibio la Hoja de Trámite');
				} else {
					alert(v_resultado);
					//ok
					alerta('Correcto, se recibio la Hoja de trámite');

				}
			}
		});
	}
</script>
<script type="text/javascript">
	window.onload = function() {
		fnlistarBandeja('BANDEJA_PENDIENTE');
		fnlistarBandeja('BANDEJA_RECIBIDO');
		fnlistarBandeja('BANDEJA_DERIVADO');
		fnlistarBandeja('BANDEJA_DEVUELTO');
		fnlistarBandeja('BANDEJA_APROBADO');
		fnlistarBandeja('BANDEJA_CONTESTADO');
		fnlistarBandeja('BANDEJA_ARCHIVADO');
	}
</script>

