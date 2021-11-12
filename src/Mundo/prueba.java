package Mundo;

public class prueba {
    public static void main(String[] args) {
        Cita mia = new Cita(112, "Enero-20.2021", 120, "Pasto");
        Cita mia1 = new Cita(113, "Enero-20.2021", 120, "Pasto");
        Usuario mio = new Usuario(192, "Cedula", "Alfonso", "Gomajoa", 3163, "@gmail", "Calle 2", mia);
        Usuario mio1 = new Usuario(193, "Cedula", "Sebastian", "Gomajoa", 3163, "@gmail", "Calle 2", mia);
        Operacion miOperacion = new Operacion();
        String miMensaje = miOperacion.agendarCita(mia, mio);
        String miMensaje1 = miOperacion.agendarCita(mia1, mio1);
        boolean verificar = miOperacion.verificarUsuario(mio);
        boolean verificar1 = miOperacion.verificarUsuario(mio);
        System.out.println(miMensaje);
        System.out.println(miMensaje1);
        System.out.println(verificar);
        System.out.println(verificar1);
    }
}
