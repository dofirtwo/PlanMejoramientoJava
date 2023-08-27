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
public class DatosOficinas {

    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;

    public DatosOficinas() {
        this.miConexion = Conexion.getConexion();
    }

    public String getMensaje() {
        return mensaje;
    }

    /**
     * Lista las oficinas agregadas en la base de datos
     * @return la lista
     */
    public ArrayList<Oficinas> listarOficinas() {
        ArrayList<Oficinas> lista = new ArrayList<>();
        mensaje = "";
        try {
            String consulta = "select * from oficinas";
            ps = this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Oficinas o = new Oficinas();
                o.setIdentificacionOficina(rs.getInt("idOficina"));
                o.setNombreOfi(rs.getString("ofiNombre"));
                lista.add(o);
            }
            rs.close();
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return lista;
    }
}
