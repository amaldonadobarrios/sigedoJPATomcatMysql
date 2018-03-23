<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String sWS = request.getContextPath();
%>
<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
<!DOCTYPE html>
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Cambiar Contraseña</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-12">
                <label for="exampleInputName">Contraseña Actual</label>
                <input class="form-control" id="claveactual" type="password" name="claveactual" aria-describedby="nameHelp" placeholder="Ingrese Contraseña actual">
              </div>
              <div class="col-md-12">
                <label for="exampleInputLastName">Contraseña Nueva</label>
                <input class="form-control" id="clavenueva1" type="password" name="clavenueva1" aria-describedby="nameHelp" placeholder="Ingrese su nueva Contraseña">
              </div>
                <div class="col-md-12">
                <label for="exampleConfirmPassword">Confirme Contraseña nueva</label>
                <input class="form-control" id="clavenueva2" type="password"  name="clavenueva2" placeholder="confirme su contraseña">
              </div>
            </div>
          </div>
         <a class="btn btn-primary btn-block" onclick="fn_modificar();" >Modificar</a>
        </form>
      </div>
    </div>
  </div>
<script type="text/javascript">
function fn_modificar(){
if (validarkey()) {
if (confirm("Desea Cambiar su contraseña")) {
	var contexto = document.getElementById("contexto").value;
	var vservlet = contexto + '/ServAdministracionAJAX';
	var txtevento = 'CAMBIAR_CLAVE';
	var act = document.getElementById("claveactual").value;
	var new1 = document.getElementById("clavenueva1").value;
	var new2 = document.getElementById("clavenueva2").value;
	var jqdata = {
				hdEvento : txtevento,
				act : act,
				new1 : new1,
				new2 : new2	
			};
	fnEjecutarPeticion(vservlet, jqdata, txtevento);
}
		

}
}
function validarkey(){
var act = document.getElementById("claveactual").value;
var new1 = document.getElementById("clavenueva1").value;
var new2 = document.getElementById("clavenueva2").value;

if (act.trim()==''|| new1.trim()=='' || new2.trim()==''  ) {
	danger("ERROR, FALTAN COMPLETAR LOS CAMPOS");
	return false;
}else if (new1.trim()!=new2.trim()) {
	danger("ERROR, No coincide la  Nueva contraseña");
}else if (new1.length<8) {
	danger("ERROR, La  nueva contraseña debe tener como minimo 8 caracteres");
}else{
return true;
}
}
</script>
