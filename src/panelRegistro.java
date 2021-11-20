import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Mundo.Cita;
import Mundo.Usuario;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Conexion.CitaDAO;
import Conexion.UsuarioDAO;

public class panelRegistro implements Initializable{
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
    private TextField txtCodigo;

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
        limpiar();
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {

    }
    @FXML
    void btnVerificarOnClicked(ActionEvent event) {
        String documento = String.valueOf(cbxDocumento.getSelectionModel().getSelectedItem());
        if(!documento.isEmpty()){
            Usuario nUsuario = usuarioDAO.buscarUsuario(documento);
            String codigo = nUsuario.getCita();
            Cita nCita = citaDAO.buscarCita(codigo); 
            if(nCita != null && nUsuario != null){
                actualizarElementos(nUsuario, nCita);
            }else{
                Alertar.display("Verificar", "El usuario o la cita estan mal¡¡??");
            }
        }else{
            Alertar.display("Verificar", "Seleccione un usuario");
        }
    }
    /**
     * se inicializan los combo cox
     * <b> pre: </b> los elementos se encuentran inicializados
     * <b> post: </b> se inicializan la combo box
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        agregarElemento();
    }
    /**
     * actualizar elementos de la interfaz con la informacion de usuario y cita
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se actualiza la informacion de los elementos
     * @param nUsuario, es el usuario con la informacion. nUsuario != null && nUsuario != ""
     * @param nCita, es la cita con la informacion. nCita != "" && nCita != null
     */
    public void actualizarElementos(Usuario nUsuario, Cita nCita){
        txtApellido.setText(nUsuario.getApellido());
        txtCelular.setText(String.valueOf(nUsuario.getCelular()));
        txtCorreo.setText(nUsuario.getCorreo());
        txtDireccion.setText(nUsuario.getDireccion());
        txtLugar.setText(nCita.getLugar());
        txtNombre.setText(nUsuario.getNombre());
        txtTurno.setText(String.valueOf(nCita.getTurno()));
        dtaFecha.setValue(LocalDate.parse(nCita.getFecha()));
        txtCodigo.setText(String.valueOf(nCita.getCodigo()));
    }
    /**
     * limpiar los elementos de la interfaz
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se limpian los elementos de la interfaz
     */
    public void limpiar(){
        txtApellido.setText(null);
        txtCelular.setText(null);
        txtCorreo.setText(null);
        txtDireccion.setText(null);
        txtLugar.setText(null);
        txtNombre.setText(null);
        txtTurno.setText(null);
        txtCodigo.setText(null);
        dtaFecha.setValue(null);
        cbxDocumento.setValue(null);
        cbxTipo.setValue(null);
    }
    /**
     * agregar elementos a las combo box
     * <b> pre: </b> la lista de elementos se encuentra inicializada
     * <b> post: </b> se agrega el elemento a la combo box
     */
    public void agregarElemento(){
        ObservableList<Integer> usuarios = usuarioDAO.seleccionarUsuario();
        cbxDocumento.setItems(usuarios);
        cbxTipo.getItems().add("id");
        cbxTipo.getItems().add("otro");
        cbxTipo.getItems().add("cc");

    }
}