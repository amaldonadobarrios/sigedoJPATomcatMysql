<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%
	String sWS = request.getContextPath();
%>
<jsp:useBean id="now" class="java.util.Date" scope="request" />
<ol class="breadcrumb">
    <div class="container-fluid">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#Pendiente" role="tab">Pendiente</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#Recibido" role="tab">Recibido</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#Enviados" role="tab">Enviados</a>
            </li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="Pendiente" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div  id ="tpendiente" class="table-responsive"> 
                          ${lstpendiente} 
                        </div>
                    </div>
                     <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>  




            </div>
            <div class="tab-pane" id="Recibido" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div  id ="trecibido" class="table-responsive"> 
                          ${lstrecibido} 
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   





            </div>
            <div class="tab-pane" id="Enviados" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-body">
                        <div  id ="tderivado" class="table-responsive"> 
                          ${lstderivado} 
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Actualizado  al <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${now}" /></div>
                </div>   

            </div>

        </div>
    </div>
</ol>





