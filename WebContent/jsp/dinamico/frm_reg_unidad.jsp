<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<!DOCTYPE html>
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
		<div class="card-header">Registrar Unidades</div>
		<div class="card-body">
			<form action="<%=sWS%>/ServAdministracion" method="post" id="form1"
				name="form1">
				<div class="form-group">
					<label for="exampleInputEmail1">Unidad</label> <input type="hidden"
						id="id_unidad" name="id_unidad"> <input type="hidden"
						id="hdEvento" name="hdEvento" value="AGREGAR_USUARIO"> <input class="form-control"
						id="txtunidad" name="txtunidad" type="text"
						aria-describedby="emailHelp" placeholder="Ingrese Unidad">
				</div>
				<input class="btn btn-success btn-block"
					onclick="javascript:añadirunidad();" id="btn1añadir"
					value="Añadir Unidad" type="button">
			</form>
		</div>
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>UNIDAD</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="unid" items="${lstUnidad}" varStatus="loop">
						<tr>
							<td class="center">${loop.count}   ${unid.descripcion}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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

	window.onload = function() {

	}
</script>




