<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- Encabezado comun: abre html, head y body. Se cierra en footer.jsp --%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- el titulo llega como parametro del jsp:include -->
    <title>${empty param.titulo ? 'ProgI Proyecto Web' : param.titulo}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">

</head>
<body class="d-flex flex-column min-vh-100">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">ProgI Web</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menuPrincipal"
                aria-controls="menuPrincipal" aria-expanded="false" aria-label="Mostrar menu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menuPrincipal">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/hola">Hola</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/listadoEmpleados.jsp">Listado (scriptlet)</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/empleados">Listado (servlet)</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/empleados?accion=nuevo">Nuevo Empleado</a>
                </li>
            </ul>

            <!-- busca el atributo usuario en la sesion (lo guarda LoginServlet) -->
            <c:choose>
                <c:when test="${not empty sessionScope.usuario}">
                    <span class="navbar-text me-3">
                        Usuario: <strong><c:out value="${sessionScope.usuario.nombre}"/></strong>
                        <c:out value="${sessionScope.mensaje}"/>
                    </span>
                    <a class="btn btn-outline-light btn-sm"
                       href="${pageContext.request.contextPath}/login?accion=salir">Cerrar Sesión</a>
                </c:when>
                <c:otherwise>
                    <span class="navbar-text me-3">Invitado</span>
                    <a class="btn btn-outline-light btn-sm" href="${pageContext.request.contextPath}/login">Ingresar</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<main class="container my-4 flex-grow-1">
