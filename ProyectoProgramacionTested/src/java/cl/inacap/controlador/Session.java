/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.controlador;

import cl.inacap.DAO.DAOHincha;
import cl.inacap.modelo.Hincha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Session", urlPatterns = {"/Session"})
public class Session extends HttpServlet {

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
        String user, password;
        ArrayList<Hincha> listaHincha = new ArrayList();
        DAOHincha daoHincha = new DAOHincha();
        user = request.getParameter("txtUsuario");
        password = request.getParameter("txtPassword");
        
        listaHincha = daoHincha.listarHinchas();
        //si el tipo de ususario es hincha o es administrador, creara un objeta administrador o session
        for (Hincha h : listaHincha) {
            if (h.getUsuario().equalsIgnoreCase(user) && h.getPassword().equals(password)){
                //se crea un objeto sesion que guardara el tipo de ususario
                HttpSession session = request.getSession();
                session.setAttribute("tipoUsuario", h.getTipoUsuario());
                session.setAttribute("Usuario", h);
                if(h.getTipoUsuario().equals("Administrador")){
                    request.getRequestDispatcher("RecuperarSesion").forward(request, response);
                }else{
                    request.getRequestDispatcher("inicioHincha.jsp").forward(request, response);
                }
            }else{
                String msg = "Usuario no existe o datos mal ingresados";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
