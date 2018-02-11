<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<!DOCTYPE html>
<div class="row">


<div class="container">
    <div class="card card-register mx-auto mt-5">
		<div class="card-header">Asignar Oficinas</div>
		<div class="card-body">
			<form action="<%=sWS%>/ServAdministracion" method="post" id="form1" name="form1">
    <input type="hidden" id="hdEvento2" name="hdEvento2">
    <div class="form-group">
							<label for="exampleInputEmail1">Seleccione Unidad</label> <select 
								class="selectpicker form-control" data-live-search="true" id="cbxunidad" name="cbxunidad" onchange="fn_listarOficina()">
								<option data-tokens="ketchup mustard" value=""
									selected="selected" >Seleccione Unidad</option>
								<c:forEach var="unid" items="${combouni}" varStatus="loop">
									<option data-tokens="ketchup mustard" value="${unid.idUnidad}">${unid.descripcion} </option>
								</c:forEach>

							</select>
						</div>			
	</form>	

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
							<td class="center"><a>
									${loop.count} ${ofi.descripcion}</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input class="btn btn-success btn-block"
					onclick="javascript:añadirunidad();" id="btn1añadir"
					value="Añadir Oficina" type="button">
	</div>
	
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
	function añadirunidad() {
		var unidad = $('#txtunidad').val();
		if (confirm("Desea Añadir una Unidad")) {
			if (unidad !== '') {
				$('#hdEvento').val('AGREGAR_UNIDAD');
				document.forms["form1"].submit();
			} else {
				danger('Ingrese un nombre de Unidad');
			}
		}

	}
	function fn_listarOficina(){
	var id_unidad=$('#cbxunidad').val();
	if (id_unidad!='') {
	$('#hdEvento2').val('BUSCAR_OFICINA');
		document.forms["form1"].submit();
	}
	}
	window.onload=function() {
			$("#cbxunidad").val(${VcomboUnidad});
		}
	
</script>




