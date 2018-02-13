
<%-- 
    Document   : template
    Created on : 09/11/2017, 03:23:52 PM
    Author     : 31424836

     
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SIGEDO PNP</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template
        -->
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/chosen.min.css" rel="stylesheet">

    </head>
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">
        <%@include file="head.jspf" %>
        <div class="content-wrapper">
            <div class="container-fluid">
                <div class="container-fluid">
                    <div class="row" align="center">
                        <div class="col-md-4" style="background-color: black;align-items: center;">
                            <a class="navbar-brand" href="#">Unidad: ${sessionScope.usuario[3].descripcion} </a>
                        </div>
                        <div class="col-md 4" style="background-color: black;">
                            <a class="navbar-brand" href="#">Oficina: ${sessionScope.usuario[4].descripcion}</a>
                        </div>
                        <div class="col-md 4" style="background-color: black;">
                            <a class="navbar-brand" href="#">Perfil: ${sessionScope.usuario[5].descripcion}</a>
                        </div>
                    </div>
                </div>

                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Sigedo</a>
                    </li>
                    <li class="breadcrumb-item active">${breadcrumb}</li>
                </ol>    
                <c:import url="dinamico/${body}.jsp"/>
                
                <script src="vendor/jquery/jquery.min.js"></script>
                <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                <!-- Core plugin JavaScript-->
                <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
                <!-- Page level plugin JavaScript-->
                <script src="vendor/chart.js/Chart.min.js"></script>

                <!-- Custom scripts for all pages-->
                <script src="js/sb-admin.min.js"></script>
                <script src="js/sb-admin-charts.min.js"></script>
                <!-- Custom scripts for this page
               
                
                
                -->
                <script src="js/sb-admin-datatables.min.js"></script>
                <script src="vendor/datatables/jquery.dataTables.js"></script>
                <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
				<script src="js/bootstrap-notify.min.js"></script>
				<script src="js/chosen.jquery.min.js"></script>
				
				
				
				
            </div>

    </body>
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © Your Website 2017</small>
            </div>
        </div>
    </footer>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Desea Salir del Sistema?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Seleccione "Cerrar Sesión" si está seguro de salir del sistema.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" href="SPage?action=login">Cerrar Sesión</a>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">
$(".chosen-select").chosen()
</script>
</html>

