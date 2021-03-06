/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.DAO.DAOUsuario;
import cl.inacap.modelo.Usuario;
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
@WebServlet(name = "NuevaCuenta", urlPatterns = {"/NuevaCuenta"})
public class NuevaCuenta extends HttpServlet {

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
                Usuario h = new Usuario();
                h.setUsuario(request.getParameter("txtUsuario"));
                //if(request.getParameter("txtPass") == request.getParameter("txtRePass")){
                    h.setPassword(request.getParameter("txtPass"));
                
                //}else{

                //}
                h.setRut(Integer.parseInt(request.getParameter("txtRut")));
                h.setNombre(request.getParameter("txtNombre"));
                h.setApellido(request.getParameter("txtApellido"));
                h.setMail(request.getParameter("txtMail"));
                h.setTipoUsuario("Hincha");
                
                DAOUsuario daoHincha = new DAOUsuario();
                String msg = "";
                if(daoHincha.registrarHincha(h)){
                    msg = "Registro Exitoso Ahota debe logearse";
                }else{
                    msg = "Error en el registro";
                }
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("RegistrarCuenta.jsp").forward(request, response);
        
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
