package cl.inacap.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import cl.inacap.DAO.DAOSeleccion;
import cl.inacap.modelo.Seleccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre_000
 */
@WebServlet(name = "IngresarSeleccion", urlPatterns = {"/IngresarSeleccion"})
public class IngresarSeleccion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Seleccion seleccion = new Seleccion();
        seleccion.setAcronimo(request.getParameter("txtAcronimo"));
        seleccion.setPais(request.getParameter("txtPais"));
        seleccion.setNomFederacion(request.getParameter("txtFederacion"));
        
        DAOSeleccion daoSeleccion = new DAOSeleccion();
        boolean ingresar = daoSeleccion.registrarSeleccion(seleccion);
        String msg="";
        if(ingresar == true){
            msg = "Seleccion Ingresada Correctamente.";
        }else{
            msg = "Error al ingresar Seleccion.";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("IngresarSeleccion.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
