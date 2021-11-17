package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mundo.Cita;
public class CitaDAO {
    //--------------------//
    /**
     * conexion con la base de datos
     */
    private Conectar miConexion = new Conectar();
    /**
     * buscar la cita en la base de datos dado el codigo de la cita 
     * <b> pre: </b> la tabla de cita se encuentra inicializada
     * <b> post: </b> se busca la cita dado el codigo de la cita
     * @param codigo, es el codigo de la cita a buscar. codigo != "" && codigo != null
     * @return la cita buscada
     */
    public Cita buscarCita(String codigo){
        Connection mia = miConexion.conectar();
        Cita nueva = null;
        try{
            PreparedStatement pst = null;
            String sql = "select * from vacuna where codigo = ?";
            pst = mia.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                nueva = new Cita(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4)); 
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
        finally{
            miConexion.desconectar(mia);
        }
        return nueva;
    }
    /**
     * registrar una cita en la base de datos
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se registra la cita en la base de datos
     * @param nCita, es la cita a insertar. nCita != "" && nCita != null
     * @return la cita registrada
     */
    public Cita insertarCita(Cita nCita){
        Cita registrar = null;
        Connection mia = miConexion.conectar();
        try{
            String sql = "insert into vacuna (codigo, fecha, turno, lugar) values (?, ?, ?, ?)";
            PreparedStatement pst = mia.prepareStatement(sql);
            pst.setString(1, String.valueOf(nCita.getCodigo()));
            pst.setString(2, nCita.getFecha());
            pst.setString(3, String.valueOf(nCita.getTurno()));
            pst.setString(4, nCita.getLugar());
            pst.execute();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            miConexion.desconectar(mia);
        }
        return registrar;
    }
    /**
     * eliminar la cita de la base de datos buscada por codigo
     * <b> pre: </b> la base de datos se encuentra inicializada
     * <b> post: </b> se elimina la cita de la base de datos
     * @param nCita, es la cita a eliminar. nCita != "" && nCita != null
     * @return true si se elimino la cita, de lo contrario false
     */
    public Boolean eliminarCita(Cita nCita){
        Boolean eliminar = false;
        Connection mia = miConexion.conectar();
        try{
            String sql = "delete from vacuna where codigo = ?";
            if(buscarCita(String.valueOf(nCita.getCodigo()))==null){
                System.out.print("La cita no existe");
                
            }else{
                PreparedStatement pst = mia.prepareStatement(sql);
                pst.setString(1, String.valueOf(nCita.getCodigo()));
                pst.execute();
                eliminar = true;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            miConexion.desconectar(mia);
        }
        return eliminar;
    }
}