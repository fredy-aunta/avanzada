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
                            <button class="btn btn-primary" id="createRutina" type="button" onclick="crearRutina()">Crear Rutina</button>
                        </form>
                        <h2>Adicionar Ejercicios</h2>
                        <form class="form-inline" role="form-ejercicio">
                            <div class="form-group">
                                <select class="form-control" id="dia" name="dia">
                                    <option value="">Dia</option>
                                    <option value="1">Lunes</option>
                                    <option value="2">Martes</option>
                                    <option value="3">Miercoles</option>
                                    <option value="4">Jueves</option>
                                    <option value="5">Viernes</option>
                                    <option value="6">Sabado</option>
                                    <option value="7">Domingo</option>
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
                            <button onclick="addEjercicioDia()" id="adicionarEjercicio" type="button" class="btn btn-primary">Adicionar Ejercicio</button>
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
                                        <td><ul id="dia_1"></ul></td>
                                        <td><ul id="dia_2"></ul></td>
                                        <td><ul id="dia_3"></ul></td>
                                        <td><ul id="dia_4"></ul></td>
                                        <td><ul id="dia_5"></ul></td>
                                        <td><ul id="dia_6"></ul></td>
                                        <td><ul id="dia_7"></ul></td>
                                    </tr>
                                </tbody>
                            </table>
                            <div id="hiddenInputs"></div>
                            <input class="btn btn-success" type="submit" value="Adicionar Rutina" id="adicionarRutina"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" >
                                $(document).ready(function() {
                                    $('#dia').attr("disabled", "disabled");
                                    $('#ejercicioId').attr("disabled", "disabled");
                                    $('#adicionarEjercicio').attr("disabled", "disabled");
                                    $('#adicionarRutina').attr("disabled", "disabled");
                                });
                                function crearRutina() {
                                    if ($('#clienteId').val() != '') {
                                        $('#dia').removeAttr("disabled");
                                        $('#ejercicioId').removeAttr("disabled");
                                        $('#adicionarEjercicio').removeAttr("disabled");
                                        $('#adicionarRutina').removeAttr("disabled");
                                        $('#clienteId').attr("disabled", "disabled");
                                        $('#createRutina').attr("disabled", "disabled");
                                    }else{
                                        alert("error cliente");
                                    }
                                }
                                function addEjercicioDia() {
                                    var numDia = $('#dia').val();
                                    var ejercicioId = $('#ejercicioId').val();
                                    
                                    if(numDia != '' && ejercicioId != ''){
                                        var input = '<input type="hidden" value="' + ejercicioId + '" name="ejerciciosDia[' + numDia + ']"/>';
                                        $('#hiddenInputs').html($('#hiddenInputs').html() + input);
                                        switch(numDia){
                                            case '1':
                                                $('#dia_1').html($('#dia_1').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                            case '2':
                                                $('#dia_2').html($('#dia_2').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                            case '3':
                                                $('#dia_3').html($('#dia_3').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                            case '4':
                                                $('#dia_4').html($('#dia_4').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                            case '5':
                                                $('#dia_5').html($('#dia_5').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                            case '6':
                                                $('#dia_6').html($('#dia_6').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                            case '7':
                                                $('#dia_7').html($('#dia_7').html() + '<li>' + ejercicioId + '</li>');
                                                break;
                                        }
                                    }else{
                                        alert('datos erroneos');
                                    }
                                }
        </script>
    </body>
</html>
