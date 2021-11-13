package Mundo;

public class prueba {
    public static void main(String[] args) {
        Cita mia = new Cita(112, "Enero-20.2021", 120, "Pasto");
        Cita mia1 = new Cita(112, "Enero-20.2021", 120, "Pasto");
        Usuario mio = new Usuario(192, "Cedula", "Alfonso", "Gomajoa", 3163, "@gmail", "Calle 2", mia);
        Usuario mio1 = new Usuario(193, "Cedula", "Sebastian", "Gomajoa", 3163, "@gmail", "Calle 2", mia1);
        Operacion miOperacion = new Operacion();
        String registrar = miOperacion.registrarCita(mia, mio);
        Boolean buscar = miOperacion.buscarUsuario(mio);
        System.out.println("Usuario 1: nombre : " + mio1.darNombre() + "\n" + 
        "Usuario 2: nombre: " + mio.darNombre() + "\n" + 
        "Usuario 1: cita: " + mio1.darCita().darCodigo() + "\n" + 
        "Se registro la cita ?: " + registrar + "\n" + 
        "Existe el usuario ingresado: " + buscar);
    }
}
