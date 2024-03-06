<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form   action="${pageContext.request.contextPath}/usuario/modificar/ejecutar" method="post" data-role="validator">

<table class="tableStyle">
  <tr><th colspan="4">Modificar Usuario</th>
  <tr><td>ID Usuario</td>
  	  <td><div class="input-control text info">
          <input 
          type="text" name="id" value="${usuario.idUsuario}" readonly>
         
        </div>
        </td>
        
        <td class="cellSpacing" >Tipo Usuario</td>
     <td><div class="input-control select">
    <select name="tipo">
    
    <c:if test="${usuario.tipoUsuario eq 'ADMIN'}">
        <option value = "ADMIN" selected="selected">Administrador</option>
        <option value = "EST">Estudiante</option>
        <option value = "PRO">Profesor</option>
        </c:if>
        
        <c:if test="${usuario.tipoUsuario eq 'EST'}">
        <option value = "ADMIN" >Administrador</option>
        <option value = "EST" selected="selected">Estudiante</option>
        <option value = "PRO">Profesor</option>
        </c:if>
        
         <c:if test="${usuario.tipoUsuario eq 'PRO'}">
        <option value = "ADMIN" >Administrador</option>
        <option value = "EST" >Estudiante</option>
        <option value = "PRO" selected="selected">Profesor</option>
        </c:if>
        
        
        </select>
</div></td>
        
        </tr>
        
  <tr><td>Pimer Nombre</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="nombre1" value="${usuario.nombre1}">
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Estado Usuario</td>
 	 <td> <select name="estado">
 	    <c:if test="${usuario.estadoUsuario eq '1'}">
        	<option value = "1" selected="selected" >Activo</option>
        	<option value = "0">Inactivo</option>
        </c:if>
        
        <c:if test="${usuario.estadoUsuario eq '0'}">
        	<option value = "1"  >Activo</option>
        	<option value = "0" selected="selected">Inactivo</option>
        </c:if>
        
        </select>
        </td>
        
        </tr>
  <tr><td>Segundo Nombre</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="nombre2" value="${usuario.nombre2}"> 
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Fecha Ingreso</td>
  	  <td><div class="input-control text" data-format="dd-mm-yyyy" data-role="datepicker">
    <input type="text" name="fecha" value="${usuario.fechaIngreso}">
    <button class="button"><span class="mif-calendar"></span></button>
</div>
</td>
       
        </tr>
  <tr><td>Primer Apellido</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="apellido1" value="${usuario.apellido1}">
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Contraseña</td>
  	  <td><div class="input-control password">
    <input type="password" name="pass">
</div>
	</td>
        
        </tr>
 <tr><td>Segundo Apellido</td>
 	 <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="apellidos2" value="${usuario.apellidos2}">
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Confirmar Contraseña</td>
 	  <td><div class="input-control password">
    <input type="password" name="pass2">
</div>
    </td>
        
        </tr>
 <tr>
 <td colspan="4">
 <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/usuario/all'" class="button primary btnleft mif-keyboard-return">&nbsp;Regresar</button>
 <button class="button primary btnright mif-checkmark">&nbsp;Modificar</button>
 
 
 
 </td>
 
 
 </tr>
                   
</table>
</form>

