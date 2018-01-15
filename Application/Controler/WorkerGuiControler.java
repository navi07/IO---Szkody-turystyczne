package Application.Controler;

import Application.Pracownik;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class WorkerGuiControler
{
    Pracownik pracownik = new Pracownik();

    @FXML
    public TextField textFieldId;
    public TextField textFieldInstertID;
    public TextField textFieldStatusId;
    public WorkerGuiControler() throws SQLException { }

    @FXML
    public void handleSprawdzTozsamoscKlienta() throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textFieldId.setText("Wprowadź ID !");
        else
        {
            int id = Integer.parseInt(textFieldInstertID.getText());
            String tozsamosc = pracownik.sprawdz_tozsamosc(id);
            textFieldId.setText(tozsamosc);
        }
    }
    @FXML
    public void handleOdrzucZgloszenie() throws SQLException
    {
        int id = Integer.parseInt(textFieldInstertID.getText());
        pracownik.odrzuc_zgloszenie(id);
        textFieldId.setText("Usunięto zgłoszenie o ID : "+id);
    }

    @FXML
    public void handlePrzyjmijZgloszenie() throws SQLException
    {
        int id = Integer.parseInt(textFieldInstertID.getText());
        boolean status = Boolean.parseBoolean(textFieldStatusId.getText());
        pracownik.przyjmij_zgloszenie(status,id);
    }
}
