package Conexion;
import Mundo.Cita;
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
     * cita del usuario
     */
    private CitaDAO miCitaDAO = new CitaDAO();
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
                u  = new Usuario(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getString(7), miCitaDAO.buscarCita(rs.getString(8)));
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
     * buscar usuario dado el codigo de la cita
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se busca el usuario dado el codigo de cita
     * @param nCodigo, es el codigo de la cita a buscar. nCodigo != "" && nCodigo != null
     * @return true si el usuario tiene cita, false de lo contrario
     */
    public Boolean usuarioPorCodigo(Cita nCodigo){
        Boolean encontrado = false;
        Connection mia = miConexion.conectar();
        Usuario nuevo = null;
        PreparedStatement pst = null;
        try{    
            String sql = "select * from usuario where codigo =?";
            pst = mia.prepareStatement(sql);
            pst.setString(8, String.valueOf(nCodigo.getCodigo()));
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                nuevo  = new Usuario(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), rs.getString(6), rs.getString(7), miCitaDAO.buscarCita(rs.getString(8)));
                encontrado = true;
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }finally{
            miConexion.desconectar(mia);
        }
        return encontrado;
    }
    /**
     * buscar el codigo de la cita dado el usuario
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se busca el codigo de la cita
     * @param documento, es el numero de documento del usuario. documento != null && documento != ""
     * @return el codigo de la cita
     */
    public int codigoCitaUsuario(String documetno){
        int codigo = 0;
        if(buscarUsuario(documetno)!=null){
            codigo = buscarUsuario(documetno).getCita().getCodigo();
        }else{
            System.out.print("Error al consultar la cita");
        }
        return codigo;
    }
}