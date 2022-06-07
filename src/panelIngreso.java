import Mundo.Operacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class panelIngreso {
    /**
     * Operaciones de la cita
     */
    Operacion miOperacion = new Operacion();
    /**
     * Estado del controlador
     */
    private Stage stage;
    /**
     * boton para ingresar al panelCita
     */
    @FXML
    private Button btnIngresar;
    /**
     * boton para registrar usuario
     */
    @FXML
    private Button btnRegistro;
    /**
     * etiqueta de la contrasenia
     */
    @FXML
    private Label lblPasword;
    /**
     * etiqueta con el usuario
     */
    @FXML
    private Label lblUsuarioL;
    /**
     * elemento con la contrasenia de la cuenta
     */
    @FXML
    private PasswordField txtPasword;
    /**
     * elemento con el usuario de la cuenta
     */
    @FXML
    private TextField txtUsuario;
    /**
     * elemento con la informacion del panel
     */
    private FXMLLoader root;
    /**
     * ingresar al panel cita
     * @param event accion de ingresar al panelCita
     */
    @FXML
    void btnIngresarOnClicked(ActionEvent event) {
        entrarCita();
    }
    /**
     * registrar usuario
     * @param event accion de registrar usuario
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        Alertar.display("Registrar", "Desabilitado \n por el momento");
    }
    /**
     * limpiar los elementos de la interfaz
     */
    public void limpiar(){
        txtUsuario.setText(null);
        txtPasword.setText(null);
    } 
    /**
     * Metodo para ingresar al panel cita y cerrar el panel de ingreso; 
     * una vez se entra al panelCita no se puede regresar al panel de ingreso; 
     * se debe hacer un boton en el panelCita para regresar al panelIngreso
     * <br> pre: </br> el panelCita se encuentra inicializado
     * <br> post: </br> se ingreso al panelCita y se cierra panelIngreso
     */
    public void entrarCita(){
        try {
            //cargamos el archivo con la vista
            root= new FXMLLoader(getClass().getResource("PanelCita.fxml"));    
            //creamos el estado del controlador
            Stage citaStage = new Stage();
            //creamos el padre de la vista
            Parent mio = root.load();
            // creamos un objeto del controlador de panelCita y le asignamos el controlador de la vista 
            panelCita mia = root.getController();
            //creamos la escena del controlador
            Scene scene = new Scene(mio);
            //asignamos la escene al controlador de panelIngreso
            citaStage.setScene(scene);
            //visualizamos la interfaz creada
            citaStage.show();
            //asignamos el valor deseado al controlador panelCita, preferiblemente asignar un metodo que reciba valores
            //de panelIngreso y utilizarlo en panelCita
            //en este caso solo agrego elemento que es un metodo void que no necesita de parametros.
            mia.agregarElemento();
            //cirro panelIngreso
            this.stage.close();

        } catch (Exception e) {
            Alertar.display("Error", e.getMessage());
        }
    }
    /**
     * metodo para recibir el estado del controlador panelIngreso desde la clase main
     * <br> pre: </br> la clase main se encuentra inicializada
     * <br> post: </br> se recibe el estado del controlador de panelIngreso
     * @param primaryStage, es el estado del controlador panelIngreso, primaryStage != "" && primaryStage!=null
     */
    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
}