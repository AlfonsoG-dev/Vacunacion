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
     * operaciones de la cita del usuario
     */
    CitaDAO citaDAO = new CitaDAO();
    /**
     * operaciones del usuario
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    /**
     * boton para cancelar las acciones que se esten realizando
     */
    @FXML
    private Button btnCncelar;
    /**
     * boton para realizar el registro de la cita al usuario
     */
    @FXML
    private Button btnRegistrar;
    /**
     * boton para verificar informacion 
     */
    @FXML
    private Button btnVrificar;
    /**
     * lista de codigos de cita
     */
    @FXML
    private ComboBox<Integer> cbxCodigoCIta;
    /**
     * lista de usuarios sin cita
     */
    @FXML
    private ComboBox<Integer> cbxDocumento;
    /**
     * tipo de documento
     */
    @FXML
    private ComboBox<String> cbxTipo;
    /**
     * fecha actual
     */
    @FXML
    private DatePicker dtaFecha;
    /**
     * etiqueta del apellido del usuario
     */
    @FXML
    private Label lblApellido;
    /**
     * etiqueta del celular del usuario
     */
    @FXML
    private Label lblCelular;
    /**
     * etiqueta del codigo de cita
     */
    @FXML
    private Label lblCodigoCita;
    /**
     * etiqueta del correo del usuario
     */
    @FXML
    private Label lblCorreo;
    /**
     * etiqueta de la direccion del usuario
     */
    @FXML
    private Label lblDireccion;
    /**
     * etiqeta de documento del usuario
     */
    @FXML
    private Label lblDocumento;
    /**
     * etiqueta de la fecha de cita
     */
    @FXML
    private Label lblFechaCIta;
    /**
     * etiqueta del lugar de la cita
     */
    @FXML
    private Label lblLugarICita;
    /**
     * etiqueta de nombre del usuario
     */
    @FXML
    private Label lblNombre;
    /**
     * etiqueta de registro de la cita
     */
    @FXML
    private Label lblRegistroCita;
    /**
     * etiqueta de registro del usuario
     */
    @FXML
    private Label lblRegistroUsuario;
    /**
     * etiqueta del tipo de documento
     */
    @FXML
    private Label lblTipo;
    /**
     * etiqueta del turno de la cita
     */
    @FXML
    private Label lblTurnoCita;
    /**
     * casilla de texto para el apellido del usuario
     */
    @FXML
    private TextField txtApellido;
    /**
     * casilla de texto para el numero de celular del usuario
     */
    @FXML
    private TextField txtCelular;
    /***
     * casilla de texto para el correo del usuario
     */
    @FXML
    private TextField txtCorreo;
    /**
     * casilla de texto para la direccion del usuario 
     */
    @FXML
    private TextField txtDireccion;
    /**
     * casilla de texto para el lugar de la cita
     */
    @FXML
    private TextField txtLugar;
    /**
     * casilla de texto para el nombre del usuario
     */
    @FXML
    private TextField txtNombre;
    /**
     * casilla de texto para el turno de la cita
     */
    @FXML
    private TextField txtTurno;
    /**
     * boton con la accion de cancelar las operaciones que se esten realizando
     * @param event. es el evento de cancelar
     */
    @FXML
    void btnCancelarOnClicked(ActionEvent event) {
        limpiar();
    }
    /**
     * accion de registrar la cita al usuario consultado 
     * @param event evento de registrar cita al usuario
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        String codigo = String.valueOf(cbxCodigoCIta.getSelectionModel().getSelectedItem());
        String documento = String.valueOf(cbxDocumento.getSelectionModel().getSelectedItem());
        if(!codigo.isEmpty()){
            Cita nCita = new Cita(Integer.parseInt(codigo), dtaFecha.getValue().toString(), Integer.parseInt(txtTurno.getText()), txtLugar.getText());
            registrarCitaUsuario(nCita, documento);
        }else{
            Alertar.display("Registro", "El codigo es invalido");
        }
    }
    /**
     * boton para verificar la informacion del usuario y cita
     * @param event, evento de verificar la informacion
     */
    @FXML
    void btnVerificarOnClicked(ActionEvent event) {
        String documento = String.valueOf(cbxDocumento.getSelectionModel().getSelectedItem());
        if(!documento.isEmpty()){
            Usuario nUsuario = usuarioDAO.buscarUsuario(documento);
            if(nUsuario != null){
                String codigo = nUsuario.getCita();
                Cita nCita = citaDAO.buscarCita(codigo); 
                if(nUsuario != null){
                    actualizarElementosUsuario(nUsuario);
                    if(nCita != null){
                        actualizarElementosCita(nCita);
                    }else{
                        Alertar.display("Verificar", "El usuario no posee \n una cita asignada");
                    }
                }
            }else{
                Alertar.display("Verificar", "Seleccione un usuario");
            }
        }else{
            Alertar.display("Verificar", "Seleccione un usuario");
        }
    }
    /**
     * registrar cita a usuario
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se registra la cita y el codigo de cita al usuario
     * @param nCita, es la cita a registrar. nCita != "" && nCita != null
     * @param nDocumento, es el documento del usuario sin cita. nDocumento != "" && nDocumento != null
     */
    public void registrarCitaUsuario(Cita nCita, String nDocumento){
        Usuario buscar = usuarioDAO.buscarUsuario(nDocumento);
        Cita nBuscada = citaDAO.buscarCita(String.valueOf(nCita.getCodigo()));
        if(buscar != null){
            if(nBuscada == null){
                if(citaDAO.insertarCita(nCita)!=null){
                    if(usuarioDAO.actualizarUsuario(buscar, String.valueOf(nCita.getCodigo()))!=null){
                        Alertar.display("Registro", "La cita se registro");
                    }else{
                        Alertar.display("Registro", "No se actualizo la informacion del usuario");
                    }
                }else{
                    Alertar.display("Registrar", "La cita no se registro");
                }
            }else{
                Alertar.display("Registrar", "La cita se encuentra registrada \n intente con otro codigo de cita");
            }
        }else{
            Alertar.display("Registrar", "El usuario no existe");
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
     */
    public void actualizarElementosUsuario(Usuario nUsuario){
        txtApellido.setText(nUsuario.getApellido());
        txtCelular.setText(String.valueOf(nUsuario.getCelular()));
        txtCorreo.setText(nUsuario.getCorreo());
        txtDireccion.setText(nUsuario.getDireccion());
        txtNombre.setText(nUsuario.getNombre());
        cbxTipo.setValue(nUsuario.getTipo());
    }
    /**
     * actualizar los elementos de la interfaz con la informacion de cita
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se actualizan los elementos con la informacion de la cita
     */
    public void actualizarElementosCita(Cita nCita){
        txtLugar.setText(nCita.getLugar());
        txtTurno.setText(String.valueOf(nCita.getTurno()));
        dtaFecha.setValue(LocalDate.parse(nCita.getFecha()));
        cbxCodigoCIta.setValue(nCita.getCodigo());
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
        cbxCodigoCIta.setValue(null);
        dtaFecha.setValue(null);
        cbxDocumento.setValue(null);
        cbxTipo.setValue(null);
    }
    /**
     * agregar elementos a las combo box
     * <b> pre: </b> la lista de elementos se encuentra inicializada
     * <b> post: </b> se agrega el elemento a cada combo box
     */
    public void agregarElemento(){
        ObservableList<Integer> usuarios = usuarioDAO.usuariosSinCita();
        cbxDocumento.setItems(usuarios);
        ObservableList<Integer> citas = citaDAO.seleccionarCitas();
        cbxCodigoCIta.setItems(citas);
        cbxTipo.getItems().add("id");
        cbxTipo.getItems().add("otro");
        cbxTipo.getItems().add("cc");

    }
}