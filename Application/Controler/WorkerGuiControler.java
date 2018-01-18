package Application.Controler;

import Application.Pracownik;
import Application.Zgloszenie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

public class WorkerGuiControler
{
    Pracownik pracownik = new Pracownik();
    Zgloszenie zgloszenie = new Zgloszenie();

    @FXML
    public TextField textFieldInstertID;
    public TextArea textAreaId;
    public WorkerGuiControler() throws SQLException { }

    @FXML
    public void handleSprawdzTozsamoscKlienta() throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else
        {
            int id = Integer.parseInt(textFieldInstertID.getText());
            String tozsamosc = pracownik.sprawdz_tozsamosc(id);
            textAreaId.setText(tozsamosc);
        }
    }
    @FXML
    public void handleOdrzucZgloszenie() throws SQLException
    {
        int id = Integer.parseInt(textFieldInstertID.getText());
        pracownik.odrzuc_zgloszenie(id);
        textAreaId.setText("Usunięto zgłoszenie o ID : "+id);
    }

    @FXML
    public void handlePrzyjmijZgloszenie() throws SQLException
    {
        textAreaId.setText(zgloszenie.pokaz_zgloszenia_niezatwierdzone() + "\n Wpisz ID zgloszenia aby je zatwierdzić");
        if (textFieldInstertID.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wprowadź ID");
            alert.show();
        }
        else
        {
            int id = Integer.parseInt(textFieldInstertID.getText());
            pracownik.przyjmij_zgloszenie(id);
        }
    }

    @FXML
    public void handlePrzegladajZgloszenia() throws SQLException
    {
        textAreaId.setText(zgloszenie.pokaz_zgloszenia_wszystkie());
    }
}
