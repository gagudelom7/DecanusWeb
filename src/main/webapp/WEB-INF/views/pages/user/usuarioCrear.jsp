<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form   action="${pageContext.request.contextPath}/usuario/guardar" method="post" data-role="validator">

<table class="tableStyle">
  <tr><th colspan="4">Crear Usuario</th>
  <tr><td>ID Usuario</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="id" >
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Tipo Usuario</td>
     <td><div class="input-control select">
    <select name="tipo">
        <option value = "ADMIN">Administrador</option>
        <option value = "EST">Estudiante</option>
        <option value = "PRO">Profesor</option>
    </select>
</div></td>
        
        </tr>
        
  <tr><td>Pimer Nombre</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="nombre1" >
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Estado Usuario</td>
 	 <td> <select name="estado">
        <option value = "1">Activo</option>
        <option value = "0">Inactivo</option>
     </select></td>
        
        </tr>
  <tr><td>Segundo Nombre</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="nombre2"  >
          <span class="input-state-error mif-warning"></span>
        </div>
        </td>
        
        <td class="cellSpacing" >Fecha Ingreso</td>
  	  <td><div class="input-control text" data-format="dd-mm-yyyy" data-role="datepicker">
    <input type="text" name="fecha">
    <button class="button"><span class="mif-calendar"></span></button>
</div>
</td>
        
        </tr>
  <tr><td>Primer Apellido</td>
  	  <td><div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="apellido1" >
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
          type="text" name="apellido2">
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
 <button class="button primary btnright mif-checkmark">&nbsp;Crear</button>
 
 
 
 </td>
 
 
 </tr>
                   
</table>
</form>

