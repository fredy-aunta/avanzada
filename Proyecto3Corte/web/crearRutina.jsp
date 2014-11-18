<%-- 
    Document   : crearRutina
    Created on : 12/11/2014, 11:33:37 PM
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
        <title>GYM-Entrenador</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
                        <h1>Rutina</h1>
                        <h2>Crear Rutina</h2>
                        <form class="form-inline" role="form-cliente">
                            <div class="form-group">
                                <select name="clienteId" id="clienteId" class="form-control">
                                    <option value="">Cliente</option>
                                    <c:forEach var="cliente" items="${clientes}">
                                        <option value="${cliente.idCliente}"><c:out value="${cliente.nombreCliente}"></c:out></option>
                                    </c:forEach>
                                </select>
                            </div>
                                    <button class="btn btn-primary" type="button" onclick="">Crear Rutina</button>
                        </form>
                        <h2>Adicionar Ejercicios</h2>
                        <form class="form-inline" role="form-ejercicio">
                            <div class="form-group">
                                <select class="form-control" id="dia" name="dia">
                                    <option value="">Dia</option>
                                    <option value="lunes">Lunes</option>
                                    <option value="martes">Martes</option>
                                    <option value="miercoles">Miercoles</option>
                                    <option value="jueves">Jueves</option>
                                    <option value="viernes">Viernes</option>
                                    <option value="sabado">Sabado</option>
                                    <option value="domingo">Domingo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <select class="form-control" id="ejercicioId" name="ejercicioId">
                                    <option value="">Ejercicio</option>
                                    <c:forEach var="ejercicio" items="${ejercicios}">
                                        <option value="${ejercicio.idEjercicio}"><c:out value="${ejercicio.nombreEjercicio}"></c:out></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button onclick="addEjercicioDia()" type="button" class="btn btn-primary">Adicionar Ejercicio</button>
                            <h2>Ejercicios - Dia</h2>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Lunes</th>
                                        <th>Martes</th>
                                        <th>Miercoles</th>
                                        <th>Jueves</th>
                                        <th>Viernes</th>
                                        <th>Sabado</th>
                                        <th>Domingo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><ul id="lunes"></ul></td>
                                        <td><ul id="martes"></ul></td>
                                        <td><ul id="miercoles"></ul></td>
                                        <td><ul id="jueves"></ul></td>
                                        <td><ul id="viernes"></ul></td>
                                        <td><ul id="sabado"></ul></td>
                                        <td><ul id="domingo"></ul></td>
                                    </tr>
                                </tbody>
                            </table>
                            <div id="hiddenInputs"></div>
                            <input class="btn btn-success" type="submit" value="Crear Rutina" id="crearRutina"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" >
    $(document).ready(function() {

    });
    function addEjercicioDia() {

    }
        </script>
    </body>
</html>
