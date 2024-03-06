<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Usuarios</h2>

<button onclick="window.location.href='${pageContext.request.contextPath}/usuario/crear'" class="button primary mif-user-plus">&nbsp;Crear</button>


<table id="example_table" class="dataTable striped border bordered" data-role="datatable" data-searching="true">
        <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Tipo Usuario</th>
                    <th>Estado Usuario</th>
                    <th>Fecha Ingreso</th>
                     <th>Acciones</th>
                    </tr>
                </thead>
     <tbody>
<c:forEach var="listValue" items="${listUsuario}">
		<tr>
			<td>${listValue.idUsuario}</td>
			<td>${listValue.nombre1}</td>
			<td>${listValue.apellido1}</td>
			<td>${listValue.tipoUsuario}</td>
			<td>${listValue.estadoUsuario}</td>
			<td>${listValue.fechaIngreso}</td>
			<td>
			
			<button type="button" onclick="eliminarRecurso('${listValue.idUsuario}','${pageContext.request.contextPath}/usuario/eliminar')" class="button primary btnleft mif-bin icon rounded"> 
			</button>
			
			<button type="button" onclick="modificarRecurso('${listValue.idUsuario}','${pageContext.request.contextPath}/usuario/modificar')" class="button primary btnleft mif-pencil icon rounded"> 
			</button>
			
			
			</td>
		</tr>		
</c:forEach>
     
  </tbody>              
  </table>


  
