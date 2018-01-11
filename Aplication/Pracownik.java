package Aplication;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Pracownik extends Osoba
{
    private Zgloszenie zgloszenie = new Zgloszenie();
    private Klient klient = new Klient();
    private String nr_tel;
    private int id_prac;

    public Pracownik() throws SQLException {};

    public Pracownik(String imie, String nazwisko, String nr_tel) throws SQLException
    {
        super(imie, nazwisko);
        this.nr_tel = nr_tel;
    }

    public String sprawdz_tozsamosc() throws SQLException { return klient.pokaz_dane(); }

    public void odrzuc_zgloszenie() throws SQLException
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
    public void przyjmij_zgloszenie()
    {
        // operacja na bazie danych
    };

}
