<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>

<jsp:include page="header.jsp">
    <jsp:param name="titulo" value="Inicio"/>
</jsp:include>


<a href="hola"> Ir a la pagina Hola</a>
<br><a href="listadoEmpleados.jsp"> Listado de Empleados</a>
<br><a href="empleados"> Listado de Empleados via servlet</a>
<br><a href="empleados?accion=nuevo"> Formulario Empleado</a>
<br><a href="login"> Login</a>

<jsp:include page="footer.jsp"/>
