<%@ page contentType="text/html" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listado de Empleados</title>
</head>
<body>
<h1>Listado de Empleados</h1>

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
            <td>  <a href="${pageContext.request.contextPath}/empleados?accion=editar&id=${emp.id}">Editar </a> </td>
            <td>  <a href="${pageContext.request.contextPath}/empleados?accion=borrar&id=${emp.id}">Borrar </a> </td>
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

</body>
</html>