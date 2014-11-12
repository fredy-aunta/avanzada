<%-- 
    Document   : crearEntrenador
    Created on : 11/11/2014, 07:07:34 PM
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
                        <form class="form-horizontal" role="form" action="User">
                            <div class="form-group">
                                <label for="name" class="col-sm-2 col-md-2 control-label">Name</label>
                                <div class="col-sm-10 col-md-10">
                                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
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
