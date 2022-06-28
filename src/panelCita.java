import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import Conexion.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Mundo.Usuario;
import Mundo.Cita;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class panelCita implements Initializable{

    /**
     * usuarioDAto
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    /**
     * estado del controlador actual
     */
    private Stage stage;
    /**
     * boton para consultar si el usuario tiene cita
     */
    @FXML
    private Button btnConsultar;
    /**
     * boton para eliminar la cita del usuario
     */
    @FXML
    private Button btnEliminar;
    /**
     * boton para registrar una cita
     */
    @FXML
    private Button btnRegistrar;
    /**
     * elemento con la informacion del panel 
     */
    private FXMLLoader root;
    /**
     * columna de la tabla de citas en donde esta el codigo de cita
     */
    @FXML
    private TableColumn<Cita, Integer> colCodigo;
    /**
     * columna de la tabla citas en donde esta la fecha de cita 
     */
    @FXML
    private TableColumn<Cita, String> colFecha;
    /**
     * columna de la tabla citas en donde esta el lugar de cita
     */
    @FXML
    private TableColumn<Cita, String> colLugar;
    /**
     * columna de la tabla citas en donde esta el turno de la cita
     */
    @FXML
    private TableColumn<Cita, Integer> colTurno;
    /**
     * columna de la tabla usuarios que representa el documento del usuaro
     */
    @FXML
    private TableColumn<Usuario, Integer> colDocumento;
    /**
     * etiqueta de la tabla citas 
     */
    @FXML
    private Label lblCitas;
    /**
     * tabla con las citas del usuario
     */
    @FXML
    private TableView<Cita> tblCitas;
    /**
     * tabla con el documento del usuario
     */
    @FXML
    private TableView<Usuario> tblUsuarios;
    /**
     * accion de consultar la cita del usuario
     */
    @FXML
    void btnConsultarOnClicked(ActionEvent event) {

    }
    /**
     * accion de eliminar la cita del usuario
     */
    @FXML
    void btnEliminarOnClicked(ActionEvent event) {

    }
    /**
     * accion de registrar cita el usuario
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        entrarRegistro();
    }
    /**
     * inicializar los datos de las tablas 
     * <br> pre: </br> las tablas se encuentran declaradas
     * <br> post: </br> se inicializan los datos de las tablas
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
        colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        agregarElemento();
    }
    /**
     * metodo para añadir los datos a la tabla cita
     * <br> pre: </br> la tabla  de usuarios se encuentra inicializada
     * <br> post: </br> se agregaron los usuarios a la tabla
     */
    public void agregarElemento(){
        ObservableList<Usuario> misUsuarios = usuarioDAO.seleccionarUsuario();
        tblUsuarios.setItems(misUsuarios);
    }
    /**
     * entrar al panelRegistro
     * cerrar el panelCita para entrar en panelRegistro
     * <br> pre: </br> el panelRegistro se encuentra inicializado
     * <br> post: </br> se ingresa al panelRegistro y se cierra panelCita
     */
    public void entrarRegistro(){
        try {
            root = new FXMLLoader(getClass().getResource("PanelRegistro.fxml"));
            Stage registroStage =new Stage();
            Parent miPadre = root.load();
            panelRegistro miPanelRegistro = root.getController();
            Scene citaScena = new Scene(miPadre);
            registroStage.setTitle("Vacunacion: Registro");
            registroStage.setScene(citaScena);
            registroStage.show();
            this.stage.close();
            miPanelRegistro.setStage(registroStage);
        } catch (IOException e) {
            Alertar.display("Error: ", e.getMessage());
        }
    }
    /**
     * estado del controlador de panelCita
     * <br> pre: </br> el controlador de panelCita se encuentra inicializado
     * <br> post: </br> se da el controlador de panelCita
     */
    public void setStage(Stage citaStage){
        stage = citaStage;
    }
}