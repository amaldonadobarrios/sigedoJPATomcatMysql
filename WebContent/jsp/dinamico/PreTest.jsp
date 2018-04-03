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
				href="#IND1" role="tab">Indicador 1 <span
					class="badge badge-pill badge-primary"><div id="lblpretest1"></div></span>
			</a>
			</li>
			<li class="nav-item" onclick="fnlistarBandeja('PRETEST_IND2')">
				<a class="nav-link" data-toggle="tab" href="#IND2" role="tab">Indicador 2
					<span class="badge badge-pill badge-primary">
					<div id="lblpretest2"></div></span>
			</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="IND1" role="tabpanel">
				<div class="card mb-3">
				<h5 align="center">"Porcentaje de documentos no clasificados apropiadamente"</h5>
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
					<div align="center"><img alt="Brand" class="img" 	src="./images/formula1.png" width="200"height="150"></div>
					<h5 align="center">Total documentos no clasificados apropiadamente (TDCD) <span class="badge badge-secondary"><div id="lblval1t1"></div></span></h5>
					<h5 align="center">Total documentos casificados  (TDC) <span class="badge badge-secondary"><div id="lblval2t1"></div></span></h5>
					<h5 align="center">Porcentaje de documentos no clasificados apropiadamente (PDCD)<span class="badge badge-secondary"><div id="lblval3t1"></div></span></h5>
					<div class="container-fluid"><div id="graft1" ></div> </div>
				</div>
			</div>
			<div class="tab-pane" id="IND2" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
					<h5 align="center">"Porcentaje de consultas contestadas  a documentos dentro del plazo (15 min)"</h5>
						<div class="table-responsive">
							<div id="tpretest2"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
					<div align="center"><img alt="Brand" class="img" 	src="./images/formula2.png" width="200"height="150"></div>
					<h5 align="center">Total de consultas a documentos (TC)  <span class="badge badge-secondary"><div id="lblval2t2"></div></span></h5>
					<h5 align="center">Total de consultas contestadas a documentos dentro del plazo de 15 min (TCC) <span class="badge badge-secondary"><div id="lblval1t2"></div></span></h5>
					<h5 align="center">Porcentaje de consultas contestadas  a documentos dentro del plazo (15 min) (PCC)<span class="badge badge-secondary"><div id="lblval3t2"></div></span></h5>
					<div class="container-fluid"><div id="graft2" ></div> </div>
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
	        text: 'Indicador 1:"Porcentaje de documentos no clasificados apropiadamente"'
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
function graficoHigchar5(titulo,dato){
	  var cadenaTexto ='Porcentaje de consultas dentro del plazo#Porcentaje de consultas fuera del plazo';
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

	 Highcharts.chart('graft2', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Indicador 2:"Porcentaje de consultas contestadas  a documentos dentro del plazo (15 min)"'
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
	        name: 'Documentos consultados',
	        colorByPoint: true,
	        data: vnavegador
	    }]
	});   


	}
</script>




<script type="text/javascript">
	window.onload = function() {
		fnlistarBandeja('PRETEST_IND1');
		
	}
</script>



