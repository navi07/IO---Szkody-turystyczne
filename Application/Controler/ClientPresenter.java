package Application.Controler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ClientPresenter
{
    private Stage primaryStage;

    public ClientPresenter(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show()
    {
        try {
            // load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getClassLoader().getResource("Application/Resources/ClientGui.fxml"));
            Parent rootLayout = loader.load();

            // add layout to a scene and show them all
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(false);
            primaryStage.show();

        } catch (IOException e)
        {
            // don't do this in common apps
            e.printStackTrace();
        }
    }
}
