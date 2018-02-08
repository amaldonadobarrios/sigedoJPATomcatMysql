<%-- 
    Document   : regordenJF
    Created on : 29/12/2017, 08:39:51 PM
    Author     : 31424836
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ol class="breadcrumb">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">

                <div class="card" >
                    <div class="card-header">Registrar Orden</div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <label for="exampleInputName">First name</label>
                                            <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter first name">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="exampleInputLastName">Last name</label>
                                            <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Enter last name">
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input class="form-control" id="exampleInputEmail1" type="email" aria-describedby="emailHelp" placeholder="Enter email">
                            </div>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
                                    </div>
                                    <div class="col-md-6">
                                        <label for="exampleConfirmPassword">Confirm password</label>
                                        <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Confirm password">
                                    </div>
                                </div>
                            </div>
                            <a class="btn btn-primary btn-block" href="login.html">Register</a>
                        </form>
                        <div class="text-center">
                            <a class="d-block small mt-3" href="login.html">Login Page</a>
                            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                    </div>
                </div>





            </div> 
            <div class="col-md-6">
                <div class="card" >
                    <div class="card-header">Subir Pdf</div>
                    <div class="card-body">
                        <form>
                            <div class="form-group" align="center">

                                <input id="uploadPDF" type="file" name="myPDF" onchange="PreviewImage();"/>&nbsp;
                               <button type="submit"><img src="img/save.png" width="20" height="20"> Guardar fichero</button>
                            </div>
                            <div style="clear:both" align="center">
                                <iframe id="viewer" frameborder="0" scrolling="no" width="400" height="600"></iframe>
                            </div>  
                        </form>

                    </div>
                </div>   

            </div>
        </div>
    </div>
</ol>
<script type="text/javascript">
    function PreviewImage() {
        var file = $('[name="myPDF"]');
        var filename = $.trim(file.val());
        if (filename !== '') {
            if (isJpg(filename) || isPdf(filename)) {
                $('#viewer').attr('src', 'about:blank');
                pdffile = document.getElementById("uploadPDF").files[0];
                pdffile_url = URL.createObjectURL(pdffile);
                $('#viewer').attr('src', pdffile_url);
            } else {
                $('#viewer').attr('src', 'about:blank');
                $('#uploadPDF').val('');
            }
        }
    }

    var isJpg = function (name) {
        return name.match(/jpg$/i)
    };
    var isPdf = function (name) {
        return name.match(/pdf$/i)
    };
</script>      
<style>
    button {
        font: 700 1em Tahoma, Arial, Verdana, sans-serif;
        color: #fff; background-color: #59B0E5;
        border: 1px solid #0074a5;
        border-top: 1px solid #004370;
        border-left: 1px solid #004370;
        cursor: pointer;
    }

    button {
        width: auto; /* ie */
        overflow: visible; /* ie */
        padding: 3px 8px 2px 6px; /* ie */
    }

    button[type] {
        padding: 4px 8px 4px 6px; /* firefox */
    }
</style>