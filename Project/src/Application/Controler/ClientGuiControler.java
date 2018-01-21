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
            textAreaId.setText("Wprowadź ID zgłoszenia !");
        else
        {
            try
            {
                int id = Integer.parseInt(textFieldInstertID.getText());
                String status = zgloszenie.sprawdz_status(id);
                textAreaId.setText(status);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }
    }

    public void handleSprawdzCzasPolisy(ActionEvent actionEvent) throws SQLException
    {
        if (textFieldInstertIDPolisy.getText().equals(""))
            textAreaId.setText("Wprowadź ID polisy !");
        else
        {
            try
            {
                int id = Integer.parseInt(textFieldInstertIDPolisy.getText());
                String czas_trwania = klient.sprawdz_czas_trwania_polisy(id);
                textAreaId.setText(czas_trwania);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }
    }

    public void handleZglosSzkode(ActionEvent actionEvent) throws SQLException
    {
        if (textFieldOplataPolisy.getText().equals("") ||
                ChoiceBoxID.getSelectionModel().isEmpty() ||
                textFieldInstertIDPolisy.getText().equals("") ||
                (DatePickerID.getValue().equals(null)))
            textAreaId.setText("Wprowadź wszystkie dane !");
        else
        {
            try
            {
                String opis = (String) ChoiceBoxID.getValue();
                Double oplata = Double.valueOf(textFieldOplataPolisy.getText());
                int d = (DatePickerID.getValue().getDayOfMonth());
                int m = (DatePickerID.getValue().getMonthValue());
                int r = (DatePickerID.getValue().getYear());
                int id_polisy = Integer.valueOf(textFieldInstertIDPolisy.getText());

                klient.zglos_szkode(opis, oplata, id_polisy, d, m, r);
                textAreaId.setText("Utworzono zgłoszenie : \nOpis : " + opis + "\nOplata : " + oplata + " Zł \nData : " + d + "." + m + "." + r + "\nID polisy : " + id_polisy);
            }
            catch (NumberFormatException e)
            {
                textAreaId.setText("Wprowadzono nieprawidłową wartość !");
            }
        }

    }

    public void handleEdytujZglosznie(ActionEvent actionEvent) throws SQLException
        {
            if (textFieldInstertID.getText().equals("") ||
                    ChoiceBoxID.getSelectionModel().isEmpty() ||
                    textFieldOplataPolisy.getText().equals("") ||
                    textFieldInstertIDPolisy.getText().equals("") ||
                    (DatePickerID.getValue().equals(null)))
                textAreaId.setText("Wprowadź wszystkie dane !");
            else
            {
                try
                {
                    int id = Integer.valueOf(textFieldInstertID.getText());
                    String opis = (String) ChoiceBoxID.getValue();
                    Double oplata = Double.valueOf(textFieldOplataPolisy.getText());
                    int d = (DatePickerID.getValue().getDayOfMonth());
                    int m = (DatePickerID.getValue().getMonthValue());
                    int r = (DatePickerID.getValue().getYear());
                    int id_polisy = Integer.valueOf(textFieldInstertIDPolisy.getText());

                    klient.edytuj_zgloszenie(id, opis, oplata, id_polisy, d, m, r);
                    textAreaId.setText("Edytowano zgłoszenie : \nOpis : " + opis + "\nOplata : " + oplata + " Zł \nData : " + d + "." + m + "." + r + "\nID polisy : " + id_polisy);
                }
                catch (NumberFormatException e)
                {
                    textAreaId.setText("Wprowadzono nieprawidłową wartość !");
                }
            }
        }

    public void handlePokazMojeZgloszenia() throws SQLException
    {
        if (textFieldInstertID.getText().equals(""))
            textAreaId.setText("Wprowadź swoje ID aby obejrzeć własne zgłoszenia !");
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
                textAreaId.setText("Wprowadzono nieprawidłową wartość ! ");
            }
        }
    }

    public void handleWyjdzAction() { System.exit(0); }

}
