package Application;

import Application.Controler.View;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.SQLException;

public class Main extends Application
{
    public Main() throws SQLException {}

    public static void main(String[] args) throws SQLException { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Zgłaszanie szkód turystycznych");
        View view = new View(primaryStage);
        view.init();
    }
}