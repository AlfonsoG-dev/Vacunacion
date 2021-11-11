package Mundo;
public class Usuario {
    //-------------------------------------//
    //----------------Atributos------------//
    //-------------------------------------//
    /**
     * numero de documento del usuario
     */
    private int numDocumento;
    /**
     * tipo de documento
     */
    private String tipoDocumento;
    /**
     * nombre del usuario
     */
    private String nombre;
    /**
     * apellido del usuario
     */
    private String apellido;
    /**
     * numero de celular del usuario
     */
    private int celular;
    /**
     * correo electronico del usuario
     */
    private String correo;
    /**
     * direccion de domicilio del usuario
     */
    private String direccion;
    /**
     * Cita agendada por el usuario 
     */
    private Cita cita;
    //-------------------------------------//
    //----------------Constructor------------//
    //-------------------------------------//
    /**
     * usuario nuevo o existente en el sistema
     * <b> pre: </b> los atributos del usuario se encuentran declarados
     * <b> post: </b> se crea un usuario con los atributos 
     * @param nDocumento, es el numero de documento del usuario. nDocumento > 0 && nDocumento != null
     * @param nTipo, es el tipo de documento del usuario. nTipo != "" && nTipo != null
     * @param nNombre, es el nombre del usuario. nNombre != "" && nNombre != null
     * @param nApellido, es el apellido del usuario. nApellido != "" && nApellido != null
     * @param nCelular, es el numero de celular del usuario. nCelular > 0 && nCelular != null
     * @param nCorreo, es el correo electronico del usuario. nCorreo != "" && nCorreo != null
     * @param nDireccion, es la direccion de domicilio del usuario. nDireccion != "" && nDireccion != null
     * @param nCita, es el codigo de la cita del usuario. nCita > 0 && nCita != null
     */
    public Usuario(int nDocumento, String nTipo, String nNombre, String nApellido, int nCelular, String nCorreo, String nDireccion){
        
        numDocumento = nDocumento;
        tipoDocumento = nTipo;
        nombre = nNombre;
        apellido = nApellido;
        celular = nCelular;
        correo = nCorreo;
        direccion = nDireccion;
        cita = null;
    }
    //-------------------------------------//
    //----------------Metodos------------//
    //-------------------------------------//
    /**
     * numero de documento del usuario 
     * @return numero de documento 
     */
    public int darDocumento(){
        return numDocumento;
    }
    /**
     * tipo de documento del usuario
     * @return tipo de documento
     */
    public String darTipo(){
        return tipoDocumento;
    }
    /**
     * nombre del usuario 
     * @return nombre del usuario
     */
    public String darNombre(){
        return nombre;
    }
    /**
     * apellido del usuario 
     * @return apellido del usuario
     */
    public String darApellido(){
        return apellido;
    }
    /**
     * numero de celular del usuario
     * @return numero de celular
     */
    public int darCelular(){
        return celular;
    }
    /**
     * correo electronico del usuario
     * @return correo del usuario
     */
    public String darCorreo(){
        return correo;
    }
    /**
     * direccion de domicilio del usuario
     * @return direccion del usuario
     */
    public String darDireccion(){
        return direccion;
    }
    /**
     * codigo de la cita del usuario
     * @return codigo de la cita
     */
    public int darCita(Cita miCita){
        int codigo = 0;
        if(miCita!=null){
            cita = miCita;
            codigo = cita.darCodigo();
        }
        return codigo;
    }
}