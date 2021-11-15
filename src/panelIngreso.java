import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class panelIngreso {

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
        limpiar();
    }

    @FXML
    void btnRegistrarOnClicked(ActionEvent event) {

    }
    public void limpiar(){
        txtUsuario.setText(null);
        txtPasword.setText(null);
    }

}
