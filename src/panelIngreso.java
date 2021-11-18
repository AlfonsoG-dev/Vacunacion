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
     * clase de tipo operacion
     */
    Operacion miOperacion = new Operacion();
    /**
     * 
     */
    Conectar conexion;
    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistro;

    @FXML
    private Label lblPasword;

    @FXML
    private Label lblUsuarioL;

    @FXML
    private PasswordField txtPasword;

    @FXML
    private TextField txtUsuario;
    private Parent root;
    @FXML
    void btnIngresarOnClicked(ActionEvent event) {
        entrarCita();
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {

    }
    /**
     * limpiar las casillas de texto de la pantalla
     */
    public void limpiar(){
        txtUsuario.setText(null);
        txtPasword.setText(null);
    } 
    /**
     * start la segunda ventana
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