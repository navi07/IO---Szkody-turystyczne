package Aplication.Controler;

import Aplication.Pracownik;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class WorkerGuiControler
{
    Pracownik pracownik = new Pracownik();

    @FXML
    private TextField textFieldId;
    public WorkerGuiControler() throws SQLException { }

    @FXML
    public void handleSprawdzTozsamoscKlienta() throws SQLException
    {
        String tozsamosc = pracownik.sprawdz_tozsamosc();
        textFieldId.setText(tozsamosc);
    }
    @FXML
    public void handleOdrzucZgloszenie() throws SQLException
    {
        pracownik.odrzuc_zgloszenie();
    }
}
