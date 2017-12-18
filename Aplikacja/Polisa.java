

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Polisa
{
    private boolean status;
    private String rodzaj;
    protected LocalDate data_zawarcia = LocalDate.of(2015, 01, 10);
    protected LocalDate data_rozwiazania= LocalDate.of(2015, 01, 15);


    //Polisa(){}
    Polisa(boolean status, String rodzaj)
    {
        this.status = status;
        this.rodzaj = rodzaj;
        //this.data_zawarcia = data_zawarcia;
        //this.data_rozwiazania = data_rozwiazania;
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
