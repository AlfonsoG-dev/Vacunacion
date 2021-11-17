import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Mundo.Cita;
public class CitaTest{
    /**
     * importar la clase en la que se realizan las pruebas
     */
    private Cita miCita;
    /**
     * Escenario 1: crear una nueva cita con valores
     */
    public void scenario1(){
       miCita = new Cita(1, "enero/20/2021", 12, "Pasto");
    }
    /**
     * Prueba 1: verificar el metodo constructor de la clase cita
     * <b> Metodos a probar: </b> Cita, getCodigo, getFecha, getTurno, getLugar
     * <b> casos de prueba: </b> crear una cita sin valores
     */
    @Test
    public void testCita(){
        scenario1();
        assertEquals("No inicializo el codigo de la cita correctamente", 1, miCita.getCodigo());
        assertEquals("No inicializo la fecha de la cita correctamente", "enero/20/2021", miCita.getFecha());
        assertEquals("No inicializo el turno de la cita correctamente", 12, miCita.getTurno());
        assertEquals("No inicializo el lugar de la cita correctamente", "Pasto", miCita.getLugar());
    }
}