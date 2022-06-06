import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import Conexion.CitaDAO;
import Conexion.UsuarioDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Mundo.Cita;
public class panelCita implements Initializable{

    /**
     * cita del usuario 
     */
    CitaDAO miCitaDAO = new CitaDAO();
    /**
     * operaciones del usuario
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
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
        String documento = String.valueOf(cbxUsuarios.getSelectionModel().getSelectedItem());
        if(!documento.isEmpty()){
            Usuario mio = usuarioDAO.buscarUsuario(documento);
            if(mio!=null){
                buscarCita(mio.getCita());
            }else{
                Alertar.display("Buscar Usuario", "El usuario no existe");
            }
        }else{
            Alertar.display("Buscar", "Documento mal digitado");
        }
    }
    /**
     * eliminar la cita del usuario
     * @param event accion de eliminar la cita
    */
    @FXML
    void btnEliminarOnClicked(ActionEvent event) {
        int posicion = tblCitas.getSelectionModel().getSelectedIndex();
        if(String.valueOf(posicion) != null){
            Cita miCita = tblCitas.getSelectionModel().getSelectedItem(); 
            if(miCita!=null){
                /*eliminarCita(miCita);*/
                eliminarElementoTabla(miCita, posicion);
            }else{
                Alertar.display("Eliminar: Cita", "La cita es nula");
            }
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
     * buscar la cita dado el codigo de la cita
     * <b> pre: </b> la cita se encuentra inicializada
     * <b> post: </b> se busca la cita dado el codigo
     * @param nCodigo, es el codigo de la cita a buscar
     * @return true si la encontro de lo contrario false
     */
    public Boolean buscarCita(String nCodigo){
        Boolean encontrar = false;
        Cita consultar = miCitaDAO.buscarCita(nCodigo);
        if(consultar != null){
            tblCitas.getItems().add(consultar);
            actualizarElementos(consultar);
            limpiar();
        }else{
            Alertar.display("Consultar: Cita", "La cita \n no se encuentra registrada");
        }
        return encontrar;
    }
    /**
     * eliminar cita de la base de datos
     * <b> pre: </b> la cita se encuetra registrada
     * <b> post: </b> se elimino la cita registrada
     * @param nCita, es la cita a eliminar. nCita != "" && nCita != null
     */
    public void eliminarCita(Cita nCita){
        if(nCita!=null){
            Boolean mia = miCitaDAO.eliminarCita(nCita);
            if(mia != false){
                Alertar.display("Eliminar: Cita", "La cita se elimino");
            }else{
                Alertar.display("Eliminar: Cita", "La cita no se elimino");
            }

        }else{
            Alertar.display("Eliminar: Cita", "La cita es nula");
        }
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
     * añadir elemento al comboBox
     * <b> pre: </b> la lista de elementos se encuentra inicializada
     * <b> post: </b> se añade el elemento al ComboBox
     */
    public void agregarElemento(){
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
     * @param n
     */
    public void eliminarElementoTabla(Cita nCita, int posicion){
        if(tblCitas.getItems().contains(nCita)==true){
            tblCitas.getItems().remove(posicion);
        }else{
            JOptionPane.showMessageDialog(null, "Error no existe el elemento en la tabla");
        }
    }
    /**
     * ingresar al panel de registro
     * <b> pre: </b> el panel de registro se encuentra inicializado
     * <b> post: </b> se ingresa al panel registro
     * para entrar al registro se utiliza el boton <b> (btnRegistroOnClicked)</b>
     */
    public void entrarARegistro(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("PanelRegistro.fxml"));
            Stage registroStage = new Stage();
            Scene scena = new Scene(root);
            registroStage.setTitle("Vacunacion: Registro");
            registroStage.setScene(scena);
            registroStage.showAndWait();
        }catch(Exception e){
            Alertar.display("Ingreso", e.getMessage());
        }
    }
}