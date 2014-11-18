<%-- 
    Document   : consultarEjercicios
    Created on : 13/11/2014, 12:11:54 AM
    Author     : Fredy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Negocio.Ejercicio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_head.html" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GYM-Entrenador</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
                        <h1>Ejercicios</h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Tipo</th>
                                    <th>Repeticiones</th>
                                    <th>Serie</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="ejercicio" items="${ejercicios}">
                                <tr>
                                    <td>
                                        <c:out value="${ejercicio.idEjercicio}"/>
                                    </td>
                                    <td>
                                        <c:out value="${ejercicio.nombreEjercicio}"/>
                                    </td>
                                    <td>
                                        <c:out value="${ejercicio.tipoEjercicio}"/>
                                    </td>
                                    <td>
                                        <c:out value="${ejercicio.repeticionesEjercicio}"/>
                                    </td>
                                    <td>
                                        <c:out value="${ejercicio.serieEjercicio}"/>
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
