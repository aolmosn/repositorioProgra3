/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.DAO;


import cl.inacap.modelo.Objeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre_000
 */
public class DAOObjeto extends ConBD{
    public boolean registrarObjeto(Objeto Obj){
        //Variable que permite verificar si se inserto correctamente
        //el empleado
        boolean exito=false;
        try {
            //Recuperar la conexcion con la base de datos
            Connection con = this.getConexion();
            //Se prepara la consulta select.
            String strSQL = "insert into objeto values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(strSQL); //Preparar la consulta 
            ps.setInt(1, Obj.getIdObjeto());
            ps.setString(2, Obj.getNombreObjeto());
            ps.setString(3, Obj.getEstadoObjeto());
            ps.setString(4, Obj.getAutorizacion());
            //Se ejecuta la consulta.
            int cantFilas = ps.executeUpdate();//Se usa para insert, delete y update
            if (cantFilas > 0 ){
            exito = true;
            Logger.getLogger(DAOObjeto.class.getName()).log(Level.SEVERE, "Insercion Correcta");
            }else{
            Logger.getLogger(DAOObjeto.class.getName()).log(Level.SEVERE, "No se pudo insertar");
            }
            con.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOObjeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
    
    public int IDNuevoObjeto(){
        int entrada = 0;
        try {
            Connection con = this.getConexion();
            String strSQL = "SELECT count(*) FROM Objeto";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                entrada = rs.getInt(0);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entrada;
    }
}
