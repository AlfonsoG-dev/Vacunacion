import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import Conexion.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Mundo.Usuario;
import Mundo.Cita;
import Mundo.Operacion;
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
     * Usuario con la conexion a la base de datos
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    /**
     * operaciones con los usuarios
     */
    Operacion operaciones = new Operacion();
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
        try {
            int miDocumento = tblUsuarios.getSelectionModel().getSelectedItem().getDocumento();
            int index = tblUsuarios.getSelectionModel().getSelectedIndex();
            informacionCita(miDocumento, index);
        } catch (Exception e) {
            Alertar.display("Error: panelCita-Consultar", e.getMessage());
        }
    }
    /**
     * accion de eliminar la cita del usuario
     */
    @FXML
    void btnEliminarOnClicked(ActionEvent event) {
        try {
            if(JOptionPane.showConfirmDialog(null, "Desea eliminar el la cuenta??", "Eliminar Cuenta", JOptionPane.YES_NO_OPTION) == 0){
            }
        } catch (Exception e) {
            Alertar.display("Error: panelCita-Eliminar", e.getMessage());
        }
    }
    /**
     * accion de registrar cita el usuario
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        entrarRegistro();
    }
    /**
     * actualizar la informacion de cita dado el documento del usuario
     * <br> pre: </br> el usuario se encuentra inicializado
     * <br> post: </br> se obtiene la cita
     * @param documento, es el numero de documento del usuario que posee la cita, documento > 0
     * @param nIndex, es el la posicion del documento en la tabla
     */
    public void informacionCita(int documento, int nIndex){
        Usuario buscado = operaciones.buscarUsuario(String.valueOf(documento));
        if(buscado != null){
            Cita miCitaBuscada = operaciones.buscarCita(buscado.getCita());
            if(miCitaBuscada!=null){
                tblCitas.getItems().add(miCitaBuscada);
                eliminarUsuarioTabla(nIndex);
            }
        }
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
     * elimina un elemento de la tabla usuarios
     * <br> pre: </br> la tabla se encuentra inicializada 
     * <br> post: </br> se elimino el usuario
     * @param nIndex, es la posicion del usuario a eliminar
     * @return true si se elimina el usuario, false de lo contrario
     */
    public Boolean eliminarUsuarioTabla(int nIndex){
        Boolean eliminado = false;
        if(tblUsuarios.getItems().remove(nIndex) != null){
            eliminado = true;
        }
        return eliminado;
    }
    /**
     * elimnar cita de los datos de la tabla
     * <br> pre: </br> la tabla se encuentra inicializada
     * <br> post: </br> se elimina la cita de la tabla 
     * @param nIndex, es la posicion de la cita en la tabla
     * @return true si se elimina la cita, false de lo contrario 
     */
    public Boolean eliminarCitaTabla(int nIndex){
        Boolean eliminar = false;
        //TODO eliminar la cita
        return eliminar;
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