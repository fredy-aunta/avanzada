<%-- 
    Document   : crearEjercicio
    Created on : 13/11/2014, 12:01:53 AM
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
                    <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
                        <form class="form-horizontal" role="form" action="CrearEjercicio" method="post">
                            <div class="form-group">
                                <label for="nombre" class="col-sm-3 col-md-3 control-label">Nombre</label>
                                <div class="col-sm-9 col-md-9">
                                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="tipo" class="col-sm-3 col-md-3 control-label">Tipo de Ejercicio</label>
                                <div class="col-sm-9 col-md-9">
                                    <input type="text" class="form-control" id="tipo" name="tipo" placeholder="Tipo">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="repeticiones" class="col-sm-3 col-md-3 control-label">Repeticiones</label>
                                <div class="col-sm-9 col-md-9">
                                    <input type="text" class="form-control" id="repeticiones" name="repeticiones" placeholder="repeticiones">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="serie" class="col-sm-3 col-md-3 control-label">Serie Ejercicio</label>
                                <div class="col-sm-9 col-md-9">
                                    <input type="text" class="form-control" id="serie" name="serie" placeholder="Serie">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9 col-md-offset-3 col-md-9">
                                    <button type="submit" class="btn btn-success">Crear</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
