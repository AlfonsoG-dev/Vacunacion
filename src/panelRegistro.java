import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Mundo.Cita;
import Mundo.Usuario;
import Conexion.CitaDAO;
import Conexion.UsuarioDAO;

public class panelRegistro {
    /**
     * 
     */
    CitaDAO citaDAO = new CitaDAO();
    /**
     * 
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    @FXML
    private Button btnCncelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnRegistrar1;

    @FXML
    private ComboBox<Integer> cbxCodigoCita;

    @FXML
    private ComboBox<Integer> cbxDocumento;

    @FXML
    private ComboBox<String> cbxTipo;

    @FXML
    private DatePicker dtaFecha;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCelular;

    @FXML
    private Label lblCodigoCita;

    @FXML
    private Label lblCorreo;

    @FXML
    private Label lblDireccion;

    @FXML
    private Label lblDocumento;

    @FXML
    private Label lblFechaCIta;

    @FXML
    private Label lblLugarICita;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblRegistroCita;

    @FXML
    private Label lblRegistroUsuario;

    @FXML
    private Label lblTipo;

    @FXML
    private Label lblTurnoCita;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtLugar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTurno;

    @FXML
    void btnCancelarOnClicked(ActionEvent event) {

    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {

    }

}
