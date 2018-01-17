package Application.Controler;

import Application.Klient;
import Application.Zgloszenie;
import com.mysql.fabric.xmlrpc.Client;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ClientGuiControler {
    Klient klient = new Klient();
    Zgloszenie zgloszenie = new Zgloszenie();
    public TextField textFieldInstertID;
    public TextArea textAreaId;
    public TextField textFieldD;
    public TextField textFieldM;
    public TextField textFieldR;
    public TextField textFieldOpis;
    public TextField textFieldOplataPolisy;
    public ChoiceBox ChoicekBoxID;
    //http://www.java2s.com/Tutorials/Java/javafx.scene.control/ChoiceBox/0320__ChoiceBox.setValue_T_value_.htm
    ObservableList<String>ChoicekBoxList= FXCollections.observableArrayList("szkody");
    @FXML
    public TextField textFieldSprawdzStatusZgloszeniaID;
    public ClientGuiControler() throws SQLException {
    }

    @FXML

    public void handleSprawdzStatusZgloszenia(ActionEvent actionEvent) throws SQLException {

        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else {
            int id = Integer.parseInt(textFieldInstertID.getText());
            String status = zgloszenie.sprawdz_status(id);
            textAreaId.setText(status);
        }
    }

    public void handleSprawdzCzasPolisy(ActionEvent actionEvent) throws SQLException {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else {
            int id = Integer.parseInt(textFieldInstertID.getText());
            String czas_trwania = klient.sprawdz_czas_trwania_polisy(id);
            textAreaId.setText(czas_trwania);
        }
    }
    public void handleZglosSzkode(ActionEvent actionEvent) throws SQLException {
        if (textFieldOpis.getText().equals("") &&
                textFieldOplataPolisy.getText().equals("") &&
                textFieldD.getText().equals("") &&
                textFieldM.getText().equals("") &&
                textFieldR.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else {
            String opis = textFieldOpis.getText();
            Double oplata = Double.valueOf(textFieldOplataPolisy.getText());
            int d = Integer.valueOf(textFieldD.getText());
            int m = Integer.valueOf(textFieldM.getText());
            int r = Integer.valueOf(textFieldR.getText());
            int id_polisy = 1;

            klient.zglos_szkode(opis, oplata, id_polisy, d, m, r);
        }
    }
        public void handleEdytujZglosznie(ActionEvent actionEvent) throws SQLException {
            if (textFieldInstertID.getText().equals("") &&
                    textFieldOpis.getText().equals("") &&
                    textFieldOplataPolisy.getText().equals("") &&
                    textFieldD.getText().equals("") &&
                    textFieldM.getText().equals("") &&
                    textFieldR.getText().equals(""))
                textAreaId.setText("Wprowadź wszystkie dane !");
            else {

                int id = Integer.valueOf(textFieldInstertID.getText());
                String opis = textFieldOpis.getText();
                Double oplata = Double.valueOf(textFieldOplataPolisy.getText());
                int d = Integer.valueOf(textFieldD.getText());
                int m = Integer.valueOf(textFieldM.getText());
                int r = Integer.valueOf(textFieldR.getText());
                int id_polisy = 1;

                klient.edytuj_zgloszenie(id, opis, oplata, id_polisy, d, m, r);
            }
        }
}
