package Application.Controler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class View
{
    private Stage primaryStage;

    public View(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void init()
    {
        try {
            // load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getClassLoader().getResource("Application/Resources/Gui.fxml"));
            AnchorPane rootLayout = (AnchorPane)loader.load();

            GuiControler guiControler = loader.getController();
            guiControler.setWorkerPresenter(new WorkerPresenter(primaryStage));
            guiControler.setClientPresenter(new ClientPresenter(primaryStage));

            // add layout to a scene and show them all
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setMaximized(false);
            primaryStage.show();

        } catch (IOException e)
        {
            // don't do this in common apps
            e.printStackTrace();
        }
    }



}