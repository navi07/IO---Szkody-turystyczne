public class Pracownik extends Osoba
{
    private int id_prac;
    private String nr_tel;

    Klient k;

    Pracownik()
    {
        
    };

    Pracownik(String imie, String nazwisko, String nr_tel)
    {
        super(imie, nazwisko);
        this.nr_tel = nr_tel;
    }

    void sprawdz_tozsamosc()
    {
        k.pokaz_dane();
        // Sprawdzanie z baza danych
    }
    void odrzuc_zgloszenie()
    {
        // operacja na bazie danych
    }
    void przyjmij_zgloszenie()
    {
        // operacja na bazie danych
    };

}
