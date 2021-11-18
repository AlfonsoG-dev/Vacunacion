import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Conexion.Conectar;
import Conexion.CitaDAO;
import Conexion.UsuarioDAO;
import Mundo.Cita;

public class panelCita implements Initializable{

    /**
     * cita del usuario
     */
    Cita miCita;
    /**
     * conexion con la base de datos
     */
    Conectar miConexion = new Conectar();
    /**
     * clase cita con las operaciones de la base de datos
     */
    CitaDAO miCitaDAO = new CitaDAO();
    /**
     * clase para las operaciones con usuario
     */
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnVolver;

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
    private TextField txtUsuario;

    @FXML   
    void btnConsultarOnClicked(ActionEvent event) {
        buscar();
    }

    @FXML
    void btnEliminarOnClicked(ActionEvent event) {
       eliminar(txtCodigo.getText());
    }

    @FXML
    void btnModificarOnClicked(ActionEvent event) {
        String codigo = txtCodigo.getText();
        String fecha = dtaFecha.getValue().toString();
        String turno = txtTurno.getText();
        String lugar = txtLugar.getText();
        Cita nueva = new Cita(Integer.parseInt(codigo), fecha, Integer.parseInt(turno), lugar);
        if(miCitaDAO.modificarCita(nueva)!=null){
            Alertar.display("Modificar", "Se modifico la cita");
        }
        else{
            Alertar.display("Modificar", "No se modifco la cita");
        }
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        registrar();
    }
    @FXML
    void btnVolverOnClicked(ActionEvent event) {
        limpiar();
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
    }
    /**
     * verificar los campos a digitar
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se verifican los campos
     */
    public void verificarCampos(){
        if(txtUsuario.getText() == null || txtUsuario.getText() == ""){
            Alertar.display("Verificar", "Verificar usuario");
        }else if(txtCodigo.getText() == null || txtCodigo.getText() == ""){
            Alertar.display("verificar", "Verificar codigo");
        }else if(dtaFecha.getValue().toString() == null || dtaFecha.getValue().toString() == ""){
            Alertar.display("Verificar", "Verificar fecha");
        }
        else if(txtTurno.getText() == null || txtTurno.getText() == ""){
            Alertar.display("verificar", "Verificar turno");
        }        
    }
    /**
     * actualizar los valores de los campos
     * <b> pre: </b> los elementos de la interfaz se encuentran inicializados
     * <b> post: </b> se actualizan los elementos
     */
    public void actualizarCampos(Cita c){
        txtCodigo.setText(String.valueOf(c.getCodigo()));
        txtLugar.setText(c.getLugar());
        txtTurno.setText(String.valueOf(c.getTurno()));
        dtaFecha.setValue(LocalDate.parse(c.getFecha()));
    }
    /**
     * buscar la cita del usuario dado el numero de documento del usuario
     * <b> pre: </b> los metodos se encuentran inicializados
     * <b> post: </b> se busca la cita del usuario
     */
    public void buscar(){
        int codigo = usuarioDAO.codigoCitaUsuario(txtUsuario.getText());
        if(codigo>0){
            if(miCitaDAO.buscarCita(String.valueOf(codigo))!=null){
                verificarElemento(miCitaDAO.buscarCita(String.valueOf(codigo)));
                actualizarCampos(miCitaDAO.buscarCita(String.valueOf(codigo)));
            }
            else{
                Alertar.display("Error", "Cita incorrecta");
            }
        }else{
            Alertar.display("Error", "Codigo igual a cero");
        }
    }
    /**
     * se registra la cita a la base de datos, no pueden haber 2 citas con el mismo codigo
     * <b> pre: </b> los metodos se encuentran inicializados
     * <b> post: </b> se registra la cita 
     */
    public void registrar(){
        try{
            Cita registrar = new Cita(Integer.parseInt(txtCodigo.getText()), dtaFecha.getValue().toString(), Integer.parseInt(txtTurno.getText()), txtLugar.getText());
            if(miCitaDAO.buscarCita(txtCodigo.getText())==null){
                miCitaDAO.insertarCita(registrar);
                Alertar.display("Felicidades", "Se registro la cita con exito");
            }else{
                Alertar.display("Error", "se encuentra registrada");
            }
        }catch(Exception e){
            Alertar.display("Error", e.getMessage());
        }
    }
    /**
     * elimina la cita de la base de datos y el usuario tiene como cita 0
     * <b> pre: </b> los metodos se encuentran inicializados
     * <b> post: </b> se elimino la cita
    */
    public void eliminar(String codigo){
        try{
            buscar();
            Cita bb = miCitaDAO.buscarCita(codigo);
            Boolean eliminada = miCitaDAO.eliminarCita(bb);
            if(eliminada != false){
                limpiar();
                tblCitas.getItems().remove(bb);
                Alertar.display("Eliminar", "Se elimino la cita");
            }else{
                Alertar.display("Error", "Se elimino la cita del usuario");
            }
        }catch(Exception e){
            Alertar.display("Error", e.getMessage());
        }
    }
    /**
     * verificar si el elemento esta o no en la tabla
     */
    public Boolean verificarElemento(Cita nCita){
        Boolean v = false;
        if(tblCitas.getItems().contains(nCita)==false){
            tblCitas.getItems().add(nCita);
            v = true;
        }else if(tblCitas.getItems().contains(nCita)!=false){
            Alertar.display("Añadir", "El elemento \n se encuentra registrado");
        }
        return v;
    }
    /**
     * limpiar las casillas de texto 
     * <b> pre: </b> los elementos se encuentran inicializados
     * <b> post: </b> se limpian los elementos
     */
    public void limpiar(){
        txtCodigo.setText(null);
        txtLugar.setText(null);
        txtTurno.setText(null);
        txtUsuario.setText(null);
        dtaFecha.setValue(null);
    }
}