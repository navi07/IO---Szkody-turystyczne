import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Pracownik extends Osoba
{
    private Zgloszenie z = new Zgloszenie();
    private Klient k = new Klient();
    private int id_prac;
    private String nr_tel;

    Pracownik() throws SQLException {};

    Pracownik(String imie, String nazwisko, String nr_tel) throws SQLException {
        super(imie, nazwisko);
        this.nr_tel = nr_tel;
    }

    void sprawdz_tozsamosc() throws SQLException { k.pokaz_dane(); }

    void odrzuc_zgloszenie() throws SQLException
    {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Usuwanie zgloszenia\n Podaj id zgloszenia :");
        System.out.println("ID : ");
        int id_wpr = odczyt.nextInt();

        PreparedStatement prepStmt = con.prepareStatement(
                "DELETE FROM zgloszenie_szkody_turystycznej WHERE id = ?");
        prepStmt.setInt(1, id_wpr);
        prepStmt.executeUpdate();
    }
    void przyjmij_zgloszenie()
    {
        // operacja na bazie danych
    };

}
