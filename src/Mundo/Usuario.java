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
    private String cita;
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
    public Usuario(int nDocumento, String nTipo, String nNombre, String nApellido, int nCelular, String nCorreo, String nDireccion, String nCita){
        
        numDocumento = nDocumento;
        tipoDocumento = nTipo;
        nombre = nNombre;
        apellido = nApellido;
        celular = nCelular;
        correo = nCorreo;
        direccion = nDireccion;
        cita = nCita;
        verificarInvariante();
    }
    //-------------------------------------//
    //----------------Metodos------------//
    //-------------------------------------//
    /**
     * numero de documento del usuario 
     * @return numero de documento 
     */
    public int getDocumento(){
        return numDocumento;
    }
    /**
     * tipo de documento del usuario
     * @return tipo de documento
     */
    public String getTipo(){
        return tipoDocumento;
    }
    /**
     * nombre del usuario 
     * @return nombre del usuario
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * apellido del usuario 
     * @return apellido del usuario
     */
    public String getApellido(){
        return apellido;
    }
    /**
     * numero de celular del usuario
     * @return numero de celular
     */
    public int getCelular(){
        return celular;
    }
    /**
     * correo electronico del usuario
     * @return correo del usuario
     */
    public String getCorreo(){
        return correo;
    }
    /**
     * direccion de domicilio del usuario
     * @return direccion del usuario
     */
    public String getDireccion(){
        return direccion;
    }
    /**
     * cita agendada del usuario
     * @return codigo de la cita
     */
    public String getCita(){
        return cita;
    }
    //-------------------------------------//
    //----------------Invariantes---------//
    //-----------------------------------//
    /**
     * verificar la invariante de la clase
     * <b> pre: </b> los atributos de la clase se encuentran declarados e inicializados
     * <b> post: </b> se verifica la invariante de la clase
     * El numero de documento no puede ser 0. numDocumento > 0 
     * El nombre del usuario no puede ser null. nombre != null 
     * El apellido del usuario no puede ser null. apellido != null
     * La cita del usuario no puede ser null. cita != null
     */
    private void verificarInvariante(){
        assert numDocumento > 0 : "El numero de documento no puede ser 0";
        assert nombre != null : "El nombre del usuario no puede ser null";
        assert apellido != null : "El apellido del usuario no puede ser null";
        assert cita != null : "La cita del usuario no puede ser null";
    }
}