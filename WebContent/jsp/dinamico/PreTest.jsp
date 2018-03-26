<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String sWS = request.getContextPath();
%>
<jsp:useBean id="now" class="java.util.Date" scope="request" />
<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">

<ol class="breadcrumb">
	<div class="container-fluid">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item" onclick="fnlistarBandeja('PRETEST_IND1')">
				<a class="nav-link active primary" data-toggle="tab"
				href="#Administrativo" role="tab">Indicador 1 <span
					class="badge badge-pill badge-primary"><div id="lblpretest1"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('PRETEST_IND2')">
				<a class="nav-link" data-toggle="tab" href="#Desaprobado" role="tab">Indicador 2
					<span class="badge badge-pill badge-primary"><div
							id="lbldesaprobado"></div></span>
			</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="Administrativo" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tpretest1"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
					
					<h5 align="center">Total Documentos Clasificados inapropiadamente <span class="badge badge-secondary"><div id="lblval1t1"></div></span></h5>
					<h5 align="center">Total Documentos Clasificados <span class="badge badge-secondary"><div id="lblval2t1"></div></span></h5>
					<h5 align="center">Porcentaje de  Documentos Clasificados Inapropiadamente<span class="badge badge-secondary"><div id="lblval3t1"></div></span></h5>
					<div class="container-fluid"><div id="graft1" ></div> </div>
				</div>
			</div>
			<div class="tab-pane" id="Desaprobado" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<div class="table-responsive">
							<div id="tdesaprobado"></div>
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
	</div>
</ol>
<script type="text/javascript">
function graficoHigchar4(titulo,dato){
	  var cadenaTexto ='Documento clasificados inapropiadamente#Documento clasificados apropiadamente';
	var cadenaCantidad ='';

	var vlistatext = cadenaTexto.split('#');
	var vlistatextCant = dato.split('#');

	var vnavegador = new Array();

	for( var i in vlistatext )
	{
	var vlabel = vlistatext[i];
	var vcantidad =  parseInt( vlistatextCant[i]);

	vnavegador.push([ vlabel ,  vcantidad ,'silver' ]);

	}

	 Highcharts.chart('graft1', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Indicador 1'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                style: {
	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                }
	            }
	        }
	    },
	    series: [{
	        name: 'Documentos clasificados',
	        colorByPoint: true,
	        data: vnavegador
	    }]
	});   


	}
</script>




<script type="text/javascript">
	window.onload = function() {
		fnlistarBandeja('PRETEST_IND1');
		//fnlistarBandeja('BANDEJA_DESESTIMADO');
	}
</script>



