/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class DatosVisitantes {

    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;

    public DatosVisitantes() {
        this.miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }

    /**
     * Agrega una visita a la base de datos con el estado de ingreso y le asigna
     * una fecha
     *
     * @param v: objeto con sus datos
     * @return true or false
     */
    public boolean agregarIngreso(Visitantes v) {
        boolean agregado = false;
        mensaje = "";
        try {
            String consulta = "insert into Visitantes values(null,?,?,NOW(),null,?)";
            ps = this.miConexion.prepareStatement(consulta);
            ps.setString(1, v.getVisPersonas().getPerIdentificacion());
            ps.setInt(2, v.getVisOficinas().getIdentificacionOficina());
            ps.setString(3, v.getEstado());
            ps.execute();
            agregado = true;
            mensaje = "Se ha registrado el ingreso de la persona";
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return agregado;
    }

    /**
     * vuelve la visita al estado Salida y le asigna una fecha
     *
     * @param PerId: Identificacion de la persona
     * @param estado: valor del estado
     * @return true or false
     */
    public boolean agregarSalida(String PerId, int estado) {
        boolean editado = false;
        mensaje = "";
        try {
            String consulta = "UPDATE Visitantes SET visFechaHoraSalida=NOW(),estado=? WHERE visPersona=?";
            ps = this.miConexion.prepareStatement(consulta);
            ps.setInt(1, estado);
            ps.setString(2, PerId);
            ps.executeUpdate();
            mensaje = "Se ha registrado la salida de la persona";
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return editado;
    }

    /**
     * Lista los visitantes con el estado Ingreso
     *
     * @return lista
     */
    public ArrayList<Visitantes> listarActuales() {
        ArrayList<Visitantes> lista = new ArrayList<>();
        mensaje = "";
        try {
            String consulta = "select Visitantes.*, Personas.perNombre, Personas.perApellido, Oficinas.ofiNombre"
                    + " from Personas inner join Visitantes on Visitantes.visPersona=Personas.perIdentificacion"
                    + " inner join Oficinas on Visitantes.visOficina = Oficinas.idOficina where estado=1";
            ps = this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Visitantes v = new Visitantes();
                v.setIdentificacionVisitantes(rs.getInt("idVisitantes"));
                v.getVisPersonas().setPerIdentificacion(rs.getString("visPersona"));
                v.getVisPersonas().setPerNombre(rs.getString("perNombre"));
                v.getVisPersonas().setPerApellido(rs.getString("perApellido"));
                v.getVisOficinas().setIdentificacionOficina(rs.getInt("visOficina"));
                v.getVisOficinas().setNombreOfi(rs.getString("ofiNombre"));
                v.setVisFechaIngreso(rs.getDate("visFechaHoraIngreso"));
                v.setEstado(rs.getString("estado"));
                lista.add(v);
            }
            rs.close();
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    /**
     * Lista los visitantes con el estado de Salida
     *
     * @return lista
     */
    public ArrayList<Visitantes> listarSalida() {
        ArrayList<Visitantes> lista = new ArrayList<>();
        mensaje = "";
        try {
            String consulta = "select Visitantes.*, Personas.perNombre, Personas.perApellido, Oficinas.ofiNombre"
                    + " from Personas inner join Visitantes on Visitantes.visPersona=Personas.perIdentificacion"
                    + " inner join Oficinas on Visitantes.visOficina = Oficinas.idOficina where estado=2";
            ps = this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Visitantes v = new Visitantes();
                v.setIdentificacionVisitantes(rs.getInt("idVisitantes"));
                v.getVisPersonas().setPerIdentificacion(rs.getString("visPersona"));
                v.getVisPersonas().setPerNombre(rs.getString("perNombre"));
                v.getVisPersonas().setPerApellido(rs.getString("perApellido"));
                v.getVisOficinas().setIdentificacionOficina(rs.getInt("visOficina"));
                v.getVisOficinas().setNombreOfi(rs.getString("ofiNombre"));
                v.setVisFechaSalida(rs.getDate("visFechaHoraSalida"));
                v.setEstado(rs.getString("estado"));
                lista.add(v);
            }
            rs.close();
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    /**
     * lista todos los visitantes con las oficinas donde fueron
     *
     * @return lista
     */
    public ArrayList<Visitantes> listarVisitantesOfi() {
        ArrayList<Visitantes> lista = new ArrayList<>();
        mensaje = "";
        try {
            String consulta = ("select Visitantes.*, Personas.perNombre, Personas.perApellido, Oficinas.ofiNombre"
                    + " from Personas inner join Visitantes on Visitantes.visPersona=Personas.perIdentificacion"
                    + " inner join Oficinas on Visitantes.visOficina = Oficinas.idOficina");
            ps = this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                Visitantes v = new Visitantes();
                v.setIdentificacionVisitantes(rs.getInt("idVisitantes"));
                v.getVisPersonas().setPerIdentificacion(rs.getString("visPersona"));
                v.getVisPersonas().setPerNombre(rs.getString("perNombre"));
                v.getVisPersonas().setPerApellido(rs.getString("perApellido"));
                v.getVisOficinas().setIdentificacionOficina(rs.getInt("visOficina"));
                v.getVisOficinas().setNombreOfi(rs.getString("ofiNombre"));
                lista.add(v);
            }
            rs.close();
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }
}
