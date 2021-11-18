import Mundo.Operacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import Mundo.Cita;
import Mundo.Usuario;
public class OperacionTest {
    /**
     * calse en la que se realizan las pruebas
     */
    private Operacion miOperacion;
    /**
     * clase necesaria para las pruebas
     */
    private Usuario miUsuario;
    /**
     * clase necesaria para las pruebas
     */
    private Cita miCita;
    /**
     * Escenario 1: Crear un usuario con cita
     */
    public void scenario1(){
        miCita = new Cita(20, "octubre/12/2018", 12, "Pasto");
        miUsuario = new Usuario(456, "identificacion", "lucas", "jojoa", 320, "@hotmail", "calle-12", String.valueOf(miCita.getCodigo()));
    }
    /**
     * Prueba 1: se prueba los metodos de la clase prueba
     * <b> metodos a prueba: </b> buscarCita, buscarCuenta, buscarUsuario, eliminarCuenta, cancelarCita, registrarCuenta, registrarCita
     * <b> casos de uso: </b> se crea un nuevo usuario con cita y se realiza las prueba de metodos
     */
    @Test
    public void testOperacion(){
        scenario1();
        assertNotNull("No deberia ser null", miOperacion.buscarCita(miCita));
        assertNotNull("No deberia ser null", miOperacion.buscarUsuario(miUsuario));
        assertEquals("Deberia eliminar la cita", true, miOperacion.cancelarCita(miCita));

        //registrar una nueva cuenta 
        //registrar una nueva cita
        Cita c = new Cita(23, "noviembre/28/2021", 123, "cali");
        Usuario u = new Usuario(895, "cedula", "jack", "pantoja", 318, "@google", "sector centro", String.valueOf(c.getCodigo()));
        assertNotNull("Deberia registar la cita", miOperacion.registrarCita(c, u));
    }
    /**
     * prueba 2: se prueba los metodos de la clase prueba
     * <b> metodos a prueba: </b> miCita, miUsuario, miCuenta, darUsuarioConCita
     * <b> casos de usaro: </b> se crea un usuario con cita y se realiza la prueba
     */
    @Test
    public void testOperacion2(){
        Cita c = new Cita(140, "octubre/1/2021", 50, "bogota");
        Usuario u= new Usuario(105, "cedula", "jakob", "mirama", 318, "@gmail", "villaflores", String.valueOf(c.getCodigo()));
        Usuario buscado = miOperacion.buscarUsuario(u);
        Cita buscada = miOperacion.buscarCita(c);
        if(miOperacion.registrarCita(c, u)!=null){
            assertNotNull("Deberia estar el usuario registrado", miOperacion.miUsuario());
            assertEquals("Deberia ser el mismo usuario", u.getDocumento(), buscado.getDocumento());
            assertEquals("Deberia ser la misma cita", c.getCodigo(), buscada.getCodigo());

        }else{
            fail("No deberia suceder este error");
        }
    }
}