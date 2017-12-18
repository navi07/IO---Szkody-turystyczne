public class Klient extends Osoba
{
    private String pesel;
    private int nr_ubezpieczenia;
    private Zgloszenie z;
    private Polisa p;
    int id;
    private static int count;
    
    public Klient(String imie, String nazwisko, String pesel, int nr_ubezpieczenia)
    {
        super(imie, nazwisko);
        this.pesel = pesel;
        this.nr_ubezpieczenia = nr_ubezpieczenia;
        count++;
        id = count;
    }
    
    void pokaz_dane()
    {
        System.out.println(imie+" "+nazwisko+" "+pesel+" "+nr_ubezpieczenia+" "+id);
    }
    
    void zglos_szkode()
    {
        
    } // uzupelnic
    
    void sprawdz_status_zgloszenia()
    {
       z.sprawdz_status();
    }
    
    void sprawdz_czas_trwania_polisy()
    {
        p.czas_trwania();
    }
}


