<%-- 
    Document   : index
    Created on : 9/11/2014, 03:08:06 PM
    Author     : Fredy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_head.html" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GYM</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Adm.png">
                                    <div class="caption">
                                        <h3>Admin</h3>
                                        <p>Admin</p>
                                        <p><a href="loginAdmin.jsp" class="btn btn-primary btn-block" role="button">Login</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/usu.png">
                                    <div class="caption">
                                        <h3>Cliente</h3>
                                        <p>Cliente</p>
                                        <p><a href="loginCliente.jsp" class="btn btn-primary btn-block" role="button">Login</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/entr.jpg">
                                    <div class="caption">
                                        <h3>Entrenador</h3>
                                        <p>Entrenador</p>
                                        <p><a href="loginEntrenador.jsp" class="btn btn-primary btn-block" role="button">Login</a></p>
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
