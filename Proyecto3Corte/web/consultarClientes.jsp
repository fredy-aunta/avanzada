<%-- 
    Document   : consultarClientes
    Created on : 11/11/2014, 11:58:28 PM
    Author     : Fredy
--%>

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
                        <h1>Clientes</h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID Cliente</th>
                                    <th>Nombre</th>
                                    <th>Altura</th>
                                    <th>Masa</th>
                                    <th>Edad</th>
                                    <th>Genero</th>
                                    <th>Objetivo</th>
                                </tr>
                            </thead>
                            </th>
                            <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>
                                        <c:out value="${cliente.idCliente}"/>
                                    </td>
                                    <td>
                                        <c:out value="${cliente.nombreCliente}"/>
                                    </td>
                                    <td>
                                        <c:out value="${cliente.alturaCliente}"/>
                                    </td>
                                    <td>
                                        <c:out value="${cliente.masaCliente}"/>
                                    </td>
                                    <td>
                                        <c:out value="${cliente.edadCliente}"/>
                                    </td>
                                    <td>
                                        <c:out value="${cliente.generoCliente}"/>
                                    </td>
                                    <td>
                                        <c:out value="${cliente.objetivo.getObjetivo()}"/>
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
