public class Pracownik extends Osoba
{
<<<<<<< HEAD
    private int id_prac;
    private String nr_tel;

    Klient k;
=======
    private int id;
    private String nr_tel;

    Pracownik()
    {
        
    };
>>>>>>> 7db65012eaa5cc1f3bc2ac438bb4f1b1cf86c3d4

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
