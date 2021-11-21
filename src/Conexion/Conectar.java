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
    private final static String url="jdbc:postgresql://localhost:5432/GestorP";
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
     * metodo para realizar la conexion con la base de datos
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se crea la conexion con la base de datos
     * @return la conexion con la base de datos
     */
    public Connection conectar(){
        Connection c = null;
        try{
            c = DriverManager.getConnection(url, user, password);
            //System.out.print("Conectado");
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
        return c;
    }
    /**
     * se cierra la conexion con la base de datos
     * <b> pre: </b> la conexion con la base de datos se encuentra inicializada
     * <b> post: </b>  se cerro la conexion con la base de datos
     * @param c, es la conexon con la base de datos. c !="" && c != null 
     */
    public void desconectar(Connection c){
        try{
            c.close();
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
    }
}