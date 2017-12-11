public class Main
{
    public static void main(String[] args)
    {
        Osoba o1 = new Osoba("Tester","Testowy");
        o1.wyswietl();

        Polisa p1 = new Polisa(true,"ubezpieczniowa");
        p1.czas_trwania();

        if(o1 != null)
            System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
        else
            System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
    }
}

