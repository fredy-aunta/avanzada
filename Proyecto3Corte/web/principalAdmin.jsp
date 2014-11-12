<%-- 
    Document   : principalAdmin
    Created on : 9/11/2014, 09:40:48 PM
    Author     : Fredy
--%>

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
                        <div class="row">
                            <div class="col-md-4 col-md-offset-2 col-sm-4 col-sm-offset-2">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Add.jpg">
                                    <div class="caption">
                                        <h3>Agregar</h3>
                                        <p>...</p>
                                        <p><a href="crearEntrenador.jsp" class="btn btn-primary btn-block" role="button">Entrenador</a></p>
                                        <p><a href="crearCliente.jsp" class="btn btn-primary btn-block" role="button">Cliente</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/consultar.jpg">
                                    <div class="caption">
                                        <h3>Consultar</h3>
                                        <p>...</p>
                                        <p><a href="consultarClientes.jsp" class="btn btn-primary btn-block" role="button">Clientes</a></p>
                                        <p><a href="consultarEntrenadores.jsp" class="btn btn-primary btn-block" role="button">Entrenadores</a></p>
                                        <p><a href="consultarRutinas.jsp" class="btn btn-primary btn-block" role="button">Rutinas</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
