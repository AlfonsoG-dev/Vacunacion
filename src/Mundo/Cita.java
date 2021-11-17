package Mundo;

public class Cita{
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
    public int getCodigo(){
        return codigo;
    }
    /**
     * fecha de la cita agendada
     * @return fecha de la cita
     */
    public String getFecha(){
        return fecha;
    }
    /**
     * turno de la cita agendada
     * @return turno de la cita
     */
    public int getTurno(){
        return turno;
    }
    /**
     * lugar de la cita agendada
     * @return lugar de la cita
     */
    public String getLugar(){
        return lugar;
    }
    //-----------------------------------//
    //--------------Invariantes------------//
    //-----------------------------------//
    /**
     * verificar la invariante de clase 
     * <b> pre: </b> los atributos se encuentran declarados e inicializados
     * <b> post: </b> se verifica la invariante de la clase
     * El codigo de la cita no puede ser 0. codigo > 0
     * La fecha de la cita no puede ser null. fecha != null
     * El turno de la cita no puede ser 0. turno > 0
     * El lugar de la cita no puede ser null. lugar != null
     */
    public void verificarInvariante(){
        assert codigo > 0 : "El codigo de la clase no puede ser 0";  
        assert turno > 0 : "El turno de la cita no puede ser 0"; 
        assert lugar != null: "El lugar de la cita no puede ser null";  
    }
}