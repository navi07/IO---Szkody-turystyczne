import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException {
        Osoba o1 = new Osoba("Tester","Testowy");
        o1.wyswietl();

        Polisa p1 = new Polisa(true,"ubezpieczniowa",2016,05,04,2017,05,04);
        p1.czas_trwania();
        
        Klient k1 = new Klient("Klient", "Testowy", "98040705678", 1, 000000000);

        k1.pokaz_dane();
        k1.zglos_szkode();

        if(o1 != null)
            System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
        else
            System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
    }
}

