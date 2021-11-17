import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import Conexion.Conectar;
import Conexion.CitaDAO;
import Mundo.Cita;

public class panelCita implements Initializable{

    /**
     * cita del usuario
     */
    Cita miCita;
    /**
     * conexion con la base de datos
     */
    Conectar miConexion = new Conectar();
    /**
     * clase cita con las operaciones de la base de datos
     */
    CitaDAO miCitaDAO = new CitaDAO();
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
    private Label lblCodigo;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblLugar;

    @FXML
    private Label lblTurno;

    @FXML
    private Label lblUsuairo;

    @FXML
    private TableView<Cita> tblCitas;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtLugar;

    @FXML
    private TextField txtTurno;

    @FXML
    private TextField txtUsuario;

    @FXML
    void btnConsultarOnClicked(ActionEvent event) {
        try{
            if(miCitaDAO.buscarCita(txtCodigo.getText())!=null){

                tblCitas.getItems().add(miCitaDAO.buscarCita(txtCodigo.getText()));
            }
            else{
                Alertar.display("Consulta", "No existe la cita");
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
     * se inicializan las columnas de la tabla
     * <b> pre: </b> la tabla se encuentra inicializada
     * <b> post: </b> se inicializan las columnas de la tabla
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
    }

}
