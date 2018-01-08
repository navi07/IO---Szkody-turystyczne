import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws SQLException {
        Scanner odczyt = new Scanner(System.in);
        int x;

        Polisa p1 = new Polisa(true,"ubezpieczniowa",2016,05,04,2017,05,04);
        Osoba o1 = new Osoba("Tester","Testowy");
        Klient k1 = new Klient("Klient", "Testowy", "98040705678", 1, 000000000);
        Pracownik prac1 = new Pracownik();

       do {
           System.out.println("Wybierz czynność : ");
           System.out.println("1. Zgloś szkodę jako klient");
           System.out.println("2. Edytuj zgłoszenie jako klient");
           System.out.println("3. Pokaz dane klienta");
           System.out.println("4. Pokaz czas trwania polisy");
           System.out.println("5. Wyświetl dane osoby");
           System.out.println("6. Zgloś szkodę jako klient");
           System.out.println("7. Odrzuć zgłoszenie");
           System.out.println("8. Wykonaj test (Czy osoba istnieje ?)");
           System.out.println("Wybierz czynność : ");
           x = odczyt.nextInt();
           switch (x) {
               case 1:
                   k1.zglos_szkode();
                   break;
               case 2:
                   k1.edytuj_zgloszenie();
                   break;
               case 3:
                   k1.pokaz_dane();
                   break;
               case 4:
                   p1.czas_trwania();
                   break;
               case 5:
                   o1.wyswietl();
                   break;
               case 6:
                   k1.zglos_szkode();
                   break;
               case 7:
                   prac1.odrzuc_zgloszenie();
                   break;
               case 8:
                   if (o1 != null)
                       System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
                   else
                       System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
                   break;
           }
       } while(x != 0);
    }
}

