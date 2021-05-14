<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<LINK REL=StyleSheet HREF="CCS/Diseño.css" TYPE="text/css" />
<head>
<meta charset="UTF-8">
<title>USUARIO</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />

</head>
<body>
<script type="text/javascript">
	$(document).ready(function () {
				$.post('ControllerUsuario', {
					//Envio de datos a js
				}, function (response) {
					let datos = JSON.parse(response);

					console.log(datos);

					var tabla = document.getElementById('tablaDatos');
					for (let item of datos) {
						tabla.innerHTML +=
							`
					<tr>
						<td>${item.Id}</td>
						<td>${item.Nombre}</td>
						<td>${item.Apellido}</td>
						<td><a href="ControllerUsuario?Id=${item.Id}&Eliminar=btne" class="btn btn-danger">Eliminar</a>
						</td>
					</tr>
					`
						console.log(item.Pass);
					}
				});
			});
		</script>
			
<form action="ControllerAcceso" method="post">
		<input type="submit" name="btncerrar" value="Cerrar sesion">
		<br>
		<br>
		<input type="submit" name="btniniciar" value="Iniciar sesion">
	</form>
	<br>
<div class="tabla" id="tabladiv">
			<table id="tablaDatos" class="table table-sm table-dark">
				<thead >
					<th>ID</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
					<th>ACCIONES</th>
				</thead>
			</table>

		</div>
</body>
</html>