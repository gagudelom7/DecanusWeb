<h2>Materias</h2>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form   action="${url}" method="post" data-role="validator">
<input type="hidden" name="codigo"   value="${materia.codigo}"  />
<table>
  <tr>
    <th>Nombre Materia</th>
    <th>Profesor</th>
    <th>Horas</th>
    <th></th>
  </tr>
  <tr>
    <td>
    	<div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="nombre" value="${materia.nombre}"  >
          <span class="input-state-error mif-warning"></span>
        </div>
    </td>
    <td>
    <div class="input-control text info">
          <input 
            data-validate-func="minlength"
            data-validate-arg="4"
          type="text" name="profesor" value="${materia.profesor}" >
          <span class="input-state-error mif-warning"></span>
        </div>
    </td>
    <td>
    <div class="input-control select">
    <select name="horas"  >
    <c:forEach var="i" begin="1" end="4" >
    <c:if test="${materia.horas eq 0}">
    	<option value="${i}" >${i}</option>
    </c:if>
    <c:if test="${materia.horas > 0 }">
        <c:if test="${materia.horas eq i}">
        	<option value="${i}" selected="selected" >${i}</option>
        </c:if>
          <c:if test="${not (materia.horas eq i)}">
        	 <option value="${i}" >${i}</option>
        </c:if>
       
    </c:if>
    </c:forEach>
    </select>
</div>
    </td>
    <td>
    	<button class="button rounded primary"><c:out value="${accion}"></c:out></button>
    </td>
  </tr>
</table>
</form>
<table id="example_table" class="dataTable striped border bordered" data-role="datatable" data-searching="true">
        <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Horas</th>
                    <th>Profesor</th>
                    <th>Acciones</th>
                    </tr>
                </thead>
     <tbody>
<c:forEach var="listValue" items="${listMateria}">
		<tr>
			<td>${listValue.codigo}</td>
			<td>${listValue.nombre}</td>
			<td>${listValue.horas}</td>
			<td>${listValue.profesor}</td>
			<td>
			<a href="${pageContext.request.contextPath}/materias/eliminar/${listValue.codigo}">
                            <span class="mif-bin icon"></span>
                        </a>
             <a href="${pageContext.request.contextPath}/materias/${listValue.codigo}">
                            <span class="mif-pencil icon"></span>
                        </a>
			</td>
		</tr>		
</c:forEach>
     
  </tbody>              
  </table>
