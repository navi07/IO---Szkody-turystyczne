public class Klient extends Osoba
{
    private String pesel;
    private int nr_ubezpieczenia;
<<<<<<< HEAD
    private Zgloszenie z;
    private Polisa p;
    int id;
    private static int count;
=======
    protected int id = 0;
    private Zgloszenie z;
    private Polisa p;
>>>>>>> 7db65012eaa5cc1f3bc2ac438bb4f1b1cf86c3d4
    
    public Klient(String imie, String nazwisko, String pesel, int nr_ubezpieczenia)
    {
        super(imie, nazwisko);
        this.pesel = pesel;
        this.nr_ubezpieczenia = nr_ubezpieczenia;
<<<<<<< HEAD
        count++;
        id = count;
=======
        id++; // FIX ID 
>>>>>>> 7db65012eaa5cc1f3bc2ac438bb4f1b1cf86c3d4
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

<<<<<<< HEAD

=======
>>>>>>> 7db65012eaa5cc1f3bc2ac438bb4f1b1cf86c3d4
