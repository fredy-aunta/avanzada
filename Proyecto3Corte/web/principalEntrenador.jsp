<%-- 
    Document   : principalEntrenador
    Created on : 9/11/2014, 10:00:45 PM
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
                    <div class="col-md-offset-2 col-md-8">
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Adm.png">
                                    <div class="caption">
                                        <h3>Crear</h3>
                                        <p>...</p>
                                        <p><a href="crearRutina.jsp" class="btn btn-primary btn-block" role="button">Rutina</a></p>
                                        <p><a href="crearEjercicio.jsp" class="btn btn-primary btn-block" role="button">Ejercicio</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Adm.png">
                                    <div class="caption">
                                        <h3>Consultar</h3>
                                        <p>...</p>
                                        <p><a href="consultarRutinasEntrenador.jsp" class="btn btn-primary btn-block" role="button">Rutinas</a></p>
                                        <p><a href="consultarEjercicios.jsp" class="btn btn-primary btn-block" role="button">Ejercicios</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="thumbnail">
                                    <img alt="..." src="data/Adm.png">
                                    <div class="caption">
                                        <h3>Cambiar</h3>
                                        <p>...</p>
                                        <p><a href="cambiarPasswordEntrenador.jsp" class="btn btn-primary btn-block" role="button">Contraseña</a></p>
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
