<%-- 
    Document   : consultarRutinas
    Created on : 11/11/2014, 11:59:24 PM
    Author     : Fredy
--%>

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
                        <h1>Rutinas</h1>
                        <table class="table">
                            <tr>
                                <td>ID Rutina</td>
                                <td>Nombre Rutina</td>
                                <td>Nombre Entrenador</td>
                            </tr>
                            <% for(int i=0;i<=10;i++){%>
                            <tr>
                                <td>ID</td>
                                <td>NOMR</td>
                                <td>NOME</td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
