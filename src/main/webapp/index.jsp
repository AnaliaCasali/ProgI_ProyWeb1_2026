<%@ page contentType="text/html" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page include file="header.jsp" %>

<c: set var="titulo" value="Pagina de Inicio" >

<a href="hola"> Ir a la pagina Hola</a>
<br><a href="listadoEmpleados.jsp"> Listado de Empleados</a>
<br><a href="empleados"> Listado de Empleados via servlet</a>
<br><a href="empleados?accion=nuevo"> Formulario Empleado</a>


<jsp:include page="footer.jsp"></jsp:include>
