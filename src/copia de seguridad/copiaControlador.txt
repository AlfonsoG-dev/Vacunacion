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
        if(pass!=null && usuario!=null){
            if(miOperacion.buscarCuenta(miCuenta)!=false){
                
                JOptionPane.showMessageDialog(null, "Feliciataciones ingresaste");
            }else{
                
                JOptionPane.showMessageDialog(null, "la cuenta no se encuentra registrada");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los valores se encuentran mal registrados");
        }
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String pass = txtPasword.getText();
        if(miOperacion.buscarCuenta(miCuenta)==false){
            miOperacion.registrarCuenta(usuario, pass);
            JOptionPane.showMessageDialog(null, "Se registro al usuario" + usuario);

        }else{
            
            JOptionPane.showMessageDialog(null, "el usuario ya se encuentra registrado");
        }
    }
    public void limpiar(){
        txtUsuario.setText(null);
        txtPasword.setText(null);
    } 
}