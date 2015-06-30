/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.DAO;

import cl.inacap.modelo.Seleccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre_000
 */
public class DAOSeleccion extends ConBD {
      public boolean registrarSeleccion(Seleccion seleccion){
        //Variable que permite verificar si se inserto correctamente
        //el empleado
        boolean exito=false;
        try {
            //Recuperar la conexcion con la base de datos
            Connection con = this.getConexion();
            //Se prepara la consulta select.
            String strSQL = "insert into seleccion values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(strSQL); //Preparar la consulta 
            ps.setString(1, seleccion.getAcronimo());
            ps.setString(2, seleccion.getPais());
            ps.setString(3, seleccion.getNomFederacion());
            //Se ejecuta la consulta.
            int cantFilas = ps.executeUpdate();//Se usa para insert, delete y update
            if (cantFilas > 0 ){
            exito = true;
            Logger.getLogger(DAOSeleccion.class.getName()).log(Level.SEVERE, "Insercion Correcta");
            }else{
            Logger.getLogger(DAOSeleccion.class.getName()).log(Level.SEVERE, "No se pudo insertar");
            }
            con.close();
            ps.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOSeleccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSeleccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
}
