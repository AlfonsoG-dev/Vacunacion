import Mundo.Usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Mundo.Cita;
public class UsuarioTest {
    /**
     * clase a la que se le realizara el test
     */
    private Usuario miUsuario;
    /**
     * clase necesaria para realizar el test
     */
    private Cita miCita;
    /**
     * Escenario 1: crear nueva cita y usuario con valores
     */
    public void scenario1(){
        miCita = new Cita(12, "febrero/23/2020", 13, "cali");
        miUsuario = new Usuario(123, "cedula", "juan", "lopez", 316, "@gmail", "calle-20", "12");
    }
    /**
     * Prueba 1: Se encarga de verificar el constructor de la clase usuario
     * <b> metodos a probar: </b> Usuario, getDocumento, getTipoDocumento, getNombre, getApellido, getCelular, getCorreo, getDireccion, getCita
     * <b> cases de prueba: </b> crear un usuario con cita
     */
    @Test
    public void testUsuario(){
        scenario1();
        assertEquals("No inicializa correctamente el numero de documento correctamente", 12, miUsuario.getDocumento());
        assertEquals("No iniciliza correctamente el tipo de documento", "cedula", miUsuario.getTipo());
        assertEquals("No inicializa correctamente el nombre del usuario", "juan", miUsuario.getNombre());
        assertEquals("No inicializa correctamente el apellido del usuario", "lopez", miUsuario.getApellido());
        assertEquals("No inicializa correctamente el numero de celular del usuario", 316, miUsuario.getCelular());
        assertEquals("No inicializa correctamente el correo del usuario", "@gmail", miUsuario.getCorreo());
        assertEquals("No inicializa correctamente la direccion del usuario", "calle-20", miUsuario.getDireccion());
        assertNotNull("La cita no deberia ser null", miCita);
    }
}
