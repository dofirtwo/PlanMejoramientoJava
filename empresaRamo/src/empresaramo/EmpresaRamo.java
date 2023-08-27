/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaramo;

import Modelo.Conexion;
import Vista.FrmInicioSesion;

/**
 *
 * @author USUARIO
 */
public class EmpresaRamo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.getConexion();
        System.out.println(Conexion.getMensaje());
        FrmInicioSesion frm = new FrmInicioSesion();
        frm.setVisible(true);
    }

}
