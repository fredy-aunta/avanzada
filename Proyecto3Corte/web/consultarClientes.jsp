<%-- 
    Document   : consultarClientes
    Created on : 11/11/2014, 11:58:28 PM
    Author     : Fredy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_head.html" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
                        <h1>Clientes</h1>
                        <table class="table">
                            <tr>
                                <td><strong>ID Cliente</strong></td>
                                <td><strong>Nombre</strong></td>
                                <td><strong>Altura</strong></td>
                                <td><strong>Masa</strong></td>
                                <td><strong>Edad</strong></td>
                                <td><strong>Genero</strong></td>
                                <td><strong>Objetivo</strong></td>
                            </tr>
                            <% for(int x=1;x<=10;x++){%>
                            <tr>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
