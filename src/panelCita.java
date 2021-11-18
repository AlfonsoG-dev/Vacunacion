import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
     * 
     */
    CitaDAO miCitaDAO = new CitaDAO();
    /**
     * 
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<Integer> cbxUsuarios;

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
    private TableView<Cita> tblCitas;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtLugar;

    @FXML
    private TextField txtTurno;

    @FXML
    void btnConsultarOnClicked(ActionEvent event) {
        String s = cbxUsuarios.getSelectionModel().getSelectedItem().toString();
        if(!s.isEmpty()){
            Usuario mio = usuarioDAO.buscarUsuario(s);
            if(mio!=null){
                buscarCita(mio.getCita());
            }else{
                Alertar.display("Buscar Usuario", "El usuario no existe");
            }
        }else{
            Alertar.display("Seleccion", "Seleccione al usuario");
        }
    }

    @FXML
    void btnEliminarOnClicked(ActionEvent event) {
        if(txtCodigo.getText()!=null){
            Cita buscada = miCitaDAO.buscarCita(txtCodigo.getText());
            if(buscada!=null){
                if(JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere cambiar la informacion" + JOptionPane.YES_NO_OPTION)==0){
                    miCitaDAO.eliminarCita(buscada);
                    Alertar.display("Eliminar", "Se elimino la cita");
                }
            }else{
                Alertar.display("Eliminar", "La cita no existe");
            }
        }else{
            Alertar.display("Validar", "El codigo es null");
        }
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        Alertar.display("Mensaje", "Proximamente");
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
        }else{
            Alertar.display("Consultar", "La cita \n no se encutra registrada");
        }
        return encontrar;
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
}