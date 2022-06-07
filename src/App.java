import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 /**
  * Clase grafica con java fx
  */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) { 
        try {
            FXMLLoader mio = new FXMLLoader(getClass().getResource("PanelLogin.fxml"));    
            Parent root = mio.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Loggin");
            primaryStage.setScene(scene);
            panelIngreso ingreso = mio.getController();
            ingreso.setStage(primaryStage);
            primaryStage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar llamar la interfaz: " + e.getMessage());
        }
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}