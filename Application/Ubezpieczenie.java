package Application;

public class Ubezpieczenie
{
    private   String typ;
  
    public Ubezpieczenie() {}
    
    public Ubezpieczenie(String typ)
    {
        this.typ = typ;
    }

    void edytuj(String typ)
    {
        this.typ = typ;
    }

}
