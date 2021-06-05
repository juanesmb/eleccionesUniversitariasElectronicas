<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscripcion de candidatos</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-expand-md navbar-dark"
					style="background-color: red">
					<div>
						<a href="#" class="navbar-brand"></a>
					</div>
					<!-- 
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Usuarios</a></li>
			</ul>-->
				</nav>

			</div>
		</div>
	</header>

	<br>
	<div class="container">
		<div class="row">
			<h2>Inscripción de candidato</h2>
			<form action="insertarCandidato" method="post">
				<select class="form-select" aria-label="Default select example" name="eleccionId">
					<c:forEach var="i" items="${elecciones}">
						<option selected>Seleccione elección</option>
						<option value="${i.id}">
						"${i.nombre}"&nbsp;"${i.fechaInicio}"-"${i.fechaFin}"
						</option>
					</c:forEach>
				</select> 
				<fieldset class="form-group">
					<label>Documento</label> <input type="text" class="form-control"
						name="documento" required="required" maxlength="15">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre</label> <input type="text" class="form-control"
						name="nombre" required="required" maxlength="50">
				</fieldset>

				<fieldset class="form-group">
					<label>Apellido</label> <input type="text" class="form-control"
						name="apellido" required="required" maxlength="50">
				</fieldset>
				<br>
				<button type="submit" class="btn btn-success">Registrar</button>
			</form>
		</div>
	</div>

</body>
</html>