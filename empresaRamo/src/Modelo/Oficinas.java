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
public class Oficinas {

    private int identificacionOficina;
    private String nombreOfi;

    /**
     * Constructor con parametros de inicializacion
     *
     * @param nombreOfi
     */
    public Oficinas(String nombreOfi) {
        this.nombreOfi = nombreOfi;
    }

    public Oficinas() {
    }

    public int getIdentificacionOficina() {
        return identificacionOficina;
    }

    public void setIdentificacionOficina(int identificacionOficina) {
        this.identificacionOficina = identificacionOficina;
    }

    public String getNombreOfi() {
        return nombreOfi;
    }

    public void setNombreOfi(String nombreOfi) {
        this.nombreOfi = nombreOfi;
    }

    @Override
    public String toString() {
        return nombreOfi;
    }

}
