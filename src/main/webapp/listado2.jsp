<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<jsp:include page="header.jsp">
    <jsp:param name="titulo" value="Inicio"/>
</jsp:include>


<h1>Listado de Empleados</h1>

<c:if test="${!empty sessionScope.usuario}">

<table>
    <thead>
        <th>Id</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Salario Base</th>
        <th>Editar</th>
        <th>Borrar</th>

    </thead>
    <tbody>
      <c:forEach items="${lista}"  var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.nombre}</td>
            <td>${emp.apellido}</td>
            <td>${emp.salarioBase}</td> <!--si no tiene extension jsp antes de ? va al servlet-->
         <!--   <td><img src="https://ies63lastoscas.edu.ar/assets/imagenes/c5ae74ab1b4fa9285966da79b3f03dfb.png">  </td>-->
            <td>  <a href="${pageContext.request.contextPath}/empleados?accion=editar&id=${emp.id}">
                <i class="bi bi-pencil-fill"></i>
            </a> </td>
            <td>  <a href="${pageContext.request.contextPath}/empleados?accion=borrar&id=${emp.id}">
                <i class="bi bi-trash"></i>
            </a> </td>
        </tr>
      </c:forEach>


      <c:if test="${empty lista}">
          <tr colspan="5">
              <td> No existen registros</td>
          </tr>
      </c:if>
    </tbody>
</table>


<a href="${pageContext.request.contextPath}/empleados?accion=nuevo">Agregar Nuevo Empleado </a>

</c:if>

</main>
<jsp:include page="footer.jsp"/>
