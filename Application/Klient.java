package Application;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klient extends Osoba
{
    private String pesel;
    private int nr_ubezpieczenia;
    private int nr_tel;
    private Zgloszenie z = new Zgloszenie();
    private Polisa p;
    int id;
    private static int count;

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

    String pokaz_dane() throws SQLException
    {
        String tmp = new String();
        DBConnect connect =new DBConnect();
        ResultSet rs = connect.getData("select * from klienci");
        while(rs.next()){
            if(id == rs.getInt("ID"))
            {
                int ID=rs.getInt("ID");
                String imie= rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String adres_zamieszkania = rs.getString("adres_zamieszkania");
                int kod_pocztowy = rs.getInt("kod_pocztowy");
                String email = rs.getString("email");
                String numer_telefonu = rs.getString("numer_telefonu");
                String pesel = rs.getString("pesel");
                String seria_dowodu = rs.getString("seria_dowodu");
                tmp = new String(imie+" "+nazwisko+" "+pesel+" ID = "+ID+'\n'+tmp);
            }
        }
        return tmp;
    }

    public void zglos_szkode() throws SQLException { z.utworz(); }
    void edytuj_zgloszenie() throws SQLException {z.edytuj();}
    void sprawdz_status_zgloszenia()
    {
        z.sprawdz_status();
    }
    void sprawdz_czas_trwania_polisy()
    {
        p.czas_trwania();
    }
}
