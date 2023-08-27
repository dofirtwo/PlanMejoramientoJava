/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Personas {

    private int identificacionPersona;
    private String perIdentificacion;
    private String perNombre;
    private String perApellido;
    private String perCorreo;

    /**
     * Constructor con parametros de inicializacion
     *
     * @param perIdentificacion
     * @param perNombre
     * @param perApellido
     * @param perCorreo
     */
    public Personas(String perIdentificacion, String perNombre, String perApellido, String perCorreo) {
        this.perIdentificacion = perIdentificacion;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perCorreo = perCorreo;
    }

    public Personas() {
    }

    public Personas(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public int getIdentificacionPersona() {
        return identificacionPersona;
    }

    public void setIdentificacionPersona(int identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
    }

    public String getPerIdentificacion() {
        return perIdentificacion;
    }

    public void setPerIdentificacion(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }

}
