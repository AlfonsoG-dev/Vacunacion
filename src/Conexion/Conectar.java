package Conexion;
import java.sql.Connection;

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
    /**
     * driver para la conexion
     */
    private final static String driver = "";
    //---------------------------//
    //---------Metodos----------//
    //--------------------------//
    public Connection conectar(){
        Connection c = null;
        try{
            Class.forName(driver);

        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
        return c;
    }
}