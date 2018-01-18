package Application.Controler;

import Application.Model.Klient;
import Application.Model.Zgloszenie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Calendar;

public class ClientGuiControler 
{
    Klient klient = new Klient();
    Zgloszenie zgloszenie = new Zgloszenie();
    public TextArea textAreaId;
    public TextField textFieldOplataPolisy;
    public TextField textFieldInstertID;
    public TextField textFieldInstertIDPolisy;
    public ChoiceBox ChoiceBoxID;
    public DatePicker DatePickerID;
    ObservableList<String> RodzajeSzkod = FXCollections.observableArrayList("Szkoda w hotelu", "Opóźnienie", "Kradzież", "Zaginięcie bagażu", "Uszkodzenie bagażu", "Odwołanie podróży");

    public ClientGuiControler() throws SQLException {}

    @FXML
    public void initialize() { ChoiceBoxID.setItems(RodzajeSzkod); }

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
        if (textFieldInstertIDPolisy.getText().equals(""))
            textAreaId.setText("Wprowadź ID !");
        else
        {
            int id = Integer.parseInt(textFieldInstertIDPolisy.getText());
            String czas_trwania = klient.sprawdz_czas_trwania_polisy(id);
            textAreaId.setText(czas_trwania);
        }
    }
    public void handleZglosSzkode(ActionEvent actionEvent) throws SQLException
    {
        if (ChoiceBoxID.getValue().equals("") ||
                textFieldOplataPolisy.getText().equals("") ||
                textFieldInstertIDPolisy.getText().equals("") ||
                (DatePickerID.getValue().equals(null)))
            textAreaId.setText("Wprowadź wszystkie dane !");
        else
        {
            String opis = (String)ChoiceBoxID.getValue();
            Double oplata = Double.valueOf(textFieldOplataPolisy.getText());
            int d = (DatePickerID.getValue().getDayOfMonth());
            int m = (DatePickerID.getValue().getMonthValue());
            int r = (DatePickerID.getValue().getYear());
            int id_polisy = Integer.valueOf(textFieldInstertIDPolisy.getText());

            klient.zglos_szkode(opis, oplata, id_polisy, d, m, r);
            textAreaId.setText("Edytowano zgłoszenie : \n Opis : " + opis + "\n Oplata : " + oplata + " Zł \n Data : " + d + "." + m + "." + r + "\n ID polisy : " + id_polisy);
        }
    }
        public void handleEdytujZglosznie(ActionEvent actionEvent) throws SQLException
        {
            if (textFieldInstertID.getText().equals("") ||
                    ChoiceBoxID.getValue().equals("") ||
                    textFieldOplataPolisy.getText().equals("") ||
                    textFieldInstertIDPolisy.getText().equals("") ||
                    (DatePickerID.getValue().equals(null)))
                textAreaId.setText("Wprowadź wszystkie dane !");
            else
            {
                int id = Integer.valueOf(textFieldInstertID.getText());
                String opis = (String)ChoiceBoxID.getValue();
                Double oplata = Double.valueOf(textFieldOplataPolisy.getText());
                int d = (DatePickerID.getValue().getDayOfMonth());
                int m = (DatePickerID.getValue().getMonthValue());
                int r = (DatePickerID.getValue().getYear());
                int id_polisy = Integer.valueOf(textFieldInstertIDPolisy.getText());

                klient.edytuj_zgloszenie(id, opis, oplata, id_polisy, d, m, r);
                textAreaId.setText("Edytowano zgłoszenie : \n Opis : " + opis + "\n Oplata : " + oplata + " Zł \n Data : " + d + "." + m + "." + r + "\n ID polisy : " + id_polisy);
            }
        }

        public void handlePokazMojeZgloszenia() throws SQLException
        {
            if (textFieldInstertID.getText().equals(""))
                textAreaId.setText("Wprowadź swoje ID aby obejrzeć własne zgłoszenia !");
            else
            {
                int id = Integer.parseInt(textFieldInstertID.getText());
                String zgloszenia = zgloszenie.pokaz_zgloszenia_klienta(id);
                textAreaId.setText(zgloszenia);
            }
        }

}
