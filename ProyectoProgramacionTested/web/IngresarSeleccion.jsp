<%-- 
    Document   : IngresarSeleccion
    Created on : 28-jun-2015, 21:12:37
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
        <option>
            <li><a href="RecuperarSesion">Inicio</a></li>
            <li><a href="Admministrador/IngresarSeleccion.jsp">Ingresar Seleccion</a></li>
            <li><a href="Admministrador/IngresarObjetos.jsp">Ingresar Objetos</a></li>
            <li><a href="Admministrador/AprobarSolicitudes.jsp">Solicitudes</a></li>
        </option>
        <h1>Complete Datos</h1>
       
        <form action="IngresarSeleccion">
            <label>Ingrese acronimo pais</label>
            <input type="text" name="txtAcronimo" required="" />
            <label>Indique Pais </label>
            <input type="text" name="txtPais" required="" />
            <label>Nombre Federacion</label>
            <input type="text" name="txtFederacion" required="" />
            <input type="submit" name="Ingresar" />
            
        </form>
        <%
        String msg = "";
        if(request.getAttribute("msg") != null){
        msg =(String) request.getAttribute("msg");
        }
        %>
        <%=msg%>
    </body>
</html>
