package Application.Model;

public class Osoba extends DBConnect
{
    protected String imie = "Imie";
    protected String nazwisko = "Nazwisko";

    void edytuj_dane(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Osoba(){}

    public Osoba(String imie, String nazwisko)
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
