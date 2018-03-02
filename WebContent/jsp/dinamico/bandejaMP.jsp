<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                <a class="nav-link active primary" data-toggle="tab" href="#Pendiente" role="tab">Pendiente <span class="badge badge-pill badge-primary"><div id="lblpendiente"></div></span></a>
            </li>
            <li class="nav-item" onclick="fnlistarBandeja('BANDEJA_RECIBIDO')">
                <a class="nav-link" data-toggle="tab" href="#Recibido" role="tab">Recibido <span class="badge badge-pill badge-primary"><div id="lblrecibido"></div></span></a>
            </li>
             <li class="nav-item" onclick="fnlistarBandeja('BANDEJA_DEVUELTO')">
                <a class="nav-link" data-toggle="tab" href="#Devuelto" role="tab">Devuelto <span class="badge badge-pill badge-primary"><div id="lbldevuelto"></div></span></a>
            </li>
            <li class="nav-item" onclick="fnlistarBandeja('BANDEJA_DERIVADO')">
                <a class="nav-link" data-toggle="tab" href="#Derivados" role="tab">Derivado <span class="badge badge-pill badge-info"><div id="lblderivado"></div></span></a>
            </li>
             <li class="nav-item" onclick="fnlistarBandeja('BANDEJA_APROBADO')">
                <a class="nav-link" data-toggle="tab" href="#Aprobado" role="tab">Aprobado <span class="badge badge-pill badge-primary"><div id="lblaprobado"></div></span></a>
            </li>
             <li class="nav-item" onclick="fnlistarBandeja('BANDEJA_CONTESTADO')">
                <a class="nav-link" data-toggle="tab" href="#Contestado" role="tab">Contestado <span class="badge badge-pill badge-info"><div id="lblcontestado"></div></span></a>
            </li>
            <li class="nav-item" onclick="fnlistarBandeja('BANDEJA_ARCHIVADO')">
                <a class="nav-link" data-toggle="tab" href="#Archivado" role="tab">Archivado <span class="badge badge-pill badge-info"><div id="lblarchivado"></div></span></a>
            </li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="Pendiente" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div   class="table-responsive"> 
                         <div id ="tpendiente"> </div>
                        </div>
                    </div>
                     <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>  
            </div>
            <div class="tab-pane" id="Recibido" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="table-responsive"> 
                           <div id ="trecibido"> </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   
            </div>
            <div class="tab-pane" id="Devuelto" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="table-responsive"> 
                           <div id ="tdevuelto"> </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   
            </div>
            <div class="tab-pane" id="Derivados" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div  class="table-responsive"> 
                         <div id ="tderivado"> </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   
            </div>
            <div class="tab-pane" id="Aprobado" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="table-responsive"> 
                           <div id ="taprobado"> </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   
            </div>
            <div class="tab-pane" id="Contestado" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="table-responsive"> 
                           <div id ="tcontestado"> </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   
            </div>
            <div class="tab-pane" id="Archivado" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="table-responsive"> 
                           <div id ="tarchivado"> </div>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   
            </div>

        </div>
    </div>
</ol>
<script type="text/javascript">

function fnrecibir(idht,iduni,idofi,idusu,iddoc){
		if (idht!= '' && iduni!= '' && idofi!= '' && idusu != '' && iddoc!='') {
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = 'RECIBIR';
			var jdata={
			hdEvento : txtevento,
			id_ht: idht,
			id_uni: iduni,
			id_ofi: idofi,
			id_usu: idusu,
			id_doc: iddoc
			};
			if (confirm('Esta seguro de recibir la Hoja de Trámite N°'+idht)) {
				fnrecibir_ajax(vservlet, txtevento, jdata);
			}
			
		}
	}

	function fnrecibir_ajax(servlet, evento, jdata) {
		$
				.ajax({
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
window.onload=function() {
			fnlistarBandeja('BANDEJA_PENDIENTE');
			fnlistarBandeja('BANDEJA_RECIBIDO');
			fnlistarBandeja('BANDEJA_DERIVADO');
			fnlistarBandeja('BANDEJA_DEVUELTO');
			fnlistarBandeja('BANDEJA_APROBADO');
			fnlistarBandeja('BANDEJA_CONTESTADO');
			fnlistarBandeja('BANDEJA_ARCHIVADO');
		}

</script>



