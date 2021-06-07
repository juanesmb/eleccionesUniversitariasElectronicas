<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selección de candidato</title>
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
				<nav class="navbar navbar-expand-md navbar-dark bg-dark">
					<!-- <ul class="navbar-nav">
						<li><a
							href="<%=request.getContextPath()%>/inscripcionCandidato"
							class="nav-link">Inscripción de candidato</a></li>
					</ul>-->
				</nav>
			</div>
		</div>
	</header>

	<div class="container">
		<div class="row">
			<h2>Selección de candidato</h2>

			<h3 color="red">"${eleccion.cargo}"&nbsp;"${eleccion.fechaInicio}"-"${eleccion.fechaFin}"</h3>
			<h3>"${estamento.descripcion}"</h3>

			<div class="alert alert-primary" role="alert">Debes seleccionar
				el candidato de tu preferencia y confirmar tu voto</div>

			<form action="votar" method="post">
				<div class="row">
					<c:forEach var="i" items="candidatos">
						<div class="col-6">
							<div class="card" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">"${i.getNumero()}"</h5>
									<h6 class="card-subtitle mb-2 text-muted">i.getNombre()</h6>
									<a class="navbar-brand" href="#"> <img
										src="https://www.google.com/url?sa=i&url=http%3A%2F%2Fdatapartners.cl%2Fregister-company%2F&psig=AOvVaw1XqD5jxqzi5y8B_s8OysMV&ust=1623122623027000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLC8843JhPECFQAAAAAdAAAAABAD"
										alt="" width="50" height="50">
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
					<button type="submit" class="btn btn-danger">Confirmo mi voto</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>