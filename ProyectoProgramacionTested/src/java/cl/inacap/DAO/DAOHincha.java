/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.DAO;

import cl.inacap.modelo.Hincha;
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
public class DAOHincha extends ConBD{
    
    public ArrayList<Hincha> listarUsuarios(){
        ArrayList<Hincha> listaHincha = new ArrayList();
        Hincha h;
        try {
            Connection con = this.getConexion();
            String strSQL = "SELECT * FROM USUARIO";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                h = new Hincha();
                h.setUsuario(rs.getString("ident_usuario"));
                h.setPassword(rs.getString("pass_usuario"));
                h.setRut(rs.getInt("rut_usuario"));
                h.setNombre(rs.getString("nom_usuario"));
                h.setApellido(rs.getString("ape_usuario"));
                h.setMail(rs.getString("mail_ususario"));
                h.setTipoUsuario(rs.getString("tipo_usuario"));
                h.setAcronimo(rs.getString("acron_seleccion"));
                listaHincha.add(h);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaHincha;
    }
    
    public ArrayList<Hincha> listarHinchas(){
        ArrayList<Hincha> listaHincha = new ArrayList();
        Hincha h;
        try {
            Connection con = this.getConexion();
            String strSQL = "SELECT * FROM USUARIO WHERE TIPO_USUARIO LIKE 'HINCHA%'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                h = new Hincha();
                h.setUsuario(rs.getString("ident_usuario"));
                h.setPassword(rs.getString("pass_usuario"));
                h.setRut(rs.getInt("rut_usuario"));
                h.setNombre(rs.getString("nom_usuario"));
                h.setApellido(rs.getString("ape_usuario"));
                h.setMail(rs.getString("mail_ususario"));
                h.setTipoUsuario(rs.getString("tipo_usuario"));
                h.setAcronimo(rs.getString("acron_seleccion"));
                listaHincha.add(h);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaHincha;
    }
    
    public boolean registrarHincha(Hincha h){
        //Variable que permite verificar si se inserto correctamente
        //el empleado
        boolean exito=false;
        try {
            //Recuperar la conexcion con la base de datos
            Connection con = this.getConexion();
            //Se prepara la consulta select.
            String strSQL = "insert into usuario values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(strSQL); //Preparar la consulta
            ps.setString(1,h.getUsuario());
            ps.setInt(2, h.getRut());
            ps.setString(4, h.getPassword());
            ps.setString(5, h.getNombre());
            ps.setString(6, h.getApellido());
            ps.setString(7, h.getMail());
            ps.setString(8, h.getTipoUsuario());
            ps.setString(9, h.getAcronimo());
            //Se ejecuta la consulta.
            int cantFilas = ps.executeUpdate();//Se usa para insert, delete y update
            if (cantFilas > 0 ){
            exito = true;
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, "Insercion Correcta");
            }else{
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, "No se pudo insertar");
            }
            con.close();
            ps.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHincha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
    
}
