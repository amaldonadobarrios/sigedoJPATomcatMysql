<%-- 
    Document   : bandejaJF
    Created on : 29/12/2017, 08:27:31 PM
    Author     : 31424836
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ol class="breadcrumb">
    <div class="container-fluid">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#Pendiente" role="tab">Recibido</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#Recibido" role="tab">Asignados</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#Enviados" role="tab">Validación de Respuesta</a>
            </li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div class="tab-pane active" id="Pendiente" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Data Table Example</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>N°</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Salary</th>
                                        <th>Visualizar</th>
                                        <th>Recibir</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>N°</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>asasas</th>
                                        <th>Visualizar</th>
                                        <th>Recibir</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>System Architect</td>
                                        <td>Edinburgh</td>
                                        <td>61</td>
                                        <td>2011/04/25</td>
                                        <td>$320,800</td>
                                        <th style="text-align: center;"><button class="btn-info">Ver</button></th>
                                        <th style="text-align: center;"><button class="btn-success">Recibir</button></th>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Accountant</td>
                                        <td>Tokyo</td>
                                        <td>63</td>
                                        <td>2011/07/25</td>
                                        <td>$170,750</td>
                                        <th style="text-align: center;"><button class="btn-info">Ver</button></th>
                                        <th style="text-align: center;"><button class="btn-success">Recibir</button></th>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Junior Technical Author</td>
                                        <td>San Francisco</td>
                                        <td>66</td>
                                        <td>2009/01/12</td>
                                        <td>$86,000</td>
                                        <th style="text-align: center;"><button class="btn-info">Ver</button></th>
                                        <th style="text-align: center;"><button class="btn-success">Recibir</button></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>  




            </div>
            <div class="tab-pane" id="Recibido" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Data Table Example</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable1" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Estado</th>
                                        <th>Responder</th>
                                        <th>Archivar</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Name</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Estado</th>
                                        <th>Responder</th>
                                        <th>Archivar</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <tr>
                                        <td>RECIBIDO</td>
                                        <td>System Architect</td>
                                        <td>Edinburgh</td>
                                        <td>61</td>
                                        <td>2011/04/25</td>
                                        <td style="text-align: center;">Recibido <button class="btn-dark">Ver detalle</button></td>
                                        <th style="text-align: center;"><button class="btn-info">Responder</button></th>
                                        <th style="text-align: center;"><button class="btn-success">Archivar</button></th>
                                    </tr>
                                    <tr>
                                        <td>Garrett Winters</td>
                                        <td>Accountant</td>
                                        <td>Tokyo</td>
                                        <td>63</td>
                                        <td>2011/07/25</td>
                                         <td style="text-align: center;">Asignado <button class="btn-dark">Ver detalle</button></td>
                                        <th style="text-align: center;"><button class="btn-info">Responder</button></th>
                                        <th style="text-align: center;"><button class="btn-success">Archivar</button></th>
                                    </tr>
                                    <tr>
                                        <td>Ashton Cox</td>
                                        <td>Junior Technical Author</td>
                                        <td>San Francisco</td>
                                        <td>66</td>
                                        <td>2009/01/12</td>
                                         <td style="text-align: center;">Aprobado <button class="btn-dark">Ver detalle</button></td>
                                        <th style="text-align: center;"><button class="btn-info">Responder</button></th>
                                        <th style="text-align: center;"><button class="btn-success">Archivar</button></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>   





            </div>
            <div class="tab-pane" id="Enviados" role="tabpanel">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Data Table Example</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Salary</th>
                                        <th>Estado</th>
                                        <th>Salary</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Name</th>
                                        <th>Position</th>
                                        <th>Office</th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>asasas</th>
                                        <th>Estado</th>
                                        <th>Estado</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <tr>
                                        <td>APROBADO</td>
                                        <td>System Architect</td>
                                        <td>Edinburgh</td>
                                        <td>61</td>
                                        <td>2011/04/25</td>
                                        <td>$320,800</td>
                                        <th>Recibido</th>
                                        <th style="text-align: center;"><button class="btn-success">Archivar</button></th>
                                    </tr>
                                    <tr>
                                        <td>Garrett Winters</td>
                                        <td>Accountant</td>
                                        <td>Tokyo</td>
                                        <td>63</td>
                                        <td>2011/07/25</td>
                                        <td>$170,750</td>
                                        <td>Asignado</td>
                                        <th style="text-align: center;"><button class="btn-success">Archivar</button></th>
                                    </tr>
                                    <tr>
                                        <td>Ashton Cox</td>
                                        <td>Junior Technical Author</td>
                                        <td>San Francisco</td>
                                        <td>66</td>
                                        <td>2009/01/12</td>
                                        <td>$86,000</td>
                                        <td>Aprobado</td>
                                        <th style="text-align: center;"><button class="btn-success">Archivar</button></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>   

            </div>

        </div>
    </div>
</ol>





