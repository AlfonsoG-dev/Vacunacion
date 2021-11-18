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
    public Usuario buscarUsuario(Usuario nUsuario){
        Boolean encontrado = false;
        Usuario u = null;
        try{
            for(int i=0; i<miUsuario().size() && !encontrado; i++){
                Usuario existe = miUsuario().get(i);
                if(existe.getDocumento() != nUsuario.getDocumento()){
                    u = null;
                    System.out.print("El usuario no existe se debe registrar : ");
                }
                else{
                    encontrado = true;
                    u = nUsuario;
                }
            }

        }catch (Exception e){
            System.out.println("Error al buscar al usuario : " + e.getMessage());
        }
        return u;
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
    public Cita buscarCita(Cita nCita){
        Boolean encontrado = false;
        Cita c = null;
        try{
            for(int i=0; i<miCita().size() && !encontrado; i++){
                Cita existe = miCita().get(i);
                if(existe.getCodigo() != nCita.getCodigo()){
                    c = null;
                    encontrado = false;
                    System.out.print("La cita se debe registrar : ");
                }
                else{
                    c = nCita;
                    encontrado = true;
                }
            }

        }catch(Exception e){
            System.out.println("Error al momento de buscar la cita: " + e.getMessage());
        }
        return c;
    }
    /**
     * cancelar la cita agendada por el usuario, para cancelar la cita se pone 0 en el turno de la cita
     * <b> pre: </b> la lista de citas y de usuarios se encuentra inicializada
     * <b> post: </b> se elimina la cita de la lista de citas
     * @param nCita, es la cita a eliminar, nCita != "" && nCita != ""
     * @return true si la cita se elimino de lo contrario false
     */
    public Boolean cancelarCita(Cita nCita){
        Boolean encontrado = false;
        try{
            if(buscarCita(nCita)!=null){
                miCita().remove(nCita);
            }
        }catch(Exception e){
            System.out.println("Error al momento de cancelar la cita: " + e.getMessage());
        }
        return encontrado;
    }
    /**
     * re agenget la cita que se cancelo para otra fecha
     * <b> pre: </b> la lista de citas se encuentra inicializada
     * <b> post: </b> se agenda la cita para el usuario
     * @param nCita, cita del usuario a agenget
     * @param nUsuario, usuario que agenda la cita
     * @return la cita con el usuario que agendo la cita
     */
    public Usuario registrarCita(Cita nCita, Usuario nUsuario){
        Cita nuevaCita = null;
        Usuario nuevoUsuario = null;
        try{
            if(nCita != null && nUsuario != null){
                nuevaCita = new Cita(nCita.getCodigo(), nCita.getFecha(), nCita.getTurno(), nCita.getLugar());
                nuevoUsuario = new Usuario(nUsuario.getDocumento(), nUsuario.getTipo(), nUsuario.getNombre(), nUsuario.getApellido(), 
                nUsuario.getCelular(), nUsuario.getCorreo(), nUsuario.getDireccion(), nuevaCita);
                if(buscarUsuario(nuevoUsuario) == null && buscarCita(nuevaCita)==null){
                    agregarDatosLista(nuevaCita, nuevoUsuario);
                }
            }
        }catch(Exception e){
            System.out.println("Error al momento de registrar la cita del usuario: " + e.getMessage());
        }
        return nuevoUsuario;
    }
    /**
     * se agregan los elementos a la lista para su verificacion
     * <b> pre: </b> las lista de usuario, cita se encuentran inicializadas
     * <b> post: </b> se añaden los elementos a la lista
     * @param nCita, es la cita del usuario. nCita != "" && nCita != null
     * @param nUsuario, es el usurio que agendo la cita. nUsuario != "" && nUsuario != null
     */
    public void agregarDatosLista(Cita nCita, Usuario nUsuario){
        try{
            miUsuario().add(nUsuario);
            miCita().add(nCita);
            darUsuariosConCita().add(nUsuario);

        }catch(Exception e){
            System.out.println("Error al momento de registrar datos en las listas: " + e.getMessage());
        }
    }
    //-*---------------------------*-//
    //-*------Invariante-----------*-//
    //-*---------------------------*-//
    private void verificarInvariante(){
        assert !usuariosRepetidos() : "No tienen que existir 2 usuarios con numero de identificacion igual";
        assert !turnoRepetido() : "No tienen que existir 2 usuarios con el mismo turno de cita";
        assert !codigoCitaRepetido() : "No tienen que existir 2 usuarios con el mismo codigo de cita";
    }
    /**
     * valiget que no existan usuarios repetidos
     * <b> pre: </b> la lista de usuarios se encuentra inicializada
     * <b> post: </b> se valida que no existan usuarios repetidos
     * @return true si no existen usuarios repetidos, de lo contrario false
     */
    private Boolean usuariosRepetidos(){
        Boolean noRepetido = true;
        for(int i = 1; i < miUsuario().size();i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.getDocumento()==miUsuario().get(i).getDocumento()){
                noRepetido = false;
            }
        }
        return noRepetido;
    }
    /**
     * valiget que no existan usuarios con el mismo turno de cita
     * <b> pre: </b> la lista de usuarios se encuentra inicializada
     * <b> post: </b> se valida que no existan usuarios con el mismo turno de cita
     * @return true si no existe el usuario con el mismo turno de cita, de lo contrario false
     */
    private Boolean turnoRepetido(){
        Boolean noRepetido = true;
        for(int i=1; i<miUsuario().size(); i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.getCita().getTurno() == miUsuario().get(i).getCita().getTurno()){
                noRepetido = false;
            }
        }
        return noRepetido;
    }
    /**
     * valiget que no existan 2 usuarios con la misma cita
     * <b> pre: </b> la lista de usurios se encuentra inicializada
     * <b> post: </b> se valida que no existan 2 usuarios con la misma cita
     * @return true si no existe el usuario con la misma cita, false de lo contrario
     */
    private Boolean codigoCitaRepetido(){
        Boolean noRepetido = false;
        for(int i=1; i<miUsuario().size();i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.getCita().getCodigo() == miUsuario().get(i).getCita().getCodigo()){
                noRepetido = true;
            }
        }
        return noRepetido;
    }
}