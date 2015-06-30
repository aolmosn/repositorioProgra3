/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.DAO;

import cl.inacap.modelo.Hincha;
import cl.inacap.modelo.Solicitud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre_000
 */
public class DAOSolicitud extends ConBD{
     public ArrayList<Solicitud> listarSolicitud(){
        ArrayList<Solicitud> listaSolicitud = new ArrayList();
        Solicitud s;
        try {
            Connection con = this.getConexion();
            String strSQL = "SELECT * FROM Solicitud s, Objeto o where s.idObjetoSolicitud = idObjeto";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                s = new Solicitud();
                //Codigo para llenar objeto desde la bd
                
                listaSolicitud.add(s);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaSolicitud;
    }
}
