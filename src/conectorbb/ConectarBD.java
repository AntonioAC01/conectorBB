package conectorbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Fecha: 24/07/2017 Autor: Antonio Aburto Cortez
 */
public class ConectarBD {

    Connection miConexion;
    PreparedStatement consulta;
    ResultSet datos;

    public Connection getConnection(String BD, String usuario, String Contraseña) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.1.35/" + BD;
            miConexion = DriverManager.getConnection(servidor, usuario, Contraseña);
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro driver");
            miConexion = null;
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar la base de datos ");
            miConexion = null;
        }
        return miConexion;
    }

    public void consulta() {
        try {
            miConexion = (Connection) this.getConnection("usuario", "root", "antonioaburto1234");
            consulta = miConexion.prepareStatement("SELECT nombre, edad FROM usuario.alumno");
            datos = consulta.executeQuery();
            while (datos.next()) {
                System.out.println("Nombre =" + datos.getString("nombre") + "\n" + "Edad=" + datos.getInt("edad"));
            }
        } catch (SQLException e) {
            System.out.println("No se puedo conectar o ahcer consulta");

        }
    }
    public void desconectar(){
        try {
            miConexion.close();
            consulta.close();
            datos=null;
                    
        } catch (Exception e) {
        }
    }
}
