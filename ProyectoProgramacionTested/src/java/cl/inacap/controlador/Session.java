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
@WebServlet(name = "Session", urlPatterns = {"/Session"})
public class Session extends HttpServlet {
    /*ServletContext contexto;
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        contexto = this.getServletContext();
        contexto.log(new Date() + " - Se inicializa Servlet.");
    }*/
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
        ArrayList<Usuario> listaUsuario = new ArrayList();
        DAOUsuario daoUsuario = new DAOUsuario();
        user = request.getParameter("txtUsuario");
        password = request.getParameter("txtPassword");
        //contexto.log(new Date() + " - Se Logeo el usuario " + user);
        //contexto.log(new Date() + " - Clave:" + password);
        Usuario UsuarioValidado = new Usuario();
        listaUsuario = daoUsuario.listarUsuarios();
        //si el tipo de ususario es hincha o es administrador, creara un objeta administrador o 
        //contexto.log(new Date() + "Se revisara la lista usuarios");
        //contexto.log(new Date() + " - lista con :" + listaUsuario.size());
        for (Usuario u : listaUsuario) {
        //    contexto.log(new Date() + u.getUsuario() + " == " + user);
            if (u.getUsuario().trim().equalsIgnoreCase(user) && u.getPassword().trim().equals(password)){
                //se crea un objeto sesion que guardara el tipo de ususario
                //        contexto.log(new Date() + " - Usuario correcto");
                //        contexto.log(new Date() + " - tipo Usuario:" + u.getTipoUsuario().trim() + " == Administrador");
                UsuarioValidado = u;
                break;
            }
        }        
                
                if(UsuarioValidado.getTipoUsuario().trim().equals("Administrador")){
                    HttpSession session = request.getSession();
                    session.setAttribute("tipoUsuario", UsuarioValidado.getTipoUsuario());
                    session.setAttribute("Usuario", UsuarioValidado);
                    request.getRequestDispatcher("RecuperarSesion").forward(request, response);
                    
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("Usuario", UsuarioValidado);
                    request.getRequestDispatcher("inicioHincha.jsp").forward(request, response);
                    
                }
        //    contexto.log(new Date() + " - Usuario Incorrecto");
            /*else{
                
                String msg = "Usuario no existe o datos mal ingresados";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }*/
        
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
