<%-- 
    Document   : principalCliente
    Created on : 9/11/2014, 10:01:03 PM
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
                    <div class="col-md-offset-3 col-md-6">
                        <div class="row">
                            <div class="col-md-6 col-sm-6">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Adm.png">
                                    <div class="caption">
                                        <h3>Consultar</h3>
                                        <p>...</p>
                                        <p><a href="consultarRutina.jsp" class="btn btn-primary btn-block" role="button">Rutina</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Adm.png">
                                    <div class="caption">
                                        <h3>Cambiar</h3>
                                        <p>...</p>
                                        <p><a href="cambiarPasswordCliente.jsp" class="btn btn-primary btn-block" role="button">Contraseña</a></p>
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
