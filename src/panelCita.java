import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Mundo.Usuario;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Conexion.UsuarioDAO;

//import javax.swing.JOptionPane;

import Mundo.Cita;
import Mundo.Operacion;
public class panelCita extends panelRegistro{
    /**
     * clase conexion UsuarioDAO
     */
    UsuarioDAO usuarioDAO;
    /**
     * clase con las operaciones a realizar
     */
    private Operacion operaciones;
    /**
     * estado del controlador panelCita
     */
    private Stage stageCita;
    /**
     * boton que realiza la accion de consultar cita
     */
    @FXML
    private Button btnConsultar;
    /**
     * boton que realiza la accion de eliminar cita
     */
    @FXML
    private Button btnEliminar;
    /**
     * boton para realizar el registro de usuario y cita
     */
    @FXML
    private Button btnRegistrar;
    /**
     * lista de usuarios ordenados por documento
     */
    @FXML
    private ComboBox<Integer> cbxUsuarios;
    /**
     * columna que representa el codigo de la cita
     */
    @FXML
    private TableColumn<Cita, Integer> colCodigo;
    /**
     * columna que representa la fecha de la cita
     */
    @FXML
    private TableColumn<Cita, String> colFecha;
    /**
     * columna que representa el lugar de la cita
     */
    @FXML
    private TableColumn<Cita, String> colLugar;
    /**
     * columna que representa el turno de la cita
     */
    @FXML
    private TableColumn<Cita, Integer> colTurno;
    /**
     * elemento para elegir la fecha de la cita
     */
    @FXML
    private DatePicker dtaFecha;
    /**
     * etiqueta de la tabla de citas
     */
    @FXML
    private Label lblCitas;
    /**
     * etiqueta del codigo de cita
     */
    @FXML
    private Label lblCodigo;
    /**
     * etiqueta de la fecha de cita
     */
    @FXML
    private Label lblFecha;
    /**
     * etiqueta del lugar de la cita
     */
    @FXML
    private Label lblLugar;
    /**
     * etiqueta del turno de cita
     */
    @FXML
    private Label lblTurno;
    /**
     * etiqueta del numero de documento del usuario
     */
    @FXML
    private Label lblUsuairo;
    /**
     * tabla de registros de cita
     */
    @FXML
    private TableView<Cita> tblCitas;
    /**
     * elemento con el codigo de cita
     */
    @FXML
    private TextField txtCodigo;
    /**
     * elemento con el lugar de la cita
     */
    @FXML
    private TextField txtLugar;
    /**
     * elemento con el turno de la cita
     */
    @FXML
    private TextField txtTurno;
    /**
     * consultar la cita dado el documento del usuario
     * @param event accion de consultar cita
     */
    @FXML
    void btnConsultarOnClicked(ActionEvent event) {
        operaciones = new Operacion();
        try {
            String documento = String.valueOf(cbxUsuarios.getSelectionModel().getSelectedItem());
            Usuario paraCita = operaciones.buscarUsuario(documento);
            Cita mia = operaciones.buscarCita(paraCita.getCita());
            //System.out.print("el usuario es: " + operaciones.buscarUsuario(documento).getNombre());
            if(mia != null){
                tblCitas.getItems().add(mia);
                limpiar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error panelCita.consultar: " + "\n"
            + e.getMessage());
        }
    }
    /**
     * eliminar la cita del usuario
     * @param event accion de eliminar la cita
    */
    @FXML
    void btnEliminarOnClicked(ActionEvent event) {
        operaciones = new Operacion();
        try {
            Cita eliminar = tblCitas.getSelectionModel().getSelectedItem();
            boolean comprobar = operaciones.eliminarCita(String.valueOf(eliminar.getCodigo()));
            if(comprobar != false){
                Alertar.display("panelCita", "Se elimino la cita");
                eliminarElementoTabla(eliminar, tblCitas.getSelectionModel().getSelectedIndex());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error panelCita.eliminar: " + "\n"
            + e.getMessage());
        }
    }
    /**
     * registrar la cita al usuario sin cita
     * @param event accion de registrar cita
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        entrarARegistro();
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
        agregarElemento();
    }
    /**
     * actualizar los elementos de la interfaz con la información consultada
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b>  se actualizan los elementos de la interfaz
     * @param nCita, es el objeto con la informacion para los elementos de la interfaz
     */
    public void actualizarElementos(Cita nCita){
        txtCodigo.setText(String.valueOf(nCita.getCodigo()));
        txtLugar.setText(nCita.getLugar());
        txtTurno.setText(String.valueOf(nCita.getTurno()));
        dtaFecha.setValue(LocalDate.parse(nCita.getFecha()));
        cbxUsuarios.setValue(null);
    }
    /**
     * Lista de elementos para la combobox de usuarios
     * <b> pre: </b> la lista de elementos se encuentra inicializada
     * <b> post: </b> se añade el elemento al ComboBox
     */
    public void agregarElemento(){
        usuarioDAO = new UsuarioDAO();
        ObservableList<Integer> usuarios = usuarioDAO.seleccionarUsuario();
        cbxUsuarios.setItems(usuarios);
    }
    /**
     * limpiar los elementos de la interfaz
     * <b> pre: </b> los elementos de la interfaz se encuentra inicializados 
     * <b> post: </b> se limpian los elementos de la interfaz
     */
    public void limpiar(){
        txtCodigo.setText(null);
        txtLugar.setText(null);
        txtTurno.setText(null);
        dtaFecha.setValue(null);
    }
    /**
     * eliminar un elemento de la tabla dada la cita y la posicion en la tabla pero no de la base de datos 
     * <br> pre :</br> el elemento se encuentra en la tabla  
     * <br> post :</br> se elimino el elemento de la tabla 
     * @param posicion, es la posicion del elemento en la tabla; posicion != null && posicion > 0
     * @param nCita, es la cita a eliminar de la tabla, nCita != null && nCita != ""
     */
    public void eliminarElementoTabla(Cita nCita, int posicion){
        if(tblCitas.getItems().contains(nCita)==true){
            tblCitas.getItems().remove(posicion);
        }else{
            Alertar.display("Eliminar: elemento tabla", "No existe el elemento en la tabla");
        }
    }
    /**
     * ingresar al panel de registro y cerrar el panelCita
     * <b> pre: </b> el panel de registro se encuentra inicializado
     * <b> post: </b> se ingresa al panel registro y se cierra panelCita
     * para entrar al registro se utiliza el boton <b> (btnRegistroOnClicked)</b>
     */
    public void entrarARegistro(){
        try{
            usuarioDAO = new UsuarioDAO();
            String doc = String.valueOf(cbxUsuarios.getSelectionModel().getSelectedItem());
            Usuario miUs = usuarioDAO.buscarUsuario(doc);
            if(miUs!=null){
                FXMLLoader load = new FXMLLoader(getClass().getResource("PanelRegistro.fxml"));
                Stage registroStage = new Stage();
                Parent root = load.load();
                panelRegistro registro = load.getController();
                Scene scena = new Scene(root);
                registroStage.setTitle("Vacunacion: Registro");
                registroStage.setScene(scena);
                registroStage.show();
                registro.actualizarElementosUsuario(miUs);
                this.stageCita.close();
                registro.setStage(registroStage);
            }else{
                Alertar.display("Error:", "Seleccione un usuario");
            }
        }catch(Exception e){
            Alertar.display("Ingreso", e.getMessage());
        }
    }
    /**
     * metodo para obtener el estado del controlador panelCita
     * <br> pre: </br> el controlador panelCita se encuentra inicializado 
     * <br> post: </br> se obtine el estado del controlador
     * @param citaStage; es el estado del controlador panelCita; citaStage != null && citaStage != null
     */
    public void setStage(Stage citaStage) {
        stageCita = citaStage;
    }
}