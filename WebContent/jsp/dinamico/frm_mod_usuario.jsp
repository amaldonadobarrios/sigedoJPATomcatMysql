<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sWS = request.getContextPath();
%>
<script>
function fnconsultar(){
var cip = $('#txtconsulta').val();
if (cip!='') {
	var contexto = document.getElementById("contexto").value;
		var vservlet = contexto + '/ServAdministracionAJAX';
		var txtevento = 'CONSULTAR_USUARIO';
		fn_ajax_fnconsultar(vservlet, txtevento, cip);	
}}
function fn_ajax_fnconsultar(servlet, evento, cip) {
		$.ajax({
			url : servlet,
			data : {
				hdEvento : evento,
				cip : cip
			},
			success : function(responseText) {
				var v_resultado = responseText + "";
				if (v_resultado == 'NOSESION') {
					window.location = 'SPage';
				} else if (v_resultado == 'VACIO') {
					//$("#cbxoficina").empty();
				}else{
					alert(v_resultado);
					var arr = JSON.parse(v_resultado);
					var arrPersona = JSON.parse(arr[0]);
					var arrUsuario = JSON.parse(arr[1]);
					
					var id_Persona=arrPersona.idPersona;
					var cip=arrPersona.cip;
					var grado=arrPersona.grado;
					var unidad=
					var id_Usuario=arrUsuario.idUsuario;
	
					$("#txtcip").val(cip);
					$("#cbxgrado").val(grado);
					
	
					
					//$("#cbxoficina").empty();
					//var arr = JSON.parse(v_resultado);
					//ShareInfoLength = arr.length;
					//alert(ShareInfoLength);
					//$("<option/>").attr("value", '').text('Seleccione').appendTo("#cbxoficina");
				//	for(var i=0; i<ShareInfoLength; i++)
				//	{
				//	$("<option/>").attr("value", arr[i].id).text(arr[i].detalle).appendTo("#cbxoficina");    
				//	}
				}
			}
		});


}
	function fnlistarOfi(id) {
		var x = id.value;
		var contexto = document.getElementById("contexto").value;
		var vservlet = contexto + '/ServAdministracionAJAX';
		var txtevento = 'COMBO_OFICINA';
		fn_ajax_fnlistarOfi(vservlet, txtevento, x);
	}

	function fn_ajax_fnlistarOfi(servlet, evento, id) {
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
				}else{
					//alert(v_resultado);
					$("#cbxoficina").empty();
					var arr = JSON.parse(v_resultado);
					ShareInfoLength = arr.length;
					//alert(ShareInfoLength);
					$("<option/>").attr("value", '').text('Seleccione').appendTo("#cbxoficina");
					for(var i=0; i<ShareInfoLength; i++)
					{
					$("<option/>").attr("value", arr[i].id).text(arr[i].detalle).appendTo("#cbxoficina");    
					}
				}
			}
		});
	}
</script>
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
	<div class="container" align="center">
		<div class="col-md-8" align="center">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Buscar por CIP"
					maxlength="8" onkeypress="return solo_numeros(event)"
					id="txtconsulta" name="txtconsulta"> <span
					class="input-group-btn">
					<button class="btn btn-default" onclick="fnconsultar();"
						type="button">Consultar</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<div class="col-md-6">
		<div class="card-header">Datos Personales</div>
		<div class="card-body">
			<form data-toggle="validator" role="form"
				action="<%=sWS%>/ServAdministracion" method="post" id="form1"
				name="form1">
				<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
				<input type="hidden" id="hdEvento" name="hdEvento"
					value="AGREGAR_USUARIO">
				<div class="form-group">
					<label for="lblcip">CIP</label> <input class="form-control"
						id="txtcip" name="txtcip" type="text"
						aria-describedby="Ingrese su cip" placeholder="Ingrese su cip"
						required="required" maxlength="8"
						onkeypress="return solo_numeros(event)">
				</div>
				<div class="form-group">
					<label for="lbldni">DNI</label> <input class="form-control"
						id="txtdni" name="txtdni" type="text"
						aria-describedby="Ingrese su dni" maxlength="8"
						placeholder="Ingrese su dni" required="required"
						onkeypress="return solo_numeros(event)">
				</div>
				<div class="form-group">
					<label for="lblgrado">Grado</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxgrado" name="cbxgrado" required="required">
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
						placeholder="Ingrese su Apellido Paterno" required="required"
						onkeypress="return solo_letras(event)">
				</div>
				<div class="form-group">
					<label for="lblapemat">Apellido Materno</label> <input
						class="form-control" id="txtapemat" name="txtapemat" type="text"
						aria-describedby="Ingrese su Apellido Materno"
						placeholder="Ingrese su Apellido Materno" required="required"
						onkeypress="return solo_letras(event)">
				</div>
				<div class="form-group">
					<label for="lblnom">Nombres</label> <input class="form-control"
						id="txtnom" name="txtnom" type="text"
						aria-describedby="Ingrese sus Nombres"
						placeholder="Ingrese sus Nombres" required="required"
						onkeypress="return solo_letras(event)">
				</div>
				<div class="form-group">
					<label for="lblcel">Celular</label> <input class="form-control"
						id="txtcel" name="txtcel" type="tel"
						aria-describedby="Ingrese su numero celular"
						placeholder="Ingrese su numero celular" required="required"
						maxlength="9" onkeypress="return solo_numeros(event)">
				</div>
				<div class="form-group">
					<label for="lblunidad">Unidad</label> <select
						class="selectpicker form-control" data-live-search="true"
						id="cbxunidad" name="cbxunidad" required="required"
						onchange="javascript:fnlistarOfi(this);">
						<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>
						<c:forEach var="lstu" items="${lstuni}" varStatus="loop">
							<option data-tokens="ketchup mustard" value="${lstu.idUnidad}">${lstu.descripcion}</option>
						</c:forEach>
					</select>
				</div>
				<div id="combo">
					<div class="form-group">
						<label for="lbloficina">Oficina</label> <select
							class="selectpicker form-control" data-live-search="true"
							id="cbxoficina" name="cbxoficina" required="required">
							<option data-tokens="ketchup mustard" value=""
								selected="selected">Seleccione</option>

						</select>

					</div>
				</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="card-header">Datos de Usuario</div>
		<div class="card-body">
			<div class="form-group">
				<label for="lblperfil">Perfil</label> <select
					class="selectpicker form-control" data-live-search="true"
					id="cbxperfil" name="cbxperfil" required="required">
					<option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>
					<option data-tokens="ketchup mustard" value="2">MESA DE
						PARTES</option>
					<option data-tokens="ketchup mustard" value="3">ADMINISTRATIVO</option>
					<option data-tokens="ketchup mustard" value="4">ARCHIVADOR</option>
					<option data-tokens="ketchup mustard" value="5">JEFE</option>
					<c:if test="${sessionScope.usuario[5].idPerfil==6}">
						<option data-tokens="ketchup mustard" value="1">ADMINISTRADOR</option>
						<option data-tokens="ketchup mustard" value="6">SUPER
							ADMINISTRADOR</option>
					</c:if>
				</select>
			</div>
			<div class="form-group">
				<label for="lblnom">Usuario</label> <input class="form-control"
					id="txtusu" name="txtusu" type="text"
					aria-describedby="Ingrese sus Usuario"
					placeholder="Ingrese su Usuario" maxlength="15" required="required">
			</div>
			<div class="form-group">
				<label for="lblpass">Contraseña</label> <input class="form-control"
					id="txtpass" name="txtpass" type="password"
					aria-describedby="Ingrese sus contraseña"
					placeholder="Ingrese su contraseña" maxlength="8"
					required="required">
			</div>
			<input type="button" value="Cambiar Contraseña"
				class="btn  btn-block  btn-info" onclick="">
			<div class="form-group">
				<label for="lblestado">Estado</label> <select
					class="selectpicker form-control" data-live-search="true"
					id="cbxest" name="cbxest" required="required">
					<option data-tokens="ketchup mustard" value="1" selected="selected">ACTIVO</option>
					<option data-tokens="ketchup mustard" value="0">DESACTIVO</option>
				</select>
			</div>
			<input class="btn btn-success btn-block" id="btnregistrar"
				value="Modificar" type="button">
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




