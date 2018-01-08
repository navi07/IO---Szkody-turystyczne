public class Ubezpieczenie
{
    private   String typ;
  
    Ubezpieczenie() {}
    
    Ubezpieczenie(String typ)
    {
        this.typ = typ;
    }

    void edytuj(String typ)
    {
        this.typ = typ;
    }

}
