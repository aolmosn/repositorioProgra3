/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.DAO.DAOHincha;
import cl.inacap.DAO.DAOSolicitud;
import cl.inacap.modelo.Hincha;
import cl.inacap.modelo.Solicitud;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre_000
 */
@WebServlet(name = "RecuperarSesion", urlPatterns = {"/RecuperarSesion"})
public class RecuperarSesion extends HttpServlet {

    ServletContext contexto;
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        contexto = this.getServletContext();
        contexto.log(new Date() + " - Se inicializa Servlet.");
    }
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
        contexto.log(new Date() + " - Se recupera sesion si es que la hay ");
        HttpSession sesion = request.getSession();
        
        if (sesion.isNew()){
            contexto.log(new Date() + " - No se ha iniciado sesion, debe logearse");
            request.getRequestDispatcher("index.jsp").forward(request, response);    
        }else{
            contexto.log(new Date() + " - Se recupero la sesion, se redireccionara a la pagina de inicio");
            String tipoUsuario = (String)sesion.getAttribute("tipoUsuario");
            
            //Revisa si es un administrador o un hincha
            if (tipoUsuario.equals("Administrador")){
//                contexto.log(new Date() + " - Se recupero la sesion ADMINISTRADOR");
                DAOHincha hincha = new DAOHincha();
                ArrayList<Hincha> ListaHincha = hincha.listarHinchas();
                DAOSolicitud solicitud = new DAOSolicitud();
                ArrayList<Solicitud> listaSolicitud = new ArrayList();
                
                request.setAttribute("listaHincha", ListaHincha);
                request.setAttribute("listaSolicitud", listaSolicitud);
                request.getRequestDispatcher("inicioAdministrador.jsp").forward(request, response);    
            }else{
                contexto.log(new Date() + " - Se recupero la sesion HINCHA");
                request.getRequestDispatcher("inicioHincha.jsp").forward(request, response);
            }
            
        }
        
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
