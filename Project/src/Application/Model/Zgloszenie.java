package Application.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Zgloszenie extends DBConnect
{
    private String opis;
    private boolean status;
    protected LocalDate data = LocalDate.now();
    protected double oplata;
    private static int count;
    private int id_polisy;
    int id;

    public Zgloszenie() {};

    public void utworz(String opis,Double oplata,Integer id_polisy,Integer d_z,Integer m_z,Integer r_z) throws SQLException
    {
        status = false;
        count++;
        id = count;
        data = LocalDate.of(r_z, m_z, d_z);
        java.sql.Date data_sql = java.sql.Date.valueOf( data );

        PreparedStatement prepStmt = con.prepareStatement(
                "insert into zgloszenie_szkody_turystycznej values(NULL,?,?,?,?,?);");

        prepStmt.setDate(1, data_sql);
        prepStmt.setString(2, opis);
        prepStmt.setInt(3,(status) ? 1 : 0);
        prepStmt.setDouble(4, oplata);
        prepStmt.setInt(5, id_polisy);
        prepStmt.executeUpdate();
    }

    public void edytuj(Integer id_wpr, String opis,Double oplata,Integer id_polisy,Integer d_z,Integer m_z,Integer r_z) throws SQLException
    {
        data = LocalDate.of(r_z, m_z, d_z);
        java.sql.Date data_sql = java.sql.Date.valueOf( data );

        PreparedStatement prepStmt = con.prepareStatement(
                "update zgloszenie_szkody_turystycznej SET data = ?, opis = ?, status = ?, oplata_polisy = ?, Polisa_turystyczna_id = ?  WHERE id = ?");
        prepStmt.setDate(1, data_sql);
        prepStmt.setString(2, opis);
        prepStmt.setInt(3,(status) ? 1 : 0);
        prepStmt.setDouble(4, oplata);
        prepStmt.setInt(5, id_polisy);
        prepStmt.setInt(6, id_wpr);
        prepStmt.executeUpdate();
    }
    
    public String sprawdz_status(Integer id) throws SQLException
    {
        DBConnect connect = new DBConnect();
        ResultSet rs = connect.getData("SELECT id,status FROM zgloszenie_szkody_turystycznej");

        int status = 0;
        while(rs.next())
        {
            if (rs.getInt("id")==id)
            {
                status = rs.getInt("status");
                break;
            }
        }
        String ret;
        if (status != 0)
            ret = "Zgłoszenie zostało przyjęte";
        else
            ret = "Zgłoszenie zostało odrzucone";
        return ret;
    }

    public String pokaz_zgloszenia_wszystkie() throws SQLException
    {
        DBConnect connect = new DBConnect();
        ResultSet rs = connect.getData("SELECT * FROM zgloszenie_szkody_turystycznej");
        return pokaz(rs);
    }

    public String pokaz_zgloszenia_niezatwierdzone() throws SQLException
    {
        DBConnect connect = new DBConnect();
        ResultSet rs = connect.getData("SELECT * FROM zgloszenie_szkody_turystycznej WHERE status = 0");
        return pokaz(rs);
    }

    public String pokaz_zgloszenia_klienta(int id) throws SQLException
    {
        String tmp = new String();
        DBConnect connect = new DBConnect();
        String zapytanie = new String("SELECT * FROM zgloszenie_szkody_turystycznej INNER JOIN polisy_turystyczne ON zgloszenie_szkody_turystycznej.Polisa_turystyczna_id = polisy_turystyczne.id WHERE polisy_turystyczne.Klienci_ID ="+Integer.toString(id));
        ResultSet rs = connect.getData(zapytanie);
        tmp = pokaz(rs);
        return tmp;
    }

    private String pokaz(ResultSet rs) throws SQLException
    {
        boolean istnieje = false;
        String tmp = new String();
        while(rs.next())
        {
            id = rs.getInt("id");
            data = rs.getDate("data").toLocalDate();
            opis = rs.getString("opis");
            status = rs.getBoolean("status");
            oplata = rs.getInt("oplata_polisy");
            id_polisy = rs.getInt("Polisa_turystyczna_id");
            tmp = new String("ID : "+ id + ", Data : " + data + ", Opis : " + opis + ", Status : " + status + ", Oplata : "
                    + oplata + " Zł , ID polisy : " + id_polisy + "\n" + tmp );
            istnieje = true;
        }
        if (istnieje) return tmp;
        else return new String("Zgloszenie nie istnieje !");
    }
}


