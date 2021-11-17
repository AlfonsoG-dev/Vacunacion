import java.net.URL;
import java.util.ResourceBundle;

import Mundo.Cita;
import Mundo.Usuario;
import Mundo.Operacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class panelCita {
    private Parent root;
    private Scene scene;
    Operacion miOperacion = new Operacion();
    Cita miCita;
    Usuario miUsuario;
    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Cita, Integer> colCodigo;

    @FXML
    private TableColumn<Usuario, Integer> colDocumento;

    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colLugar;

    @FXML
    private TableColumn<Cita, Integer> colTurno;

    @FXML
    private TableColumn<Usuario, String> colUsuario;

    @FXML
    private DatePicker dtaFecha;

    @FXML
    private Label lblCita;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblCodigo1;

    @FXML
    private Label lblLugar;

    @FXML
    private Label lblTurno;

    @FXML
    private TableView<?> tblCitas;

    @FXML
    private TextField txtCita;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtLugar;

    @FXML
    private TextField txtTurno;

    @FXML
    void btnConsultarOnClicked(ActionEvent event) {

    }

    @FXML
    void btnEliminarOnClicked(ActionEvent event) {

    }

    @FXML
    void btnModificarOnClicked(ActionEvent event) {

    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {

    }

    @FXML
    void btnVolverOnClicked(ActionEvent event) {
        entrarLogin();

    }
    
    public void initialize(URL arg0, ResourceBundle arg1){
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
    }
    /**
     * 
     */
    public void entrarLogin(){
        try {
            root= FXMLLoader.load(getClass().getResource("PanelLogin.fxml"));    
            scene = new Scene(root);
            Stage loginStage = new Stage();
            loginStage.setTitle("Loggin");
            loginStage.setScene(scene);
            loginStage.showAndWait();
        } catch (Exception e) {
            Alertar.display("Error", e.getMessage());
        }
    }
}