<%-- 
    Document   : crearCliente
    Created on : 11/11/2014, 08:19:43 PM
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
                    <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8">
                        <form class="form-horizontal" role="form" action="CrearCliente">
                            <div class="form-group">
                                <label for="nombre" class="col-sm-2 col-md-2 control-label">Name</label>
                                <div class="col-sm-10 col-md-10">
                                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="objetivo" class="col-sm-2 col-md-2 control-label">Objetivo</label>
                                <div class="col-sm-10 col-md-10">
                                    <select class="form-control" id="objetivo" name="objetivo">
                                        <option value="Marcar">Marcar</option>
                                        <option value="Adelgazar">Adelgazar</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label">Genero</label>
                                <div class="col-md-10">
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" id="gender_m" value="M"> Masculino
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="gender" id="gender_f" value="F"> Femenino
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="dob" class="col-sm-2 col-md-2 control-label">Fecha de Nacimiento</label>
                                <div class="col-sm-10 col-md-10">
                                    <input type="date" class="form-control" id="dob" name="dob">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="masa" class="col-sm-2 col-md-2 control-label">Masa</label>
                                <div class="col-sm-10 col-md-10">
                                    <input type="text" class="form-control" id="masa" name="masa" placeholder="Masa">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="altura" class="col-sm-2 col-md-2 control-label">Altura</label>
                                <div class="col-sm-10 col-md-10">
                                    <input type="text" class="form-control" id="altura" name="altura" placeholder="Altura">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10 col-md-offset-2 col-md-10">
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
