public class Polisa
{
    private
    boolean status;
    String rodzaj;
    int [] data_zawarcia = new int [8]; // zmienic zeby SQL obslugiwal
    int [] data_rozwiazania = new int [8];

    Polisa(){}
    Polisa(boolean status, String rodzaj, int [] data_zawarcia, int [] data_rozwiazania )
    {
        this.status = status;
        this.rodzaj = rodzaj;
        this.data_zawarcia = data_zawarcia;
        this.data_rozwiazania = data_rozwiazania;
    }

    void edytuj(boolean status, String rodzaj, int [] data_zawarcia, int [] data_rozwiazania )
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
        // Dorobic obliczenia
        //System.out.println("Czas trwania polisy: "+);
    }
}
