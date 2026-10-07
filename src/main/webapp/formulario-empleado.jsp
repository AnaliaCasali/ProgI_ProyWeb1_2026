<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<jsp:include page="header.jsp">
    <jsp:param name="titulo" value="Inicio"/>
</jsp:include>


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

<jsp:include page="footer.jsp"/>
