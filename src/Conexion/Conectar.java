package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;

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
    /**
     * 
     * @return
     */
    public Connection conectar(){
        Connection c = null;
        try{
            c = DriverManager.getConnection(url, user, password);
            System.out.print("Conectado");
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
        return c;
    }
    /**
     * 
     */
    public void desconectar(Connection c){
        try{
            c.close();
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
    }
}