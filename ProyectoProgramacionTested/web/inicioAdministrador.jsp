<%-- 
    Document   : inicioAdministrador
    Created on : 27-jun-2015, 16:51:18
    Author     : andre_000
--%>

<%@page import="cl.inacap.modelo.Usuario"%>
<%@page import="cl.inacap.modelo.Solicitud"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario)sesion.getAttribute("Usuario");
        ArrayList<Solicitud> listaSolicitud = (ArrayList) request.getAttribute("listaSolicitud");
    %>
    <body>
        <form action="CerrarSesion">
            <input type="submit" name="Cerrar Sesion" value="Cerra" />
        </form>

        <h1>Hola </h1>
        <%=u.getUsuario() %>

   
            <a href="IngresarSeleccion.jsp">Ingresar Seleccion</a>
            <a href="IngresarObjetos.jsp">Ingresar Objetos</a>
            <a href="AprobarSolicitudes.jsp">Solicitudes</a>
           

            <h2>Lista Solicitudes</h2>
            <form action="action">
                <input list="EstadoSolicitudes" />
			<datalist id="EstadoSolicitudes">
				<option value="Todas" />
				<option value="Pendientes" />
				<option value="Aprobadas" />
				<option value="Rechazadas" />
			</datalist>
                <input type="submit" value="Filtrar" />
            </form>
            <table border="1">
                <thead>
                    <tr>
                        <th>Rut Solicitud</th>
                        <th>Nombre Usuario</th>
                        <th>Correo Usuario</th>
                        <th>Nombre Objeto</th>
                        <th>Estado Solicitud</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

            <h2>Lista Hinchas</h2>
            <form action="action">
                <input list="Pais" />
			<datalist id="Pais">
				<% //For each con todos los paises para su filtro%>
                                <option value="Todas" />
				<option value="Pendientes" />
				<option value="Aprobadas" />
				<option value="Rechazadas" />
			</datalist>
                <input type="submit" value="Filtrar" />
            </form>

    </body>
</html>
