package Mundo;

public class Cita {
    //-------------------------------------//
    //----------------Atributos------------//
    //-------------------------------------//
    /**
     * codigo de la cita del usuario
     */
    private int codigo;
    /**
     * fecha de la cita agendada
     */
    private String fecha;
    /**
     * turno de la cita agendada
     */
    private int turno;
    /**
     * localidad o lugar en donde tiene que asistir para la cita
     */
    private String lugar;
    //-------------------------------------//
    //----------------Constructor------------//
    //-------------------------------------//
    /**
     * cita agendada por el usuario 
     * <b> pre: </b> los atributos de la cita se encuentran declarados
     * <b> post: </b> se crea la cita con los atributos
     * @param nCodigo, es el codigo de la cita agendada. nCodigo > 0 && nCodigo != null
     * @param nFecha, es la fecha de la cita agendada. nFecha != "" && nFecha != null
     * @param nTurno, es el turno de la cita agendada. nTurno > 0 && nTurno != null
     * @param nLugar, es el lugar de la cita agendada. nLugar != "" && nLugar != null
     */
    public Cita(int nCodigo, String nFecha, int nTurno, String nLugar){

        codigo = nCodigo;
        fecha = nFecha;
        turno = nTurno;
        lugar = nLugar;
    }
    //-------------------------------------//
    //----------------Metodos------------//
    //-------------------------------------//
    /**
     * codigo de la cita agendada
     * @return el codigo de la cita
     */
    public int darCodigo(){
        return codigo;
    }
    /**
     * fecha de la cita agendada
     * @return fecha de la cita
     */
    public String darFecha(){
        return fecha;
    }
    /**
     * turno de la cita agendada
     * @return turno de la cita
     */
    public int darTurno(){
        return turno;
    }
    /**
     * lugar de la cita agendada
     * @return lugar de la cita
     */
    public String darLugar(){
        return lugar;
    }
}