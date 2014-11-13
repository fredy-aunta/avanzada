<%-- 
    Document   : consultarRutina
    Created on : 12/11/2014, 12:48:00 AM
    Author     : Fredy
--%>

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
                            <div class="col-md-3">
                                <select name="dia">
                                    <option vale="1">Lunes</option>
                                    <option value="2">Martes</option>
                                    <option value="3">Miercoles</option>
                                    <option value="4">Jueves</option>
                                    <option value="5">Viernes</option>
                                    <option value="6">Sabado</option>
                                    <option value="7">Domingo</option>
                                </select>
                            </div>
                            <div class="col-md-9">
                                <table class="table">
                                    <tr>
                                        <td>Nombre Ejercicio</td>
                                        <td>Tipo Ejercicio</td>
                                        <td>Repeticiones</td>
                                        <td>Serie</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
