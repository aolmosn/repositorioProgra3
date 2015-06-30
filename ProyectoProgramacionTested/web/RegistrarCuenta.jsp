<%-- 
    Document   : RegistrarCuenta
    Created on : 29-jun-2015, 5:25:14
    Author     : andre_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="NuevaCuenta">
            <label>Ingrese un nombre de Usuario</label>
            <input type="text" name="txtUsuario" required />
            <label>Ingrese password</label>
            <input type="password" name="txtPass" required />
            <label>ingrese nuevamente password</label>
            <input type="password" name="txtRePass" required />
            <label>Ingrese su RUT</label>
            <input type="text" name="txtRut" />
            <label>Ingrese su nombre</label>
            <input type="text" name="txtNombre" required />
            <label>Ingrese sus Apellidos</label>
            <input type="text" name="txtApellido" required />
            <label>Ingrese e-mail de contacto</label>
            <input type="text" name="txtMail" required />
            <input type="submit" name="crear">
        </form>
        <%
            String msg = "";
            if(request.getAttribute("msg") != null){
                msg = (String) request.getAttribute("msg");
            }
        %>
        <%=msg%>
    </body>
</html>
