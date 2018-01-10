import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class WorkerGuiControler
{
    Pracownik pracownik = new Pracownik();

    public WorkerGuiControler() throws SQLException {
    }

    @FXML
    public void handleSprawdzTozsamoscKlienta() throws SQLException {
        pracownik.sprawdz_tozsamosc();
    }
    @FXML
    public void handleOdrzucZgloszenie() throws SQLException {
        pracownik.odrzuc_zgloszenie();
    }
}
