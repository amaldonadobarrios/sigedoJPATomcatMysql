<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.ServletRequest"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SIGEDO PNP</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
</head>
<body class="bg-dark">
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td valign="top" height="74">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					background="images/header_policia_nacional_fondo.png">
					<tr>
						<td width="418"><img
							src="images/header_policia_nacional_peru.png" width="418"
							height="74" /></td>

						<td>
							<table>
								<tr>
									<td align="center"></td>
									<td width="20" align="center"></td>
									<td width="20" align="center"></td>
								</tr>
								<tr>
									<td align="center"></td>
									<td width="20" align="center"></td>
									<td width="20" align="center"></td>
								</tr>
							</table>
						</td>
						<td width="400" height="74" align="right" valign="bottom"
							background="images/header_policia_nacional_peru_right.png">


						</td>
					</tr>

				</table>
			</td>
		</tr>
	</table>
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Iniciar Sesión</div>
			<div class="card-body">
				<form data-toggle="validator" role="form" action="ServSeguridad"
					method="post">
					<div class="form-group">
						<label for="username">Usuario</label> <input class="form-control"
							id="username" name="username" required="required" type="text"
							placeholder="Ingrese su usuario" value="amaldonadob">
					</div>
					<div class="form-group">
						<label for="password">Contraseña</label> <input
							class="form-control" id="password" name="password"
							type="password" placeholder="Ingrese su contraseña"
							required="required" value="mauricio">
					</div>

					<div class="container">
						<div class="col-lg-3"></div>
						<div class="form-group">
							<div class="panel-body">
								<div align="center">
									<%
										Captcha captcha = Captcha.load(request, "exampleCaptcha");
										captcha.setUserInputID("captchaCode");
										String captchaHtml = captcha.getHtml();
										out.write(captchaHtml);
									%>
								</div>

							</div>
							<div class="form-group has-error" style="align-content: center; text-align: center;">
								<input name="captchaCode" type="text" id="captchaCode"
									class="form-control" required="required"  style="align-content: center; text-align: center;"/>
							</div>
						</div>
					</div>
					<div class="col-lg-3"></div>
					<button class="btn btn-primary btn-block" type="submit">Iniciar
						Sesión</button>
						<div class="col-lg-3"><BR></div>
				</form>
				<c:if test="${msg!=null}">
					<div class="alert alert-danger" align="center">
						<strong>ERROR!</strong> ${msg}
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="js/validator.min.js"></script>
</body>
<style>
background-color
:
#0066CC
;

	
color
:
#FFFFFF
;

	
font-style
:normal
;

	
font
:
 
sans-serif
;
</style>
</html>
