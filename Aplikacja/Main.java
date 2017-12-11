public class Main
{
    public static void main(String[] args)
    {
        Osoba o1 = new Osoba("Tester","Testowy");
        o1.wyswietl();

        if(o1 != null)
            System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
        else
            System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
    }
}

