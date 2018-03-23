<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String sWS = request.getContextPath();
%>
<input type="hidden" id="contexto" name="contexto" value="<%=sWS%>">
<ol class="breadcrumb">
        
     
<div class="col-lg-12">
    <div class="container">
        
        <div class="row">
        <div class="container-fluid"><div id="graf1" ></div> </div>
         <div class="container-fluid"><div id="graf2"></div> </div> 
         <div class="container-fluid"><div id="graf3"></div> </div> 
          <div class="container-fluid"><div id="graf4"></div> </div> 
        </div>
      </div>
</div>
 </ol>
<script>
function fn_verGraficos(){
			var contexto = document.getElementById("contexto").value;
			var vservlet = contexto + '/ServAdministracionAJAX';
			var txtevento = "VER_GRAFICOS";
			var jqdata = {
				hdEvento : txtevento
			};

			fnEjecutarPeticion(vservlet, jqdata, txtevento);
	
}


</script>
<script>
  function graficoHigchar(titulo,json){
  var cadenaTexto ='';
var cadenaCantidad ='';
var arr = null;
		arr = JSON.parse(json);
		ShareInfoLength = arr.length;
		var elementos='';
		for (var i = 0; i < ShareInfoLength; i++) {
		cadenaTexto=cadenaTexto+arr[i].elemento+'#';
		cadenaCantidad =cadenaCantidad+arr[i].cantidad+'#';
		}  


var vlistatext = cadenaTexto.split('#');
var vlistatextCant = cadenaCantidad.split('#');

var vnavegador = new Array();

for( var i in vlistatext )
{
var vlabel = vlistatext[i];
var vcantidad =  parseInt( vlistatextCant[i]);

vnavegador.push([ vlabel ,  vcantidad  ]);

}

Highcharts.chart('graf1', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: 0,
        plotShadow: false
    },
    title: {
        text: 'Administrativo<br>Top<br>Documentos Respondidos',
        align: 'center',
        verticalAlign: 'middle',
        y: 40
    },   
    plotOptions: {
        pie: {
            dataLabels: {
                enabled: true,
                distance: -50,
                style: {
                    fontWeight: 'bold',
                    color: 'white'
                }
            },
            startAngle: -90,
            endAngle: 90,
            center: ['50%', '75%']
        }
    },
    series: [{
        type: 'pie',
        name: 'Documentos Respondidos',
        innerSize: '50%',
        data: vnavegador
    }]
});}



 function graficoHigchar2(titulo,json){
  var cadenaTexto ='';
var cadenaCantidad ='';
var arr = null;
		arr = JSON.parse(json);
		ShareInfoLength = arr.length;
		var elementos='';
		for (var i = 0; i < ShareInfoLength; i++) {
		cadenaTexto=cadenaTexto+arr[i].elemento+'#';
		cadenaCantidad =cadenaCantidad+arr[i].cantidad+'#';
		}  


var vlistatext = cadenaTexto.split('#');
var vlistatextCant = cadenaCantidad.split('#');

var vnavegador = new Array();

for( var i in vlistatext )
{
var vlabel = vlistatext[i];
var vcantidad =  parseInt( vlistatextCant[i]);

vnavegador.push([ vlabel ,  vcantidad ,'silver' ]);

}

 Highcharts.chart('graf2', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Top de Usuarios Registra en Sistema'
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
        name: 'Registros',
        colorByPoint: true,
        data: vnavegador
    }]
});   


}
function graficoHigchar3(titulo,json){
  var cadenaTexto ='';
var cadenaCantidad ='';
var arr = null;
		arr = JSON.parse(json);
		ShareInfoLength = arr.length;
		var elementos='';
		for (var i = 0; i < ShareInfoLength; i++) {
		cadenaTexto=cadenaTexto+arr[i].elemento+'#';
		cadenaCantidad =cadenaCantidad+arr[i].cantidad+'#';
		}  


var vlistatext = cadenaTexto.split('#');
var vlistatextCant = cadenaCantidad.split('#');

var vnavegador = new Array();

for( var i in vlistatext )
{
var vlabel = vlistatext[i];
var vcantidad =  parseInt( vlistatextCant[i]);

vnavegador.push([ vlabel ,  vcantidad ]);

}

Highcharts.chart('graf3', {
    chart: {
        type: 'pie',
        options3d: {
            enabled: true,
            alpha: 45
        }
    },
    title: {
        text: 'Top total Documentos archivados'
    },
    subtitle: {
        text: 'Documentos Archivados'
    },
    plotOptions: {
        pie: {
            innerSize: 100,
            depth: 45
        }
    },
    series: [{
        name: 'Documentos Archivados',
        data: vnavegador
    }]
});


}
function graficoHigchar4(titulo,json){
  var cadenaTexto ='';
var cadenaCantidad ='';
var arr = null;
		arr = JSON.parse(json);
		ShareInfoLength = arr.length;
		var elementos='';
		for (var i = 0; i < ShareInfoLength; i++) {
		cadenaTexto=cadenaTexto+arr[i].elemento+'#';
		cadenaCantidad =cadenaCantidad+arr[i].cantidad+'#';
		}  


var vlistatext = cadenaTexto.split('#');
var vlistatextCant = cadenaCantidad.split('#');

var vnavegador = new Array();

for( var i in vlistatext )
{
var vlabel = vlistatext[i];
var vcantidad =  parseInt( vlistatextCant[i]);

vnavegador.push([ vlabel ,  vcantidad ,'silver' ]);

}

Highcharts.chart('graf4', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Documentos digitalizados por meses en el presente año'
    },
    subtitle: {
        text: 'Archivo'
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -45,
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Documentos Archivados'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: 'Documentos Archivados en el presente año</b>'
    },
    series: [{
        name: 'Mes',
        data: vnavegador,
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y:.1f}', // one decimal
            y: 10, // 10 pixels down from the top
            style: {
                fontSize: '13px',
                fontFamily: 'Verdana, sans-serif'
            }
        }
    }]
});  


}
</script>
<script type="text/javascript">
	window.onload = function() {
	fn_verGraficos();
	}
</script>
	

	
	