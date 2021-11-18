package Conexion;
import Mundo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UsuarioDAO {
    /**
     * Conexion con la base de datos
     */
    private Conectar miConexion = new Conectar();
    /**
     * seleccionar los usuarios de la base de datos
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se seleccionan todos los usuarios
     * @return el usuario de la base de datos
     */
    public Usuario seleccionarUsuario(){
        Usuario seleccion = null;
        Connection mia = miConexion.conectar();
        PreparedStatement pst = null;
        try{
            String sql = "select * from usuario";
            pst = mia.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                seleccion = new Usuario(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }finally{
            miConexion.desconectar(mia);
        }
        return seleccion;
    }
    /**
     * buscar el usuario por numero de documento
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se busca al usuario en la base de datos
     * @param nDocumento, numero de documento del usuario. nDocumento != "" && nDocumento != null
     * @return el codigo de la cita
     */    
    public Usuario buscarUsuario(String nDocumento){
        Usuario u = null;
        Connection mia = miConexion.conectar();
        PreparedStatement pst = null;
        try{
            String sql = "select * from usuario where documento =?";
            pst = mia.prepareStatement(sql);
            pst.setString(1, nDocumento);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                u  = new Usuario(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getString(7), rs.getString(8));
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
        finally{
            miConexion.desconectar(mia);
        }
        return u;
    }
    /**
     * buscar el codigo de la cita dado el usuario
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se busca el codigo de la cita
     * @param documento, es el numero de documento del usuario. documento != null && documento != ""
     * @return el codigo de la cita
     */
    public String codigoCitaUsuario(String documento){
        String codigo = null;
        Usuario buscar = null;
        try{
            buscar = buscarUsuario(documento);
            if(buscar != null){
                codigo = buscar.getCita();
            }else{
                System.out.print("El usuario no existe");
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
        return codigo;
    }
    /**
     * Modifica la informacion del usuario cuando no tiene una cita
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se modifica el usuario dado el documento 
     * @param documento, es el numero de documento del usuario. documento != "" && documento != null
     * @param codigoCita, es el codigo de la cita a modificar. codigoCita != "" && codigoCita != null
     * @return el usuario actualizado
     */
    public Usuario actualizarUsuario(String documento, String codigoCita){
        Usuario mio=null;
        Connection mia = miConexion.conectar();
        PreparedStatement pst = null;
        try{
            String sql = "update usuario set cita =? where documento =?";
            pst = mia.prepareStatement(sql);
            pst.setString(1, documento);
            pst.setString(2, codigoCita);
            int num = pst.executeUpdate();
            if(num>0){
                mio=buscarUsuario(documento);
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }finally{
            miConexion.desconectar(mia);
        }
        return mio;
    }
}