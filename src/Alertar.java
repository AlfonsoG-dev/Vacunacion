import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alertar {
    public static void display(String titulo, String mensaje){
        Stage windows = new Stage();
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setTitle(titulo);

        Label lblMensaje = new Label();
        lblMensaje.setText(mensaje);
        Button btnCerrar = new Button("Cerrar ventana");
        btnCerrar.setOnAction(e->windows.close());
        VBox layout = new VBox();
        layout.getChildren().addAll(lblMensaje, btnCerrar);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        windows.setScene(scene);
        windows.showAndWait();

    }    
}
