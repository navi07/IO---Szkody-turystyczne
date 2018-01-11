package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

import Application.Controler.WorkerGuiControler;

public class Klient extends Osoba
{
    private String pesel;
    private String seria_dowodu;
    private String adres_zamieszkania;
    private String email;
    private String numer_telefonu;
    private int kod_pocztowy;
    private int nr_ubezpieczenia;
    private int nr_tel;

    private Zgloszenie zgloszenie = new Zgloszenie();
    private Polisa polisa;

    private static int count;
    int id;

    Klient()throws SQLException
    {
        count++;
        id = count;
    }

    public Klient(String imie, String nazwisko, String pesel, int nr_ubezpieczenia, int nr_tel) throws SQLException
    {
        super(imie, nazwisko);
        this.pesel = pesel;
        this.nr_ubezpieczenia = nr_ubezpieczenia;
        this.nr_tel = nr_tel;
        count++;
        id = count;
    }

    String pokaz_dane(int id) throws SQLException
    {
        String tmp = new String();
        DBConnect connect =new DBConnect();
        ResultSet rs = connect.getData("select * from klienci");

        while(rs.next()){
            if(id == rs.getInt("ID"))
            {
                int ID = rs.getInt("ID");
                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                adres_zamieszkania = rs.getString("adres_zamieszkania");
                kod_pocztowy = rs.getInt("kod_pocztowy");
                email = rs.getString(   "email");
                numer_telefonu = rs.getString("numer_telefonu");
                pesel = rs.getString("pesel");
                seria_dowodu = rs.getString("seria_dowodu");
                tmp = new String(imie+" "+nazwisko+" "+pesel+" ID = "+ID+'\n'+tmp);
            }
        }
        return tmp;
    }

    public void zglos_szkode() throws SQLException { zgloszenie.utworz(); }
    void edytuj_zgloszenie() throws SQLException { zgloszenie.edytuj();}
    void sprawdz_status_zgloszenia()
    {
        zgloszenie.sprawdz_status();
    }
    void sprawdz_czas_trwania_polisy()
    {
        polisa.czas_trwania();
    }
}
