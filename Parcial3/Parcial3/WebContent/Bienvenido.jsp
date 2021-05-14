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
	
	function cargardatos() {

		$(document).ready(function () {


			$.post('controllerUsuario', function (datos) {
				try {
					var tabla = document.getElementById('tablaDatos');
					$('#tablaDatos tbody tr').remove();
					datos.forEach(function (item) {
						tabla.innerHTML += `
								<td> ${item.Id} </td>
							    <td >  ${item.Nombre} </td>
							   <td> ${item.Apellido}</td>
							   <td>
								<a class="btn btn-danger" href="controllerUsuario?id=${item.Id}&Eliminar=btne"> ELIMINAR </a> 
								</td>
								</tr>
							`

					})
					
				} catch (e) {
					// TODO: handle exception
				}
				
			});
		})


	}
			

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