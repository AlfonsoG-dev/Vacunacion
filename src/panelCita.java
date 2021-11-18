import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class panelCita {

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<?> cbxUsuarios;

    @FXML
    private TableColumn<?, ?> colCodigo;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colLugar;

    @FXML
    private TableColumn<?, ?> colTurno;

    @FXML
    private DatePicker dtaFecha;

    @FXML
    private Label lblCitas;

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
    private TableView<?> tblCitas;

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
    void btnRegistrarOnClicked(ActionEvent event) {

    }

}
