<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<!DOCTYPE html>
<div class="row">

	<div class="col-md-6">
		<div class="card-header">Datos Personales</div>
		<div class="card-body">
			<form action="<%=sWS%>/ServAdministracion" method="post" id="form1"
				name="form1">
				<input type="hidden" id="hdEvento" name="hdEvento">
				<div class="form-group">
					<label for="lblcip">CIP</label> <input class="form-control"
						id="txtcip" name="txtcip" type="text"
						aria-describedby="Ingrese su cip" placeholder="Ingrese su cip">
				</div>
				<div class="form-group">
					<label for="lbldni">DNI</label> <input class="form-control"
						id="txtdni" name="txtdni" type="text"
						aria-describedby="Ingrese su dni" placeholder="Ingrese su dni">
				</div>
				<div class="form-group">
					<label for="lblgrado">Grado</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxgrado" name="cbxgrado">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>
						<option data-tokens="ketchup mustard" value="S1 PNP">S1
							PNP</option>
						<option data-tokens="ketchup mustard" value="S2 PNP">S2
							PNP</option>
						<option data-tokens="ketchup mustard" value="S3 PNP">S3
							PNP</option>
					</select>
				</div>
				<div class="form-group">
					<label for="lblapepat">Apellido Paterno</label> <input
						class="form-control" id="txtapepat" name="txtapepat" type="text"
						aria-describedby="Ingrese su Apellido Paterno"
						placeholder="Ingrese su Apellido Paterno">
				</div>
				<div class="form-group">
					<label for="lblapemat">Apellido Materno</label> <input
						class="form-control" id="txtapemat" name="txtapemat" type="text"
						aria-describedby="Ingrese su Apellido Materno"
						placeholder="Ingrese su Apellido Materno">
				</div>
				<div class="form-group">
					<label for="lblnom">Nombres</label> <input class="form-control"
						id="txtnom" name="txtnom" type="text"
						aria-describedby="Ingrese sus Nombres"
						placeholder="Ingrese sus Nombres">
				</div>
				<div class="form-group">
					<label for="lblcel">Celular</label> <input class="form-control"
						id="txtcel" name="txtcel" type="phone"
						aria-describedby="Ingrese su numero celular"
						placeholder="Ingrese su numero celular">
				</div>
				<div class="form-group">
					<label for="lblunidad">Unidad</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxunidad" name="cbxunidad">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>

					</select>
				</div>
				<div class="form-group">
					<label for="lbloficina">Oficina</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxoficina" name="cbxoficina">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>

					</select>
				</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="card-header">Datos de Usuario</div>
		<div class="card-body">

			<div class="form-group">
				<label for="lblperfil">Perfil</label> <select
					class="selectpicker form-control" data-live-search="true"
					id="cbxperfil" name="cbxperfil">
					<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>
					<!-- <c:forEach var="unid" items="${combouni}" varStatus="loop">
									<option data-tokens="ketchup mustard" value="${unid.idUnidad}">${unid.descripcion}</option>
								</c:forEach> -->
				</select>
			</div>
			<div class="form-group">
				<label for="lblnom">Usuario</label> <input class="form-control"
					id="txtusu" name="txtusu" type="text"
					aria-describedby="Ingrese sus Usuario"
					placeholder="Ingrese su Usuario">
			</div>
			<div class="form-group">
				<label for="lblpass">Contraseña</label> <input class="form-control"
					id="txtpass" name="txtpass" type="password"
					aria-describedby="Ingrese sus contraseña"
					placeholder="Ingrese su contraseña">
			</div>
			<div class="form-group">
				<label for="lblestado">Estado</label> <select
					class="selectpicker form-control" data-live-search="true"
					id="cbxest" name="cbxest">
					<option data-tokens="ketchup mustard" value="1" selected="selected">ACTIVO</option>
					<option data-tokens="ketchup mustard" value="0">DESACTIVO</option>
				</select>
			</div>
			<input class="btn btn-success btn-block" id="btnregistrar"
				value="Registrar" type="button">
			<div class="form-group">

				<img src="https://aguila6.pnp.gob.pe/FotosTit/6/31424836.jpg"
					class="img-circle" alt="Cinque Terre" width="304" height="236">
			</div>
			</form>
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
		document.forms["form2"].submit();
	}
	}
	window.onload=function() {
			$("#cbxunidad").val(${VcomboUnidad});
		}
	
</script>




