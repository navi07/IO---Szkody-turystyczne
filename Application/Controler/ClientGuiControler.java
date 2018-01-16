package Application.Controler;

import Application.Model.Klient;
import Application.Model.Zgloszenie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ClientGuiControler
{
    Klient klient = new Klient();
    Zgloszenie zgloszenie = new Zgloszenie();
    public TextField textFieldInstertID;
    public TextArea textAreaId;

    public ClientGuiControler() throws SQLException {}

    @FXML
    public void handleSprawdzStatusZgloszenia(ActionEvent actionEvent) throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else
        {
            int id = Integer.parseInt(textFieldInstertID.getText());
            String status = zgloszenie.sprawdz_status(id);
            textAreaId.setText(status);
        }
    }

    public void handleSprawdzCzasPolisy(ActionEvent actionEvent) throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else
        {
            int id = Integer.parseInt(textFieldInstertID.getText());
            String czas_trwania = klient.sprawdz_czas_trwania_polisy(id);
            textAreaId.setText(czas_trwania);
        }
    }
}
