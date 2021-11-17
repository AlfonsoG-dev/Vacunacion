import javax.swing.JOptionPane;

import Mundo.Operacion;
import Mundo.Cuenta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    @FXML
    void btnIngresarOnClicked(ActionEvent event) {
        String pass = txtPasword.getText();
        String usuario = txtUsuario.getText();
        miCuenta = new Cuenta(usuario, pass);
        if(pass!=null && usuario!=null){
            if(miOperacion.buscarCuenta(miCuenta)!=false){
                
                Alertar.display("Ingreso y registro", "Ingresaste");
                limpiar();
            }else{

                Alertar.display("Ingreso y registro", "El usuario se debe registrar");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los valores se encuentran mal registrados");
        }
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String pass = txtPasword.getText();
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
}