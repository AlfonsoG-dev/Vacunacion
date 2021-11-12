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
    private ArrayList<Usuario> citasAgendadas;
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
        usuarios = null;
        citas = null;
        citasAgendadas = new ArrayList<Usuario>();
    }
    //-------------------------------------//
    //----------------Metodos------------//
    //-------------------------------------//    
    /**
     * lista de usuarios en la eps
     * @return usuarios en la eps
     */
    public ArrayList<Usuario> miUsuario(){
        usuarios = new ArrayList<Usuario>();
        return usuarios;
    }
    /**
     * lista de citas para el usuario
     * @return citas para el usuario
     */
    public ArrayList<Cita> miCita(){
        citas = new ArrayList<Cita>();
        return citas;
    }
    /**
     * lista con las citas agendadas al usuario
     * @return citas agendadas por el usuario
     */
    public ArrayList<Usuario> darCitasAgendadas(){
        return citasAgendadas;
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
        if(nUsuario != null){
            for(int i=0; i<miUsuario().size();i++){
                Usuario verificar = miUsuario().get(i);
                if(verificar.darDocumento() == nUsuario.darDocumento()){
                    encontrado = true;
                }
            }
        }
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
        int codigoU=0;
        int codigoC=0;
        if(nCita != null && nUsuario != null){
            codigoC = nCita.darCodigo();
            codigoU = nUsuario.darCita(nCita);
            if(codigoC == codigoU){
                encontrado = true;
                darCitasAgendadas().add(nUsuario);
            }
            else{
                System.out.println("EL usuario no tiene citas agendadas");
            }
        }
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
        if(nCita != null){
            for(int i=0; i<citas.size(); i++){
                Cita eliminar = miCita().get(i);
                if(eliminar.darCodigo() == nCita.darCodigo()){
                    encontrado = true;
                    miCita().remove(i);
                    
                }
                else{
                    System.out.println("La cita no se encuentra agendada");
                }
            }
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
    public String agendarCita(Cita nCita, Usuario nUsuario){
        String mensaje = null;
        if(nCita != null && nUsuario!=null){
            Usuario nuevo = new Usuario(nUsuario.darDocumento(), nUsuario.darTipo(), nUsuario.darNombre(), nUsuario.darApellido(), nUsuario.darCelular(), nUsuario.darCorreo(), nUsuario.darDireccion(), nCita);
            agregarListas(nCita, nUsuario);
            mensaje = "El usuario se agrego a la lista: " + nuevo.darNombre();
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
    public void agregarListas(Cita nCita, Usuario nUsuario){
        miUsuario().add(nUsuario);
        miCita().add(nCita);
        darCitasAgendadas().add(nUsuario);
    }
}