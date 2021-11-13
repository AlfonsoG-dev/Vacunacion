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
     * busca al usuario en la lista de usuarios para verificar 
     * <b> pre: </b> la lsita de usuarios se encuentra inicializada
     * <b> post: </b> se verifica el usuario y si el usuario no existe se debe de registrar
     * @param nUsuario, es el usuario a verificar. nUsuario != "" && nUsuario != null
     * @return true si el usuario esta en el sistema, false de lo contrario 
     */
    public Boolean buscarUsuario(Usuario nUsuario){
        Boolean encontrado = false;
        for(int i=0; i<miUsuario().size() && !encontrado; i++){
            Usuario existe = miUsuario().get(i);
            if(existe.darDocumento() != nUsuario.darDocumento()){
                System.out.print("El usuario no existe se debe registrar");
            }
            else{
                encontrado = true;
            }
        }
        return encontrado;
    }
    /**
     * buscar la cita para saber si se encuentra registrada
     * <b> pre: </b> la lista de citas y usuarios se encuentra incializada
     * <b> post: </b> se verifica si el usuario tiene una cita agendada o nop
     * @param nUsuario, es el usuario con la cita a verificar, nUsuario != null && nUsuario != ""
     * @return true si el usuario tiene una cita agendada, de lo contrario false
     * el usuario solo tiene el codigo de la cita en donde 0 es que no tiene asignada cita.
     * si el usuario tiene agendada una cita se lo añade a la lista de citas agendadas
     */
    public Boolean buscarCita(Usuario nUsuario){
        Boolean encontrado = false;
        for(int i=0; i<miCita().size() && !encontrado; i++){
            Cita existe = nUsuario.darCita();
            if(existe.darCodigo() != nUsuario.darCita().darCodigo()){
                System.out.print("La cita se debe registrar");
            }
            else{
                encontrado = true;
            }
        }
        return encontrado;
    }
    /**
     * cancelar la cita agendada por el usuario, para cancelar la cita se pone 0 en el turno de la cita
     * <b> pre: </b> la lista de citas y de usuarios se encuentra inicializada
     * <b> post: </b> se elimina la cita de la lista de citas
     * @param nCita, es la cita a eliminar, nCita != "" && nCita != ""
     * @return true si la cita se elimino de lo contrario false
     */
    public Boolean cancelarTurno(Usuario nUsuario){
        Boolean encontrado = false;
        if(buscarUsuario(nUsuario)!=false){
            int turno = nUsuario.darCita().darTurno();
            turno = 0;
            System.out.print("El turno cambio a: "+turno);
        }
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
    public String registrarCita(Cita nCita, Usuario nUsuario){
        String mensaje = null;
        Cita nuevaCita = null;
        Usuario nuevoUsuario = null;
        if(nCita != null && nUsuario != null){
            nuevaCita = new Cita(nCita.darCodigo(), nCita.darFecha(), nCita.darTurno(), nCita.darLugar());
            nuevoUsuario = new Usuario(nUsuario.darDocumento(), nUsuario.darTipo(), nUsuario.darNombre(), nUsuario.darApellido(), 
            nUsuario.darCelular(), nUsuario.darCorreo(), nUsuario.darDireccion(), nuevaCita);
            if(buscarUsuario(nuevoUsuario)==false){
                mensaje = "El Usuario se registro como: " + nuevoUsuario.darNombre() + "\n" + 
                "Con numero de identificacion: " + nuevoUsuario.darDocumento();
                agregarDatosLista(nuevaCita, nuevoUsuario);
            }
            else{
                mensaje = "El usuario ya se encuentra registrado en el sistema";
            }
        }
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
        assert !usuariosRepetidos() : "No tienen que existir 2 usuarios con numero de identificacion igual";
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