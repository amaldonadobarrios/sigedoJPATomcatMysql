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
        <div class="container-fluid">
        
        
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
       <div id="chart_div"></div>
        
        </div>
      </div>
</div>
 </ol>
<script type="text/javascript">
 google.charts.load('current', {packages:["orgchart"]});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('string', 'Manager');
        data.addColumn('string', 'ToolTip');

        // For each orgchart box, provide the name, manager, and tooltip to show.
        data.addRows([
          [{v:'REGISTRO', f:'REGISTRO<div style="color:red; font-style:italic">MESA DE PARTES</div>'},
           '', 'REGISTRO'],
          [{v:'DERIVACIÓN', f:'DERIVACIÓN<div style="color:red; font-style:italic">JEFE</div>'},
           'REGISTRO', 'DERIVACIÓN'],
          [{v:'RESPUESTA', f:'RESPUESTA<div style="color:red; font-style:italic">ADMINISTRATIVO</div>'},
           'DERIVACIÓN', 'RESPUESTA'],
          [{v:'DEVOLUCIÓN', f:'DEVOLUCIÓN<div style="color:red; font-style:italic">ADMINISTRATIVO</div>'},
           'DERIVACIÓN', 'DEVOLUCIÓN'],
          [{v:'APROBACIÓN', f:'APROBACIÓN<div style="color:red; font-style:italic">JEFE</div>'},
           'RESPUESTA', 'APROBACIÓN'],
           [{v:'DESAPROBACIÓN', f:'DESAPROBACIÓN<div style="color:red; font-style:italic">JEFE</div>'},
           'RESPUESTA', 'DESAPROBACIÓN'],
          [{v:'CONTESTADO', f:'CONTESTADO<div style="color:red; font-style:italic">MESA DE PARTES</div>'},
           'APROBACIÓN', 'CONTESTADO'],
           [{v:'ARCHIVADO', f:'ARCHIVADO<div style="color:red; font-style:italic">ARCHIVADOR</div>'},
           'CONTESTADO', 'ARCHIVADO']
        ]);

        // Create the chart.
        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
        // Draw the chart, setting the allowHtml option to true for the tooltips.
        chart.draw(data, {allowHtml:true});
      }
</script>
	

	
	