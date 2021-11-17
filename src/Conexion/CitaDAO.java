package Conexion;
import Mundo.Operacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mundo.Cita;
public class CitaDAO {
    //--------------------//
    /**
     * clase que realiza las operaciones 
     */
    private Operacion miOperacion;
    /**
     * clase cita 
     */
    private Cita miCita;
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
        try{
            PreparedStatement pst = null;
            String sql = "select * from vacuna where codigo = ?";
            pst = mia.prepareStatement(sql);
            pst.setString(1, codigo);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                miCita = new Cita(Integer.parseInt(rs.getString(1)), rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4)); 
            }
        }catch(Exception e){
            System.out.print("Error: " + e.getMessage());
        }
        finally{
            miConexion.desconectar(mia);
        }
        return miCita;
    }
    
}
