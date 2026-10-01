<%@ page contentType="text/html" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulario de Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<h1>
    <!-- atrapa la variable de la request que se llama empleado -->
${not empty empleado? 'Editando empleado' : 'Agregando Nuevo Empleado '}
</h1>

    <div class="container">
    <form method="post"  action="${pageContext.request.contextPath}/empleados">
        <!-- hidden es control oculto para visualizacion-->

        <c:if  test="${not empty empleado}">
            <input type="hidden"name="txtId" id="txtId" value="${empleado.id}" >
        </c:if>

        <div class="input-group mb-3">
            <label>Nombre</label>
            <input type="text" name="txtNombre" id="txtNombre"
             value="${empleado.nombre}"
             required placeholder="Ingrese su nombre" >
        </div>
        <div class="input-group mb-3">
            <label>Apellido</label>
            <input type="text" name="txtApellido" id="txtApellido"
            value="${empleado.apellido}"
            required  >
        </div>
        <div class="input-group mb-3">
            <label>Salario Base</label>
            <span class="input-group-text">$</span>
            <input type="text"  class="form-control"  name="txtSalarioBase" id="txtSalarioBase"
               value="${empleado.salarioBase}"
           aria-label="Cantidad en pesos">
            <span class="input-group-text">.00</span>
        </div>

        <input type="submit"  value="${not empty empleado? 'Actualizar' : 'Guardar'}">
        <input type="reset" value="Limpiar">

    </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>