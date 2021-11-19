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
import Conexion.Conectar;
public class panelIngreso {
    /**
     * Operaciones de la cita
     */
    Operacion miOperacion = new Operacion();
    /**
     * conexion con la base de datos
     */
    Conectar conexion;
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
    private Parent root;
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
     * llamar al panelCita 
     */
    public void entrarCita(){
        try {
            root= FXMLLoader.load(getClass().getResource("PanelCita.fxml"));    
            Stage citaStage = new Stage();
            Scene scene = new Scene(root);
            citaStage.setTitle("Vacunacion: Cita");
            citaStage.setScene(scene);
            citaStage.showAndWait();
        } catch (Exception e) {
            Alertar.display("Error", e.getMessage());
        }
    }
}