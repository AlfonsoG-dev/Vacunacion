import Mundo.Operacion;
import Mundo.Cuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class panelIngreso {
    /**
     * clase de tipo operacion
     */
    Operacion miOperacion = new Operacion();
    /**
     * clase de tipo cuenta
     */
    Cuenta miCuenta;
    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistro;

    @FXML
    private Label lblPasword;

    @FXML
    private Label lblUsuarioL;

    @FXML
    private PasswordField txtPasword;

    @FXML
    private TextField txtUsuario;
    private String usuario;
    private String pass;
    private Parent root;
    @FXML
    void btnIngresarOnClicked(ActionEvent event) {
        entrarCita();
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        usuario = txtUsuario.getText();
        pass = txtPasword.getText();
        miCuenta = new Cuenta(usuario, pass);
        if(miOperacion.buscarCuenta(miCuenta)==false){
            miOperacion.registrarCuenta(usuario, pass);
            Alertar.display("Ingreso y registro", "Se registro el usuario");
            limpiar();

        }else{
            
            Alertar.display("Ingreso y registro", "El usuario se encuentra registrado");
        }
    }
    /**
     * limpiar las casillas de texto de la pantalla
     */
    public void limpiar(){
        txtUsuario.setText(null);
        txtPasword.setText(null);
    } 
    /**
     * start la segunda ventana
     */
    public void entrarCita(){
        try {
            root= FXMLLoader.load(getClass().getResource("PanelCita.fxml"));    
            Stage citaStage = new Stage();
            Scene scene = new Scene(root);
            citaStage.setTitle("Loggin");
            citaStage.setScene(scene);
            citaStage.showAndWait();
        } catch (Exception e) {
            Alertar.display("Error", e.getMessage());
        }
    }
}