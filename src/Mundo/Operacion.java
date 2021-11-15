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
    private ArrayList<Cuenta> cuentas;
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
        cuentas = new ArrayList<Cuenta>();
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
     * lista con las cuentas del usuario
     * @return cuentas del usuario
     */
    public ArrayList<Cuenta> miCuenta(){
        return cuentas;
    }
    /**
     * buscar la cuenta del usuario
     * <b> pre: </b> la lista de cuentas se encuentra inicializada
     * <b> post: </b> se busca la cuenta y si no eixte se registra la cuenta
     * @param nCuenta, es la cuenta a buscar. nCuenta != "" && nCuenta != null
     * @return true si la cuenta se encuentra, de lo contrario false
     */
    public Boolean buscarCuenta(Cuenta nCuenta){
        Boolean encontrado = false;
        try{
            for(int i=0; i<miCuenta().size() && !encontrado; i++){
                Cuenta buscar = miCuenta().get(i);
                if(buscar.darUsuario() != nCuenta.darUsuario()){
                    System.out.println("La cuenta no se encuentra registrada en el sistema");
                }else{
                    encontrado = true;
                }   
            }
        }catch (Exception e){
            System.out.println("Error al momento de buscar la cuenta: " + e.getMessage());
        }
        return encontrado;
    }
    /**
     * registar la cuenta del usuario
     * <b> pre: </b> la lista de cuentas se encuentra inicializada
     * <b> post: </b> se regitra la cuenta del usuario
     * @param nUsuario, es el usuario de la cuenta. nUsuario != "" && nUsuario != null
     * @param nPassword, es la contrasenia de la cuentra. nPassword != "" && nPassword != null
     * @return mensaje de "registro exitoso"
     */
    public String registrarCuenta(String nUsuario, String nPassword){
        String mensaje = "";
        Boolean stop = false;
        Cuenta nueva = null;
        try{
            for(int i=0; i<miCuenta().size() && !stop;i++){
                Cuenta inicial = miCuenta().get(i);
                if(inicial.darUsuario() != nUsuario){
                    nueva = new Cuenta(nUsuario, nPassword);
                    mensaje = "Se registro la cuenta con usurio: " + nueva.darUsuario() + "\n" + 
                    "y contrasenia: " + nueva.darPasword();
                }else{
                    mensaje = "la cuenta se encuentra registrada con usuario: " + nUsuario + "\n" + 
                    "y contrasenia: " + nPassword; 
                }
            }
        }catch(Exception e){
            System.out.println("Error al registrar la cuenta: " + e.getMessage());
        }
        return mensaje;
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
        try{
            for(int i=0; i<miUsuario().size() && !encontrado; i++){
                Usuario existe = miUsuario().get(i);
                if(existe.darDocumento() != nUsuario.darDocumento()){
                    System.out.print("El usuario no existe se debe registrar : ");
                }
                else{
                    encontrado = true;
                }
            }

        }catch (Exception e){
            System.out.println("Error al buscar al usuario : " + e.getMessage());
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
        try{
            for(int i=0; i<miCita().size() && !encontrado; i++){
                Cita existe = nUsuario.darCita();
                if(existe.darCodigo() != nUsuario.darCita().darCodigo()){
                    System.out.print("La cita se debe registrar : ");
                }
                else{
                    encontrado = true;
                }
            }

        }catch(Exception e){
            System.out.println("Error al momento de buscar la cita: " + e.getMessage());
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
    public Boolean cancelarCita(Usuario nUsuario){
        Boolean encontrado = false;
        try{

            if(buscarUsuario(nUsuario)!=false && buscarCita(nUsuario)!=false){
                Cita eliminar = nUsuario.darCita();
                for(int i=0; i<miCita().size() && !encontrado; i++){
                    if(eliminar.darCodigo() != miCita().get(i).darCodigo()){
                        System.out.println("La cita del usuario no se encuentra registrada");
                    }
                    else{
                        encontrado = true;
                        miCita().remove(i);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error al momento de cancelar la cita: " + e.getMessage());
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
        try{
            
            if(nCita != null && nUsuario != null){
                nuevaCita = new Cita(nCita.darCodigo(), nCita.darFecha(), nCita.darTurno(), nCita.darLugar());
                nuevoUsuario = new Usuario(nUsuario.darDocumento(), nUsuario.darTipo(), nUsuario.darNombre(), nUsuario.darApellido(), 
                nUsuario.darCelular(), nUsuario.darCorreo(), nUsuario.darDireccion(), nuevaCita);
                if(buscarUsuario(nuevoUsuario) == false){
                    mensaje = "El Usuario se registro como: " + nuevoUsuario.darNombre() + "\n" + 
                    "Con numero de identificacion: " + nuevoUsuario.darDocumento() + "\n" + 
                    "Con codigo de cita: " + nuevoUsuario.darCita().darCodigo() + "\n" + 
                    "el turno de la cita es: " + nuevoUsuario.darCita().darTurno();
                    agregarDatosLista(nuevaCita, nuevoUsuario);
                }
                else{
                    mensaje = "El usuario ya se encuentra registrado en el sistema";
                }
            }
        }catch(Exception e){
            System.out.println("Error al momento de registrar la cita del usuario: " + e.getMessage());
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
        assert !cuentaRepetida(): "No tienen que existir 2 cuentas con el mismo usuario";
    }
    /**
     * validar que no existan usuarios repetidos
     * <b> pre: </b> la lista de usuarios se encuentra inicializada
     * <b> post: </b> se valida que no existan usuarios repetidos
     * @return true si no existen usuarios repetidos, de lo contrario false
     */
    private Boolean usuariosRepetidos(){
        Boolean noRepetido = true;
        for(int i = 1; i < miUsuario().size();i++){
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
        for(int i=1; i<miUsuario().size(); i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.darCita().darTurno() == miUsuario().get(i).darCita().darTurno()){
                noRepetido = false;
            }
        }
        return noRepetido;
    }
    /**
     * validar que no existan 2 usuarios con la misma cita
     * <b> pre: </b> la lista de usurios se encuentra inicializada
     * <b> post: </b> se valida que no existan 2 usuarios con la misma cita
     * @return true si no existe el usuario con la misma cita, false de lo contrario
     */
    private Boolean codigoCitaRepetido(){
        Boolean noRepetido = false;
        for(int i=1; i<miUsuario().size();i++){
            Usuario inicial = miUsuario().get(0);
            if(inicial.darCita().darCodigo() == miUsuario().get(i).darCita().darCodigo()){
                noRepetido = true;
            }
        }
        return noRepetido;
    }
    /**
     * validar que no existan 2 cuentas con el mismo usuario
     * <b> pre: </b> la lista de cuentas se encuentra inicializada
     * <b> post: </b> se valida que no existan 2 cuentas con el mismo usuario
     * @return true si no existen 2 cuentas con el mismo usuario, false de lo contrario
     */
    private Boolean cuentaRepetida(){
        Boolean noRepetido = true;
        for(int i=1; i<miCuenta().size() && !noRepetido; i++){
            Cuenta inicial = miCuenta().get(0);
            if(inicial.darUsuario() == miCuenta().get(i).darUsuario()){
                noRepetido = false;
            }
        }
        return noRepetido;
    }
}