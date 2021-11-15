package Mundo;

public class Cuenta {
    //------------------------------------------------------------------//
    //------------------------------Atributos--------------------------//
    //----------------------------------------------------------------//
    /**
     * usuario de la cuenta
    */
    private String usuario;
    /**
     * password de la cuenta
     */
    private String pasword;
    //-------------------------------------------------------------//
    //------------------------Constructor-------------------------//
    //-----------------------------------------------------------//
    /**
     * crear una cuenta para el usuario
     * <b> pre: </b> los atributos de la cuenta se encuentran declarados
     * <b> post: </b> se crea la cuenta con usuario y contraseña
     * @param nUsuario, es el usuario de la cuenta. nUsuario != "" && nUsuario != null
     * @param nPasword, es la contrasenia de la cuenta. nPasword != "" && nPasword != null
     */
    public Cuenta(String nUsuario, String nPasword){
        usuario = nUsuario;
        pasword = nPasword;
    }
    //----------------------------------------------------------------//
    //-------------------------------Metodos-------------------------//
    //--------------------------------------------------------------//
    /**
     * usuario de la cuenta para loggin
     * @return usuario de la cuenta
     */
    public String darUsuario(){
        return usuario;
    }
    /**
     * contrasenia de la cuenta
     * @return contrasenia de la cuenta
     */
    public String darPasword(){
        return pasword;
    }

}
