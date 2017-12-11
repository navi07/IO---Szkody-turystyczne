public class Osoba
{
    protected
    String imie;
    String nazwisko;

    void edytuj_dane(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    Osoba(){}

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
