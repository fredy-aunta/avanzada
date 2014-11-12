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
        <title>GYM-Ciente</title>
    </head>
    <body>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
                        <div class="row">
                            <form class="form-horizontal" role="form" action="">
                                <div class="form-group">
                                    <label for="currentPassword" class="col-sm-3 col-md-3 control-label">Current Password</label>
                                    <div class="col-sm-9 col-md-9">
                                        <input type="password" class="form-control" id="currentPassword" name="currentPassword">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="newPassword" class="col-sm-3 col-md-3 control-label">New Password</label>
                                    <div class="col-sm-9 col-md-9">
                                        <input type="password" class="form-control" id="newPassword" name="newPassword">
                                    </div>
                                </div>
                                <input type="hidden" name="roleId" value="3"/>
                                <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-9 col-md-offset-3 col-md-9">
                                        <button type="submit" class="btn btn-success">Cambiar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>