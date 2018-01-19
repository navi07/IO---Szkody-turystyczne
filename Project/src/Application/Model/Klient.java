package Application.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    private Polisa polisa = new Polisa();

    private static int count;
    int id;

   public Klient()throws SQLException
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
        boolean istnieje = false;
        String tmp = new String();
        DBConnect connect = new DBConnect();
        ResultSet rs = connect.getData("select * from klienci");

        while(rs.next())
        {
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
                tmp = new String("Imie : "+imie+"\nNazwisko : "+nazwisko+"\nPesel : "+pesel+"\nID = "+ID+'\n'+tmp);
                istnieje = true;
            }
        }
        if (istnieje) return tmp;
        else return new String("Podany klient nie istnieje !");
    }

    public void zglos_szkode(String opis,Double oplata,Integer id_polisy,Integer d_z,Integer m_z,Integer r_z) throws SQLException
    { zgloszenie.utworz(opis,oplata,id_polisy,d_z,m_z, r_z); }

    public void edytuj_zgloszenie(Integer id, String opis,Double oplata,Integer id_polisy,Integer d_z,Integer m_z,Integer r_z) throws SQLException
    { zgloszenie.edytuj(id,opis,oplata,id_polisy,d_z,m_z, r_z); }

    void sprawdz_status_zgloszenia() throws SQLException { zgloszenie.sprawdz_status(id); }

    public String sprawdz_czas_trwania_polisy(int id) throws SQLException { return polisa.czas_trwania(id); }
}
