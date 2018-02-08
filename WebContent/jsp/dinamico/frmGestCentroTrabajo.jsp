<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String sWS=request.getContextPath(); %>
<!DOCTYPE html>
  <div class="row">
    <div class="col-md-6">
      <div class="card-header">Registrar Unidades</div>
      <div class="card-body">
        <form action="<%=sWS%>/ServAdministracion" method="post" id="form1" name="form1">
          <div class="form-group">
            <label for="exampleInputEmail1">Unidad</label>
            <input type="hidden" id="id_unidad" name="id_unidad">
            <input type="hidden" id="hdEvento" name="hdEvento">
            <input class="form-control" id="txtunidad" name="txtunidad" type="text" aria-describedby="emailHelp" placeholder="Ingrese Unidad">
          </div>
          <input class="btn btn-success btn-block" onclick="javascript:añadirunidad();" id="btn1añadir" value="Añadir Unidad" type="button">
          <input class="btn btn-success btn-block" onclick="javascript:modificarunidad();" id="btn1modificar" disabled="disabled" value="Modificar Unidad" type="button">
        </form>
      </div>
      <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>UNIDAD</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach var="unid" items="${combouni}" varStatus="loop">
                                   <tr>
                                        <td class="center"><a href="javascript:seleccionarUnidad('Seleccionado  ${unid.descripcion}','${unid.descripcion}','${unid.idUnidad}');"> ${loop.count} ${unid.descripcion}</a></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
    </div>
    <div class="col-md-6">
      <div class="card-header">Registrar Oficinas</div>
      <div class="card-body">
        <form action="ServAdministracion" method="post" id="form2" name="form2">
        <div class="row"> 
        <div class="col-md-6">
        <div class="form-group">
        <label for="exampleInputEmail1">Unidad</label>
        <select class="selectpicker form-control" data-live-search="true">
         <option data-tokens="ketchup mustard" value="" selected="selected">Seleccione</option>
        <c:forEach var="unid" items="${combouni}" varStatus="loop">
<option data-tokens="ketchup mustard" value="${unid.idUnidad}">${unid.descripcion}</option>
 </c:forEach>
  
	</select>
    </div>  
    </div> <div class="col-md-6"> 
          <div class="form-group">
            <label for="exampleInputEmail1">Oficina</label>
            <input class="form-control" id="txtofocina" type="text" aria-describedby="emailHelp" placeholder="Enter oficina">
          </div>
          </div>
          </div>
          <input class="btn btn-primary btn-block" onclick="javascript:añadiroficina();" id="btn2añadir" value="Añadir Oficina" type="button">
          <input class="btn btn-primary btn-block" onclick="javascript:modificaroficina();" id="btn2modificar" value="Modificar Oficina" type="button">
        </form>  
      </div>
    <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable1" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>UNIDAD</th>
                                    </tr>
                                </thead>
                                <tbody>
                                  
                                </tbody>
                            </table>
                        </div>
    
    </div>
  </div>
  <script>
  function alerta(msg){
  var texto=msg;
$.notify({
	title: '<strong>Mensaje:</strong>',
	message: texto
},{
	type: 'success'
});
  }
  function danger(msg){
  var texto=msg;
$.notify({
	title: '<strong>Alerta:</strong>',
	message: texto
},{
	type: 'danger'
});
  }
  
  function seleccionarUnidad(msg,uni,id){
  $('#txtunidad').val(uni);
  $('#id_unidad').val(id);
  $('#btn1añadir').attr("disabled", true);
  $('#btn1modificar').attr("disabled", false);
  alerta(msg);
  }
  function añadirunidad(){
   var unidad=$('#txtunidad').val();
   if (confirm("Desea Añadir una Unidad")) {
   if (unidad!=='') {
	$('#hdEvento').val('AGREGAR_UNIDAD');
  document.forms["form1"].submit();	
}else{
danger('Ingrese un nombre de Unidad');
}
}
 
  }
  </script>
  
  
  
  
  