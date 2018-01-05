import java.sql.*;

public class Klient extends Osoba
{
    private String pesel;
    private int nr_tel;
    private int nr_ubezpieczenia;
    private Zgloszenie z;
    private Polisa p;
    int id;
    private static int count;
    
    public Klient(String imie, String nazwisko, String pesel, int nr_ubezpieczenia, int nr_tel)
    {
        super(imie, nazwisko);
        this.pesel = pesel;
        this.nr_ubezpieczenia = nr_ubezpieczenia;
        this.nr_tel = nr_tel;
        count++;
        id = count;
    }
    
    void pokaz_dane() throws SQLException
    {
    	 DBConnect connect =new DBConnect();
         try (ResultSet rs = connect.getData("select * from klienci"))
         {
            while (rs.next())
            {
                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                pesel = rs.getString("pesel");
                nr_tel = rs.getInt("numer_telefonu");
            }
        }
        System.out.println(imie+" "+nazwisko+" "+pesel+" "+nr_ubezpieczenia+" "+nr_tel+" "+id);
    }
    
    void zglos_szkode()
    {
        
    } // uzupelnic
    
    void sprawdz_status_zgloszenia()
    {
       z.sprawdz_status();
    }
    
    void sprawdz_czas_trwania_polisy()
    {
        p.czas_trwania();
    }
}


