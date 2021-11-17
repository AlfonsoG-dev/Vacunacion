package Conexion;
import Mundo.Operacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mundo.Cita;
public class CitaDAO {
    //--------------------//
    /**
     * 
     */
    private Operacion miOperacion;
    /**
     * 
     */
    private Cita miCita;
    /**
     * 
     */
    private Conectar miConexion = new Conectar();
    /**
     * 
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
