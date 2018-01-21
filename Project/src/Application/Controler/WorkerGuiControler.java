package Application.Controler;

import Application.Model.Pracownik;
import Application.Model.Zgloszenie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class WorkerGuiControler
{
    Pracownik pracownik = new Pracownik();
    Zgloszenie zgloszenie = new Zgloszenie();


    @FXML
    public TextField textFieldInstertID;
    public TextArea textAreaId;
    public WorkerGuiControler() throws SQLException {}

    @FXML
    public void handleSprawdzTozsamoscKlienta() throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else
        {
            try
            {
                int id = Integer.parseInt(textFieldInstertID.getText());
                String tozsamosc = pracownik.sprawdz_tozsamosc(id);
                textAreaId.setText(tozsamosc);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }
    }
    @FXML
    public void handleOdrzucZgloszenie() throws SQLException
    {
        textAreaId.setText(zgloszenie.pokaz_zgloszenia_wszystkie() + "\n Wpisz ID zgloszenia aby je usunąć");
        if (textFieldInstertID.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wprowadź ID zgłoszenia aby je usunąć");
            alert.show();
        }
        else
        {
            try
            {
                int id = Integer.parseInt(textFieldInstertID.getText());
                pracownik.odrzuc_zgloszenie(id);
                textAreaId.setText("Usunięto zgłoszenie o ID : " + id);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }
    }

    @FXML
    public void handlePrzyjmijZgloszenie() throws SQLException
    {
        textAreaId.setText(zgloszenie.pokaz_zgloszenia_niezatwierdzone() + "\n Wpisz ID zgloszenia aby je zatwierdzić");
        if (textFieldInstertID.getText().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wprowadź ID zgłoszenia aby je przyjąć");
            alert.show();
        }
        else
        {
            try
            {
                int id = Integer.parseInt(textFieldInstertID.getText());
                pracownik.przyjmij_zgloszenie(id);
                textAreaId.setText("Przyjęto zgłoszenie o ID : " + id);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }
    }

    @FXML
    public void handlePrzegladajZgloszenia() throws SQLException
    {
        textAreaId.setText(zgloszenie.pokaz_zgloszenia_wszystkie());
    }

    public void handlePokazZgloszeniaKlienta() throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID klienta aby obejrzeć jego zgłoszenia !");
        else
        {
            try
            {
                int id = Integer.parseInt(textFieldInstertID.getText());
                String zgloszenia = zgloszenie.pokaz_zgloszenia_klienta(id);
                textAreaId.setText(zgloszenia);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }
    }

    public void handleWyjdzAction() { System.exit(0); }
}
