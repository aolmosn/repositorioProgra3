/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.modelo;

/**
 *
 * @author Cubil
 */
public class Objeto {
    private int idObjeto;
    private String nombreObjeto;
    private String estadoObjeto;
    private String autorizacion;
    private String nomMiembro;

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombre) {
        this.nombreObjeto = nombre;
    }

    public String getEstadoObjeto() {
        return estadoObjeto;
    }

    public void setEstadoObjeto(String estado) {
        this.estadoObjeto = estado;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getNomMiembro() {
        return nomMiembro;
    }

    public void setNomMiembro(String nomMiembro) {
        this.nomMiembro = nomMiembro;
    }
    
}
