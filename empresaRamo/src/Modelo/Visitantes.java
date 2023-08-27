/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class Visitantes {

    private int identificacionVisitantes;
    private Personas visPersonas;
    private Oficinas visOficinas;
    private Date visFechaIngreso;
    private Date visFechaSalida;
    private String Estado;
    private int total;

    /**
     * Constructor con parametros de inicializacion
     *
     * @param visPersonas
     * @param visOficinas
     * @param estado
     */
    public Visitantes(Personas visPersonas, Oficinas visOficinas, String estado) {
        this.visPersonas = visPersonas;
        this.visOficinas = visOficinas;
        this.Estado = estado;
    }

    public Visitantes() {
        visPersonas = new Personas();
        visOficinas = new Oficinas();
    }

    public int getIdentificacionVisitantes() {
        return identificacionVisitantes;
    }

    public void setIdentificacionVisitantes(int identificacionVisitantes) {
        this.identificacionVisitantes = identificacionVisitantes;
    }

    public Personas getVisPersonas() {
        return visPersonas;
    }

    public void setVisPersonas(Personas visPersonas) {
        this.visPersonas = visPersonas;
    }

    public Oficinas getVisOficinas() {
        return visOficinas;
    }

    public void setVisOficinas(Oficinas visOficinas) {
        this.visOficinas = visOficinas;
    }

    public Date getVisFechaIngreso() {
        return visFechaIngreso;
    }

    public void setVisFechaIngreso(Date visFechaIngreso) {
        this.visFechaIngreso = visFechaIngreso;
    }

    public Date getVisFechaSalida() {
        return visFechaSalida;
    }

    public void setVisFechaSalida(Date visFechaSalida) {
        this.visFechaSalida = visFechaSalida;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
