<%-- 
    Document   : consultarRutinas
    Created on : 11/11/2014, 11:59:24 PM
    Author     : Fredy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_head.html" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GYM-Admin</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
                        <h1>Rutinas</h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Id Entrenador</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="rutina" items="${rutinas}">
                                <tr>
                                    <td>
                                    <c:out value="${rutina.idRutina}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${rutina.nombreRutina}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${rutina.entrenador.idEntrenador}"></c:out>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
