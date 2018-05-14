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
			<li class="nav-item"><a class="nav-link active primary"
				data-toggle="tab" href="#IND1" role="tab">Indicador 1 </a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#IND2" role="tab">Indicador 2 </a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane active" id="IND1" role="tabpanel">
				<div class="card mb-3">
					<h5 align="center">"Localización de documentos"</h5>
					<div class="card-body">
						<div style="clear: both" align="center">
							<ol class="breadcrumb">
								<div class="col-lg-12" align="center">
									<form class="form-horizontal" name="form-registro"
										id="form-registro" role="form" method="post">
										<fieldset class="scheduler-border">
											<legend class="scheduler-border">Ingrese Rango de
												Fechas de Recepción de documento</legend>
											<div class="form-group">
												<label id="lblfecha">DESDE</label>
												<div class="input-group date datepicker">
													<input type="date" data-format="dd/mm/yyyy"
														class="form-control" id="txtfecha11" name="txtfechadoc"
														required>
													<!-- 									<span -->
													<!-- 									class="input-group-addon"> <i -->
													<!-- 									class="fa fa-calendar bigger-110"></i> -->
													<!-- 								</span>	 -->
												</div>
											</div>
											<div class="form-group">
												<label id="lblfecha">HASTA</label>
												<div class="input-group date datepicker">
													<input type="date" data-format="dd/mm/yyyy"
														class="form-control" id="txtfecha12" name="txtfechadoc"
														required>
													<!-- 									<span -->
													<!-- 									class="input-group-addon"> <i -->
													<!-- 									class="fa fa-calendar bigger-110"></i> -->
													<!-- 								</span>	 -->
												</div>
											</div>
											<!--</div>-->
											<div class="form-group">
												<div class="col-md-12 text-center">
													<button class="btn btn-success" type="button"
														name="indicador1" id="btn1" onclick="fn_consultar1();">
														<span class='glyphicon glyphicon-search'
															aria-hidden='true'></span> Consultar
													</button>
												</div>
											</div>
										</fieldset>

									</form>
								</div>
							</ol>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<div id="tIndicador1"></div>
							</div>
						</div>



					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
					<div align="center">
						<img alt="Brand" class="img" src="./images/formula1.png"
							width="200" height="150">
					</div>
					<h5 align="center">
						Dias de evaluación: <span class="badge badge-secondary"><div
								id="lblregistros1"></div></span>
					</h5>
					<h5 align="center">
						DESDE: <span class="badge badge-secondary"><div
								id="lblfechaini1"></div></span> HASTA: <span
							class="badge badge-secondary"><div id="lblfechafin1"></div></span>
					</h5>
					<h5 align="center">
						Total documentos consultados (CDC) <span
							class="badge badge-secondary"><div id="lblval1t1"></div></span>
					</h5>
					<h5 align="center">
						Total documentos localizados (CDL) <span
							class="badge badge-secondary"><div id="lblval2t1"></div></span>
					</h5>
					<h5 align="center">
						Localización de Documentos (LD) representa el:<span
							class="badge badge-secondary"><div id="lblval3t1"></div></span>
					</h5>
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
							<ol class="breadcrumb">
								<div class="col-lg-12" align="center">
									<form class="form-horizontal" name="form-registro"
										id="form-registro" role="form" method="post">
										<fieldset class="scheduler-border">
											<legend class="scheduler-border">Ingrese Rango de
												Fechas de Recepción de documento</legend>
											<div class="form-group">
												<label id="lblfecha">DESDE</label>
												<div class="input-group date datepicker">
													<input type="date" data-format="dd/mm/yyyy"
														class="form-control" id="txtfecha21" name="txtfechadoc"
														required>
													<!-- 									<span -->
													<!-- 									class="input-group-addon"> <i -->
													<!-- 									class="fa fa-calendar bigger-110"></i> -->
													<!-- 								</span>	 -->
												</div>
											</div>
											<div class="form-group">
												<label id="lblfecha">HASTA</label>
												<div class="input-group date datepicker">
													<input type="date" data-format="dd/mm/yyyy"
														class="form-control" id="txtfecha22" name="txtfechadoc"
														required>
													<!-- 									<span -->
													<!-- 									class="input-group-addon"> <i -->
													<!-- 									class="fa fa-calendar bigger-110"></i> -->
													<!-- 								</span>	 -->
												</div>
											</div>
											<!--</div>-->
											<div class="form-group">
												<div class="col-md-12 text-center">
													<button class="btn btn-success" type="button"
														name=btnindicador2 id="btn2" onclick="fn_consultar2();">
														<span class='glyphicon glyphicon-search'
															aria-hidden='true'></span> Consultar
													</button>
												</div>
											</div>
										</fieldset>

									</form>
								</div>
							</ol>









						</div>
						<div class="card-body">
							<div class="table-responsive">
								<div id="tIndicador2"></div>
							</div>
						</div>
					</div>
					<div class="card-footer small text-muted">
						Actualizado al
						<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
							value="${now}" />
					</div>
					<div align="center">
						<img alt="Brand" class="img" src="./images/formula2.png"
							width="200" height="150">
					</div>
					<h5 align="center">
						Dias de evaluación: <span class="badge badge-secondary"><div
								id="lblregistros2"></div></span>
					</h5>
					<h5 align="center">
						DESDE: <span class="badge badge-secondary"><div
								id="lblfechaini2"></div></span> HASTA: <span
							class="badge badge-secondary"><div id="lblfechafin2"></div></span>
					</h5>
					<h5 align="center">
						Total peticiones Recibidas (PR) <span
							class="badge badge-secondary"><div id="lblval1t2"></div></span>
					</h5>
					<h5 align="center">
						Total peticiones atendidas (PA) <span
							class="badge badge-secondary"><div id="lblval2t2"></div></span>
					</h5>
					<h5 align="center">
						Nivel de Servicio (NS) representa el:<span
							class="badge badge-secondary"><div id="lblval3t2"></div></span>
					</h5>
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
	// 	window.onload = function() {
	// 	graficoHigchar4('Localización de documentos','56#44');
	// 	graficoHigchar5('Nivel de Servicio','57#43');
	// 		//fnlistarBandeja('PRETEST_IND1');

	// 	}
</script>
<script>
	function fn_consultar1() {
		var fecha1 = document.getElementById("txtfecha11").value;
		var fecha2 = document.getElementById("txtfecha12").value;
		if (fecha1 != '' && fecha2 != '') {

			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = "REPPOSTESTI1";
			var jqdata = {
				hdEvento : txtevento,
				fecha1 : fecha1,
				fecha2 : fecha2
			};

			fnEjecutarPeticion(vservlet, jqdata, txtevento);

		} else {
			danger("Error, Debe ingresar un rango de fechas validas");
		}

	}
	function fn_consultar2() {
		var fecha1 = document.getElementById("txtfecha21").value;
		var fecha2 = document.getElementById("txtfecha22").value;
		if (fecha1 != '' && fecha2 != '') {

			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServBandejaAJAX';
			var txtevento = "REPPOSTESTI2";
			var jqdata = {
				hdEvento : txtevento,
				fecha1 : fecha1,
				fecha2 : fecha2
			};

			fnEjecutarPeticion(vservlet, jqdata, txtevento);

		} else {
			danger("Error, Debe ingresar un rango de fechas validas");
		}

	}
</script>



