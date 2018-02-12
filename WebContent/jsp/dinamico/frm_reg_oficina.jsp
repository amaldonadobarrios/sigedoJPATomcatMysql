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
		<div class="card-header">Registrar Oficinas</div>
		<div class="card-body">
			<form action="ServAdministracion" method="post" id="form1"
				name="form1">
				<input type="hidden" id="hdEvento" name="hdEvento">

				<div class="form-group">
					<label for="exampleInputEmail1">Oficina</label> <input
						class="form-control" id="txtoficina" name="txtoficina" type="text"
						aria-describedby="emailHelp" placeholder="Enter oficina">
				</div>
				<input class="btn btn-primary btn-block"
					onclick="javascript:añadiroficina();" id="btn2añadir"
					value="Añadir Oficina" type="button">
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
					<c:forEach var="ofi" items="${lstOfi}" varStatus="loop">
						<tr>
							<td class="center"><a> ${loop.count}   ${ofi.descripcion}</a></td>
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

	function añadiroficina() {
		var oficina = $('#txtoficina').val();
		if (confirm("Desea Añadir una Oficina")) {
			if (oficina !=='') {
				$('#hdEvento').val('AGREGAR_OFICINA');
				document.forms["form1"].submit();
			} else {
				danger('Ingrese el nombre de la Oficina');
			}
		}

	}
</script>




