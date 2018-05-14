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
		<!-- Nav tabs onclick="fnlistarBandeja('PRETEST_IND2')"-->
		<ul class="nav nav-tabs" role="tablist">
			<li class="nav-item">
				<a class="nav-link active primary" data-toggle="tab" href="#IND1"
				role="tab">Indicador 1 
			</a>
			</li>
			<li class="nav-item" >
				<a class="nav-link" data-toggle="tab" href="#IND2" role="tab">Indicador
					2 
			</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="IND1" role="tabpanel">
				<div class="card mb-3">
					<h5 align="center">"Localización de documentos"</h5>
					<div class="card-body">
						<div style="clear: both" align="center">
							<iframe id="viewer" src="images/Pre-Test1.pdf" Width="600px" height="450px" align="center"
								scrolling="auto" frameborder="0" allowtransparency="true"
								border="0"></iframe>
						</div>
					</div>
<!-- 					<div class="card-footer small text-muted"> -->
<!-- 						Actualizado al -->
<%-- 						<fmt:formatDate type="both" dateStyle="short" timeStyle="short" --%>
<%-- 							value="${now}" /> --%>
<!-- 					</div> -->
<!-- 					<div align="center"> -->
<!-- 						<img alt="Brand" class="img" src="./images/formula1.png" -->
<!-- 							width="200" height="150"> -->
<!-- 					</div> -->
<!-- 					<h5 align="center"> -->
<!-- 						Total documentos no clasificados apropiadamente (TDCD) <span -->
<!-- 							class="badge badge-secondary"><div id="lblval1t1"></div></span> -->
<!-- 					</h5> -->
<!-- 					<h5 align="center"> -->
<!-- 						Total documentos casificados (TDC) <span -->
<!-- 							class="badge badge-secondary"><div id="lblval2t1"></div></span> -->
<!-- 					</h5> -->
<!-- 					<h5 align="center"> -->
<!-- 						Porcentaje de documentos no clasificados apropiadamente (PDCD)<span -->
<!-- 							class="badge badge-secondary"><div id="lblval3t1"></div></span> -->
<!-- 					</h5> -->
					<div class="container-fluid">
						<div id="graft1"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane" id="IND2" role="tabpanel">
				<div class="card mb-3">
					<div class="card-body">
						<h5 align="center">"Nivel de Servicio"</h5>
						<div style="clear: both" align="center">
							<iframe id="viewer" src="images/Pre-Test2.pdf" Width="600px" height="450px" align="center"
								scrolling="auto" frameborder="0" allowtransparency="true"
								border="0"></iframe>
						</div>
					</div>
<!-- 					<div class="card-footer small text-muted"> -->
<!-- 						Actualizado al -->
<%-- 						<fmt:formatDate type="both" dateStyle="short" timeStyle="short" --%>
<%-- 							value="${now}" /> --%>
<!-- 					</div> -->
<!-- 					<div align="center"> -->
<!-- 						<img alt="Brand" class="img" src="./images/formula2.png" -->
<!-- 							width="200" height="150"> -->
<!-- 					</div> -->
<!-- 					<h5 align="center"> -->
<!-- 						Total de consultas a documentos (TC) <span -->
<!-- 							class="badge badge-secondary"><div id="lblval2t2"></div></span> -->
<!-- 					</h5> -->
<!-- 					<h5 align="center"> -->
<!-- 						Total de consultas contestadas a documentos dentro del plazo de 15 -->
<!-- 						min (TCC) <span class="badge badge-secondary"><div -->
<!-- 								id="lblval1t2"></div></span> -->
<!-- 					</h5> -->
<!-- 					<h5 align="center"> -->
<!-- 						Porcentaje de consultas contestadas a documentos dentro del plazo -->
<!-- 						(15 min) (PCC)<span class="badge badge-secondary"><div -->
<!-- 								id="lblval3t2"></div></span> -->
<!-- 					</h5> -->
					<div class="container-fluid">
						<div id="graft2"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</ol>
<script type="text/javascript">
	function graficoHigchar4(titulo, dato) {
		var cadenaTexto = 'Documento localizados#Documento no localizados';
		var cadenaCantidad = '';

		var vlistatext = cadenaTexto.split('#');
		var vlistatextCant = dato.split('#');

		var vnavegador = new Array();

		for ( var i in vlistatext) {
			var vlabel = vlistatext[i];
			var vcantidad = parseInt(vlistatextCant[i]);

			vnavegador.push([ vlabel, vcantidad, 'silver' ]);

		}

		Highcharts
				.chart(
						'graft1',
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false,
								type : 'pie'
							},
							title : {
								text : 'Indicador 1:"Localización de documentos"'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										format : '<b>{point.name}</b>: {point.percentage:.1f} %',
										style : {
											color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
													|| 'black'
										}
									}
								}
							},
							series : [ {
								name : 'Documentos',
								colorByPoint : true,
								data : vnavegador
							} ]
						});

	}
	function graficoHigchar5(titulo, dato) {
		var cadenaTexto = 'Documentos tramitados en el plazo#Documentos fuera del plazo';
		var cadenaCantidad = '';

		var vlistatext = cadenaTexto.split('#');
		var vlistatextCant = dato.split('#');

		var vnavegador = new Array();

		for ( var i in vlistatext) {
			var vlabel = vlistatext[i];
			var vcantidad = parseInt(vlistatextCant[i]);

			vnavegador.push([ vlabel, vcantidad, 'silver' ]);

		}

		Highcharts
				.chart(
						'graft2',
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false,
								type : 'pie'
							},
							title : {
								text : 'Indicador 2:"Nivel de Servicio"'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										format : '<b>{point.name}</b>: {point.percentage:.1f} %',
										style : {
											color : (Highcharts.theme && Highcharts.theme.contrastTextColor)
													|| 'black'
										}
									}
								}
							},
							series : [ {
								name : 'Documentos',
								colorByPoint : true,
								data : vnavegador
							} ]
						});

	}
</script>




<script type="text/javascript">
	window.onload = function() {
	graficoHigchar4('Localización de documentos','56#44');
	graficoHigchar5('Nivel de Servicio','57#43');
		//fnlistarBandeja('PRETEST_IND1');
		

	}
</script>



