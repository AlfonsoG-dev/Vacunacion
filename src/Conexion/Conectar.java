package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conectar {
    //-----------------------------//
    //----------Atributos---------//
    //----------------------------//
    /**
     * direccion url de la conexion
     */
    private final static String url="jdbc:postgressql://localhost:5432/GestorP";
    /**
     * usuario de la base de datos
     */
    private final static String user = "postgres";
    /**
     * contrasenia de la base de datos
     */
    private final static String  password = "5x5W12";
    //---------------------------//
    //---------Metodos----------//
    //--------------------------//
    public Connection conectar(){
        Connection c = null;
        try{
            c = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conectado");
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
        return c;
    }
}