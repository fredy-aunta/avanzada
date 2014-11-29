<%-- 
    Document   : consultarRutina
    Created on : 12/11/2014, 12:48:00 AM
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
        <title>GYM-Cliente</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <h1>Consultar Rutina</h1>
                            </div>
                            <div class="col-md-9">
                                <table class="table">
                                    <thead><tr>
                                        <td>Nombre Ejercicio</td>
                                        <td>Tipo Ejercicio</td>
                                        <td>Repeticiones</td>
                                        <td>Serie</td>
                                    </tr></thead>
                                    <tbody>
                                    <c:forEach var="ejercicio" items="${ejercicios}">
                                        <tr>
                                            <td><c:out value="${ejercicio.nombreEjercicio}"</td>
                                            <td><c:out value="${ejercicio.tipoEjercicio}"</td>
                                            <td><c:out value="${ejercicio.repeticionesEjercicio}"</td>
                                            <td><c:out value="${ejercicio.serieEjercicio}"</td>
                                        </tr>
                                    </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
