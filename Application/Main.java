package Application;

import Application.Controler.View;
import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.SQLException;

public class Main extends Application
{
    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException
    {
        /*
        Scanner odczyt = new Scanner(System.in);
        int x;

        Application.Polisa p1 = new Application.Polisa(true,"ubezpieczniowa",2016,05,04,2017,05,04);
        Application.Osoba o1 = new Application.Osoba("Tester","Testowy");
        Application.Klient k1 = new Application.Klient("Application.Klient", "Testowy", "98040705678", 1, 000000000);
        Application.Pracownik prac1 = new Application.Pracownik();
        Application.Zgloszenie z1 = new Application.Zgloszenie();
        Application.Ubezpieczenie u1 = new Application.Ubezpieczenie();

       do
       {
           System.out.println("Wybierz czynność : ");
           System.out.println("1. Zgloś szkodę jako klient");
           System.out.println("2. Edytuj zgłoszenie jako klient");
           System.out.println("3. Pokaz dane klienta");
           System.out.println("4. Pokaz czas trwania polisy");
           System.out.println("5. Wyświetl dane osoby");
           System.out.println("6. Zgloś szkodę jako klient");
           System.out.println("7. Odrzuć zgłoszenie");
           System.out.println("8. Wykonaj test klasy Application.Osoba");
           System.out.println("9. Wykonaj test klasy Application.Klient");
           System.out.println("10. Wykonaj test klasy Application.Polisa");
           System.out.println("11. Wykonaj test klasy Application.Pracownik");
           System.out.println("12. Wykonaj test klasy Application.Zgloszenie");
           System.out.println("13. Wykonaj test klasy Application.Ubezpieczenie");
           System.out.println("Wybierz czynność : ");
           x = odczyt.nextInt();
           switch (x)
           {
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
               case 9:
                   if (k1 != null)
                       System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
                   else
                       System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
                   break;
               case 10:
                   if (p1 != null)
                       System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
                   else
                       System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
                   break;
               case 11:
                   if (prac1 != null)
                       System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
                   else
                       System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
                   break;
               case 12:
                   if (z1 != null)
                       System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
                   else
                       System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
                   break;
               case 13:
                   if (u1 != null)
                       System.out.println("Obiekt istnieje. Test wykonany pomyslnie ");
                   else
                       System.out.println("Obiekt nie istnieje. Test wykonany negatywnie ");
                   break;
           }
       } while(x != 0);
       */
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Zgłaszanie szkód turystycznych");
        View view = new View(primaryStage);
        view.init();
    }
}