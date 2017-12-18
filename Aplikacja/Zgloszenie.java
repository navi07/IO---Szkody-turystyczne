public class Zgloszenie
{
    private String rodzaj;
    private boolean status;
    private int id;

    Zgloszenie()
    {
        
    }

    Zgloszenie(String rodzaj, boolean status, int id)
    {
        this.rodzaj = rodzaj;
        this.status = status;
        this.id = id;
    }

    void edytuj(String rodzaj, boolean status, int id)
    {
        this.rodzaj = rodzaj;
        this.status = status;
        this.id = id;
    }
    
     void sprawdz_status()
    {
        if (status != false)
            System.out.println("Zgloszenie istnieje");
        else
            System.out.println("Zgloszenie nie istnieje");
        
    }
}


