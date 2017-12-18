import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Polisa
{
    private boolean status;
    private String rodzaj;
    protected LocalDate data_zawarcia = LocalDate.of(2015, 01, 10);
    protected LocalDate data_rozwiazania= LocalDate.of(2015, 01, 15);


    Polisa()
    {

    }

    Polisa(boolean status, String rodzaj, int r_z, int m_z, int d_z, int r_r, int m_r, int d_r)
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

    void sprawdz()
    {
        if(status)
            System.out.println("Polisa jest aktualna");
        else
            System.out.println("Polisa nie jest aktualna");
    }

    void czas_trwania()
    {
        long days = ChronoUnit.DAYS.between(data_zawarcia, data_rozwiazania);
        System.out.println("Czas trwania polisy: "+days+" dni");
    }
}
