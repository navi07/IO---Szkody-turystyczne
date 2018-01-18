package Application.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Polisa
{
    private boolean status;
    private String rodzaj;
    protected LocalDate data_zawarcia = LocalDate.now();
    protected LocalDate data_rozwiazania = LocalDate.now();
    protected int id;

    public Polisa() {}

    public Polisa(boolean status, String rodzaj, int r_z, int m_z, int d_z, int r_r, int m_r, int d_r)
    {
        this.status = status;
        this.rodzaj = rodzaj;
        data_zawarcia = LocalDate.of(r_z, m_z, d_z);
        data_rozwiazania = LocalDate.of(r_r, m_r, d_r);
    }

    void edytuj(boolean status, String rodzaj, LocalDate data_zawarcia, LocalDate data_rozwiazania)
    {
        this.status = status;
        this.rodzaj = rodzaj;
        this.data_zawarcia = data_zawarcia;
        this.data_rozwiazania = data_rozwiazania;
    }

    void sprawdz_status()
    {
        if(status)
            System.out.println("Polisa jest aktualna");
        else
            System.out.println("Polisa nie jest aktualna");
    }

    public String czas_trwania(int id_polisy) throws SQLException
    {
        data_zawarcia = null;
        data_rozwiazania = null;
        DBConnect connect = new DBConnect();
        ResultSet rs = connect.getData( "SELECT * FROM polisy_turystyczne");
        while(rs.next())
        {
            if (rs.getInt("id") == id_polisy)
            {
                data_zawarcia = rs.getDate("data_rozpoczecia").toLocalDate();
                data_rozwiazania = rs.getDate("data_zakonczenia").toLocalDate();
            }
        }

        if(data_rozwiazania != null && data_zawarcia != null)
        {
            int dni = (int) ChronoUnit.DAYS.between(data_zawarcia, data_rozwiazania);
            String czas=  "Do konca polisy pozostało  "+dni+" dni";
            return czas;
        }
        else return new String("Podana polisa nie istnieje !");
    }
}