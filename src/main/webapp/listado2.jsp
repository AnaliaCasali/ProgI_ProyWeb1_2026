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
    </thead>
    <tbody>
      <c:forEach items="${lista}"  var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.nombre}</td>
            <td>${emp.apellido}</td>
            <td>${emp.salarioBase}</td>
        </tr>
      </c:forEach>
      <c:if test="${empty lista}">
          <tr colspan="4">
              <td> No existen registros</td>
          </tr>
      </c:if>
    </tbody>
</table>

</body>
</html>