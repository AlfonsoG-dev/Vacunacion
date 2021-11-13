package Mundo;

import java.util.ArrayList;

public class Operacion {
    //-------------------------------------//
    //----------------Atributos------------//
    //-------------------------------------//
    /**
     * usuarios a vacunar
     */
    private ArrayList<Usuario> usuarios;
    /**
     * citas agendadas para el usuario
     */
    private ArrayList<Cita> citas;
    /**
     * lista con usuarios que tienen citas agendadas
     */
    private ArrayList<Usuario> usuariosCita;
    /**
     * numero maximo de citas o usuarios
     */
    public final static int MAX_C = 20;
    //-------------------------------------//
    //----------------Constructor------------//
    //-------------------------------------//
    /**
     * Se asignan citas y usuarios estableciendo un limite
     * <b> pre: </b> los atributos se encuentran inicializados
     * <b> post: </b> se inicializan las listas de usuario y cita
     * las listas se inicializan como null
     */
    public Operacion(){
        usuarios = new ArrayList<Usuario>();
        citas = new ArrayList<Cita>();
        usuariosCita = new ArrayList<Usuario>();
        verificarInvariante();
    }
    //-------------------------------------//
    //----------------Metodos------------//
    //-------------------------------------//    
    /**
     * lista de usuarios en la eps
     * @return usuarios en la eps
     */
    public ArrayList<Usuario> miUsuario(){
        return usuarios;
    }
    /**
     * lista de citas para el usuario
     * @return citas para el usuario
     */
    public ArrayList<Cita> miCita(){
        return citas;
    }
    /**
     * lista con las citas agendadas al usuario
     * @return citas agendadas por el usuario
     */
    public ArrayList<Usuario> darUsuariosConCita(){
        return usuariosCita;
    }
    /**
     * verificar si el usuario esta en el sistema
     * <b> pre: </b> la lsita de usuarios se encuentra inicializada
     * <b> post: </b> se verifica el usuario
     * @param nUsuario, es el usuario a verificar. nUsuario != "" && nUsuario != null
     * @return true si el usuario esta en el sistema, false de lo contrario
     */
    public Boolean verificarUsuario(Usuario nUsuario){
        Boolean encontrado = false;
        return encontrado;
    }
    /**
     * verificar si el usuario tiene citas o nop
     * <b> pre: </b> la lista de citas y usuarios se encuentra incializada
     * <b> post: </b> se verifica si el usuario tiene una cita agendada o nop
     * @param nCita, es la cita del usuario, nCita != null && nCita != ""
     * @param nUsuario, es el usuario con la cita a verificar, nUsuario != null && nUsuario != ""
     * @return true si el usuario tiene una cita agendada, de lo contrario false
     * el usuario solo tiene el codigo de la cita en donde 0 es que no tiene asignada cita.
     * si el usuario tiene agendada una cita se lo añade a la lista de citas agendadas
     */
    public Boolean verificarCita(Cita nCita, Usuario nUsuario){
        Boolean encontrado = false;
        return encontrado;
    }
    /**
     * cancelar la cita agendada por el usuario
     * <b> pre: </b> la lista de citas y de usuarios se encuentra inicializada
     * <b> post: </b> se elimina la cita de la lista de citas
     * @param nCita, es la cita a eliminar, nCita != "" && nCita != ""
     * @return true si la cita se elimino de lo contrario false
     */
    public Boolean cancelarCita(Cita nCita){
        Boolean encontrado = false;
        return encontrado;
    }
    /**
     * re agendar la cita que se cancelo para otra fecha
     * <b> pre: </b> la lista de citas se encuentra inicializada
     * <b> post: </b> se agenda la cita para el usuario
     * @param nCita, cita del usuario a agendar
     * @param nUsuario, usuario que agenda la cita
     * @return la cita con el usuario que agendo la cita
     */
    public String agendarCita(Cita nCita, Usuario nUsuario){
        String mensaje = null;
        return mensaje;
    }
    /**
     * se agregan los elementos a la lista para su verificacion
     * <b> pre: </b> las lista de usuario, cita se encuentran inicializadas
     * <b> post: </b> se añaden los elementos a la lista
     * @param nCita, es la cita del usuario. nCita != "" && nCita != null
     * @param nUsuario, es el usurio que agendo la cita. nUsuario != "" && nUsuario != null
     */
    public void agregarDatosLista(Cita nCita, Usuario nUsuario){
        miUsuario().add(nUsuario);
        miCita().add(nCita);
        darUsuariosConCita().add(nUsuario);
    }
    //-*---------------------------*-//
    //-*------Invariante-----------*-//
    //-*---------------------------*-//
    private void verificarInvariante(){
        assert !usuariosRepetidos() : "No tienen que existir 2 usuarios con numero de identificacion igutal";
        assert !turnoRepetido() : "No tienen que existir 2 usuarios con el mismo turno de cita";
    }
    /**
     * validar que no existan usuarios repetidos
     * <b> pre: </b> la lista de usuarios se encuentra inicializada
     * <b> post: </b> se valida que no existan usuarios repetidos
     * @return true si no existen usuarios repetidos, de lo contrario false
     */
    private Boolean usuariosRepetidos(){
        Boolean noRepetido = true;
        for(int i = 0; i < miUsuario().size();i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.darDocumento()==miUsuario().get(i).darDocumento()){
                noRepetido = false;
            }
        }
        return noRepetido;
    }
    /**
     * validar que no existan usuarios con el mismo turno de cita
     * <b> pre: </b> la lista de usuarios se encuentra inicializada
     * <b> post: </b> se valida que no existan usuarios con el mismo turno de cita
     * @return true si no existe el usuario con el mismo turno de cita, de lo contrario false
     */
    private Boolean turnoRepetido(){
        Boolean noRepetido = true;
        for(int i=0; i<miUsuario().size(); i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.darCita().darTurno() == miUsuario().get(i).darCita().darTurno()){
                noRepetido = false;
            }
        }
        return noRepetido;
    }
}