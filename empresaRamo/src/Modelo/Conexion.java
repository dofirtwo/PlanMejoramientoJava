/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Conexion {

    private static Connection con;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/empresaRamo";
    private static String mensaje;

    public static Connection getConexion() {
        if (con != null) {
            return con;
        }
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password);
            mensaje = "Conexion exitosa";
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            mensaje = e.getMessage();
            return null;
        }
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void cerrar() {
        try {
            con.close();
            mensaje = "Conexion cerrada";
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
    }
}
