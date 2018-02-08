<%-- 
    Document   : consHT
    Created on : 27/12/2017, 06:31:24 PM
    Author     : 31424836
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ol class="breadcrumb">
<div class="col-lg-12" align="center">
        <form class="form-horizontal" name="form-registro" id="form-registro" role="form" method="post">                                           
            <fieldset  class="scheduler-border">
                <legend class="scheduler-border">Ingrese Datos para Consultar</legend>                                   
                <div class="form-group">
                    <label for="tipo_documento" class="col-md-6 control-label">Hoja de Trámite [HT]:</label>
                    <div class="col-md-4 ">
                        <select class="form-control" name="tipo_documento" id="tipo_documento">
                            <option value="">Año HT</option>
                            <option value="2017">2017</option><option value="2016">2016</option><option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option><option value="2010">2010</option><option value="2009">2009</option><option value="2008">2008</option>                                    </select>                                        
                    </div>   
                     <div class="col-md-4">                                                                                   
                        <input type="text" class="form-control" maxlength="14" id="numero" name="numero" placeholder="Número de HT" autocomplete="false">
                    </div>
                </div>
                <!--</div>-->
                <div class="form-group">
                    <div class="col-md-12 text-center">
                        <button class="btn btn-success" type="submit" name="submit" id="submit"><span class='glyphicon glyphicon-search' aria-hidden='true'></span> Consultar</button>
                    </div>
                </div>
            </fieldset>
            
        </form>
    </div>
</ol>
<ol class="breadcrumb">
<div class="col-lg-12" >
        <form class="form-horizontal" name="form-registro" id="form-registro" role="form" method="post">                                           
            <fieldset  class="scheduler-border">
                <legend class="scheduler-border" align="center">Detalle</legend>                                   
                <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Data Table Example</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Position</th>
                  <th>Office</th>
                  <th>Age</th>
                  <th>Start date</th>
                  <th>Salary</th>
                  <th>Salary</th>
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
                    <th>dsdsdsd</th>
                  <th>ererer</th>
                </tr>
              </tfoot>
              <tbody>
                <tr>
                  <td>Tiger Nixon</td>
                  <td>System Architect</td>
                  <td>Edinburgh</td>
                  <td>61</td>
                  <td>2011/04/25</td>
                  <td>$320,800</td>
                    <th>2323</th>
                  <th>232323y</th>
                </tr>
                <tr>
                  <td>Garrett Winters</td>
                  <td>Accountant</td>
                  <td>Tokyo</td>
                  <td>63</td>
                  <td>2011/07/25</td>
                  <td>$170,750</td>
                  <td>$86,000</td>
                  <td>$86,000</td>
                </tr>
                <tr>
                  <td>Ashton Cox</td>
                  <td>Junior Technical Author</td>
                  <td>San Francisco</td>
                  <td>66</td>
                  <td>2009/01/12</td>
                  <td>$86,000</td>
                  <td>$86,000</td>
                  <td>$86,000</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
            </fieldset>
            
        </form>
    </div>
</ol>
<style>
fieldset {
	font-family: sans-serif;
	border: 2px solid #1F497D;
	/*     background: #ddd; */
	border-radius: 5px;
	padding: 5px 10px;
}

fieldset legend {
	background: #111;
	color: white;
	padding: 1px 10px;
	font-size: 18px;
	border-radius: 5px;
	box-shadow: 0 0 0 2px #1F497D;
	margin-right: 20px;
}

.checkbox label:after, .radio label:after {
	content: '';
	display: table;
	clear: both;
}

.checkbox .cr, .radio .cr {
	position: relative;
	display: inline-block;
	border: 1px solid #a9a9a9;
	border-radius: .25em;
	width: 1.3em;
	height: 1.3em;
	float: left;
	margin-right: .5em;
}

.radio .cr {
	border-radius: 50%;
}

.checkbox .cr .cr-icon, .radio .cr .cr-icon {
	position: absolute;
	font-size: .8em;
	line-height: 0;
	top: 50%;
	left: 20%;
}

.radio .cr .cr-icon {
	margin-left: 0.04em;
}

.checkbox label input[type="checkbox"], .radio label input[type="radio"]
	{
	display: none;
}

.checkbox label input[type="checkbox"]+.cr>.cr-icon, .radio label input[type="radio"]+.cr>.cr-icon
	{
	transform: scale(3) rotateZ(-20deg);
	opacity: 0;
	transition: all .3s ease-in;
}

.checkbox label input[type="checkbox"]:checked+.cr>.cr-icon, .radio label input[type="radio"]:checked+.cr>.cr-icon
	{
	transform: scale(1) rotateZ(0deg);
	opacity: 1;
}

.checkbox label input[type="checkbox"]:disabled+.cr, .radio label input[type="radio"]:disabled+.cr
	{
	opacity: .5;
}
</style>
