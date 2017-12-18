public class Main
{
    public static void main(String[] args)
    {
        Osoba o1 = new Osoba("Tester","Testowy");
        o1.wyswietl();

        Polisa p1 = new Polisa(true,"ubezpieczniowa",2016,05,04,2017,05,04);
        p1.czas_trwania();
        
        Klient k1 = new Klient("Klient", "Testowy", "98040705678", 1);
        Klient k2 = new Klient("Klient_2", "Testowy_2", "99040705678", 2);
        
        k1.pokaz_dane();
        k2.pokaz_dane();

        if(o1 != null)
            System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
        else
            System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
    }
}

