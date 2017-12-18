public class Osoba
{
<<<<<<< HEAD
    protected String imie = "Imie";
    protected String nazwisko = "Nazwisko";
=======
    protected String imie;
    protected String nazwisko;
>>>>>>> 7db65012eaa5cc1f3bc2ac438bb4f1b1cf86c3d4

    void edytuj_dane(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    Osoba()
    {
<<<<<<< HEAD

=======
        
>>>>>>> 7db65012eaa5cc1f3bc2ac438bb4f1b1cf86c3d4
    }

    Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    void wyswietl()
    {
        System.out.println(imie);
        System.out.println(nazwisko);
    }

}
