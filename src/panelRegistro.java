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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Mundo.Cita;
import Mundo.Usuario;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Conexion.CitaDAO;
import Conexion.UsuarioDAO;

public class panelRegistro implements Initializable{
    /**
     * estado del controlador panelRegistro
     */
    private Stage miStage;
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
     * boton con la obciones para 1) regresar al panelCita; 2) quedarse en panelRegistro 3)cancelar operacion o limpiar casillas
     * @param event. es el evento de cancelar
     */
    @FXML
    void btnCancelarOnClicked(ActionEvent event) {
        int resp=JOptionPane.showConfirmDialog(null,"Quieres regresar al panelCita");
        if(JOptionPane.OK_OPTION == resp){
            regresarCita();
        }else{
            limpiar();
        }
        
    }
    /**
     * accion de registrar la cita al usuario consultado 
     * @param event evento de registrar cita al usuario
     */
    @FXML
    void btnRegistrarOnClicked(ActionEvent event){
    }
    /**
     * boton para verificar la informacion del usuario y cita
     * @param event, evento de verificar la informacion
     */
    @FXML
    void btnVerificarOnClicked(ActionEvent event) {

    }
    /**
     * registrar el codigo de la cita al usuario
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se registra la cita y el codigo de cita al usuario
     * @param nCita, es la cita registrada para el usuario. nCita != "" && nCita != null
     * @param nUsuario, es el usuario a actualizar. nUsuario != "" && nUsuario != null
     */
    public Boolean registrarTodo(Usuario nUsuario, Cita nCita){
        Boolean registrar = false;

        return registrar;
    }
    /**
     * registrar cita enn la base de datos
     * <b> pre: </b> la cita se encuentra inicializada 
     * <b> post: </b> se registra la cita 
     * @param nCita, es la cita a registrar
     */
    public Boolean registrarCita(Cita nCita){
        Boolean registrar = false;
        return registrar;
    }
    /**
     * verificar que el usuario no tenga citas asignadas
     * <b> pre: </b> el usuario se encuentra inicializado
     * <b> post: </b> se verifica la informacion del usuario
     * @param nDocumento, es el documento del usuario a verificar. nDodumento != "" && nDocumento != null
     */
    public void verificarUsuario(String nDocumento){
        
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
        cbxDocumento.setValue(nUsuario.getDocumento());
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
    /**
     * metodo para regresar al panelCita cerrando panelRegistro
     * <br> pre: </br> panelCita se encuentra inicializado y panelRegistro esta abierto
     * <br> post: </br> panelRegistro se cierra y panelCita queda abierto
     */
    public void regresarCita(){
        try {
            //cargamos el archivo con la vista
            FXMLLoader root= new FXMLLoader(getClass().getResource("PanelCita.fxml"));    
            //creamos el estado del controlador
            Stage citaStage = new Stage();
            //creamos el padre de la vista
            Parent mio = root.load();
            // creamos un objeto del controlador de panelCita y le asignamos el controlador de la vista 
            panelCita mia = root.getController();
            //creamos la escena del controlador
            Scene scene = new Scene(mio);
            citaStage.setTitle("Vacunacion: Citas");
            //asignamos la escene al controlador de panelIngreso
            citaStage.setScene(scene);
            //visualizamos la interfaz creada
            citaStage.show();
            //asignamos el valor deseado al controlador panelCita, preferiblemente asignar un metodo que reciba valores
            //de panelIngreso y utilizarlo en panelCita
            //en este caso solo agrego elemento que es un metodo void que no necesita de parametros.
            mia.agregarElemento();
            //cirro panelIngreso
            this.miStage.close();
            mia.setStage(citaStage);

        } catch (Exception e) {
            Alertar.display("Error", e.getMessage());
        }
    }
    /**
     * metodo para obtener el estado de panelRegistro
     * <br> pre: </br> panelRegistro se encuentra inicializado
     * <br> post: </br> se obtine el estado de panelRegistro
     * @param registroStage, es el estado del controlador panelRegistro; registroStage != "" && registroStage != null
     */
    public void setStage(Stage registroStage) {
        miStage = registroStage;
    }
}