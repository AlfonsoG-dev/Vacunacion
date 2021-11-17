import java.net.URL;
import java.util.ResourceBundle;
import Conexion.CitaDAO;
import Mundo.Cita;
import Mundo.Operacion;
import Mundo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class panelCita implements Initializable{

    Cita miCita;
    Operacion miOperacion = new Operacion();
    Usuario miUsuario;
    CitaDAO miCitaDAO = new CitaDAO();
    private Parent root;
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
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colLugar;

    @FXML
    private TableColumn<Cita, Integer> colTurno;

    @FXML
    private DatePicker dtaFecha;

    @FXML
    private Label lblCita;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblLugar;

    @FXML
    private Label lblTurno;

    @FXML
    private TableView<Cita> tblCitas;

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
        try{
            if(miCitaDAO.buscarCita(txtCodigo.getText())!=null){

                tblCitas.getItems().add(miCitaDAO.buscarCita(txtCodigo.getText()));
            }
        }catch(Exception e){
            Alertar.display("Error", e.getMessage());
        }
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

    }
    /**
     * 
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
    }
    /**
     * 
     */
    public void entrarLogin() {
        try {
            root = FXMLLoader.load(getClass().getResource("PanelLogin.fxml"));
            Stage citaStage = new Stage();
            Scene scene = new Scene(root);
            citaStage.setTitle("Vacunacion:login");
            citaStage.setScene(scene);
            citaStage.show();
        } catch (Exception e) {
            Alertar.display("Error", e.getMessage());
        }
    }
}