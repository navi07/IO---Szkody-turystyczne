package Application.Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pracownik extends Osoba
{
    private Zgloszenie zgloszenie = new Zgloszenie();
    private Klient klient = new Klient();
    private String nr_tel;

    public Pracownik() throws SQLException {}

    public Pracownik(String imie, String nazwisko, String nr_tel) throws SQLException
    {
        super(imie, nazwisko);
        this.nr_tel = nr_tel;
    }

    public String sprawdz_tozsamosc(int id) throws SQLException { return klient.pokaz_dane(id); }

    public void odrzuc_zgloszenie(int id) throws SQLException
    {
        PreparedStatement prepStmt = con.prepareStatement(
                "DELETE FROM zgloszenie_szkody_turystycznej WHERE id = ?");
        prepStmt.setInt(1, id);
        prepStmt.executeUpdate();
    }
    public void przyjmij_zgloszenie(int id) throws SQLException
    {
        PreparedStatement prepStmt = con.prepareStatement(
                "UPDATE zgloszenie_szkody_turystycznej SET status = ? WHERE id = ?");

        prepStmt.setInt(1,1);
        prepStmt.setInt(2, id);
        prepStmt.executeUpdate();
    }


}
