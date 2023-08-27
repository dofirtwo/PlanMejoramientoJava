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
public class DatosPersonas {

    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;

    public DatosPersonas() {
        this.miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }

    /**
     * Agrega una Persona a la base de datos
     *
     * @param p: objetos con todos sus datos
     * @return true or false
     */
    public boolean agregar(Personas p) {
        boolean agregado = false;
        mensaje = "";
        try {
            String consulta = "insert into Personas values(null,?,?,?,?)";
            ps = this.miConexion.prepareStatement(consulta);
            ps.setString(1, p.getPerIdentificacion());
            ps.setString(2, p.getPerNombre());
            ps.setString(3, p.getPerApellido());
            ps.setString(4, p.getPerCorreo());
            ps.executeUpdate();
            agregado = true;
            mensaje = "Persona agregada correctamente";
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return agregado;
    }
}
