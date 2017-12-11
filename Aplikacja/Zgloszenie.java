public class Zgloszenie
{
    private
    String rodzaj;
    boolean status;
    int id;

    Zgloszenie(){}


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
}


