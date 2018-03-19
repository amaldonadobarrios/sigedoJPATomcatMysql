<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="now" class="java.util.Date" scope="request" />
<ol class="breadcrumb">
<div class="col-lg-12" align="center">
        <form class="form-horizontal" name="form-registro" id="form-registro" role="form" method="post">                                           
            <fieldset  class="scheduler-border">
                <legend class="scheduler-border">Colsultar por palabra clave</legend>                                   
                <div class="form-group">
                    <label for="tipo_documento" class="col-md-6 control-label">Palabras clave:</label>
                     <div class="col-md-4">                                                                                   
                        <input type="text" class="form-control" maxlength="9" id="numero" name="numero" placeholder="Número de HT" onkeypress="return solo_numeros(event)" autocomplete="false">
                    </div>
                </div>
                <!--</div>-->
                <div class="form-group">
                    <div class="col-md-12 text-center">
                        <button class="btn btn-success" type="button" name="submit" id="btn" onclick="fn_consultar();"><span class='glyphicon glyphicon-search' aria-hidden='true'></span> Consultar</button>
                    </div>
                </div>
            </fieldset>
            <fieldset  class="scheduler-border">
                <legend class="scheduler-border">Consultar por tipo documento</legend>                                   
                <div class="form-group">
                    <label for="tipo_documento" class="col-md-6 control-label">Hoja de Trámite [HT]:</label>
                     <div class="col-md-4">                                                                                   
                        <input type="text" class="form-control" maxlength="9" id="numero" name="numero" placeholder="Número de HT" onkeypress="return solo_numeros(event)" autocomplete="false">
                    </div>
                </div>
                <!--</div>-->
                <div class="form-group">
                    <div class="col-md-12 text-center">
                        <button class="btn btn-success" type="button" name="submit" id="btn" onclick="fn_consultar();"><span class='glyphicon glyphicon-search' aria-hidden='true'></span> Consultar</button>
                    </div>
                </div>
            </fieldset>
            
        </form>
    </div>
</ol>
<ol class="breadcrumb">
<div class="col-lg-12" >
        <form class="form-horizontal" name="form-registro" id="form-registro" role="form" method="post">                                           
            <fieldset  class="scheduler-border">
                <legend class="scheduler-border" align="center">Detalle</legend>                                   
                <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Trazabilidad</div>
        <div class="card-body">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="ttrazabilidad"></div>
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
            </fieldset>
            
        </form>
    </div> 
</ol>
<script>
function fn_consultar(){
	var numero = document.getElementById("numero").value;
	if (numero!='') {
		
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = "TRAZABILIDAD";
			var jqdata = {
				hdEvento : txtevento,
				numero: numero
			};

			fnEjecutarPeticion(vservlet, jqdata, txtevento);
		
		
		
	}else{
		danger("Error, Debe ingresar un número de Hoja de Trámite");
	}
	
}


</script>
<style>
fieldset {
	font-family: sans-serif;
	border: 2px solid #1F497D;
	/*     background: #ddd; */
	border-radius: 5px;
	padding: 5px 10px;
}

fieldset legend {
	background: #111;
	color: white;
	padding: 1px 10px;
	font-size: 18px;
	border-radius: 5px;
	box-shadow: 0 0 0 2px #1F497D;
	margin-right: 20px;
}

.checkbox label:after, .radio label:after {
	content: '';
	display: table;
	clear: both;
}

.checkbox .cr, .radio .cr {
	position: relative;
	display: inline-block;
	border: 1px solid #a9a9a9;
	border-radius: .25em;
	width: 1.3em;
	height: 1.3em;
	float: left;
	margin-right: .5em;
}

.radio .cr {
	border-radius: 50%;
}

.checkbox .cr .cr-icon, .radio .cr .cr-icon {
	position: absolute;
	font-size: .8em;
	line-height: 0;
	top: 50%;
	left: 20%;
}

.radio .cr .cr-icon {
	margin-left: 0.04em;
}

.checkbox label input[type="checkbox"], .radio label input[type="radio"]
	{
	display: none;
}

.checkbox label input[type="checkbox"]+.cr>.cr-icon, .radio label input[type="radio"]+.cr>.cr-icon
	{
	transform: scale(3) rotateZ(-20deg);
	opacity: 0;
	transition: all .3s ease-in;
}

.checkbox label input[type="checkbox"]:checked+.cr>.cr-icon, .radio label input[type="radio"]:checked+.cr>.cr-icon
	{
	transform: scale(1) rotateZ(0deg);
	opacity: 1;
}

.checkbox label input[type="checkbox"]:disabled+.cr, .radio label input[type="radio"]:disabled+.cr
	{
	opacity: .5;
}

</style>
