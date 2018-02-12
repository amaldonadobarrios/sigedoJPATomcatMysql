<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<!DOCTYPE html>
<div class="row">


	<div class="container">
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
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Asignar Oficinas</div>
			<div class="card-body">
				<form action="<%=sWS%>/ServAdministracion" method="post" id="form1"
					name="form1">
					<input type="hidden" id="hdEvento" name="hdEvento">
					<div class="form-group">
						<label for="exampleInputEmail1">Seleccione Unidad</label> <select
							class="selectpicker form-control " data-live-search="true"
							id="cbxunidad" name="cbxunidad" onchange="fn_listarOficina()">
							<option data-tokens="ketchup mustard" value=""
								selected="selected">Seleccione Unidad</option>
							<c:forEach var="unid" items="${combouni}" varStatus="loop">
								<option data-tokens="ketchup mustard" value="${unid.idUnidad}">${unid.descripcion}
								</option>
							</c:forEach>

						</select>
					</div>
				

			</div>
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable1" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>OFICINAS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ofi" items="${listaoficina}" varStatus="loop">
							<tr>
								<td class="center"><a> ${loop.count} ${ofi.descripcion}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-12" align="center">
				<div class="input-group">
					<select class="selectpicker form-control " data-live-search="true"
						id="cbxoficina" name="cbxoficina">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione
							Oficina</option>
						<c:forEach var="ofi" items="${lstOfi}" varStatus="loop">
							<option data-tokens="ketchup mustard" value="${ofi.idOficina}">${ofi.descripcion}
							</option>
						</c:forEach>

					</select> <span class="input-group-btn">
						<button class="btn btn-success" type="button"
							onclick="javascript:añadirOficina();">Agregar Oficina</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
</form>
	</div>
</div>
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

	function seleccionarUnidad(msg, uni, id) {
		$('#txtunidad').val(uni);
		$('#id_unidad').val(id);
		$('#btn1añadir').attr("disabled", true);
		$('#btn1modificar').attr("disabled", false);
		alerta(msg);
	}
	function añadirOficina() {
		var oficina = $('#cbxoficina').val();
		var unidad= $('#cbxunidad').val(); 
		if (confirm("Desea asignar una oficina")) {
			if (oficina !== '') {
				if (unidad!== '') {
				$('#hdEvento').val('ASIGNAR_OFICINA');
				document.forms["form1"].submit();	
				}else{
				danger('Debe Seleccionar una Unidad');
				}
			} else {
				danger('Debe Seleccionar una Oficina');
				return;
			}
		}

	}
	function fn_listarOficina(){
	var id_unidad=$('#cbxunidad').val();
	if (id_unidad!='') {
	$('#hdEvento').val('BUSCAR_OFICINA');
		document.forms["form1"].submit();
	}
	}
	window.onload=function() {
			$("#cbxunidad").val(${VcomboUnidad});
		}
	
</script>




