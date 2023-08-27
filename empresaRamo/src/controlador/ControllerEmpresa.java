/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.DatosOficinas;
import Modelo.DatosPersonas;
import Modelo.DatosVisitantes;
import Modelo.Oficinas;
import Modelo.Personas;
import Modelo.Visitantes;
import Vista.FrmHistorialVisitas;
import Vista.FrmRegistrarIngreso;
import Vista.FrmRegistrarSalida;
import Vista.FrmVisitasActuales;
import Vista.FrmVisitasOficinas;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ControllerEmpresa {

    private String mensaje;
    private DatosOficinas dOficina;
    private DatosPersonas dPersona;
    private DatosVisitantes dVisitantes;
    private Visitantes consutaVisitantes;

    public ControllerEmpresa() {
        dOficina = new DatosOficinas();
        dPersona = new DatosPersonas();
        dVisitantes = new DatosVisitantes();
    }

    public String getMensaje() {
        return mensaje;
    }

    /**
     * Recibe de la vista los datos para listar las oficinas
     *
     * @param frm
     */
    public void obtenerOficinas(FrmRegistrarIngreso frm) {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) frm.cbOficina.getModel();
        ArrayList<Oficinas> lista = dOficina.listarOficinas();
        for (Oficinas oficina : lista) {
            modelo.addElement(oficina);
        }
    }

    /**
     * Recibe de la vista los datos para agregar una Personas y una visita
     *
     * @param frm: Formulario con los datos de la Persona
     * @return true o false
     */
    public boolean RegistrarIngreso(FrmRegistrarIngreso frm) {
        String identificacion = frm.txtIdentificacion.getText();
        String nombre = frm.txtNombre.getText();
        String apellido = frm.txtApellidos.getText();
        String correo = frm.txtCorreo.getText();
        Oficinas o = (Oficinas) frm.cbOficina.getSelectedItem();
        Personas p = new Personas(identificacion, nombre, apellido, correo);
        boolean personaAgregada = dPersona.agregar(p);
        //if (personaAgregada) {
            Visitantes v = new Visitantes(p, o, "1");
            boolean visitanteAgregado = dVisitantes.agregarIngreso(v);
            mensaje = dVisitantes.getMensaje();
            //return visitanteAgregado;
        //}
        return visitanteAgregado;
    }

    /**
     * Recibe de la vista los datos para editas una visita
     *
     * @param frm: Formulario con los datos
     * @return true o false
     */
    public boolean RegistrarSalida(FrmRegistrarSalida frm) {
        boolean editado = false;
        String identificacion = frm.txtIdentificacion.getText();
        int estado = 2;
        editado = dVisitantes.agregarSalida(identificacion, estado);
        mensaje = dVisitantes.getMensaje();
        return editado;
    }

    /**
     * Recibe de la vista los datos para Listar los visitantes actuales
     *
     * @param frm: tabla donde se van a listar
     */
    public void ListarVisitantesActuales(FrmVisitasActuales frm) {
        DefaultTableModel modelo = (DefaultTableModel) frm.tblVisitasActuales.getModel();
        modelo.setNumRows(0);
        ArrayList<Visitantes> lista = dVisitantes.listarActuales();
        String[] datos = new String[6];
        for (Visitantes visitantes : lista) {
            datos[0] = visitantes.getVisPersonas().getPerIdentificacion();
            datos[1] = visitantes.getVisPersonas().getPerNombre();
            datos[2] = visitantes.getVisPersonas().getPerApellido();
            datos[3] = String.valueOf(visitantes.getVisFechaIngreso());
            datos[4] = String.valueOf(visitantes.getEstado());
            datos[5] = visitantes.getVisOficinas().getNombreOfi();
            modelo.addRow(datos);
        }
    }

    /**
     * Recibe de la vista los datos para Listar los visitantes antiguos
     *
     * @param frm: tabla donde se van a listar
     */
    public void ListarVisitantesSalida(FrmHistorialVisitas frm) {
        DefaultTableModel modelo = (DefaultTableModel) frm.tblVisitasSalida.getModel();
        modelo.setNumRows(0);
        ArrayList<Visitantes> lista = dVisitantes.listarSalida();
        String[] datos = new String[6];
        for (Visitantes visitantes : lista) {
            datos[0] = visitantes.getVisPersonas().getPerIdentificacion();
            datos[1] = visitantes.getVisPersonas().getPerNombre();
            datos[2] = visitantes.getVisPersonas().getPerApellido();
            datos[3] = String.valueOf(visitantes.getVisFechaSalida());
            datos[4] = String.valueOf(visitantes.getEstado());
            datos[5] = visitantes.getVisOficinas().getNombreOfi();
            modelo.addRow(datos);
        }
    }

    /**
     * Recibe de la vista los datos para listar todos los visitantes y oficinas
     * donde se dirigen
     *
     * @param frm: tabla donde se van a listar
     */
    public void ListarVisitantesOficina(FrmVisitasOficinas frm) {
        DefaultTableModel modelo = (DefaultTableModel) frm.tblVisitaOficina.getModel();
        modelo.setNumRows(0);
        ArrayList<Visitantes> lista = dVisitantes.listarVisitantesOfi();
        String[] datos = new String[4];
        for (Visitantes visitantes : lista) {
            datos[0] = visitantes.getVisPersonas().getPerIdentificacion();
            datos[1] = visitantes.getVisOficinas().getNombreOfi();
            datos[2] = visitantes.getVisPersonas().getPerNombre();
            datos[3] = visitantes.getVisPersonas().getPerApellido();
            modelo.addRow(datos);
        }
    }
}
